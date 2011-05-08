package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class GridSetteableDouble implements IGenerator {

  protected static String nl;
  public static synchronized GridSetteableDouble create(String lineSeparator)
  {
    nl = lineSeparator;
    GridSetteableDouble result = new GridSetteableDouble();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t<f:facet name=\"header\"><h:outputText value=\"#{#2#Bundle.";
  protected final String TEXT_2 = "}\"/></f:facet>" + NL + "\t\t\t<h:outputText value=\"#{#1#.";
  protected final String TEXT_3 = "}\" >" + NL + "\t\t\t<f:converter converterId=\"javax.faces.Double\" />" + NL + "\t\t\t</h:outputText>";
  protected final String TEXT_4 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}