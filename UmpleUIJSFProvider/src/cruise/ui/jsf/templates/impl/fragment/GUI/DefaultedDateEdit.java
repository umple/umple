package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class DefaultedDateEdit implements IGenerator {

  protected static String nl;
  public static synchronized DefaultedDateEdit create(String lineSeparator)
  {
    nl = lineSeparator;
    DefaultedDateEdit result = new DefaultedDateEdit();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "<h:panelGrid columns=\"2\">" + NL + "<rich:calendar value=\"#{#1#Bean.";
  protected final String TEXT_3 = "}\" popup=\"true\"" + NL + "\t\t\t\t\t\tid=\"";
  protected final String TEXT_4 = "#{uniqueId}\"" + NL + "\t\t\t\t\t\tdatePattern=\"yyyy-MM-dd\" showApplyButton=\"false\" cellWidth=\"24px\"" + NL + "\t\t\t\t\t\tcellHeight=\"22px\" style=\"width:200px\" />" + NL + "\t<a4j:commandLink " + NL + "\t\taction=\"#{#1#Bean.resetToDefaulted";
  protected final String TEXT_5 = "}\"" + NL + "\t\treRender=\"";
  protected final String TEXT_6 = "#{uniqueId}\">" + NL + "\t\t<h:graphicImage value=\"/images/icons/reload.png\" style=\"border:0\" />" + NL + "\t</a4j:commandLink>" + NL + "</h:panelGrid>";
  protected final String TEXT_7 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}