package cruise.ui.jsf.templates.impl.fragment.set;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class SetteableTimeSet implements IGenerator {

  protected static String nl;
  public static synchronized SetteableTimeSet create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableTimeSet result = new SetteableTimeSet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tpublic void set";
  protected final String TEXT_2 = "(int ";
  protected final String TEXT_3 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "\t}" + NL + "\tpublic void set";
  protected final String TEXT_6 = "(int ";
  protected final String TEXT_7 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "\t}\t";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getName()+"Hour");
    stringBuffer.append(TEXT_3);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_4);
    stringBuffer.append( attVar.getName()+"Hour");
    stringBuffer.append(TEXT_5);
    stringBuffer.append( attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_6);
    stringBuffer.append( attVar.getName()+"Minute");
    stringBuffer.append(TEXT_7);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_8);
    stringBuffer.append( attVar.getName()+"Minute");
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}