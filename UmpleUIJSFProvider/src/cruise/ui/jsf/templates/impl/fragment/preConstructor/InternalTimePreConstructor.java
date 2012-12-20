package cruise.ui.jsf.templates.impl.fragment.preConstructor;

import cruise.model.abstractObjects.IGenerator;
import cruise.ui.jsf.JSFProvider;
import cruise.umple.compiler.Attribute;

public class InternalTimePreConstructor implements IGenerator {

  protected static String nl;
  public static synchronized InternalTimePreConstructor create(String lineSeparator)
  {
    nl = lineSeparator;
    InternalTimePreConstructor result = new InternalTimePreConstructor();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = "= ";
  protected final String TEXT_4 = ".components.bean.TimeBean.getSqlTime(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX); 
     if(attVar.getValue()==null) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( "a"+attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_5);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_6);
    }
    return stringBuffer.toString();
  }
}