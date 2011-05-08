package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class ImmutableEditTime implements IGenerator {

  protected static String nl;
  public static synchronized ImmutableEditTime create(String lineSeparator)
  {
    nl = lineSeparator;
    ImmutableEditTime result = new ImmutableEditTime();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "<h:outputText value=\"#{#1#Bean.edited#2#.";
  protected final String TEXT_3 = "}\">" + NL + "\t\t\t\t<f:convertDateTime pattern=\"hh:mm\" />" + NL + "</h:outputText>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getName());
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}