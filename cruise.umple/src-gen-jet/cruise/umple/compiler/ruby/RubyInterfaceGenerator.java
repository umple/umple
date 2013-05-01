package cruise.umple.compiler.ruby;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class RubyInterfaceGenerator implements ILang 
{

  protected static String nl;
  public static synchronized RubyInterfaceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    RubyInterfaceGenerator result = new RubyInterfaceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "# PLEASE DO NOT EDIT THIS CODE" + NL + "# This code was generated using the UMPLE ${last.version} modeling language!" + NL + "# NOTE: Ruby generator is experimental and is missing some features available in" + NL + "# in other Umple generated languages like Java or PHP";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "class ";
  protected final String TEXT_5 = NL + "  ";
  protected final String TEXT_6 = NL + "end";

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
    
  UmpleInterface uInterface = (UmpleInterface) uElement;
  // GeneratedInterface gInterface = uInterface.getGeneratedInterface();
  RubyGenerator gen = new RubyGenerator();
  gen.setModel(model);
  
  String extraCode = "";
  if (uInterface.getExtraCode() != null)
  {
    extraCode = uInterface.getExtraCode();
  }


    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gen.translate("packageDefinition",uInterface));
    
  for (Depend depend : uInterface.getDepends())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "require '{0}'",depend.getName());
  }
  
  // TODO: No test failed from removing this
  // for (String anImport : gInterface.getMultiLookup("import"))
  // {
  //  appendln(stringBuffer, "");
  //  append(stringBuffer, "require '{0}'",anImport);
  // }

    stringBuffer.append(TEXT_4);
    stringBuffer.append(uInterface.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(extraCode);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}