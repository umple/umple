package cruise.ui.jsf.templates.impl.fragment.get;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class SetteableStringGet implements IGenerator {

  protected static String nl;
  public static synchronized SetteableStringGet create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableStringGet result = new SetteableStringGet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tpublic ";
  protected final String TEXT_2 = " get";
  protected final String TEXT_3 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_4 = ";" + NL + "\t\t}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("a"+ attVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}