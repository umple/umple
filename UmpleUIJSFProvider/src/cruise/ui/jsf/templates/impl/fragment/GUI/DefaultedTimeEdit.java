package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class DefaultedTimeEdit implements IGenerator {

  protected static String nl;
  public static synchronized DefaultedTimeEdit create(String lineSeparator)
  {
    nl = lineSeparator;
    DefaultedTimeEdit result = new DefaultedTimeEdit();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "<h:panelGrid columns=\"2\">" + NL + "<h:panelGrid columns=\"3\" id=\"";
  protected final String TEXT_3 = "#{uniqueId}\">" + NL + "\t<h:selectOneMenu value=\"#{#1#Bean.";
  protected final String TEXT_4 = "}\">" + NL + "\t\t<f:selectItems value=\"#{timeBean.hours}\" />" + NL + "\t</h:selectOneMenu>" + NL + "\t<h:outputText value=\":\" />" + NL + "\t<h:selectOneMenu value=\"#{#1#Bean.";
  protected final String TEXT_5 = "}\">" + NL + "\t\t<f:selectItems value=\"#{timeBean.minutes}\" />" + NL + "\t</h:selectOneMenu>" + NL + "</h:panelGrid>" + NL + "\t<a4j:commandLink " + NL + "\t\taction=\"#{#1#Bean.resetToDefaulted";
  protected final String TEXT_6 = "}\"" + NL + "\t\treRender=\"";
  protected final String TEXT_7 = "#{uniqueId}\">" + NL + "\t\t<h:graphicImage value=\"/images/icons/reload.png\" style=\"border:0\" />" + NL + "\t</a4j:commandLink>" + NL + "</h:panelGrid>";
  protected final String TEXT_8 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append( attVar.getName()+"Hour");
    stringBuffer.append(TEXT_4);
    stringBuffer.append( attVar.getName()+"Minute");
    stringBuffer.append(TEXT_5);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}