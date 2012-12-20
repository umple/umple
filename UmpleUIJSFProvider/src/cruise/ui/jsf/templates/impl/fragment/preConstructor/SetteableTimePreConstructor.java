package cruise.ui.jsf.templates.impl.fragment.preConstructor;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.ui.jsf.*;;

public class SetteableTimePreConstructor implements IGenerator {

  protected static String nl;
  public static synchronized SetteableTimePreConstructor create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableTimePreConstructor result = new SetteableTimePreConstructor();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = "= get";
  protected final String TEXT_4 = "();";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX); 
     if (attVar.getValue()==null) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( "a"+attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append( attVar.getUpperCaseName()+"");
    stringBuffer.append(TEXT_4);
    } 
    return stringBuffer.toString();
  }
}