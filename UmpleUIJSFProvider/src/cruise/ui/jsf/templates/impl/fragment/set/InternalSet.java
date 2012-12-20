package cruise.ui.jsf.templates.impl.fragment.set;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class InternalSet implements IGenerator {

  protected static String nl;
  public static synchronized InternalSet create(String lineSeparator)
  {
    nl = lineSeparator;
    InternalSet result = new InternalSet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tpublic void set";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = ") {" + NL + "\t\t\tthis.";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
     if(attVar.getValue()==null) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_3);
    stringBuffer.append( attVar.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append( "a"+attVar.getUpperCaseName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append( attVar.getName());
    stringBuffer.append(TEXT_6);
    }
    return stringBuffer.toString();
  }
}