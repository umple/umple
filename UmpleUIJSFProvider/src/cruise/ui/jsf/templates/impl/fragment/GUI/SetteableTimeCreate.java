package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class SetteableTimeCreate implements IGenerator {

  protected static String nl;
  public static synchronized SetteableTimeCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableTimeCreate result = new SetteableTimeCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />";
  protected final String TEXT_3 = NL + "\t<h:panelGrid columns=\"3\">" + NL + "\t<h:selectOneMenu value=\"#{#1#Bean.";
  protected final String TEXT_4 = "}\">" + NL + "\t\t<f:selectItems value=\"#{timeBean.hours}\" />" + NL + "\t</h:selectOneMenu>" + NL + "\t<h:outputText value=\":\" />" + NL + "\t<h:selectOneMenu value=\"#{#1#Bean.";
  protected final String TEXT_5 = "}\">" + NL + "\t\t<f:selectItems value=\"#{timeBean.minutes}\" />" + NL + "\t</h:selectOneMenu>" + NL + "</h:panelGrid>";
  protected final String TEXT_6 = NL + "<h:outputText value=\"#{#1#Bean.initial";
  protected final String TEXT_7 = "}\">" + NL + "\t\t\t\t<f:convertDateTime pattern=\"hh:mm\" />" + NL + "</h:outputText>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
     if (attVar.getValue()==null){ 
    stringBuffer.append(TEXT_3);
    stringBuffer.append( attVar.getName()+"Hour");
    stringBuffer.append(TEXT_4);
    stringBuffer.append( attVar.getName()+"Minute");
    stringBuffer.append(TEXT_5);
     } else { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_7);
     } 
    return stringBuffer.toString();
  }
}