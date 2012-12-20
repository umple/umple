package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class SetteableInteger implements IGenerator {

  protected static String nl;
  public static synchronized SetteableInteger create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableInteger result = new SetteableInteger();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "\t<h:inputText value=\"#{#1#Bean.";
  protected final String TEXT_3 = "}\"  >" + NL + "\t\t<f:converter converterId=\"javax.faces.Integer\" />" + NL + "\t</h:inputText>";

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