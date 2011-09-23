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
  protected final String TEXT_184 = NL + "  public ";
  protected final String TEXT_185 = " ";
  protected final String TEXT_186 = NL + "    ";
  protected final String TEXT_187 = NL + "  end" + NL;
  protected final String TEXT_188 = NL + "  def ";
  protected final String TEXT_189 = NL + "  {" + NL + "    wasEventProcessed = false;" + NL;
  protected final String TEXT_190 = NL + "    ";
  protected final String TEXT_191 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_192 = NL + "  def ";
  protected final String TEXT_193 = "(";
  protected final String TEXT_194 = " ";
  protected final String TEXT_195 = ")" + NL + "  {";
  protected final String TEXT_196 = NL + "    ";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_199 = NL + "  def ";
  protected final String TEXT_200 = NL + "    switch(";
  protected final String TEXT_201 = ")";
  protected final String TEXT_202 = NL + "      ";
  protected final String TEXT_203 = NL + "    end" + NL + "  end" + NL;
  protected final String TEXT_204 = NL + "  private void ";
  protected final String TEXT_205 = "(";
  protected final String TEXT_206 = " ";
  protected final String TEXT_207 = ")" + NL + "  {";
  protected final String TEXT_208 = NL + "    ";
  protected final String TEXT_209 = " = ";
  protected final String TEXT_210 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_211 = ")" + NL + "    {";
  protected final String TEXT_212 = NL + "      ";
  protected final String TEXT_213 = NL + "    }";
  protected final String TEXT_214 = NL + "  }" + NL;
  protected final String TEXT_215 = NL + "  def ";
  protected final String TEXT_216 = NL + "    @";
  protected final String TEXT_217 = NL + "    ";
  protected final String TEXT_218 = " = @";
  protected final String TEXT_219 = NL + "    ";
  protected final String TEXT_220 = NL + "  end" + NL;
  protected final String TEXT_221 = NL + "  def ";
  protected final String TEXT_222 = "(index)";
  protected final String TEXT_223 = NL + "    ";
  protected final String TEXT_224 = " = @";
  protected final String TEXT_225 = "[index]";
  protected final String TEXT_226 = NL + "    ";
  protected final String TEXT_227 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_228 = NL + "    ";
  protected final String TEXT_229 = " = @";
  protected final String TEXT_230 = ".dup";
  protected final String TEXT_231 = NL + "    ";
  protected final String TEXT_232 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_233 = NL + "    number = @";
  protected final String TEXT_234 = ".size";
  protected final String TEXT_235 = NL + "    number" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_236 = NL + "    has = @";
  protected final String TEXT_237 = ".size > 0";
  protected final String TEXT_238 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_239 = "(";
  protected final String TEXT_240 = ")";
  protected final String TEXT_241 = NL + "    index = @";
  protected final String TEXT_242 = ".index(";
  protected final String TEXT_243 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_244 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_245 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_246 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_247 = " : ";
  protected final String TEXT_248 = NL + "  def ";
  protected final String TEXT_249 = NL + "    is_valid = ";
  protected final String TEXT_250 = " >= ";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = NL + "    is_valid = ";
  protected final String TEXT_253 = " >= ";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " and ";
  protected final String TEXT_256 = " <= ";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = NL + "    is_valid" + NL + "  end";
  protected final String TEXT_259 = NL + "  def self.";
  protected final String TEXT_260 = NL + "    ";
  protected final String TEXT_261 = NL + "  end";
  protected final String TEXT_262 = NL + "  def self.";
  protected final String TEXT_263 = NL + "    minimum = ";
  protected final String TEXT_264 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_265 = NL + "  def self.";
  protected final String TEXT_266 = NL + "    ";
  protected final String TEXT_267 = NL + "  end";
  protected final String TEXT_268 = NL + "  def self.";
  protected final String TEXT_269 = NL + "    minimum = ";
  protected final String TEXT_270 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_271 = NL + "  def self.";
  protected final String TEXT_272 = NL + "    ";
  protected final String TEXT_273 = NL + "  end";
  protected final String TEXT_274 = NL + "  def self.";
  protected final String TEXT_275 = NL + "    maximum = ";
  protected final String TEXT_276 = NL + "    maximum" + NL + "  end";
  protected final String TEXT_277 = NL + "  def ";
  protected final String TEXT_278 = "(";
  protected final String TEXT_279 = ")" + NL + "    was_added = false";
  protected final String TEXT_280 = NL + "    if ";
  protected final String TEXT_281 = " >= ";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_284 = NL + "    @";
  protected final String TEXT_285 = " << ";
  protected final String TEXT_286 = NL + "    if ";
  protected final String TEXT_287 = ".";
  protected final String TEXT_288 = "(self) != -1" + NL + "      was_added = true" + NL + "    else" + NL + "      was_added = ";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = "(self)" + NL + "      unless was_added" + NL + "        @";
  protected final String TEXT_291 = ".delete(";
  protected final String TEXT_292 = ")" + NL + "      end" + NL + "    end";
  protected final String TEXT_293 = NL + "    was_added" + NL + "  end";
  protected final String TEXT_294 = NL + "  def ";
  protected final String TEXT_295 = "(";
  protected final String TEXT_296 = ")" + NL + "    was_removed = false";
  protected final String TEXT_297 = NL + "    unless @";
  protected final String TEXT_298 = ".include?(";
  protected final String TEXT_299 = ")";
  protected final String TEXT_300 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_301 = ".index(";
  protected final String TEXT_302 = ")" + NL + "    @";
  protected final String TEXT_303 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_304 = ".";
  protected final String TEXT_305 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_306 = ".";
  protected final String TEXT_307 = "(self)" + NL + "      @";
  protected final String TEXT_308 = ".insert(oldIndex,";
  protected final String TEXT_309 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_310 = NL + "    was_removed" + NL + "  end";
  protected final String TEXT_311 = NL + "  def ";
  protected final String TEXT_312 = "(";
  protected final String TEXT_313 = ")" + NL + "    was_set = false";
  protected final String TEXT_314 = NL + "    @";
  protected final String TEXT_315 = " = ";
  protected final String TEXT_316 = NL + "    was_set = true";
  protected final String TEXT_317 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_318 = NL + "  def ";
  protected final String TEXT_319 = "(";
  protected final String TEXT_320 = ")" + NL + "    was_set = false";
  protected final String TEXT_321 = NL + "    unless ";
  protected final String TEXT_322 = ".nil?" + NL + "      @";
  protected final String TEXT_323 = " = ";
  protected final String TEXT_324 = NL + "      was_set = true" + NL + "    end";
  protected final String TEXT_325 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_326 = NL + "  def ";
  protected final String TEXT_327 = "(";
  protected final String TEXT_328 = ")" + NL + "    was_set = false";
  protected final String TEXT_329 = NL + "    if !@";
  protected final String TEXT_330 = ".nil? and !@";
  protected final String TEXT_331 = ".eql?(";
  protected final String TEXT_332 = ") and self.eql?(@";
  protected final String TEXT_333 = ".";
  protected final String TEXT_334 = ")" + NL + "      #Unable to ";
  protected final String TEXT_335 = ", as existing @";
  protected final String TEXT_336 = " would become an orphan";
  protected final String TEXT_337 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_338 = " = ";
  protected final String TEXT_339 = NL + "    ";
  protected final String TEXT_340 = " = !";
  protected final String TEXT_341 = ".nil? ? ";
  protected final String TEXT_342 = ".";
  protected final String TEXT_343 = " : nil" + NL + "" + NL + "    unless self.eql?(";
  protected final String TEXT_344 = ")" + NL + "      unless ";
  protected final String TEXT_345 = ".nil?";
  protected final String TEXT_346 = NL + "        ";
  protected final String TEXT_347 = ".instance_variable_set(\"@";
  protected final String TEXT_348 = "\",nil)" + NL + "      end" + NL + "      unless @";
  protected final String TEXT_349 = ".nil?" + NL + "        @";
  protected final String TEXT_350 = ".";
  protected final String TEXT_351 = "(self)" + NL + "      end" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_352 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_353 = NL + "  def ";
  protected final String TEXT_354 = "(";
  protected final String TEXT_355 = ")" + NL + "    was_set = false";
  protected final String TEXT_356 = NL + "    if ";
  protected final String TEXT_357 = ".nil?" + NL + "      #Unable to ";
  protected final String TEXT_358 = " to nil, as ";
  protected final String TEXT_359 = " must always be associated to a @";
  protected final String TEXT_360 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_361 = NL + "    ";
  protected final String TEXT_362 = " = ";
  protected final String TEXT_363 = ".";
  protected final String TEXT_364 = NL + "    if !";
  protected final String TEXT_365 = ".nil? and !self.eql?(";
  protected final String TEXT_366 = ")" + NL + "      #Unable to ";
  protected final String TEXT_367 = ", the current @";
  protected final String TEXT_368 = " already has a ";
  protected final String TEXT_369 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_370 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_371 = NL + "    ";
  protected final String TEXT_372 = " = @";
  protected final String TEXT_373 = NL + "    @";
  protected final String TEXT_374 = " = ";
  protected final String TEXT_375 = NL + "    @";
  protected final String TEXT_376 = ".";
  protected final String TEXT_377 = "(self)" + NL + "" + NL + "    unless ";
  protected final String TEXT_378 = ".nil?";
  protected final String TEXT_379 = NL + "      ";
  protected final String TEXT_380 = ".";
  protected final String TEXT_381 = "(nil)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_382 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_383 = NL + "  def ";
  protected final String TEXT_384 = "(";
  protected final String TEXT_385 = ")" + NL + "    was_added = false";
  protected final String TEXT_386 = NL + "    ";
  protected final String TEXT_387 = " = ";
  protected final String TEXT_388 = ".";
  protected final String TEXT_389 = NL + "    ";
  protected final String TEXT_390 = " = (!";
  protected final String TEXT_391 = ".nil? and !";
  protected final String TEXT_392 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_393 = " and ";
  protected final String TEXT_394 = ".";
  protected final String TEXT_395 = " <= ";
  protected final String TEXT_396 = ".";
  protected final String TEXT_397 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_398 = NL + "      ";
  protected final String TEXT_399 = ".";
  protected final String TEXT_400 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_401 = " << ";
  protected final String TEXT_402 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_403 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_404 = "(";
  protected final String TEXT_405 = ")" + NL + "    was_removed = false";
  protected final String TEXT_406 = NL + "    # Unable to remove ";
  protected final String TEXT_407 = ", as it must always have a ";
  protected final String TEXT_408 = NL + "    if ";
  protected final String TEXT_409 = ".";
  protected final String TEXT_410 = ".eql?(self)";
  protected final String TEXT_411 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_412 = " already at minimum (";
  protected final String TEXT_413 = ")" + NL + "    if ";
  protected final String TEXT_414 = " <= ";
  protected final String TEXT_415 = ".";
  protected final String TEXT_416 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_417 = ".delete(";
  protected final String TEXT_418 = ")" + NL + "    was_removed = true";
  protected final String TEXT_419 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_420 = NL + "  def ";
  protected final String TEXT_421 = "(";
  protected final String TEXT_422 = ")" + NL + "    was_added = false";
  protected final String TEXT_423 = NL + "    if ";
  protected final String TEXT_424 = " >= ";
  protected final String TEXT_425 = ".";
  protected final String TEXT_426 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_427 = NL + "    ";
  protected final String TEXT_428 = " = ";
  protected final String TEXT_429 = ".";
  protected final String TEXT_430 = NL + "    ";
  protected final String TEXT_431 = " = (!";
  protected final String TEXT_432 = ".nil? and !";
  protected final String TEXT_433 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_434 = " and ";
  protected final String TEXT_435 = ".";
  protected final String TEXT_436 = " <= ";
  protected final String TEXT_437 = ".";
  protected final String TEXT_438 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_439 = NL + "      ";
  protected final String TEXT_440 = ".";
  protected final String TEXT_441 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_442 = " << ";
  protected final String TEXT_443 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_444 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_445 = "(";
  protected final String TEXT_446 = ")" + NL + "    was_removed = false";
  protected final String TEXT_447 = NL + "    # Unable to remove ";
  protected final String TEXT_448 = ", as it must always have a ";
  protected final String TEXT_449 = NL + "    if ";
  protected final String TEXT_450 = ".";
  protected final String TEXT_451 = ".eql?(self)";
  protected final String TEXT_452 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_453 = " already at minimum (";
  protected final String TEXT_454 = ")" + NL + "    if ";
  protected final String TEXT_455 = " <= ";
  protected final String TEXT_456 = ".";
  protected final String TEXT_457 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_458 = ".delete(";
  protected final String TEXT_459 = ")" + NL + "    was_removed = true";
  protected final String TEXT_460 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_461 = NL + "  def ";
  protected final String TEXT_462 = "(";
  protected final String TEXT_463 = ")" + NL + "    was_added = false";
  protected final String TEXT_464 = NL + "    if ";
  protected final String TEXT_465 = " >= ";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_468 = NL + "    ";
  protected final String TEXT_469 = " = ";
  protected final String TEXT_470 = ".";
  protected final String TEXT_471 = NL + "    ";
  protected final String TEXT_472 = " = (!";
  protected final String TEXT_473 = ".nil? and !";
  protected final String TEXT_474 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_475 = NL + "      ";
  protected final String TEXT_476 = ".";
  protected final String TEXT_477 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_478 = " << ";
  protected final String TEXT_479 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_480 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_481 = "(";
  protected final String TEXT_482 = ")" + NL + "    was_removed = false";
  protected final String TEXT_483 = NL + "    # Unable to remove ";
  protected final String TEXT_484 = ", as it must always have a ";
  protected final String TEXT_485 = NL + "    unless ";
  protected final String TEXT_486 = ".";
  protected final String TEXT_487 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_488 = ".delete(";
  protected final String TEXT_489 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_490 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_491 = NL + "  def ";
  protected final String TEXT_492 = "(";
  protected final String TEXT_493 = ")" + NL + "    was_set = false";
  protected final String TEXT_494 = NL + "    ";
  protected final String TEXT_495 = " = []";
  protected final String TEXT_496 = NL + "    ";
  protected final String TEXT_497 = ".each do |";
  protected final String TEXT_498 = "|" + NL + "      next if (";
  protected final String TEXT_499 = ".include?(";
  protected final String TEXT_500 = "))";
  protected final String TEXT_501 = NL + "      ";
  protected final String TEXT_502 = " << ";
  protected final String TEXT_503 = NL + "    end" + NL + "" + NL + "    if (";
  protected final String TEXT_504 = ".size != ";
  protected final String TEXT_505 = ".size or ";
  protected final String TEXT_506 = ".size() > ";
  protected final String TEXT_507 = ".";
  protected final String TEXT_508 = ")";
  protected final String TEXT_509 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_510 = NL + "    ";
  protected final String TEXT_511 = " = @";
  protected final String TEXT_512 = ".dup" + NL + "    @";
  protected final String TEXT_513 = ".clear";
  protected final String TEXT_514 = NL + "    ";
  protected final String TEXT_515 = ".each do |";
  protected final String TEXT_516 = "|" + NL + "      @";
  protected final String TEXT_517 = " << ";
  protected final String TEXT_518 = NL + "      if (";
  protected final String TEXT_519 = ".include?(";
  protected final String TEXT_520 = "))";
  protected final String TEXT_521 = NL + "        ";
  protected final String TEXT_522 = ".delete(";
  protected final String TEXT_523 = ")" + NL + "      else";
  protected final String TEXT_524 = NL + "        ";
  protected final String TEXT_525 = ".";
  protected final String TEXT_526 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_527 = NL + "    ";
  protected final String TEXT_528 = ".each do |";
  protected final String TEXT_529 = "|";
  protected final String TEXT_530 = NL + "      ";
  protected final String TEXT_531 = ".";
  protected final String TEXT_532 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_533 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_534 = NL + "  def ";
  protected final String TEXT_535 = "(";
  protected final String TEXT_536 = ")" + NL + "    was_added = false";
  protected final String TEXT_537 = NL + "    ";
  protected final String TEXT_538 = " = ";
  protected final String TEXT_539 = ".";
  protected final String TEXT_540 = NL + "    ";
  protected final String TEXT_541 = " = (!";
  protected final String TEXT_542 = ".nil? and !";
  protected final String TEXT_543 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_544 = NL + "      ";
  protected final String TEXT_545 = ".";
  protected final String TEXT_546 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_547 = " << ";
  protected final String TEXT_548 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_549 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_550 = "(";
  protected final String TEXT_551 = ")" + NL + "    was_removed = false";
  protected final String TEXT_552 = NL + "    # Unable to remove ";
  protected final String TEXT_553 = ", as it must always have a ";
  protected final String TEXT_554 = NL + "    unless ";
  protected final String TEXT_555 = ".";
  protected final String TEXT_556 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_557 = ".delete(";
  protected final String TEXT_558 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_559 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_560 = NL + "  def ";
  protected final String TEXT_561 = "(";
  protected final String TEXT_562 = ")" + NL + "    was_set = false";
  protected final String TEXT_563 = NL + "    if ";
  protected final String TEXT_564 = ".nil?";
  protected final String TEXT_565 = NL + "      ";
  protected final String TEXT_566 = " = @";
  protected final String TEXT_567 = NL + "      @";
  protected final String TEXT_568 = " = nil" + NL + "      " + NL + "      if !";
  protected final String TEXT_569 = ".nil? and !";
  protected final String TEXT_570 = ".";
  protected final String TEXT_571 = ".nil?";
  protected final String TEXT_572 = NL + "        ";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = "(nil)" + NL + "      end" + NL + "      was_set = true";
  protected final String TEXT_575 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_576 = NL + "    ";
  protected final String TEXT_577 = " = self.";
  protected final String TEXT_578 = NL + "    if !";
  protected final String TEXT_579 = ".nil? and !";
  protected final String TEXT_580 = ".eql?(";
  protected final String TEXT_581 = ")";
  protected final String TEXT_582 = NL + "      ";
  protected final String TEXT_583 = ".";
  protected final String TEXT_584 = "(nil)" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_585 = " = ";
  protected final String TEXT_586 = NL + "    ";
  protected final String TEXT_587 = " = ";
  protected final String TEXT_588 = ".";
  protected final String TEXT_589 = NL + NL + "    unless self.eql?(";
  protected final String TEXT_590 = ")";
  protected final String TEXT_591 = NL + "      ";
  protected final String TEXT_592 = ".";
  protected final String TEXT_593 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_594 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_595 = NL + "  def ";
  protected final String TEXT_596 = "(";
  protected final String TEXT_597 = ")" + NL + "    was_removed = false";
  protected final String TEXT_598 = NL + "    unless @";
  protected final String TEXT_599 = ".include?(";
  protected final String TEXT_600 = ")";
  protected final String TEXT_601 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_602 = " <= ";
  protected final String TEXT_603 = ".";
  protected final String TEXT_604 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_605 = ".index(";
  protected final String TEXT_606 = ")" + NL + "    @";
  protected final String TEXT_607 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_608 = ".";
  protected final String TEXT_609 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_610 = ".";
  protected final String TEXT_611 = "(self)" + NL + "      @";
  protected final String TEXT_612 = ".insert(oldIndex,";
  protected final String TEXT_613 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_614 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_615 = NL + "  def ";
  protected final String TEXT_616 = "(";
  protected final String TEXT_617 = ")" + NL + "    was_removed = false";
  protected final String TEXT_618 = NL + "    unless @";
  protected final String TEXT_619 = ".include?(";
  protected final String TEXT_620 = ")";
  protected final String TEXT_621 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_622 = " <= ";
  protected final String TEXT_623 = ".";
  protected final String TEXT_624 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_625 = ".index(";
  protected final String TEXT_626 = ")" + NL + "    @";
  protected final String TEXT_627 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_628 = ".";
  protected final String TEXT_629 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_630 = ".";
  protected final String TEXT_631 = "(self)" + NL + "      @";
  protected final String TEXT_632 = ".insert(oldIndex,";
  protected final String TEXT_633 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_634 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_635 = NL + "  def ";
  protected final String TEXT_636 = "(";
  protected final String TEXT_637 = ")" + NL + "    was_set = false";
  protected final String TEXT_638 = NL + "    if !";
  protected final String TEXT_639 = ".nil? and ";
  protected final String TEXT_640 = ".";
  protected final String TEXT_641 = " >= ";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_644 = NL + "    ";
  protected final String TEXT_645 = " = @";
  protected final String TEXT_646 = NL + "    @";
  protected final String TEXT_647 = " = ";
  protected final String TEXT_648 = NL + "    if !";
  protected final String TEXT_649 = ".nil? and !";
  protected final String TEXT_650 = ".eql?(";
  protected final String TEXT_651 = ")";
  protected final String TEXT_652 = NL + "      ";
  protected final String TEXT_653 = ".";
  protected final String TEXT_654 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_655 = ".nil?";
  protected final String TEXT_656 = NL + "      ";
  protected final String TEXT_657 = ".";
  protected final String TEXT_658 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_659 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_660 = NL + "  def ";
  protected final String TEXT_661 = "(";
  protected final String TEXT_662 = ")" + NL + "    was_set = false";
  protected final String TEXT_663 = NL + "    if ";
  protected final String TEXT_664 = ".nil?";
  protected final String TEXT_665 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_666 = NL + "    ";
  protected final String TEXT_667 = " = @";
  protected final String TEXT_668 = NL + "    @";
  protected final String TEXT_669 = " = ";
  protected final String TEXT_670 = NL + "    if !";
  protected final String TEXT_671 = ".nil? and !";
  protected final String TEXT_672 = ".eql?(";
  protected final String TEXT_673 = ")";
  protected final String TEXT_674 = NL + "      ";
  protected final String TEXT_675 = ".";
  protected final String TEXT_676 = "(self)" + NL + "    end" + NL + "    @";
  protected final String TEXT_677 = ".";
  protected final String TEXT_678 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_679 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_680 = NL + "  def ";
  protected final String TEXT_681 = "(";
  protected final String TEXT_682 = ")" + NL + "    was_set = false";
  protected final String TEXT_683 = NL + "    # Must provide @";
  protected final String TEXT_684 = " to ";
  protected final String TEXT_685 = NL + "    if ";
  protected final String TEXT_686 = ".nil?";
  protected final String TEXT_687 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    # @";
  protected final String TEXT_688 = " already at maximum (";
  protected final String TEXT_689 = ")" + NL + "    if ";
  protected final String TEXT_690 = ".";
  protected final String TEXT_691 = " >= ";
  protected final String TEXT_692 = ".";
  protected final String TEXT_693 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_694 = NL + "    ";
  protected final String TEXT_695 = " = @";
  protected final String TEXT_696 = NL + "    @";
  protected final String TEXT_697 = " = ";
  protected final String TEXT_698 = NL + "    if !";
  protected final String TEXT_699 = ".nil? and !";
  protected final String TEXT_700 = ".eql?(";
  protected final String TEXT_701 = ")" + NL + "      didRemove = ";
  protected final String TEXT_702 = ".";
  protected final String TEXT_703 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_704 = " = ";
  protected final String TEXT_705 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_706 = ".";
  protected final String TEXT_707 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_708 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_709 = NL + "  def ";
  protected final String TEXT_710 = "(";
  protected final String TEXT_711 = ")" + NL + "    was_set = false";
  protected final String TEXT_712 = NL + "    # Must provide @";
  protected final String TEXT_713 = " to ";
  protected final String TEXT_714 = NL + "    if ";
  protected final String TEXT_715 = ".nil?";
  protected final String TEXT_716 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    if !@";
  protected final String TEXT_717 = ".nil? and @";
  protected final String TEXT_718 = ".";
  protected final String TEXT_719 = " <= ";
  protected final String TEXT_720 = ".";
  protected final String TEXT_721 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_722 = NL + "    ";
  protected final String TEXT_723 = " = @";
  protected final String TEXT_724 = NL + "    @";
  protected final String TEXT_725 = " = ";
  protected final String TEXT_726 = NL + "    if !";
  protected final String TEXT_727 = ".nil? and !";
  protected final String TEXT_728 = ".eql?(";
  protected final String TEXT_729 = ")" + NL + "      didRemove = ";
  protected final String TEXT_730 = ".";
  protected final String TEXT_731 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_732 = " = ";
  protected final String TEXT_733 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_734 = ".";
  protected final String TEXT_735 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_736 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_737 = NL + "  def ";
  protected final String TEXT_738 = "(";
  protected final String TEXT_739 = ")" + NL + "    was_added = false";
  protected final String TEXT_740 = NL + "    ";
  protected final String TEXT_741 = " = ";
  protected final String TEXT_742 = ".";
  protected final String TEXT_743 = NL + "    if ";
  protected final String TEXT_744 = ".nil?";
  protected final String TEXT_745 = NL + "      ";
  protected final String TEXT_746 = ".";
  protected final String TEXT_747 = "(self)" + NL + "    elsif !";
  protected final String TEXT_748 = ".eql?(self)";
  protected final String TEXT_749 = NL + "      ";
  protected final String TEXT_750 = ".";
  protected final String TEXT_751 = "(";
  protected final String TEXT_752 = ")";
  protected final String TEXT_753 = NL + "      ";
  protected final String TEXT_754 = "(";
  protected final String TEXT_755 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_756 = " << ";
  protected final String TEXT_757 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_758 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_759 = "(";
  protected final String TEXT_760 = ")" + NL + "    was_removed = false";
  protected final String TEXT_761 = NL + "    if @";
  protected final String TEXT_762 = ".include?(";
  protected final String TEXT_763 = ")" + NL + "      @";
  protected final String TEXT_764 = ".delete(";
  protected final String TEXT_765 = ")";
  protected final String TEXT_766 = NL + "      ";
  protected final String TEXT_767 = ".";
  protected final String TEXT_768 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_769 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_770 = NL + "  def ";
  protected final String TEXT_771 = "(";
  protected final String TEXT_772 = ")" + NL + "    was_set = false";
  protected final String TEXT_773 = NL + "    ";
  protected final String TEXT_774 = " = @";
  protected final String TEXT_775 = NL + "    @";
  protected final String TEXT_776 = " = ";
  protected final String TEXT_777 = NL + "    if !";
  protected final String TEXT_778 = ".nil? and !";
  protected final String TEXT_779 = ".eql?(";
  protected final String TEXT_780 = ")";
  protected final String TEXT_781 = NL + "      ";
  protected final String TEXT_782 = ".";
  protected final String TEXT_783 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_784 = ".nil?";
  protected final String TEXT_785 = NL + "      ";
  protected final String TEXT_786 = ".";
  protected final String TEXT_787 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_788 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_789 = NL + "  def ";
  protected final String TEXT_790 = "(";
  protected final String TEXT_791 = ")" + NL + "    was_added = false";
  protected final String TEXT_792 = NL + "    if ";
  protected final String TEXT_793 = " >= ";
  protected final String TEXT_794 = ".";
  protected final String TEXT_795 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_796 = NL + "    ";
  protected final String TEXT_797 = " = ";
  protected final String TEXT_798 = ".";
  protected final String TEXT_799 = NL + "    if ";
  protected final String TEXT_800 = ".nil?";
  protected final String TEXT_801 = NL + "      ";
  protected final String TEXT_802 = ".";
  protected final String TEXT_803 = "(self)" + NL + "    elsif !";
  protected final String TEXT_804 = ".eql?(self)";
  protected final String TEXT_805 = NL + "      ";
  protected final String TEXT_806 = ".";
  protected final String TEXT_807 = "(";
  protected final String TEXT_808 = ")";
  protected final String TEXT_809 = NL + "      ";
  protected final String TEXT_810 = "(";
  protected final String TEXT_811 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_812 = " << ";
  protected final String TEXT_813 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_814 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_815 = "(";
  protected final String TEXT_816 = ")" + NL + "    was_removed = false";
  protected final String TEXT_817 = NL + "    if @";
  protected final String TEXT_818 = ".include?(";
  protected final String TEXT_819 = ")" + NL + "      @";
  protected final String TEXT_820 = ".delete(";
  protected final String TEXT_821 = ")";
  protected final String TEXT_822 = NL + "      ";
  protected final String TEXT_823 = ".";
  protected final String TEXT_824 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_825 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_826 = NL + "  def ";
  protected final String TEXT_827 = "(";
  protected final String TEXT_828 = ")" + NL + "    was_added = false";
  protected final String TEXT_829 = NL + "    if ";
  protected final String TEXT_830 = " < ";
  protected final String TEXT_831 = ".";
  protected final String TEXT_832 = NL + "      @";
  protected final String TEXT_833 = " << ";
  protected final String TEXT_834 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_835 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_836 = "(";
  protected final String TEXT_837 = ")" + NL + "    was_removed = false";
  protected final String TEXT_838 = NL + "    unless @";
  protected final String TEXT_839 = ".include?(";
  protected final String TEXT_840 = ")";
  protected final String TEXT_841 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_842 = " <= ";
  protected final String TEXT_843 = ".";
  protected final String TEXT_844 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_845 = ".delete(";
  protected final String TEXT_846 = ")" + NL + "    was_removed = true";
  protected final String TEXT_847 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_848 = NL + "  def ";
  protected final String TEXT_849 = "(";
  protected final String TEXT_850 = ")" + NL + "    was_added = false";
  protected final String TEXT_851 = NL + "    if ";
  protected final String TEXT_852 = " >= ";
  protected final String TEXT_853 = ".";
  protected final String TEXT_854 = NL + "      return was_added" + NL + "    end";
  protected final String TEXT_855 = NL + "    ";
  protected final String TEXT_856 = " = ";
  protected final String TEXT_857 = ".";
  protected final String TEXT_858 = NL + "    if !";
  protected final String TEXT_859 = ".nil? and ";
  protected final String TEXT_860 = ".";
  protected final String TEXT_861 = " <= ";
  protected final String TEXT_862 = ".";
  protected final String TEXT_863 = NL + "      return was_added" + NL + "    elsif !";
  protected final String TEXT_864 = ".nil?";
  protected final String TEXT_865 = NL + "      ";
  protected final String TEXT_866 = ".instance_variable_get(\"@";
  protected final String TEXT_867 = "\").delete(";
  protected final String TEXT_868 = ")" + NL + "    end" + NL + "    @";
  protected final String TEXT_869 = " << ";
  protected final String TEXT_870 = NL + "    ";
  protected final String TEXT_871 = ".instance_variable_set(\"@";
  protected final String TEXT_872 = "\",self)" + NL + "    was_added = true";
  protected final String TEXT_873 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_874 = "(";
  protected final String TEXT_875 = ")" + NL + "    was_removed = false";
  protected final String TEXT_876 = NL + "    if @";
  protected final String TEXT_877 = ".include?(";
  protected final String TEXT_878 = ") and ";
  protected final String TEXT_879 = " > ";
  protected final String TEXT_880 = ".";
  protected final String TEXT_881 = NL + "      @";
  protected final String TEXT_882 = ".delete(";
  protected final String TEXT_883 = ")";
  protected final String TEXT_884 = NL + "      ";
  protected final String TEXT_885 = ".instance_variable_set(\"@";
  protected final String TEXT_886 = "\",nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_887 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_888 = NL + "  def ";
  protected final String TEXT_889 = "(";
  protected final String TEXT_890 = ")" + NL + "    was_set = false";
  protected final String TEXT_891 = NL + "    ";
  protected final String TEXT_892 = " = []";
  protected final String TEXT_893 = NL + "    ";
  protected final String TEXT_894 = ".each do |";
  protected final String TEXT_895 = "|" + NL + "      if ";
  protected final String TEXT_896 = ".include?(";
  protected final String TEXT_897 = ")";
  protected final String TEXT_898 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_899 = ".";
  protected final String TEXT_900 = ".nil? and !";
  protected final String TEXT_901 = ".";
  protected final String TEXT_902 = ".eql?(self)";
  protected final String TEXT_903 = NL + "        return was_set" + NL + "      end";
  protected final String TEXT_904 = NL + "      ";
  protected final String TEXT_905 = " << ";
  protected final String TEXT_906 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_907 = ".size != ";
  protected final String TEXT_908 = ".";
  protected final String TEXT_909 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_910 = NL + "    ";
  protected final String TEXT_911 = ".each do |";
  protected final String TEXT_912 = "|" + NL + "      @";
  protected final String TEXT_913 = ".delete(";
  protected final String TEXT_914 = ")" + NL + "    end" + NL + "    " + NL + "    @";
  protected final String TEXT_915 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_916 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_917 = ".clear";
  protected final String TEXT_918 = NL + "    ";
  protected final String TEXT_919 = ".each do |";
  protected final String TEXT_920 = "|";
  protected final String TEXT_921 = NL + "      ";
  protected final String TEXT_922 = ".instance_variable_set(\"@";
  protected final String TEXT_923 = "\",self)" + NL + "      @";
  protected final String TEXT_924 = " << ";
  protected final String TEXT_925 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_926 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_927 = NL + "  def ";
  protected final String TEXT_928 = "(";
  protected final String TEXT_929 = ")" + NL + "    was_added = false";
  protected final String TEXT_930 = NL + "    @";
  protected final String TEXT_931 = " << ";
  protected final String TEXT_932 = NL + "    was_added = true";
  protected final String TEXT_933 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_934 = "(";
  protected final String TEXT_935 = ")" + NL + "    was_removed = false";
  protected final String TEXT_936 = NL + "    if @";
  protected final String TEXT_937 = ".include?(";
  protected final String TEXT_938 = ")" + NL + "      @";
  protected final String TEXT_939 = ".delete(";
  protected final String TEXT_940 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_941 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_942 = NL + "  def ";
  protected final String TEXT_943 = "(";
  protected final String TEXT_944 = ")" + NL + "    was_added = false";
  protected final String TEXT_945 = NL + "    if ";
  protected final String TEXT_946 = " < ";
  protected final String TEXT_947 = ".";
  protected final String TEXT_948 = NL + "      @";
  protected final String TEXT_949 = " << ";
  protected final String TEXT_950 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_951 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_952 = "(";
  protected final String TEXT_953 = ")" + NL + "    was_removed = false";
  protected final String TEXT_954 = NL + "    if @";
  protected final String TEXT_955 = ".include?(";
  protected final String TEXT_956 = ")" + NL + "      @";
  protected final String TEXT_957 = ".delete(";
  protected final String TEXT_958 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_959 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_960 = NL + "  def ";
  protected final String TEXT_961 = "(";
  protected final String TEXT_962 = ")" + NL + "    was_added = false";
  protected final String TEXT_963 = NL + "    @";
  protected final String TEXT_964 = " << ";
  protected final String TEXT_965 = NL + "    was_added = true";
  protected final String TEXT_966 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_967 = "(";
  protected final String TEXT_968 = ")" + NL + "    was_removed = false";
  protected final String TEXT_969 = NL + "    unless @";
  protected final String TEXT_970 = ".include?(";
  protected final String TEXT_971 = ")";
  protected final String TEXT_972 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_973 = " <= ";
  protected final String TEXT_974 = ".";
  protected final String TEXT_975 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_976 = ".delete(";
  protected final String TEXT_977 = ")" + NL + "    was_removed = true";
  protected final String TEXT_978 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_979 = NL + "  def ";
  protected final String TEXT_980 = "(";
  protected final String TEXT_981 = ")" + NL + "    was_set = false";
  protected final String TEXT_982 = NL + "    ";
  protected final String TEXT_983 = " = []";
  protected final String TEXT_984 = NL + "    ";
  protected final String TEXT_985 = ".each do |";
  protected final String TEXT_986 = "|" + NL + "      next if (";
  protected final String TEXT_987 = ".include?(";
  protected final String TEXT_988 = "))";
  protected final String TEXT_989 = NL + "      ";
  protected final String TEXT_990 = " << ";
  protected final String TEXT_991 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_992 = ".size != ";
  protected final String TEXT_993 = ".size or ";
  protected final String TEXT_994 = ".size() != ";
  protected final String TEXT_995 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_996 = ".clear";
  protected final String TEXT_997 = NL + "    ";
  protected final String TEXT_998 = ".each do |";
  protected final String TEXT_999 = "|" + NL + "      @";
  protected final String TEXT_1000 = " << ";
  protected final String TEXT_1001 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1002 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1003 = NL + "  def ";
  protected final String TEXT_1004 = "(";
  protected final String TEXT_1005 = ")" + NL + "    was_set = false";
  protected final String TEXT_1006 = NL + "    ";
  protected final String TEXT_1007 = " = []";
  protected final String TEXT_1008 = NL + "    ";
  protected final String TEXT_1009 = ".each do |";
  protected final String TEXT_1010 = "|" + NL + "      next if (";
  protected final String TEXT_1011 = ".include?(";
  protected final String TEXT_1012 = ")) ";
  protected final String TEXT_1013 = NL + "      ";
  protected final String TEXT_1014 = " << ";
  protected final String TEXT_1015 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1016 = ".size != ";
  protected final String TEXT_1017 = ".length or ";
  protected final String TEXT_1018 = ".size < ";
  protected final String TEXT_1019 = ".";
  protected final String TEXT_1020 = " or ";
  protected final String TEXT_1021 = ".size() > ";
  protected final String TEXT_1022 = ".";
  protected final String TEXT_1023 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1024 = NL + "    ";
  protected final String TEXT_1025 = " = @";
  protected final String TEXT_1026 = ".dup" + NL + "    @";
  protected final String TEXT_1027 = ".clear";
  protected final String TEXT_1028 = NL + "    ";
  protected final String TEXT_1029 = ".each do |";
  protected final String TEXT_1030 = "|" + NL + "      @";
  protected final String TEXT_1031 = " << ";
  protected final String TEXT_1032 = NL + "      if ";
  protected final String TEXT_1033 = ".include?(";
  protected final String TEXT_1034 = ")";
  protected final String TEXT_1035 = NL + "        ";
  protected final String TEXT_1036 = ".delete(";
  protected final String TEXT_1037 = ")" + NL + "      else";
  protected final String TEXT_1038 = NL + "        ";
  protected final String TEXT_1039 = ".";
  protected final String TEXT_1040 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1041 = NL + "    ";
  protected final String TEXT_1042 = ".each do |";
  protected final String TEXT_1043 = "|";
  protected final String TEXT_1044 = NL + "      ";
  protected final String TEXT_1045 = ".";
  protected final String TEXT_1046 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1047 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1048 = NL + "  def ";
  protected final String TEXT_1049 = "(";
  protected final String TEXT_1050 = ")" + NL + "    was_set = false";
  protected final String TEXT_1051 = NL + "    ";
  protected final String TEXT_1052 = " = []";
  protected final String TEXT_1053 = NL + "    ";
  protected final String TEXT_1054 = ".each do |";
  protected final String TEXT_1055 = "|" + NL + "      next if (";
  protected final String TEXT_1056 = ".include?(";
  protected final String TEXT_1057 = "))";
  protected final String TEXT_1058 = NL + "      ";
  protected final String TEXT_1059 = " << ";
  protected final String TEXT_1060 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1061 = ".size != ";
  protected final String TEXT_1062 = ".size or ";
  protected final String TEXT_1063 = ".size < ";
  protected final String TEXT_1064 = ".";
  protected final String TEXT_1065 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1066 = NL + "    ";
  protected final String TEXT_1067 = " = @";
  protected final String TEXT_1068 = ".dup" + NL + "    @";
  protected final String TEXT_1069 = ".clear";
  protected final String TEXT_1070 = NL + "    ";
  protected final String TEXT_1071 = ".each do |";
  protected final String TEXT_1072 = "|" + NL + "      @";
  protected final String TEXT_1073 = " << ";
  protected final String TEXT_1074 = NL + "      if ";
  protected final String TEXT_1075 = ".include?(";
  protected final String TEXT_1076 = ")";
  protected final String TEXT_1077 = NL + "        ";
  protected final String TEXT_1078 = ".delete(";
  protected final String TEXT_1079 = ")" + NL + "      else";
  protected final String TEXT_1080 = NL + "        ";
  protected final String TEXT_1081 = ".";
  protected final String TEXT_1082 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1083 = NL + "    ";
  protected final String TEXT_1084 = ".each do |";
  protected final String TEXT_1085 = "|";
  protected final String TEXT_1086 = NL + "      ";
  protected final String TEXT_1087 = ".";
  protected final String TEXT_1088 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1089 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1090 = NL + "  def ";
  protected final String TEXT_1091 = "(";
  protected final String TEXT_1092 = ")" + NL + "    was_set = false";
  protected final String TEXT_1093 = NL + "    ";
  protected final String TEXT_1094 = " = []";
  protected final String TEXT_1095 = NL + "    ";
  protected final String TEXT_1096 = ".each do |";
  protected final String TEXT_1097 = "|" + NL + "      next if (";
  protected final String TEXT_1098 = ".include?(";
  protected final String TEXT_1099 = "))";
  protected final String TEXT_1100 = NL + "      ";
  protected final String TEXT_1101 = " << ";
  protected final String TEXT_1102 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1103 = ".size != ";
  protected final String TEXT_1104 = ".size or ";
  protected final String TEXT_1105 = ".size < ";
  protected final String TEXT_1106 = ".";
  protected final String TEXT_1107 = " or ";
  protected final String TEXT_1108 = ".size > ";
  protected final String TEXT_1109 = ".";
  protected final String TEXT_1110 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1111 = ".clear";
  protected final String TEXT_1112 = NL + "    ";
  protected final String TEXT_1113 = ".each do |";
  protected final String TEXT_1114 = "|" + NL + "      @";
  protected final String TEXT_1115 = " << ";
  protected final String TEXT_1116 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1117 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1118 = NL + "  def ";
  protected final String TEXT_1119 = "(";
  protected final String TEXT_1120 = ")" + NL + "    was_set = false";
  protected final String TEXT_1121 = NL + "    if ";
  protected final String TEXT_1122 = ".length < ";
  protected final String TEXT_1123 = ".";
  protected final String TEXT_1124 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1125 = NL + "    ";
  protected final String TEXT_1126 = " = []";
  protected final String TEXT_1127 = NL + "    ";
  protected final String TEXT_1128 = " = {}";
  protected final String TEXT_1129 = NL + "    ";
  protected final String TEXT_1130 = ".each do |";
  protected final String TEXT_1131 = "|" + NL + "      if ";
  protected final String TEXT_1132 = ".include?(";
  protected final String TEXT_1133 = ")";
  protected final String TEXT_1134 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_1135 = ".";
  protected final String TEXT_1136 = ".nil? and !";
  protected final String TEXT_1137 = ".";
  protected final String TEXT_1138 = ".eql?(self)";
  protected final String TEXT_1139 = NL + "        ";
  protected final String TEXT_1140 = " = ";
  protected final String TEXT_1141 = ".";
  protected final String TEXT_1142 = NL + "        unless ";
  protected final String TEXT_1143 = ".has_key?(";
  protected final String TEXT_1144 = ")";
  protected final String TEXT_1145 = NL + "          ";
  protected final String TEXT_1146 = "[";
  protected final String TEXT_1147 = "] = ";
  protected final String TEXT_1148 = ".";
  protected final String TEXT_1149 = NL + "        end" + NL + "        currentCount = ";
  protected final String TEXT_1150 = "[";
  protected final String TEXT_1151 = "]" + NL + "        nextCount = currentCount - 1" + NL + "        if nextCount < ";
  protected final String TEXT_1152 = NL + "          return was_set" + NL + "        end";
  protected final String TEXT_1153 = NL + "        ";
  protected final String TEXT_1154 = "[";
  protected final String TEXT_1155 = "] = nextCount" + NL + "      end";
  protected final String TEXT_1156 = NL + "      ";
  protected final String TEXT_1157 = " << ";
  protected final String TEXT_1158 = NL + "    end" + NL;
  protected final String TEXT_1159 = NL + "    ";
  protected final String TEXT_1160 = ".each do |";
  protected final String TEXT_1161 = "|" + NL + "      @";
  protected final String TEXT_1162 = ".delete(";
  protected final String TEXT_1163 = ")" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1164 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_1165 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1166 = ".clear";
  protected final String TEXT_1167 = NL + "    ";
  protected final String TEXT_1168 = ".each do |";
  protected final String TEXT_1169 = "|" + NL + "      unless ";
  protected final String TEXT_1170 = ".";
  protected final String TEXT_1171 = ".nil?";
  protected final String TEXT_1172 = NL + "        ";
  protected final String TEXT_1173 = ".";
  protected final String TEXT_1174 = ".instance_variable_get(\"@";
  protected final String TEXT_1175 = "\").delete(";
  protected final String TEXT_1176 = ")" + NL + "      end";
  protected final String TEXT_1177 = NL + "      ";
  protected final String TEXT_1178 = ".instance_variable_set(\"@";
  protected final String TEXT_1179 = "\",self)" + NL + "      @";
  protected final String TEXT_1180 = " << ";
  protected final String TEXT_1181 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1182 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1183 = NL + "  def ";
  protected final String TEXT_1184 = "(";
  protected final String TEXT_1185 = ")" + NL + "    was_set = false";
  protected final String TEXT_1186 = NL + "    ";
  protected final String TEXT_1187 = " = []";
  protected final String TEXT_1188 = NL + "    ";
  protected final String TEXT_1189 = ".each do |";
  protected final String TEXT_1190 = "|" + NL + "      next if (";
  protected final String TEXT_1191 = ".include?(";
  protected final String TEXT_1192 = "))";
  protected final String TEXT_1193 = NL + "      ";
  protected final String TEXT_1194 = " << ";
  protected final String TEXT_1195 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1196 = ".size != ";
  protected final String TEXT_1197 = ".size or ";
  protected final String TEXT_1198 = ".size() > ";
  protected final String TEXT_1199 = ".";
  protected final String TEXT_1200 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1201 = ".clear";
  protected final String TEXT_1202 = NL + "    ";
  protected final String TEXT_1203 = ".each do |";
  protected final String TEXT_1204 = "|" + NL + "      @";
  protected final String TEXT_1205 = " << ";
  protected final String TEXT_1206 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1207 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1208 = NL + "  def ";
  protected final String TEXT_1209 = "(";
  protected final String TEXT_1210 = ")" + NL + "    was_set = false";
  protected final String TEXT_1211 = NL + "    ";
  protected final String TEXT_1212 = " = []";
  protected final String TEXT_1213 = NL + "    ";
  protected final String TEXT_1214 = ".each do |";
  protected final String TEXT_1215 = "|" + NL + "      next if (";
  protected final String TEXT_1216 = ".include?(";
  protected final String TEXT_1217 = "))";
  protected final String TEXT_1218 = NL + "      ";
  protected final String TEXT_1219 = " << ";
  protected final String TEXT_1220 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1221 = ".size != ";
  protected final String TEXT_1222 = ".size or ";
  protected final String TEXT_1223 = ".size() < ";
  protected final String TEXT_1224 = ".";
  protected final String TEXT_1225 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1226 = ".clear";
  protected final String TEXT_1227 = NL + "    ";
  protected final String TEXT_1228 = ".each do |";
  protected final String TEXT_1229 = "|" + NL + "      @";
  protected final String TEXT_1230 = " << ";
  protected final String TEXT_1231 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1232 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1233 = NL + "  def eql?(obj)" + NL + "    return false if obj.nil?" + NL + "    return false unless self.class == obj.class" + NL + "" + NL + "    compareTo = obj";
  protected final String TEXT_1234 = NL + "    ";
  protected final String TEXT_1235 = NL + "    true" + NL + "  end" + NL + "" + NL + "  def hash" + NL + "    return @cachedHashCode unless @cachedHashCode == -1" + NL + "    @cachedHashCode = 17";
  protected final String TEXT_1236 = NL + "    ";
  protected final String TEXT_1237 = NL + "    ";
  protected final String TEXT_1238 = NL + "    @cachedHashCode" + NL + "  end" + NL;
  protected final String TEXT_1239 = NL + "  def ";
  protected final String TEXT_1240 = NL + "    ";
  protected final String TEXT_1241 = NL + "  end" + NL;
  protected final String TEXT_1242 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1243 = NL + "    ";
  protected final String TEXT_1244 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1245 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    def run()" + NL + "    {" + NL + "      try" + NL + "      {";
  protected final String TEXT_1246 = NL + "        ";
  protected final String TEXT_1247 = NL + "      }" + NL + "      catch (InterruptedException e)" + NL + "      {" + NL + "        e.printStackTrace();" + NL + "      }" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1248 = NL + "  def ";
  protected final String TEXT_1249 = NL + "    ";
  protected final String TEXT_1250 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1251 = "\",";
  protected final String TEXT_1252 = ")" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1253 = NL + "    ";
  protected final String TEXT_1254 = ".stop()" + NL + "  end" + NL;
  protected final String TEXT_1255 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1256 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1257 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    def stop" + NL + "      timer.cancel();" + NL + "    end" + NL + "    " + NL + "    def run";
  protected final String TEXT_1258 = NL + "      if (\"";
  protected final String TEXT_1259 = "\".eql?(timeoutMethodName))" + NL + "      {" + NL + "        shouldRestart = !controller.";
  protected final String TEXT_1260 = NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1261 = NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1262 = NL + "    end" + NL + "  }" + NL;
  protected final String TEXT_1263 = NL + "    @";
  protected final String TEXT_1264 = " = nil";
  protected final String TEXT_1265 = NL + "    @";
  protected final String TEXT_1266 = ".clear";
  protected final String TEXT_1267 = NL + "    ";
  protected final String TEXT_1268 = " = @";
  protected final String TEXT_1269 = NL + "    @";
  protected final String TEXT_1270 = " = nil" + NL + "    unless ";
  protected final String TEXT_1271 = ".nil?";
  protected final String TEXT_1272 = NL + "      ";
  protected final String TEXT_1273 = ".delete" + NL + "    end";
  protected final String TEXT_1274 = NL + "    unless @";
  protected final String TEXT_1275 = ".nil?" + NL + "      @";
  protected final String TEXT_1276 = ".";
  protected final String TEXT_1277 = "(nil)" + NL + "    end";
  protected final String TEXT_1278 = NL + "    ";
  protected final String TEXT_1279 = " = @";
  protected final String TEXT_1280 = NL + "    @";
  protected final String TEXT_1281 = " = nil" + NL + "    unless ";
  protected final String TEXT_1282 = ".nil?";
  protected final String TEXT_1283 = NL + "      ";
  protected final String TEXT_1284 = ".";
  protected final String TEXT_1285 = "(nil)" + NL + "    end";
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
  protected final String TEXT_1296 = "(self)" + NL + "    end";
  protected final String TEXT_1297 = NL + "    unless @";
  protected final String TEXT_1298 = ".nil?" + NL + "      @";
  protected final String TEXT_1299 = ".delete" + NL + "    end";
  protected final String TEXT_1300 = NL + "    unless @";
  protected final String TEXT_1301 = ".nil?" + NL + "      if @";
  protected final String TEXT_1302 = ".";
  protected final String TEXT_1303 = " <= ";
  protected final String TEXT_1304 = NL + "        @";
  protected final String TEXT_1305 = ".delete" + NL + "      else" + NL + "        @";
  protected final String TEXT_1306 = ".";
  protected final String TEXT_1307 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1308 = NL + "    @";
  protected final String TEXT_1309 = ".";
  protected final String TEXT_1310 = "(self)";
  protected final String TEXT_1311 = NL + "    @";
  protected final String TEXT_1312 = ".each do |";
  protected final String TEXT_1313 = "|";
  protected final String TEXT_1314 = NL + "      ";
  protected final String TEXT_1315 = ".instance_variable_set(\"@";
  protected final String TEXT_1316 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1317 = ".clear";
  protected final String TEXT_1318 = NL + "    ";
  protected final String TEXT_1319 = " = @";
  protected final String TEXT_1320 = ".dup" + NL + "    @";
  protected final String TEXT_1321 = ".clear";
  protected final String TEXT_1322 = NL + "    ";
  protected final String TEXT_1323 = ".each do |";
  protected final String TEXT_1324 = "|" + NL + "      if ";
  protected final String TEXT_1325 = ".";
  protected final String TEXT_1326 = " <= ";
  protected final String TEXT_1327 = ".";
  protected final String TEXT_1328 = NL + "        ";
  protected final String TEXT_1329 = ".delete" + NL + "      else";
  protected final String TEXT_1330 = NL + "        ";
  protected final String TEXT_1331 = ".";
  protected final String TEXT_1332 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1333 = NL + "    ";
  protected final String TEXT_1334 = " = @";
  protected final String TEXT_1335 = ".dup" + NL + "    @";
  protected final String TEXT_1336 = ".clear";
  protected final String TEXT_1337 = NL + "    ";
  protected final String TEXT_1338 = ".each do |";
  protected final String TEXT_1339 = "|";
  protected final String TEXT_1340 = NL + "      ";
  protected final String TEXT_1341 = ".";
  protected final String TEXT_1342 = "(self)" + NL + "    end";
  protected final String TEXT_1343 = NL + "    @";
  protected final String TEXT_1344 = ".each do |";
  protected final String TEXT_1345 = "|";
  protected final String TEXT_1346 = NL + "      ";
  protected final String TEXT_1347 = ".delete" + NL + "    end";
  protected final String TEXT_1348 = NL + "    @";
  protected final String TEXT_1349 = ".each do |";
  protected final String TEXT_1350 = "|";
  protected final String TEXT_1351 = NL + "      ";
  protected final String TEXT_1352 = ".";
  protected final String TEXT_1353 = "(nil)" + NL + "    end";
  protected final String TEXT_1354 = NL + NL;
  protected final String TEXT_1355 = NL + "  #------------------------" + NL + "  # DEVELOPER CODE - PROVIDED AS-IS" + NL + "  #------------------------" + NL + "  ";
  protected final String TEXT_1356 = NL + "  ";
  protected final String TEXT_1357 = NL + "end";
  protected final String TEXT_1358 = NL;

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
     if (uClass.numberOfComments() > 0) { append(stringBuffer, "\n{0}", Comment.format("Hash",uClass.getComments())); } 
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
         
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
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

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    
// NOT IMPLEMENTED YET

     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_186);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_187);
     
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
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

    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(TEXT_190);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_191);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {
    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_193);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(TEXT_196);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_197);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_198);
    
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
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_200);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(TEXT_202);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_203);
     } 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_205);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(TEXT_208);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( gen.translate("parameterOne",sm) );
     if (hasEntry) { 
    stringBuffer.append(TEXT_210);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_213);
     } 
    stringBuffer.append(TEXT_214);
    
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
      
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("associationOne",av));
     } else { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("associationOne",av));
     append(stringBuffer, "\n    {0}",customGetPostfixCode); 
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("parameterOne",av));
     } 
    stringBuffer.append(TEXT_220);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_222);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_225);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_230);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_234);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_237);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_240);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_243);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_244);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_245);
    
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
      
    stringBuffer.append(TEXT_246);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPrefixCode); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     } else { 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPostfixCode); } 
    stringBuffer.append(TEXT_258);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_261);
     } else { 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_263);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_264);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_267);
     } else { 
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_269);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_270);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_273);
     } else { 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_276);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_279);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_283);
     } 
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_292);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_293);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_296);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_299);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_309);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_310);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_313);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_316);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_317);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_320);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_324);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_325);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_328);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_336);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_351);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_352);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_355);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_360);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_369);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_370);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_381);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_382);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_385);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_397);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_402);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_405);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_410);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_418);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_419);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_422);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_426);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_443);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_446);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_451);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_459);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_460);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_463);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_467);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_479);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_489);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_490);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_493);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_508);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_509);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_532);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_533);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_536);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_548);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_551);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_558);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_559);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_562);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_574);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_575);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_593);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_594);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_597);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_600);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_613);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_614);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_617);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_620);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_633);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_634);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_637);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_643);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_658);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_659);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_662);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_664);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_665);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_678);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_679);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_682);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_686);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_693);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_707);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_708);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_711);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_715);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_721);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_735);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_736);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_739);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_757);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_760);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_768);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_769);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_772);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_787);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_788);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_791);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_795);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_813);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_816);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_824);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_825);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_828);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_834);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_837);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_846);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_847);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_850);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_854);
     } 
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_872);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_875);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_886);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_887);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_890);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_897);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_902);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_903);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_909);
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_925);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_926);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_929);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_932);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_935);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_940);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_941);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_944);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_950);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_953);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_958);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_959);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_962);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_965);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_968);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_971);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_978);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_981);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1002);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1005);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1046);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1047);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1050);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1088);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1089);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1092);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1116);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1117);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" or {0}.size > {2}.{1}", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av),uClass.getName());

    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1120);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(orCheckMaxBound);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1133);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n          {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1182);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1185);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1206);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1207);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1210);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1231);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1232);
    
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


    stringBuffer.append(TEXT_1233);
    stringBuffer.append(TEXT_1234);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(TEXT_1236);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1237);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1238);
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
        
    stringBuffer.append(TEXT_1239);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1241);
    
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

    stringBuffer.append(TEXT_1242);
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(TEXT_1246);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1247);
    
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
        
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1249);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1250);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1251);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1253);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1254);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1255);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1256);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1257);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1258);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1259);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1260);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1261);
    
      }
    }
  }

    stringBuffer.append(TEXT_1262);
    
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
        
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1264);
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1266);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1273);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1277);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1285);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
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
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1296);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1299);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1307);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1310);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1317);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1332);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1342);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1347);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1353);
    
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

    stringBuffer.append(TEXT_1354);
     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}