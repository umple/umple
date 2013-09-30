package cruise.umple.ignore;

public class Ignore
{
  protected static String nl;
  public static synchronized Ignore create(String lineSeparator)
  {
    nl = lineSeparator;
    Ignore result = new Ignore();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  public function ";
  protected final String TEXT_2 = "($index)" + NL + "  {";
  protected final String TEXT_3 = NL + "    $";
  protected final String TEXT_4 = " = $this->";
  protected final String TEXT_5 = "[$index];";
  protected final String TEXT_6 = NL + "    return $";
  protected final String TEXT_7 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_8 = "()" + NL + "  {";
  protected final String TEXT_9 = NL + "    $";
  protected final String TEXT_10 = " = $this->";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "    return $";
  protected final String TEXT_13 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_14 = "()" + NL + "  {";
  protected final String TEXT_15 = NL + "    $number = count($this->";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_18 = "()" + NL + "  {";
  protected final String TEXT_19 = NL + "    $has = ";
  protected final String TEXT_20 = ".size() > 0;";
  protected final String TEXT_21 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_22 = "($";
  protected final String TEXT_23 = ")" + NL + "  {";
  protected final String TEXT_24 = NL + "    $rawAnswer = array_search($";
  protected final String TEXT_25 = ",$this->";
  protected final String TEXT_26 = ");" + NL + "    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;";
  protected final String TEXT_27 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_5);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_8);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_11);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_14);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_16);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_18);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_20);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_23);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_26);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
