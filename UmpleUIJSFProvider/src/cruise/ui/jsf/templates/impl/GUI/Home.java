package cruise.ui.jsf.templates.impl.GUI;

import cruise.model.abstractObjects.IGenerator;

public class Home implements IGenerator {

  protected static String nl;
  public static synchronized Home create(String lineSeparator)
  {
    nl = lineSeparator;
    Home result = new Home();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:c=\"http://java.sun.com/jstl/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL + "<ui:composition template=\"/pages/templates/common.xhtml\">" + NL + "\t<ui:define name=\"pageTitle\">Umple Generated</ui:define>" + NL + "\t<ui:define name=\"body\">" + NL + "\t\t<f:subview>" + NL + "\t\t\t<h:form>" + NL + "\t\t\t\t<rich:panel style=\"width:300;\" id=\"mainPanel\">" + NL + "\t\t\t\t\t<f:facet name=\"header\">" + NL + "\t\t\t\t\t\t<ui:insert name=\"pageHeader\">Welcome</ui:insert>" + NL + "\t\t\t\t\t</f:facet>" + NL + "\t\t\t\t\t<h:panelGrid columns=\"1\" style=\"text-align:right;\">" + NL + "\t\t\t\t\t</h:panelGrid>" + NL + "\t\t\t\t</rich:panel>" + NL + "\t\t\t</h:form>" + NL + "\t\t</f:subview>" + NL + "\t</ui:define>" + NL + "</ui:composition>" + NL + "</html>";
  protected final String TEXT_2 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}