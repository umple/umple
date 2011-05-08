package cruise.ui.jsf.templates.impl.fragment.copy;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class BooleanCopy implements IGenerator {

  protected static String nl;
  public static synchronized BooleanCopy create(String lineSeparator)
  {
    nl = lineSeparator;
    BooleanCopy result = new BooleanCopy();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#1#.set";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ");" + NL + "\t";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("this.a"+ attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}