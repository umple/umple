package cruise.ui.jsf.templates.impl.fragment.declaration;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class DefaultedTimeDeclaration implements IGenerator {

  protected static String nl;
  public static synchronized DefaultedTimeDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    DefaultedTimeDeclaration result = new DefaultedTimeDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "private  int ";
  protected final String TEXT_2 = "=getDefaulted";
  protected final String TEXT_3 = "Hour();" + NL + "private  int ";
  protected final String TEXT_4 = "=getDefaulted";
  protected final String TEXT_5 = "Minute();";
  protected final String TEXT_6 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_4);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}