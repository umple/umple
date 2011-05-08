package cruise.ui.jsf.templates.impl.fragment.asignation;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class SetteableStringAsignation implements IGenerator {

  protected static String nl;
  public static synchronized SetteableStringAsignation create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableStringAsignation result = new SetteableStringAsignation();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " = #1#;";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append("a"+ attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}