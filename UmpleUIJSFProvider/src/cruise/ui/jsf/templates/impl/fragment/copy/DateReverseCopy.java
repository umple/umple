package cruise.ui.jsf.templates.impl.fragment.copy;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class DateReverseCopy implements IGenerator {

  protected static String nl;
  public static synchronized DateReverseCopy create(String lineSeparator)
  {
    nl = lineSeparator;
    DateReverseCopy result = new DateReverseCopy();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "this.a";
  protected final String TEXT_2 = "=#1#.get";
  protected final String TEXT_3 = "();";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}