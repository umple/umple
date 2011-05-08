package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class SetteableDouble implements IGenerator {

  protected static String nl;
  public static synchronized SetteableDouble create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableDouble result = new SetteableDouble();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "\t<h:inputText \tvalue=\"#{#1#Bean.";
  protected final String TEXT_3 = "}\"  >" + NL + "\t\t<f:converter converterId=\"javax.faces.Double\" />" + NL + "\t</h:inputText>";

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