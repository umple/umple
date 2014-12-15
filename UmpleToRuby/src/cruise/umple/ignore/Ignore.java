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
  protected final String TEXT_1 = "  def ";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ")" + NL + "    was_added = false";
  protected final String TEXT_4 = NL + "    was_added = ";
  protected final String TEXT_5 = " << ";
  protected final String TEXT_6 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ")" + NL + "    was_removed = false";
  protected final String TEXT_9 = NL + "    was_removed = ";
  protected final String TEXT_10 = ".delete(";
  protected final String TEXT_11 = ")";
  protected final String TEXT_12 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_3);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(gen.translate("parameterOne",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_8);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_11);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
