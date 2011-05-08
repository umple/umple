package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class InternalDoubleCreate implements IGenerator {

  protected static String nl;
  public static synchronized InternalDoubleCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    InternalDoubleCreate result = new InternalDoubleCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "\t<h:inputText value=\"#{#1#Bean.";
  protected final String TEXT_3 = "}\"  >" + NL + "\t\t<f:converter converterId=\"javax.faces.Double\" />" + NL + "\t</h:inputText>";
  protected final String TEXT_4 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
     if (attVar.getValue()==null){ 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getName());
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}