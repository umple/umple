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
  protected final String TEXT_1 = "# PLEASE DO NOT EDIT THIS CODE" + NL + "# This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!" + NL + "# NOTE: Ruby generator is experimental and is missing some features available in" + NL + "# in other Umple generated languages like Java or PHP";
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
  protected final String TEXT_13 = " = true";
  protected final String TEXT_14 = NL + "    @";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = NL + "    @";
  protected final String TEXT_17 = " = false";
  protected final String TEXT_18 = NL + "    @";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = NL + "    @";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = NL + "    @";
  protected final String TEXT_23 = " = @@";
  protected final String TEXT_24 = NL + "    @@";
  protected final String TEXT_25 = " += 1";
  protected final String TEXT_26 = NL + "    unless ";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ")" + NL + "      raise \"Unable to create ";
  protected final String TEXT_29 = " due to ";
  protected final String TEXT_30 = "\" " + NL + "    end";
  protected final String TEXT_31 = NL + "    @";
  protected final String TEXT_32 = " = []";
  protected final String TEXT_33 = NL + "    ";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_37 = ", must have ";
  protected final String TEXT_38 = " @";
  protected final String TEXT_39 = "\" unless ";
  protected final String TEXT_40 = " ";
  protected final String TEXT_41 = NL + "    @";
  protected final String TEXT_42 = " = []";
  protected final String TEXT_43 = NL + "    @";
  protected final String TEXT_44 = " = nil";
  protected final String TEXT_45 = NL + "    @";
  protected final String TEXT_46 = " = nil" + NL + "    unless ";
  protected final String TEXT_47 = ".nil?" + NL + "      @";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = NL + "      ";
  protected final String TEXT_50 = ".instance_variable_set(\"@";
  protected final String TEXT_51 = "\",self)" + NL + "    end";
  protected final String TEXT_52 = NL + "    @";
  protected final String TEXT_53 = " = []";
  protected final String TEXT_54 = NL + "    @";
  protected final String TEXT_55 = " = nil";
  protected final String TEXT_56 = NL + "    ";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_60 = " due to @";
  protected final String TEXT_61 = "\" unless ";
  protected final String TEXT_62 = NL + "    @";
  protected final String TEXT_63 = " = []";
  protected final String TEXT_64 = NL + "    ";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_68 = ", must have ";
  protected final String TEXT_69 = " @";
  protected final String TEXT_70 = "\" unless ";
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = "@";
  protected final String TEXT_73 = " = []" + NL + "    @";
  protected final String TEXT_74 = " << ";
  protected final String TEXT_75 = NL + "    ";
  protected final String TEXT_76 = "(";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = ")";
  protected final String TEXT_79 = NL + "    ";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ")  if ";
  protected final String TEXT_83 = ".nil?";
  protected final String TEXT_84 = NL;
  protected final String TEXT_85 = NL + "  #------------------------" + NL + "  # INTERFACE" + NL + "  #------------------------" + NL;
  protected final String TEXT_86 = NL + "  def ";
  protected final String TEXT_87 = "(";
  protected final String TEXT_88 = ")" + NL + "    was_set = false";
  protected final String TEXT_89 = NL + "    ";
  protected final String TEXT_90 = " = false;" + NL + "    @";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = NL + "    was_set = true";
  protected final String TEXT_93 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_94 = NL + "  def ";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ")" + NL + "    was_set = false";
  protected final String TEXT_97 = NL + "    @";
  protected final String TEXT_98 = " = ";
  protected final String TEXT_99 = NL + "    was_set = true";
  protected final String TEXT_100 = NL + "    was_set" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_101 = NL + "    wasReset = false";
  protected final String TEXT_102 = NL + "    @";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = NL + "    wasReset = true";
  protected final String TEXT_105 = NL + "    wasReset" + NL + "  end" + NL;
  protected final String TEXT_106 = NL + "  def ";
  protected final String TEXT_107 = "(";
  protected final String TEXT_108 = ")" + NL + "    was_added = false";
  protected final String TEXT_109 = NL + "    was_added = ";
  protected final String TEXT_110 = " << ";
  protected final String TEXT_111 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = ")" + NL + "    was_removed = false";
  protected final String TEXT_114 = NL + "    was_removed = ";
  protected final String TEXT_115 = ".delete(";
  protected final String TEXT_116 = ")";
  protected final String TEXT_117 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_118 = NL + "  def ";
  protected final String TEXT_119 = "(";
  protected final String TEXT_120 = ")" + NL + "    was_set = false";
  protected final String TEXT_121 = NL + "    @";
  protected final String TEXT_122 = " = ";
  protected final String TEXT_123 = NL + "    was_set = true";
  protected final String TEXT_124 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_125 = NL + "  def ";
  protected final String TEXT_126 = "(index)";
  protected final String TEXT_127 = NL + "    ";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = "[index]";
  protected final String TEXT_130 = NL + "    ";
  protected final String TEXT_131 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_132 = NL + "    ";
  protected final String TEXT_133 = "[] ";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = ".toArray(new ";
  protected final String TEXT_136 = "[";
  protected final String TEXT_137 = ".size])";
  protected final String TEXT_138 = NL + "    ";
  protected final String TEXT_139 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_140 = NL + "    number = ";
  protected final String TEXT_141 = ".size";
  protected final String TEXT_142 = NL + "    number;" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_143 = NL + "    has = ";
  protected final String TEXT_144 = ".size > 0";
  protected final String TEXT_145 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_146 = "(";
  protected final String TEXT_147 = ")";
  protected final String TEXT_148 = NL + "    index = ";
  protected final String TEXT_149 = ".index(";
  protected final String TEXT_150 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_151 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_152 = NL + "  def ";
  protected final String TEXT_153 = NL + "    ";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = NL + "    ";
  protected final String TEXT_156 = NL + "  end";
  protected final String TEXT_157 = NL + "  def ";
  protected final String TEXT_158 = NL + "    ";
  protected final String TEXT_159 = NL + "  end";
  protected final String TEXT_160 = NL + "  def ";
  protected final String TEXT_161 = NL + "    ";
  protected final String TEXT_162 = " = @";
  protected final String TEXT_163 = NL + "    ";
  protected final String TEXT_164 = NL + "  end";
  protected final String TEXT_165 = NL + "  def ";
  protected final String TEXT_166 = NL + "    @";
  protected final String TEXT_167 = NL + "  end";
  protected final String TEXT_168 = NL + "  def ";
  protected final String TEXT_169 = NL + "    ";
  protected final String TEXT_170 = " = ";
  protected final String TEXT_171 = NL + "    ";
  protected final String TEXT_172 = NL + "  end" + NL;
  protected final String TEXT_173 = NL + "  def ";
  protected final String TEXT_174 = NL + "    ";
  protected final String TEXT_175 = NL + "  end" + NL;
  protected final String TEXT_176 = NL + "  def ";
  protected final String TEXT_177 = NL + "    ";
  protected final String TEXT_178 = " = @";
  protected final String TEXT_179 = NL + "    ";
  protected final String TEXT_180 = NL + "  end";
  protected final String TEXT_181 = NL + "  def ";
  protected final String TEXT_182 = NL + "    @";
  protected final String TEXT_183 = NL + "  end";
  protected final String TEXT_184 = NL + "  def ";
  protected final String TEXT_185 = NL + "    ";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = NL + "    ";
  protected final String TEXT_188 = NL + "  end";
  protected final String TEXT_189 = NL + "  def ";
  protected final String TEXT_190 = NL + "    @";
  protected final String TEXT_191 = NL + "  end";
  protected final String TEXT_192 = NL + "  def ";
  protected final String TEXT_193 = NL + "    ";
  protected final String TEXT_194 = " = @";
  protected final String TEXT_195 = NL + "    ";
  protected final String TEXT_196 = NL + "  end";
  protected final String TEXT_197 = NL + "  def ";
  protected final String TEXT_198 = NL + "    @";
  protected final String TEXT_199 = NL + "  end";
  protected final String TEXT_200 = NL + "  public ";
  protected final String TEXT_201 = " ";
  protected final String TEXT_202 = NL + "    ";
  protected final String TEXT_203 = NL + "  end" + NL;
  protected final String TEXT_204 = NL + "  private boolean ";
  protected final String TEXT_205 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_206 = ";" + NL + "  }" + NL;
  protected final String TEXT_207 = NL + "  def ";
  protected final String TEXT_208 = NL + "  {" + NL + "    wasEventProcessed = false;" + NL;
  protected final String TEXT_209 = NL + "    ";
  protected final String TEXT_210 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_211 = NL + "  def ";
  protected final String TEXT_212 = "(";
  protected final String TEXT_213 = " ";
  protected final String TEXT_214 = ")" + NL + "  {";
  protected final String TEXT_215 = NL + "    ";
  protected final String TEXT_216 = " = ";
  protected final String TEXT_217 = NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_218 = NL + "  def ";
  protected final String TEXT_219 = NL + "    switch(";
  protected final String TEXT_220 = ")";
  protected final String TEXT_221 = NL + "      ";
  protected final String TEXT_222 = NL + "    end" + NL + "  end" + NL;
  protected final String TEXT_223 = NL + "  private void ";
  protected final String TEXT_224 = "(";
  protected final String TEXT_225 = " ";
  protected final String TEXT_226 = ")" + NL + "  {";
  protected final String TEXT_227 = NL + "    ";
  protected final String TEXT_228 = " = ";
  protected final String TEXT_229 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_230 = ")" + NL + "    {";
  protected final String TEXT_231 = NL + "      ";
  protected final String TEXT_232 = NL + "    }";
  protected final String TEXT_233 = NL + "  }" + NL;
  protected final String TEXT_234 = NL + "  def ";
  protected final String TEXT_235 = NL + "    @";
  protected final String TEXT_236 = NL + "    ";
  protected final String TEXT_237 = " = @";
  protected final String TEXT_238 = NL + "    ";
  protected final String TEXT_239 = NL + "  end" + NL;
  protected final String TEXT_240 = NL + "  def ";
  protected final String TEXT_241 = "(index)";
  protected final String TEXT_242 = NL + "    ";
  protected final String TEXT_243 = " = @";
  protected final String TEXT_244 = "[index]";
  protected final String TEXT_245 = NL + "    ";
  protected final String TEXT_246 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_247 = NL + "    ";
  protected final String TEXT_248 = " = @";
  protected final String TEXT_249 = ".dup";
  protected final String TEXT_250 = NL + "    ";
  protected final String TEXT_251 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_252 = NL + "    number = @";
  protected final String TEXT_253 = ".size";
  protected final String TEXT_254 = NL + "    number" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_255 = NL + "    has = @";
  protected final String TEXT_256 = ".size > 0";
  protected final String TEXT_257 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_258 = "(";
  protected final String TEXT_259 = ")";
  protected final String TEXT_260 = NL + "    index = @";
  protected final String TEXT_261 = ".index(";
  protected final String TEXT_262 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_263 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_264 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_265 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_266 = " : ";
  protected final String TEXT_267 = NL + "  def ";
  protected final String TEXT_268 = NL + "    is_valid = ";
  protected final String TEXT_269 = " >= ";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = NL + "    is_valid = ";
  protected final String TEXT_272 = " >= ";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = " and ";
  protected final String TEXT_275 = " <= ";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = NL + "    is_valid" + NL + "  end";
  protected final String TEXT_278 = NL + "  def self.";
  protected final String TEXT_279 = NL + "    ";
  protected final String TEXT_280 = NL + "  end";
  protected final String TEXT_281 = NL + "  def self.";
  protected final String TEXT_282 = NL + "    minimum = ";
  protected final String TEXT_283 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_284 = NL + "  def self.";
  protected final String TEXT_285 = NL + "    ";
  protected final String TEXT_286 = NL + "  end";
  protected final String TEXT_287 = NL + "  def self.";
  protected final String TEXT_288 = NL + "    minimum = ";
  protected final String TEXT_289 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_290 = NL + "  def self.";
  protected final String TEXT_291 = NL + "    ";
  protected final String TEXT_292 = NL + "  end";
  protected final String TEXT_293 = NL + "  def self.";
  protected final String TEXT_294 = NL + "    maximum = ";
  protected final String TEXT_295 = NL + "    maximum" + NL + "  end";
  protected final String TEXT_296 = NL + "  def ";
  protected final String TEXT_297 = "(";
  protected final String TEXT_298 = ")" + NL + "    was_added = false";
  protected final String TEXT_299 = NL + "    if ";
  protected final String TEXT_300 = " >= ";
  protected final String TEXT_301 = ".";
  protected final String TEXT_302 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_303 = NL + "    @";
  protected final String TEXT_304 = " << ";
  protected final String TEXT_305 = NL + "    if ";
  protected final String TEXT_306 = ".";
  protected final String TEXT_307 = "(self) != -1" + NL + "      was_added = true" + NL + "    else" + NL + "      was_added = ";
  protected final String TEXT_308 = ".";
  protected final String TEXT_309 = "(self)" + NL + "      unless was_added" + NL + "        @";
  protected final String TEXT_310 = ".delete(";
  protected final String TEXT_311 = ")" + NL + "      end" + NL + "    end";
  protected final String TEXT_312 = NL + "    was_added" + NL + "  end";
  protected final String TEXT_313 = NL + "  def ";
  protected final String TEXT_314 = "(";
  protected final String TEXT_315 = ")" + NL + "    was_removed = false";
  protected final String TEXT_316 = NL + "    unless @";
  protected final String TEXT_317 = ".include?(";
  protected final String TEXT_318 = ")";
  protected final String TEXT_319 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_320 = ".index(";
  protected final String TEXT_321 = ")" + NL + "    @";
  protected final String TEXT_322 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = "(self)" + NL + "      @";
  protected final String TEXT_327 = ".insert(oldIndex,";
  protected final String TEXT_328 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_329 = NL + "    was_removed" + NL + "  end";
  protected final String TEXT_330 = NL + "  def ";
  protected final String TEXT_331 = "(";
  protected final String TEXT_332 = ")" + NL + "    was_set = false";
  protected final String TEXT_333 = NL + "    @";
  protected final String TEXT_334 = " = ";
  protected final String TEXT_335 = NL + "    was_set = true";
  protected final String TEXT_336 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_337 = NL + "  def ";
  protected final String TEXT_338 = "(";
  protected final String TEXT_339 = ")" + NL + "    was_set = false";
  protected final String TEXT_340 = NL + "    unless ";
  protected final String TEXT_341 = ".nil?" + NL + "      @";
  protected final String TEXT_342 = " = ";
  protected final String TEXT_343 = NL + "      was_set = true" + NL + "    end";
  protected final String TEXT_344 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_345 = NL + "  def ";
  protected final String TEXT_346 = "(";
  protected final String TEXT_347 = ")" + NL + "    was_set = false";
  protected final String TEXT_348 = NL + "    if !@";
  protected final String TEXT_349 = ".nil? and !@";
  protected final String TEXT_350 = ".eql?(";
  protected final String TEXT_351 = ") and self.eql?(@";
  protected final String TEXT_352 = ".";
  protected final String TEXT_353 = ")" + NL + "      #Unable to ";
  protected final String TEXT_354 = ", as existing @";
  protected final String TEXT_355 = " would become an orphan";
  protected final String TEXT_356 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_357 = " = ";
  protected final String TEXT_358 = NL + "    ";
  protected final String TEXT_359 = " = !";
  protected final String TEXT_360 = ".nil? ? ";
  protected final String TEXT_361 = ".";
  protected final String TEXT_362 = " : nil" + NL + "" + NL + "    unless self.eql?(";
  protected final String TEXT_363 = ")" + NL + "      unless ";
  protected final String TEXT_364 = ".nil?";
  protected final String TEXT_365 = NL + "        ";
  protected final String TEXT_366 = ".instance_variable_set(\"@";
  protected final String TEXT_367 = "\",nil)" + NL + "      end" + NL + "      unless @";
  protected final String TEXT_368 = ".nil?" + NL + "        @";
  protected final String TEXT_369 = ".";
  protected final String TEXT_370 = "(self)" + NL + "      end" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_371 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_372 = NL + "  def ";
  protected final String TEXT_373 = "(";
  protected final String TEXT_374 = ")" + NL + "    was_set = false";
  protected final String TEXT_375 = NL + "    if ";
  protected final String TEXT_376 = ".nil?" + NL + "      #Unable to ";
  protected final String TEXT_377 = " to nil, as ";
  protected final String TEXT_378 = " must always be associated to a @";
  protected final String TEXT_379 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_380 = NL + "    ";
  protected final String TEXT_381 = " = ";
  protected final String TEXT_382 = ".";
  protected final String TEXT_383 = NL + "    if !";
  protected final String TEXT_384 = ".nil? and !self.eql?(";
  protected final String TEXT_385 = ")" + NL + "      #Unable to ";
  protected final String TEXT_386 = ", the current @";
  protected final String TEXT_387 = " already has a ";
  protected final String TEXT_388 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_389 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_390 = NL + "    ";
  protected final String TEXT_391 = " = @";
  protected final String TEXT_392 = NL + "    @";
  protected final String TEXT_393 = " = ";
  protected final String TEXT_394 = NL + "    @";
  protected final String TEXT_395 = ".";
  protected final String TEXT_396 = "(self)" + NL + "" + NL + "    unless ";
  protected final String TEXT_397 = ".nil?";
  protected final String TEXT_398 = NL + "      ";
  protected final String TEXT_399 = ".";
  protected final String TEXT_400 = "(nil)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_401 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_402 = NL + "  def ";
  protected final String TEXT_403 = "(";
  protected final String TEXT_404 = ")" + NL + "    was_added = false";
  protected final String TEXT_405 = NL + "    ";
  protected final String TEXT_406 = " = ";
  protected final String TEXT_407 = ".";
  protected final String TEXT_408 = NL + "    ";
  protected final String TEXT_409 = " = (!";
  protected final String TEXT_410 = ".nil? and !";
  protected final String TEXT_411 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_412 = " and ";
  protected final String TEXT_413 = ".";
  protected final String TEXT_414 = " <= ";
  protected final String TEXT_415 = ".";
  protected final String TEXT_416 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_417 = NL + "      ";
  protected final String TEXT_418 = ".";
  protected final String TEXT_419 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_420 = " << ";
  protected final String TEXT_421 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_422 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_423 = "(";
  protected final String TEXT_424 = ")" + NL + "    was_removed = false";
  protected final String TEXT_425 = NL + "    # Unable to remove ";
  protected final String TEXT_426 = ", as it must always have a ";
  protected final String TEXT_427 = NL + "    if ";
  protected final String TEXT_428 = ".";
  protected final String TEXT_429 = ".eql?(self)";
  protected final String TEXT_430 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_431 = " already at minimum (";
  protected final String TEXT_432 = ")" + NL + "    if ";
  protected final String TEXT_433 = " <= ";
  protected final String TEXT_434 = ".";
  protected final String TEXT_435 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_436 = ".delete(";
  protected final String TEXT_437 = ")" + NL + "    was_removed = true";
  protected final String TEXT_438 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_439 = NL + "  def ";
  protected final String TEXT_440 = "(";
  protected final String TEXT_441 = ")" + NL + "    was_added = false";
  protected final String TEXT_442 = NL + "    if ";
  protected final String TEXT_443 = " >= ";
  protected final String TEXT_444 = ".";
  protected final String TEXT_445 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_446 = NL + "    ";
  protected final String TEXT_447 = " = ";
  protected final String TEXT_448 = ".";
  protected final String TEXT_449 = NL + "    ";
  protected final String TEXT_450 = " = (!";
  protected final String TEXT_451 = ".nil? and !";
  protected final String TEXT_452 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_453 = " and ";
  protected final String TEXT_454 = ".";
  protected final String TEXT_455 = " <= ";
  protected final String TEXT_456 = ".";
  protected final String TEXT_457 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_458 = NL + "      ";
  protected final String TEXT_459 = ".";
  protected final String TEXT_460 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_461 = " << ";
  protected final String TEXT_462 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_463 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_464 = "(";
  protected final String TEXT_465 = ")" + NL + "    was_removed = false";
  protected final String TEXT_466 = NL + "    # Unable to remove ";
  protected final String TEXT_467 = ", as it must always have a ";
  protected final String TEXT_468 = NL + "    if ";
  protected final String TEXT_469 = ".";
  protected final String TEXT_470 = ".eql?(self)";
  protected final String TEXT_471 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_472 = " already at minimum (";
  protected final String TEXT_473 = ")" + NL + "    if ";
  protected final String TEXT_474 = " <= ";
  protected final String TEXT_475 = ".";
  protected final String TEXT_476 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_477 = ".delete(";
  protected final String TEXT_478 = ")" + NL + "    was_removed = true";
  protected final String TEXT_479 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_480 = NL + "  def ";
  protected final String TEXT_481 = "(";
  protected final String TEXT_482 = ")" + NL + "    was_added = false";
  protected final String TEXT_483 = NL + "    if ";
  protected final String TEXT_484 = " >= ";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_487 = NL + "    ";
  protected final String TEXT_488 = " = ";
  protected final String TEXT_489 = ".";
  protected final String TEXT_490 = NL + "    ";
  protected final String TEXT_491 = " = (!";
  protected final String TEXT_492 = ".nil? and !";
  protected final String TEXT_493 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_494 = NL + "      ";
  protected final String TEXT_495 = ".";
  protected final String TEXT_496 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_497 = " << ";
  protected final String TEXT_498 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_499 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_500 = "(";
  protected final String TEXT_501 = ")" + NL + "    was_removed = false";
  protected final String TEXT_502 = NL + "    # Unable to remove ";
  protected final String TEXT_503 = ", as it must always have a ";
  protected final String TEXT_504 = NL + "    unless ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_507 = ".delete(";
  protected final String TEXT_508 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_509 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_510 = NL + "  def ";
  protected final String TEXT_511 = "(";
  protected final String TEXT_512 = ")" + NL + "    was_set = false";
  protected final String TEXT_513 = NL + "    ";
  protected final String TEXT_514 = " = []";
  protected final String TEXT_515 = NL + "    ";
  protected final String TEXT_516 = ".each do |";
  protected final String TEXT_517 = "|" + NL + "      next if (";
  protected final String TEXT_518 = ".include?(";
  protected final String TEXT_519 = "))";
  protected final String TEXT_520 = NL + "      ";
  protected final String TEXT_521 = " << ";
  protected final String TEXT_522 = NL + "    end" + NL + "" + NL + "    if (";
  protected final String TEXT_523 = ".size != ";
  protected final String TEXT_524 = ".size or ";
  protected final String TEXT_525 = ".size() > ";
  protected final String TEXT_526 = ".";
  protected final String TEXT_527 = ")";
  protected final String TEXT_528 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_529 = NL + "    ";
  protected final String TEXT_530 = " = @";
  protected final String TEXT_531 = ".dup" + NL + "    @";
  protected final String TEXT_532 = ".clear";
  protected final String TEXT_533 = NL + "    ";
  protected final String TEXT_534 = ".each do |";
  protected final String TEXT_535 = "|" + NL + "      @";
  protected final String TEXT_536 = " << ";
  protected final String TEXT_537 = NL + "      if (";
  protected final String TEXT_538 = ".include?(";
  protected final String TEXT_539 = "))";
  protected final String TEXT_540 = NL + "        ";
  protected final String TEXT_541 = ".delete(";
  protected final String TEXT_542 = ")" + NL + "      else";
  protected final String TEXT_543 = NL + "        ";
  protected final String TEXT_544 = ".";
  protected final String TEXT_545 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_546 = NL + "    ";
  protected final String TEXT_547 = ".each do |";
  protected final String TEXT_548 = "|";
  protected final String TEXT_549 = NL + "      ";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_552 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_553 = NL + "  def ";
  protected final String TEXT_554 = "(";
  protected final String TEXT_555 = ")" + NL + "    was_added = false";
  protected final String TEXT_556 = NL + "    ";
  protected final String TEXT_557 = " = ";
  protected final String TEXT_558 = ".";
  protected final String TEXT_559 = NL + "    ";
  protected final String TEXT_560 = " = (!";
  protected final String TEXT_561 = ".nil? and !";
  protected final String TEXT_562 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_563 = NL + "      ";
  protected final String TEXT_564 = ".";
  protected final String TEXT_565 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_566 = " << ";
  protected final String TEXT_567 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_568 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_569 = "(";
  protected final String TEXT_570 = ")" + NL + "    was_removed = false";
  protected final String TEXT_571 = NL + "    # Unable to remove ";
  protected final String TEXT_572 = ", as it must always have a ";
  protected final String TEXT_573 = NL + "    unless ";
  protected final String TEXT_574 = ".";
  protected final String TEXT_575 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_576 = ".delete(";
  protected final String TEXT_577 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_578 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_579 = NL + "  def ";
  protected final String TEXT_580 = "(";
  protected final String TEXT_581 = ")" + NL + "    was_set = false";
  protected final String TEXT_582 = NL + "    if ";
  protected final String TEXT_583 = ".nil?";
  protected final String TEXT_584 = NL + "      ";
  protected final String TEXT_585 = " = @";
  protected final String TEXT_586 = NL + "      @";
  protected final String TEXT_587 = " = nil" + NL + "      " + NL + "      if !";
  protected final String TEXT_588 = ".nil? and !";
  protected final String TEXT_589 = ".";
  protected final String TEXT_590 = ".nil?";
  protected final String TEXT_591 = NL + "        ";
  protected final String TEXT_592 = ".";
  protected final String TEXT_593 = "(nil)" + NL + "      end" + NL + "      was_set = true";
  protected final String TEXT_594 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_595 = NL + "    ";
  protected final String TEXT_596 = " = self.";
  protected final String TEXT_597 = NL + "    if !";
  protected final String TEXT_598 = ".nil? and !";
  protected final String TEXT_599 = ".eql?(";
  protected final String TEXT_600 = ")";
  protected final String TEXT_601 = NL + "      ";
  protected final String TEXT_602 = ".";
  protected final String TEXT_603 = "(nil)" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_604 = " = ";
  protected final String TEXT_605 = NL + "    ";
  protected final String TEXT_606 = " = ";
  protected final String TEXT_607 = ".";
  protected final String TEXT_608 = NL + NL + "    unless self.eql?(";
  protected final String TEXT_609 = ")";
  protected final String TEXT_610 = NL + "      ";
  protected final String TEXT_611 = ".";
  protected final String TEXT_612 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_613 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_614 = NL + "  def ";
  protected final String TEXT_615 = "(";
  protected final String TEXT_616 = ")" + NL + "    was_removed = false";
  protected final String TEXT_617 = NL + "    unless @";
  protected final String TEXT_618 = ".include?(";
  protected final String TEXT_619 = ")";
  protected final String TEXT_620 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_621 = " <= ";
  protected final String TEXT_622 = ".";
  protected final String TEXT_623 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_624 = ".index(";
  protected final String TEXT_625 = ")" + NL + "    @";
  protected final String TEXT_626 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_627 = ".";
  protected final String TEXT_628 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_629 = ".";
  protected final String TEXT_630 = "(self)" + NL + "      @";
  protected final String TEXT_631 = ".insert(oldIndex,";
  protected final String TEXT_632 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_633 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_634 = NL + "  def ";
  protected final String TEXT_635 = "(";
  protected final String TEXT_636 = ")" + NL + "    was_removed = false";
  protected final String TEXT_637 = NL + "    unless @";
  protected final String TEXT_638 = ".include?(";
  protected final String TEXT_639 = ")";
  protected final String TEXT_640 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_641 = " <= ";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_644 = ".index(";
  protected final String TEXT_645 = ")" + NL + "    @";
  protected final String TEXT_646 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_647 = ".";
  protected final String TEXT_648 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_649 = ".";
  protected final String TEXT_650 = "(self)" + NL + "      @";
  protected final String TEXT_651 = ".insert(oldIndex,";
  protected final String TEXT_652 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_653 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_654 = NL + "  def ";
  protected final String TEXT_655 = "(";
  protected final String TEXT_656 = ")" + NL + "    was_set = false";
  protected final String TEXT_657 = NL + "    if !";
  protected final String TEXT_658 = ".nil? and ";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = " >= ";
  protected final String TEXT_661 = ".";
  protected final String TEXT_662 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_663 = NL + "    ";
  protected final String TEXT_664 = " = @";
  protected final String TEXT_665 = NL + "    @";
  protected final String TEXT_666 = " = ";
  protected final String TEXT_667 = NL + "    if !";
  protected final String TEXT_668 = ".nil? and !";
  protected final String TEXT_669 = ".eql?(";
  protected final String TEXT_670 = ")";
  protected final String TEXT_671 = NL + "      ";
  protected final String TEXT_672 = ".";
  protected final String TEXT_673 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_674 = ".nil?";
  protected final String TEXT_675 = NL + "      ";
  protected final String TEXT_676 = ".";
  protected final String TEXT_677 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_678 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_679 = NL + "  def ";
  protected final String TEXT_680 = "(";
  protected final String TEXT_681 = ")" + NL + "    was_set = false";
  protected final String TEXT_682 = NL + "    if ";
  protected final String TEXT_683 = ".nil?";
  protected final String TEXT_684 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_685 = NL + "    ";
  protected final String TEXT_686 = " = @";
  protected final String TEXT_687 = NL + "    @";
  protected final String TEXT_688 = " = ";
  protected final String TEXT_689 = NL + "    if !";
  protected final String TEXT_690 = ".nil? and !";
  protected final String TEXT_691 = ".eql?(";
  protected final String TEXT_692 = ")";
  protected final String TEXT_693 = NL + "      ";
  protected final String TEXT_694 = ".";
  protected final String TEXT_695 = "(self)" + NL + "    end" + NL + "    @";
  protected final String TEXT_696 = ".";
  protected final String TEXT_697 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_698 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_699 = NL + "  def ";
  protected final String TEXT_700 = "(";
  protected final String TEXT_701 = ")" + NL + "    was_set = false";
  protected final String TEXT_702 = NL + "    # Must provide @";
  protected final String TEXT_703 = " to ";
  protected final String TEXT_704 = NL + "    if ";
  protected final String TEXT_705 = ".nil?";
  protected final String TEXT_706 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    # @";
  protected final String TEXT_707 = " already at maximum (";
  protected final String TEXT_708 = ")" + NL + "    if ";
  protected final String TEXT_709 = ".";
  protected final String TEXT_710 = " >= ";
  protected final String TEXT_711 = ".";
  protected final String TEXT_712 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_713 = NL + "    ";
  protected final String TEXT_714 = " = @";
  protected final String TEXT_715 = NL + "    @";
  protected final String TEXT_716 = " = ";
  protected final String TEXT_717 = NL + "    if !";
  protected final String TEXT_718 = ".nil? and !";
  protected final String TEXT_719 = ".eql?(";
  protected final String TEXT_720 = ")" + NL + "      didRemove = ";
  protected final String TEXT_721 = ".";
  protected final String TEXT_722 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_723 = " = ";
  protected final String TEXT_724 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_725 = ".";
  protected final String TEXT_726 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_727 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_728 = NL + "  def ";
  protected final String TEXT_729 = "(";
  protected final String TEXT_730 = ")" + NL + "    was_set = false";
  protected final String TEXT_731 = NL + "    # Must provide @";
  protected final String TEXT_732 = " to ";
  protected final String TEXT_733 = NL + "    if ";
  protected final String TEXT_734 = ".nil?";
  protected final String TEXT_735 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    if !@";
  protected final String TEXT_736 = ".nil? and @";
  protected final String TEXT_737 = ".";
  protected final String TEXT_738 = " <= ";
  protected final String TEXT_739 = ".";
  protected final String TEXT_740 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_741 = NL + "    ";
  protected final String TEXT_742 = " = @";
  protected final String TEXT_743 = NL + "    @";
  protected final String TEXT_744 = " = ";
  protected final String TEXT_745 = NL + "    if !";
  protected final String TEXT_746 = ".nil? and !";
  protected final String TEXT_747 = ".eql?(";
  protected final String TEXT_748 = ")" + NL + "      didRemove = ";
  protected final String TEXT_749 = ".";
  protected final String TEXT_750 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_751 = " = ";
  protected final String TEXT_752 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_753 = ".";
  protected final String TEXT_754 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_755 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_756 = NL + "  def ";
  protected final String TEXT_757 = "(";
  protected final String TEXT_758 = ")" + NL + "    was_added = false";
  protected final String TEXT_759 = NL + "    ";
  protected final String TEXT_760 = " = ";
  protected final String TEXT_761 = ".";
  protected final String TEXT_762 = NL + "    if ";
  protected final String TEXT_763 = ".nil?";
  protected final String TEXT_764 = NL + "      ";
  protected final String TEXT_765 = ".";
  protected final String TEXT_766 = "(self)" + NL + "    elsif !";
  protected final String TEXT_767 = ".eql?(self)";
  protected final String TEXT_768 = NL + "      ";
  protected final String TEXT_769 = ".";
  protected final String TEXT_770 = "(";
  protected final String TEXT_771 = ")";
  protected final String TEXT_772 = NL + "      ";
  protected final String TEXT_773 = "(";
  protected final String TEXT_774 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_775 = " << ";
  protected final String TEXT_776 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_777 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_778 = "(";
  protected final String TEXT_779 = ")" + NL + "    was_removed = false";
  protected final String TEXT_780 = NL + "    if @";
  protected final String TEXT_781 = ".include?(";
  protected final String TEXT_782 = ")" + NL + "      @";
  protected final String TEXT_783 = ".delete(";
  protected final String TEXT_784 = ")";
  protected final String TEXT_785 = NL + "      ";
  protected final String TEXT_786 = ".";
  protected final String TEXT_787 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_788 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_789 = NL + "  def ";
  protected final String TEXT_790 = "(";
  protected final String TEXT_791 = ")" + NL + "    was_set = false";
  protected final String TEXT_792 = NL + "    ";
  protected final String TEXT_793 = " = @";
  protected final String TEXT_794 = NL + "    @";
  protected final String TEXT_795 = " = ";
  protected final String TEXT_796 = NL + "    if !";
  protected final String TEXT_797 = ".nil? and !";
  protected final String TEXT_798 = ".eql?(";
  protected final String TEXT_799 = ")";
  protected final String TEXT_800 = NL + "      ";
  protected final String TEXT_801 = ".";
  protected final String TEXT_802 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_803 = ".nil?";
  protected final String TEXT_804 = NL + "      ";
  protected final String TEXT_805 = ".";
  protected final String TEXT_806 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_807 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_808 = NL + "  def ";
  protected final String TEXT_809 = "(";
  protected final String TEXT_810 = ")" + NL + "    was_added = false";
  protected final String TEXT_811 = NL + "    if ";
  protected final String TEXT_812 = " >= ";
  protected final String TEXT_813 = ".";
  protected final String TEXT_814 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_815 = NL + "    ";
  protected final String TEXT_816 = " = ";
  protected final String TEXT_817 = ".";
  protected final String TEXT_818 = NL + "    if ";
  protected final String TEXT_819 = ".nil?";
  protected final String TEXT_820 = NL + "      ";
  protected final String TEXT_821 = ".";
  protected final String TEXT_822 = "(self)" + NL + "    elsif !";
  protected final String TEXT_823 = ".eql?(self)";
  protected final String TEXT_824 = NL + "      ";
  protected final String TEXT_825 = ".";
  protected final String TEXT_826 = "(";
  protected final String TEXT_827 = ")";
  protected final String TEXT_828 = NL + "      ";
  protected final String TEXT_829 = "(";
  protected final String TEXT_830 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_831 = " << ";
  protected final String TEXT_832 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_833 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_834 = "(";
  protected final String TEXT_835 = ")" + NL + "    was_removed = false";
  protected final String TEXT_836 = NL + "    if @";
  protected final String TEXT_837 = ".include?(";
  protected final String TEXT_838 = ")" + NL + "      @";
  protected final String TEXT_839 = ".delete(";
  protected final String TEXT_840 = ")";
  protected final String TEXT_841 = NL + "      ";
  protected final String TEXT_842 = ".";
  protected final String TEXT_843 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_844 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_845 = NL + "  def ";
  protected final String TEXT_846 = "(";
  protected final String TEXT_847 = ")" + NL + "    was_added = false";
  protected final String TEXT_848 = NL + "    if ";
  protected final String TEXT_849 = " < ";
  protected final String TEXT_850 = ".";
  protected final String TEXT_851 = NL + "      @";
  protected final String TEXT_852 = " << ";
  protected final String TEXT_853 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_854 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_855 = "(";
  protected final String TEXT_856 = ")" + NL + "    was_removed = false";
  protected final String TEXT_857 = NL + "    unless @";
  protected final String TEXT_858 = ".include?(";
  protected final String TEXT_859 = ")";
  protected final String TEXT_860 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_861 = " <= ";
  protected final String TEXT_862 = ".";
  protected final String TEXT_863 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_864 = ".delete(";
  protected final String TEXT_865 = ")" + NL + "    was_removed = true";
  protected final String TEXT_866 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_867 = NL + "  def ";
  protected final String TEXT_868 = "(";
  protected final String TEXT_869 = ")" + NL + "    was_added = false";
  protected final String TEXT_870 = NL + "    if ";
  protected final String TEXT_871 = " >= ";
  protected final String TEXT_872 = ".";
  protected final String TEXT_873 = NL + "      return was_added" + NL + "    end";
  protected final String TEXT_874 = NL + "    ";
  protected final String TEXT_875 = " = ";
  protected final String TEXT_876 = ".";
  protected final String TEXT_877 = NL + "    if !";
  protected final String TEXT_878 = ".nil? and ";
  protected final String TEXT_879 = ".";
  protected final String TEXT_880 = " <= ";
  protected final String TEXT_881 = ".";
  protected final String TEXT_882 = NL + "      return was_added" + NL + "    elsif !";
  protected final String TEXT_883 = ".nil?";
  protected final String TEXT_884 = NL + "      ";
  protected final String TEXT_885 = ".instance_variable_get(\"@";
  protected final String TEXT_886 = "\").delete(";
  protected final String TEXT_887 = ")" + NL + "    end" + NL + "    @";
  protected final String TEXT_888 = " << ";
  protected final String TEXT_889 = NL + "    ";
  protected final String TEXT_890 = ".instance_variable_set(\"@";
  protected final String TEXT_891 = "\",self)" + NL + "    was_added = true";
  protected final String TEXT_892 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_893 = "(";
  protected final String TEXT_894 = ")" + NL + "    was_removed = false";
  protected final String TEXT_895 = NL + "    if @";
  protected final String TEXT_896 = ".include?(";
  protected final String TEXT_897 = ") and ";
  protected final String TEXT_898 = " > ";
  protected final String TEXT_899 = ".";
  protected final String TEXT_900 = NL + "      @";
  protected final String TEXT_901 = ".delete(";
  protected final String TEXT_902 = ")";
  protected final String TEXT_903 = NL + "      ";
  protected final String TEXT_904 = ".instance_variable_set(\"@";
  protected final String TEXT_905 = "\",nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_906 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_907 = NL + "  def ";
  protected final String TEXT_908 = "(";
  protected final String TEXT_909 = ")" + NL + "    was_set = false";
  protected final String TEXT_910 = NL + "    ";
  protected final String TEXT_911 = " = []";
  protected final String TEXT_912 = NL + "    ";
  protected final String TEXT_913 = ".each do |";
  protected final String TEXT_914 = "|" + NL + "      if ";
  protected final String TEXT_915 = ".include?(";
  protected final String TEXT_916 = ")";
  protected final String TEXT_917 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_918 = ".";
  protected final String TEXT_919 = ".nil? and !";
  protected final String TEXT_920 = ".";
  protected final String TEXT_921 = ".eql?(self)";
  protected final String TEXT_922 = NL + "        return was_set" + NL + "      end";
  protected final String TEXT_923 = NL + "      ";
  protected final String TEXT_924 = " << ";
  protected final String TEXT_925 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_926 = ".size != ";
  protected final String TEXT_927 = ".";
  protected final String TEXT_928 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_929 = NL + "    ";
  protected final String TEXT_930 = ".each do |";
  protected final String TEXT_931 = "|" + NL + "      @";
  protected final String TEXT_932 = ".delete(";
  protected final String TEXT_933 = ")" + NL + "    end" + NL + "    " + NL + "    @";
  protected final String TEXT_934 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_935 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_936 = ".clear";
  protected final String TEXT_937 = NL + "    ";
  protected final String TEXT_938 = ".each do |";
  protected final String TEXT_939 = "|";
  protected final String TEXT_940 = NL + "      ";
  protected final String TEXT_941 = ".instance_variable_set(\"@";
  protected final String TEXT_942 = "\",self)" + NL + "      @";
  protected final String TEXT_943 = " << ";
  protected final String TEXT_944 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_945 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_946 = NL + "  def ";
  protected final String TEXT_947 = "(";
  protected final String TEXT_948 = ")" + NL + "    was_added = false";
  protected final String TEXT_949 = NL + "    @";
  protected final String TEXT_950 = " << ";
  protected final String TEXT_951 = NL + "    was_added = true";
  protected final String TEXT_952 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_953 = "(";
  protected final String TEXT_954 = ")" + NL + "    was_removed = false";
  protected final String TEXT_955 = NL + "    if @";
  protected final String TEXT_956 = ".include?(";
  protected final String TEXT_957 = ")" + NL + "      @";
  protected final String TEXT_958 = ".delete(";
  protected final String TEXT_959 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_960 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_961 = NL + "  def ";
  protected final String TEXT_962 = "(";
  protected final String TEXT_963 = ")" + NL + "    was_added = false";
  protected final String TEXT_964 = NL + "    if ";
  protected final String TEXT_965 = " < ";
  protected final String TEXT_966 = ".";
  protected final String TEXT_967 = NL + "      @";
  protected final String TEXT_968 = " << ";
  protected final String TEXT_969 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_970 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_971 = "(";
  protected final String TEXT_972 = ")" + NL + "    was_removed = false";
  protected final String TEXT_973 = NL + "    if @";
  protected final String TEXT_974 = ".include?(";
  protected final String TEXT_975 = ")" + NL + "      @";
  protected final String TEXT_976 = ".delete(";
  protected final String TEXT_977 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_978 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_979 = NL + "  def ";
  protected final String TEXT_980 = "(";
  protected final String TEXT_981 = ")" + NL + "    was_added = false";
  protected final String TEXT_982 = NL + "    @";
  protected final String TEXT_983 = " << ";
  protected final String TEXT_984 = NL + "    was_added = true";
  protected final String TEXT_985 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_986 = "(";
  protected final String TEXT_987 = ")" + NL + "    was_removed = false";
  protected final String TEXT_988 = NL + "    unless @";
  protected final String TEXT_989 = ".include?(";
  protected final String TEXT_990 = ")";
  protected final String TEXT_991 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_992 = " <= ";
  protected final String TEXT_993 = ".";
  protected final String TEXT_994 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_995 = ".delete(";
  protected final String TEXT_996 = ")" + NL + "    was_removed = true";
  protected final String TEXT_997 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_998 = NL + "  def ";
  protected final String TEXT_999 = "(";
  protected final String TEXT_1000 = ")" + NL + "    was_set = false";
  protected final String TEXT_1001 = NL + "    ";
  protected final String TEXT_1002 = " = []";
  protected final String TEXT_1003 = NL + "    ";
  protected final String TEXT_1004 = ".each do |";
  protected final String TEXT_1005 = "|" + NL + "      next if (";
  protected final String TEXT_1006 = ".include?(";
  protected final String TEXT_1007 = "))";
  protected final String TEXT_1008 = NL + "      ";
  protected final String TEXT_1009 = " << ";
  protected final String TEXT_1010 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1011 = ".size != ";
  protected final String TEXT_1012 = ".size or ";
  protected final String TEXT_1013 = ".size() != ";
  protected final String TEXT_1014 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1015 = ".clear";
  protected final String TEXT_1016 = NL + "    ";
  protected final String TEXT_1017 = ".each do |";
  protected final String TEXT_1018 = "|" + NL + "      @";
  protected final String TEXT_1019 = " << ";
  protected final String TEXT_1020 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1021 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1022 = NL + "  def ";
  protected final String TEXT_1023 = "(";
  protected final String TEXT_1024 = ")" + NL + "    was_set = false";
  protected final String TEXT_1025 = NL + "    ";
  protected final String TEXT_1026 = " = []";
  protected final String TEXT_1027 = NL + "    ";
  protected final String TEXT_1028 = ".each do |";
  protected final String TEXT_1029 = "|" + NL + "      next if (";
  protected final String TEXT_1030 = ".include?(";
  protected final String TEXT_1031 = ")) ";
  protected final String TEXT_1032 = NL + "      ";
  protected final String TEXT_1033 = " << ";
  protected final String TEXT_1034 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1035 = ".size != ";
  protected final String TEXT_1036 = ".length or ";
  protected final String TEXT_1037 = ".size < ";
  protected final String TEXT_1038 = ".";
  protected final String TEXT_1039 = " or ";
  protected final String TEXT_1040 = ".size() > ";
  protected final String TEXT_1041 = ".";
  protected final String TEXT_1042 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1043 = NL + "    ";
  protected final String TEXT_1044 = " = @";
  protected final String TEXT_1045 = ".dup" + NL + "    @";
  protected final String TEXT_1046 = ".clear";
  protected final String TEXT_1047 = NL + "    ";
  protected final String TEXT_1048 = ".each do |";
  protected final String TEXT_1049 = "|" + NL + "      @";
  protected final String TEXT_1050 = " << ";
  protected final String TEXT_1051 = NL + "      if ";
  protected final String TEXT_1052 = ".include?(";
  protected final String TEXT_1053 = ")";
  protected final String TEXT_1054 = NL + "        ";
  protected final String TEXT_1055 = ".delete(";
  protected final String TEXT_1056 = ")" + NL + "      else";
  protected final String TEXT_1057 = NL + "        ";
  protected final String TEXT_1058 = ".";
  protected final String TEXT_1059 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1060 = NL + "    ";
  protected final String TEXT_1061 = ".each do |";
  protected final String TEXT_1062 = "|";
  protected final String TEXT_1063 = NL + "      ";
  protected final String TEXT_1064 = ".";
  protected final String TEXT_1065 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1066 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1067 = NL + "  def ";
  protected final String TEXT_1068 = "(";
  protected final String TEXT_1069 = ")" + NL + "    was_set = false";
  protected final String TEXT_1070 = NL + "    ";
  protected final String TEXT_1071 = " = []";
  protected final String TEXT_1072 = NL + "    ";
  protected final String TEXT_1073 = ".each do |";
  protected final String TEXT_1074 = "|" + NL + "      next if (";
  protected final String TEXT_1075 = ".include?(";
  protected final String TEXT_1076 = "))";
  protected final String TEXT_1077 = NL + "      ";
  protected final String TEXT_1078 = " << ";
  protected final String TEXT_1079 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1080 = ".size != ";
  protected final String TEXT_1081 = ".size or ";
  protected final String TEXT_1082 = ".size < ";
  protected final String TEXT_1083 = ".";
  protected final String TEXT_1084 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1085 = NL + "    ";
  protected final String TEXT_1086 = " = @";
  protected final String TEXT_1087 = ".dup" + NL + "    @";
  protected final String TEXT_1088 = ".clear";
  protected final String TEXT_1089 = NL + "    ";
  protected final String TEXT_1090 = ".each do |";
  protected final String TEXT_1091 = "|" + NL + "      @";
  protected final String TEXT_1092 = " << ";
  protected final String TEXT_1093 = NL + "      if ";
  protected final String TEXT_1094 = ".include?(";
  protected final String TEXT_1095 = ")";
  protected final String TEXT_1096 = NL + "        ";
  protected final String TEXT_1097 = ".delete(";
  protected final String TEXT_1098 = ")" + NL + "      else";
  protected final String TEXT_1099 = NL + "        ";
  protected final String TEXT_1100 = ".";
  protected final String TEXT_1101 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1102 = NL + "    ";
  protected final String TEXT_1103 = ".each do |";
  protected final String TEXT_1104 = "|";
  protected final String TEXT_1105 = NL + "      ";
  protected final String TEXT_1106 = ".";
  protected final String TEXT_1107 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1108 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1109 = NL + "  def ";
  protected final String TEXT_1110 = "(";
  protected final String TEXT_1111 = ")" + NL + "    was_set = false";
  protected final String TEXT_1112 = NL + "    ";
  protected final String TEXT_1113 = " = []";
  protected final String TEXT_1114 = NL + "    ";
  protected final String TEXT_1115 = ".each do |";
  protected final String TEXT_1116 = "|" + NL + "      next if (";
  protected final String TEXT_1117 = ".include?(";
  protected final String TEXT_1118 = "))";
  protected final String TEXT_1119 = NL + "      ";
  protected final String TEXT_1120 = " << ";
  protected final String TEXT_1121 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1122 = ".size != ";
  protected final String TEXT_1123 = ".size or ";
  protected final String TEXT_1124 = ".size < ";
  protected final String TEXT_1125 = ".";
  protected final String TEXT_1126 = " or ";
  protected final String TEXT_1127 = ".size > ";
  protected final String TEXT_1128 = ".";
  protected final String TEXT_1129 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1130 = ".clear";
  protected final String TEXT_1131 = NL + "    ";
  protected final String TEXT_1132 = ".each do |";
  protected final String TEXT_1133 = "|" + NL + "      @";
  protected final String TEXT_1134 = " << ";
  protected final String TEXT_1135 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1136 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1137 = NL + "  def ";
  protected final String TEXT_1138 = "(";
  protected final String TEXT_1139 = ")" + NL + "    was_set = false";
  protected final String TEXT_1140 = NL + "    if ";
  protected final String TEXT_1141 = ".length < ";
  protected final String TEXT_1142 = ".";
  protected final String TEXT_1143 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1144 = NL + "    ";
  protected final String TEXT_1145 = " = []";
  protected final String TEXT_1146 = NL + "    ";
  protected final String TEXT_1147 = " = {}";
  protected final String TEXT_1148 = NL + "    ";
  protected final String TEXT_1149 = ".each do |";
  protected final String TEXT_1150 = "|" + NL + "      if ";
  protected final String TEXT_1151 = ".include?(";
  protected final String TEXT_1152 = ")";
  protected final String TEXT_1153 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_1154 = ".";
  protected final String TEXT_1155 = ".nil? and !";
  protected final String TEXT_1156 = ".";
  protected final String TEXT_1157 = ".eql?(self)";
  protected final String TEXT_1158 = NL + "        ";
  protected final String TEXT_1159 = " = ";
  protected final String TEXT_1160 = ".";
  protected final String TEXT_1161 = NL + "        unless ";
  protected final String TEXT_1162 = ".has_key?(";
  protected final String TEXT_1163 = ")";
  protected final String TEXT_1164 = NL + "          ";
  protected final String TEXT_1165 = "[";
  protected final String TEXT_1166 = "] = ";
  protected final String TEXT_1167 = ".";
  protected final String TEXT_1168 = NL + "        end" + NL + "        currentCount = ";
  protected final String TEXT_1169 = "[";
  protected final String TEXT_1170 = "]" + NL + "        nextCount = currentCount - 1" + NL + "        if nextCount < ";
  protected final String TEXT_1171 = NL + "          return was_set" + NL + "        end";
  protected final String TEXT_1172 = NL + "        ";
  protected final String TEXT_1173 = "[";
  protected final String TEXT_1174 = "] = nextCount" + NL + "      end";
  protected final String TEXT_1175 = NL + "      ";
  protected final String TEXT_1176 = " << ";
  protected final String TEXT_1177 = NL + "    end" + NL;
  protected final String TEXT_1178 = NL + "    ";
  protected final String TEXT_1179 = ".each do |";
  protected final String TEXT_1180 = "|" + NL + "      @";
  protected final String TEXT_1181 = ".delete(";
  protected final String TEXT_1182 = ")" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1183 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_1184 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1185 = ".clear";
  protected final String TEXT_1186 = NL + "    ";
  protected final String TEXT_1187 = ".each do |";
  protected final String TEXT_1188 = "|" + NL + "      unless ";
  protected final String TEXT_1189 = ".";
  protected final String TEXT_1190 = ".nil?";
  protected final String TEXT_1191 = NL + "        ";
  protected final String TEXT_1192 = ".";
  protected final String TEXT_1193 = ".instance_variable_get(\"@";
  protected final String TEXT_1194 = "\").delete(";
  protected final String TEXT_1195 = ")" + NL + "      end";
  protected final String TEXT_1196 = NL + "      ";
  protected final String TEXT_1197 = ".instance_variable_set(\"@";
  protected final String TEXT_1198 = "\",self)" + NL + "      @";
  protected final String TEXT_1199 = " << ";
  protected final String TEXT_1200 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1201 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1202 = NL + "  def ";
  protected final String TEXT_1203 = "(";
  protected final String TEXT_1204 = ")" + NL + "    was_set = false";
  protected final String TEXT_1205 = NL + "    ";
  protected final String TEXT_1206 = " = []";
  protected final String TEXT_1207 = NL + "    ";
  protected final String TEXT_1208 = ".each do |";
  protected final String TEXT_1209 = "|" + NL + "      next if (";
  protected final String TEXT_1210 = ".include?(";
  protected final String TEXT_1211 = "))";
  protected final String TEXT_1212 = NL + "      ";
  protected final String TEXT_1213 = " << ";
  protected final String TEXT_1214 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1215 = ".size != ";
  protected final String TEXT_1216 = ".size or ";
  protected final String TEXT_1217 = ".size() > ";
  protected final String TEXT_1218 = ".";
  protected final String TEXT_1219 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1220 = ".clear";
  protected final String TEXT_1221 = NL + "    ";
  protected final String TEXT_1222 = ".each do |";
  protected final String TEXT_1223 = "|" + NL + "      @";
  protected final String TEXT_1224 = " << ";
  protected final String TEXT_1225 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1226 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1227 = NL + "  def ";
  protected final String TEXT_1228 = "(";
  protected final String TEXT_1229 = ")" + NL + "    was_set = false";
  protected final String TEXT_1230 = NL + "    ";
  protected final String TEXT_1231 = " = []";
  protected final String TEXT_1232 = NL + "    ";
  protected final String TEXT_1233 = ".each do |";
  protected final String TEXT_1234 = "|" + NL + "      next if (";
  protected final String TEXT_1235 = ".include?(";
  protected final String TEXT_1236 = "))";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = " << ";
  protected final String TEXT_1239 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1240 = ".size != ";
  protected final String TEXT_1241 = ".size or ";
  protected final String TEXT_1242 = ".size() < ";
  protected final String TEXT_1243 = ".";
  protected final String TEXT_1244 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1245 = ".clear";
  protected final String TEXT_1246 = NL + "    ";
  protected final String TEXT_1247 = ".each do |";
  protected final String TEXT_1248 = "|" + NL + "      @";
  protected final String TEXT_1249 = " << ";
  protected final String TEXT_1250 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1251 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1252 = NL + "  def eql?(obj)" + NL + "    return false if obj.nil?" + NL + "    return false unless self.class == obj.class" + NL + "" + NL + "    compareTo = obj";
  protected final String TEXT_1253 = NL + "    ";
  protected final String TEXT_1254 = NL + "    true" + NL + "  end" + NL + "" + NL + "  def hash" + NL + "    return @cachedHashCode unless @cachedHashCode == -1" + NL + "    @cachedHashCode = 17";
  protected final String TEXT_1255 = NL + "    ";
  protected final String TEXT_1256 = NL + "    ";
  protected final String TEXT_1257 = NL + "    @cachedHashCode" + NL + "  end" + NL;
  protected final String TEXT_1258 = NL + "  def ";
  protected final String TEXT_1259 = NL + "    ";
  protected final String TEXT_1260 = NL + "  end" + NL;
  protected final String TEXT_1261 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1262 = NL + "    ";
  protected final String TEXT_1263 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1264 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    def run()" + NL + "    {" + NL + "      try" + NL + "      {";
  protected final String TEXT_1265 = NL + "        ";
  protected final String TEXT_1266 = NL + "      }" + NL + "      catch (InterruptedException e)" + NL + "      {" + NL + "        e.printStackTrace();" + NL + "      }" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1267 = NL + "  def ";
  protected final String TEXT_1268 = NL + "    ";
  protected final String TEXT_1269 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1270 = "\",";
  protected final String TEXT_1271 = ")" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1272 = NL + "    ";
  protected final String TEXT_1273 = ".stop()" + NL + "  end" + NL;
  protected final String TEXT_1274 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1275 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1276 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    def stop" + NL + "      timer.cancel();" + NL + "    end" + NL + "    " + NL + "    def run";
  protected final String TEXT_1277 = NL + "      if (\"";
  protected final String TEXT_1278 = "\".eql?(timeoutMethodName))" + NL + "      {" + NL + "        shouldRestart = !controller.";
  protected final String TEXT_1279 = NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1280 = NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1281 = NL + "    end" + NL + "  }" + NL;
  protected final String TEXT_1282 = NL + "    @";
  protected final String TEXT_1283 = " = nil";
  protected final String TEXT_1284 = NL + "    @";
  protected final String TEXT_1285 = ".clear";
  protected final String TEXT_1286 = NL + "    ";
  protected final String TEXT_1287 = " = @";
  protected final String TEXT_1288 = NL + "    @";
  protected final String TEXT_1289 = " = nil" + NL + "    unless ";
  protected final String TEXT_1290 = ".nil?";
  protected final String TEXT_1291 = NL + "      ";
  protected final String TEXT_1292 = ".delete" + NL + "    end";
  protected final String TEXT_1293 = NL + "    unless @";
  protected final String TEXT_1294 = ".nil?" + NL + "      @";
  protected final String TEXT_1295 = ".";
  protected final String TEXT_1296 = "(nil)" + NL + "    end";
  protected final String TEXT_1297 = NL + "    ";
  protected final String TEXT_1298 = " = @";
  protected final String TEXT_1299 = NL + "    @";
  protected final String TEXT_1300 = " = nil" + NL + "    unless ";
  protected final String TEXT_1301 = ".nil?";
  protected final String TEXT_1302 = NL + "      ";
  protected final String TEXT_1303 = ".";
  protected final String TEXT_1304 = "(nil)" + NL + "    end";
  protected final String TEXT_1305 = NL + "    ";
  protected final String TEXT_1306 = " = @";
  protected final String TEXT_1307 = NL + "    @";
  protected final String TEXT_1308 = " = nil" + NL + "    unless ";
  protected final String TEXT_1309 = ".nil?";
  protected final String TEXT_1310 = NL + "      ";
  protected final String TEXT_1311 = ".delete" + NL + "    end";
  protected final String TEXT_1312 = NL + "    unless @";
  protected final String TEXT_1313 = ".nil?" + NL + "      @";
  protected final String TEXT_1314 = ".";
  protected final String TEXT_1315 = "(self)" + NL + "    end";
  protected final String TEXT_1316 = NL + "    unless @";
  protected final String TEXT_1317 = ".nil?" + NL + "      @";
  protected final String TEXT_1318 = ".delete" + NL + "    end";
  protected final String TEXT_1319 = NL + "    unless @";
  protected final String TEXT_1320 = ".nil?" + NL + "      if @";
  protected final String TEXT_1321 = ".";
  protected final String TEXT_1322 = " <= ";
  protected final String TEXT_1323 = NL + "        @";
  protected final String TEXT_1324 = ".delete" + NL + "      else" + NL + "        @";
  protected final String TEXT_1325 = ".";
  protected final String TEXT_1326 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1327 = NL + "    @";
  protected final String TEXT_1328 = ".";
  protected final String TEXT_1329 = "(self)";
  protected final String TEXT_1330 = NL + "    @";
  protected final String TEXT_1331 = ".each do |";
  protected final String TEXT_1332 = "|";
  protected final String TEXT_1333 = NL + "      ";
  protected final String TEXT_1334 = ".instance_variable_set(\"@";
  protected final String TEXT_1335 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1336 = ".clear";
  protected final String TEXT_1337 = NL + "    ";
  protected final String TEXT_1338 = " = @";
  protected final String TEXT_1339 = ".dup" + NL + "    @";
  protected final String TEXT_1340 = ".clear";
  protected final String TEXT_1341 = NL + "    ";
  protected final String TEXT_1342 = ".each do |";
  protected final String TEXT_1343 = "|" + NL + "      if ";
  protected final String TEXT_1344 = ".";
  protected final String TEXT_1345 = " <= ";
  protected final String TEXT_1346 = ".";
  protected final String TEXT_1347 = NL + "        ";
  protected final String TEXT_1348 = ".delete" + NL + "      else";
  protected final String TEXT_1349 = NL + "        ";
  protected final String TEXT_1350 = ".";
  protected final String TEXT_1351 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1352 = NL + "    ";
  protected final String TEXT_1353 = " = @";
  protected final String TEXT_1354 = ".dup" + NL + "    @";
  protected final String TEXT_1355 = ".clear";
  protected final String TEXT_1356 = NL + "    ";
  protected final String TEXT_1357 = ".each do |";
  protected final String TEXT_1358 = "|";
  protected final String TEXT_1359 = NL + "      ";
  protected final String TEXT_1360 = ".";
  protected final String TEXT_1361 = "(self)" + NL + "    end";
  protected final String TEXT_1362 = NL + "    @";
  protected final String TEXT_1363 = ".each do |";
  protected final String TEXT_1364 = "|";
  protected final String TEXT_1365 = NL + "      ";
  protected final String TEXT_1366 = ".delete" + NL + "    end";
  protected final String TEXT_1367 = NL + "    @";
  protected final String TEXT_1368 = ".each do |";
  protected final String TEXT_1369 = "|";
  protected final String TEXT_1370 = NL + "      ";
  protected final String TEXT_1371 = ".";
  protected final String TEXT_1372 = "(nil)" + NL + "    end";
  protected final String TEXT_1373 = NL + NL;
  protected final String TEXT_1374 = NL + "  #------------------------" + NL + "  # DEVELOPER CODE - PROVIDED AS-IS" + NL + "  #------------------------" + NL + "  ";
  protected final String TEXT_1375 = NL + "  ";
  protected final String TEXT_1376 = NL + "end";
  protected final String TEXT_1377 = NL;

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
     if (uClass.numberOfComments() > 0) { if(!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("RubyMultiline",uClass.getComments()));} else { append(stringBuffer, "\n{0}", Comment.format("Hash",uClass.getComments()));} } 
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
    append(stringBuffer, "\n    {0}",customConstructorPrefixCode);
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
    else if ("immutable".equals(av.getModifier()) && av.getIsLazy())
    {
      
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_13);
    
    }
    else if ("immutable".equals(av.getModifier()))
    {
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_17);
     
    }
    else
    {
      if(!av.getIsLazy()){
         
    
  if(!av.getIsLazy()){
    String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_18);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate(parameterLookup,av));
     } 
    
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
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_25);
    
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
        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_30);
    
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
  

    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_40);
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_42);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_44);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_51);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_53);
    
    }
    else if (av.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_61);
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
  

    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_71);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_74);
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
    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_78);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_83);
    
    }
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
    if (av != null && !"immutable".equals(av.getModifier()))
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
  
  if (customConstructorPostfixCode != null)
  {
    append(stringBuffer, "\n    {0}",customConstructorPostfixCode);
  }

  appendln(stringBuffer, "\n    @initialized = true");
  append(stringBuffer, "  end");

    stringBuffer.append(TEXT_84);
     } 
    stringBuffer.append(TEXT_85);
    
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
    
    if ("immutable".equals(av.getModifier()))
    {
      if (av.getIsLazy())
      {
        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_88);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_89);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_92);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_93);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_96);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_99);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_101);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n    {0}",customResetPrefixCode); } 
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_104);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n    {0}",customResetPostfixCode); } 
    stringBuffer.append(TEXT_105);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_108);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("parameterOne",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_113);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_116);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_117);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_118);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_120);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_123);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_124);
    
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
      
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_126);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_129);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_137);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_141);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_144);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_147);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_150);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_151);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_156);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_158);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_159);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_160);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_161);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_163);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_164);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_165);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_167);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_170);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPostfixCode); } 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_172);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_174);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_175);
    
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
        
    stringBuffer.append(TEXT_176);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_177);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_179);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_180);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_181);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_183);
    
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
      
    stringBuffer.append(TEXT_184);
    stringBuffer.append( gen.translate("isMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_187);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_188);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_189);
    stringBuffer.append( gen.translate("isMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_191);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_192);
    stringBuffer.append( gen.translate("isMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_193);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_195);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_196);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_197);
    stringBuffer.append( gen.translate("isMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_199);
    
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
    
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_202);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_203);
    
    if (sm.hasFinalStates())
    {
      
    

  StringBuilder output = new StringBuilder();
  for(State state : sm.getFinalStates())
  {
    StateMachine finalSm = state.getStateMachine();
    if (output.length() > 0)
    {
      output.append(" && ");
    }
    output.append(StringFormatter.format("{0} == {1}.{2}",gen.translate("stateMachineOne",finalSm),gen.translate("type",finalSm),gen.translate("stateOne",state)));
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("isFinalMethod",sm));
    stringBuffer.append(TEXT_205);
    stringBuffer.append( outputAsString );
    stringBuffer.append(TEXT_206);
      
    }
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
        if (t.getGuard() != null)
        {
          allCases.append(StringFormatter.format("        if ({0})\n",t.getGuard().getCondition()));
          allCases.append(StringFormatter.format("        {\n"));
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
    allCases.append(StringFormatter.format("    }\n\n"));
  }
  

  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_207);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_210);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_212);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_217);
    
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
      entryActions.append(StringFormatter.format("\n        new DoActivityThread(this,\"{0}\");",gen.translate("doActivityMethod",state)));
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
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_219);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(TEXT_221);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_222);
     } 
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_224);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(TEXT_227);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( gen.translate("parameterOne",sm) );
     if (hasEntry) { 
    stringBuffer.append(TEXT_229);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(TEXT_231);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_232);
     } 
    stringBuffer.append(TEXT_233);
    
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
      
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("associationOne",av));
     } else { 
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("associationOne",av));
     append(stringBuffer, "\n    {0}",customGetPostfixCode); 
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("parameterOne",av));
     } 
    stringBuffer.append(TEXT_239);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_241);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_244);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_249);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_253);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_256);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_259);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_262);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_263);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_264);
    
    }
 }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
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
      
    stringBuffer.append(TEXT_265);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPrefixCode); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     } else { 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPostfixCode); } 
    stringBuffer.append(TEXT_277);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_280);
     } else { 
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_282);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_283);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_286);
     } else { 
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_288);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_289);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_292);
     } else { 
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_294);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_295);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_298);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_302);
     } 
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_311);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_312);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_315);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_318);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_328);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_329);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_332);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_335);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_336);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_339);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_343);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_344);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_347);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_355);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_370);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_371);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_374);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_379);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_388);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_389);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_400);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_401);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_404);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_421);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_424);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_429);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_437);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_438);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_441);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_445);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_462);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_465);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_470);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_478);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_479);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_498);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_501);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_508);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_509);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_512);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_527);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_528);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_551);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_552);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_555);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_577);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_578);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_581);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_593);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_594);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_612);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_613);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_616);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_619);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_632);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_633);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_636);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_639);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_652);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_653);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_656);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_662);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_677);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_678);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_681);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_683);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_684);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_697);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_698);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_701);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_705);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_712);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_726);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_727);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_730);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_734);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_740);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_754);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_755);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_758);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_776);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_779);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_787);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_788);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_791);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_806);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_807);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_810);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_814);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_832);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_835);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_843);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_844);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_856);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_859);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_866);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_869);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_873);
     } 
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_891);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_894);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_905);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_906);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_909);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_916);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_921);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_922);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_928);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_944);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_945);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_948);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_951);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_954);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_959);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_960);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_963);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_969);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_972);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_978);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_981);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_984);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_987);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_990);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_996);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_997);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1000);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1021);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1024);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1065);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1066);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1069);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1107);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1108);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1111);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1136);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" or {0}.size > {2}.{1}", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av),uClass.getName());

    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1139);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(orCheckMaxBound);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1152);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n          {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1200);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1201);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1204);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1225);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1226);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1229);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1250);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1251);
    
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


    stringBuffer.append(TEXT_1252);
    stringBuffer.append(TEXT_1253);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(TEXT_1255);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1256);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1257);
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
        
    stringBuffer.append(TEXT_1258);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1260);
    
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

    stringBuffer.append(TEXT_1261);
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(TEXT_1265);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1266);
    
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
        
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1268);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1269);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1270);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1272);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1273);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1274);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1275);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1276);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1277);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1278);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1279);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1280);
    
      }
    }
  }

    stringBuffer.append(TEXT_1281);
    
  }
}

    

  appendln(stringBuffer,"");
  append(stringBuffer,"  def delete");

  append(stringBuffer, "\n    @deleted = true");

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(stringBuffer, "\n    {0}",customDeletePrefixCode);
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
        
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1283);
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1285);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1292);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1296);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1304);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1311);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1315);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1318);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1326);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1329);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1336);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1351);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1361);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1366);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1372);
    
    }
    else
    {
      continue;
    }
  }
  
  if (!uClass.isRoot() && !"external".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(stringBuffer,"");
    append(stringBuffer, "    super.delete");
  }

  if (customDeletePostfixCode != null) 
  {
    append(stringBuffer, "\n    {0}",customDeletePostfixCode);
  }

  appendln(stringBuffer, "");
  appendln(stringBuffer, "  end");


     if (uClass.hasMethods()) { 
    
    if (uClass.hasMethods())
    {
    	for (Method aMethod : uClass.getMethods()) 
    	{
    		String methodName = aMethod.getName();
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
    			append(stringBuffer, " def {0} ({1})", methodName, finalParams);	
				appendln(stringBuffer, "end");
    			
    		}
    		else{
    			appendln(stringBuffer, "");
    			append(stringBuffer, " def {0}()", methodName);
    			appendln(stringBuffer, "end");
    		}
    	}
    }

    stringBuffer.append(TEXT_1373);
     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}