package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class ImmutableEditString implements IGenerator {

  protected static String nl;
  public static synchronized ImmutableEditString create(String lineSeparator)
  {
    nl = lineSeparator;
    ImmutableEditString result = new ImmutableEditString();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "<h:panelGrid columns=\"2\">" + NL + "<h:outputText value=\"#{#1#Bean.edited#2#.";
  protected final String TEXT_3 = "}\" />" + NL + "</h:panelGrid>";

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