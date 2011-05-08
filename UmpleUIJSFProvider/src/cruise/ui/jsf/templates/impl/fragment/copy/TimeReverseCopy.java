package cruise.ui.jsf.templates.impl.fragment.copy;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class TimeReverseCopy implements IGenerator {

  protected static String nl;
  public static synchronized TimeReverseCopy create(String lineSeparator)
  {
    nl = lineSeparator;
    TimeReverseCopy result = new TimeReverseCopy();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "=#1#.get";
  protected final String TEXT_3 = "().getHours();";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "=#1#.get";
  protected final String TEXT_6 = "().getMinutes();";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append("this.a"+ attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append("this.a"+ attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_5);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}