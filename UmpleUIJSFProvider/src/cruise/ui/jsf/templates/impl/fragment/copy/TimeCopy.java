package cruise.ui.jsf.templates.impl.fragment.copy;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.ui.jsf.*;;

public class TimeCopy implements IGenerator {

  protected static String nl;
  public static synchronized TimeCopy create(String lineSeparator)
  {
    nl = lineSeparator;
    TimeCopy result = new TimeCopy();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#1#.set";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ".components.bean.TimeBean.getSqlTime(";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = "));";
  protected final String TEXT_6 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument;
String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);  
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append("this.a"+ attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_4);
    stringBuffer.append("this.a"+ attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}