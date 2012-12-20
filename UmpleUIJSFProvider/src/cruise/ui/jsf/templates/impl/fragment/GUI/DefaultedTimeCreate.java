package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class DefaultedTimeCreate implements IGenerator {

  protected static String nl;
  public static synchronized DefaultedTimeCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    DefaultedTimeCreate result = new DefaultedTimeCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "<h:outputText value=\"#{#1#Bean.defaulted";
  protected final String TEXT_3 = "}\">" + NL + "\t\t\t\t<f:convertDateTime pattern=\"hh:mm\" />" + NL + "</h:outputText>" + NL;
  protected final String TEXT_4 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}