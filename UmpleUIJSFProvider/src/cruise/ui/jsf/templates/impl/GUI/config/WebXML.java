package cruise.ui.jsf.templates.impl.GUI.config;

import cruise.model.abstractObjects.IGenerator;

public class WebXML implements IGenerator {

  protected static String nl;
  public static synchronized WebXML create(String lineSeparator)
  {
    nl = lineSeparator;
    WebXML result = new WebXML();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\"?>" + NL + "<web-app version=\"2.5\" xmlns=\"http://java.sun.com/xml/ns/javaee\"" + NL + "\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + NL + "\txsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\">" + NL + "\t<description>Facelets StarterKit</description>" + NL + "\t<display-name>CodeTest</display-name>" + NL + "\t<context-param>" + NL + "\t\t<param-name>javax.faces.DEFAULT_SUFFIX</param-name>" + NL + "\t\t<param-value>.xhtml</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "\t\t<param-name>facelets.REFRESH_PERIOD</param-name>" + NL + "\t\t<param-value>2</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "\t\t<param-name>facelets.DEVELOPMENT</param-name>" + NL + "\t\t<param-value>true</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "\t\t<param-name>javax.faces.STATE_SAVING_METHOD</param-name>" + NL + "\t\t<param-value>client</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "\t\t<param-name>com.sun.faces.validateXml</param-name>" + NL + "\t\t<param-value>true</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "\t\t<param-name>com.sun.faces.verifyObjects</param-name>" + NL + "\t\t<param-value>true</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "\t  <param-name>org.richfaces.SKIN</param-name>" + NL + "\t  <param-value>#{skinBean.skin}</param-value>" + NL + "\t</context-param>" + NL + "\t<context-param>" + NL + "   \t\t<param-name>org.richfaces.CONTROL_SKINNING</param-name>" + NL + "   \t\t<param-value>enable</param-value>" + NL + "\t</context-param>" + NL + "\t<filter>" + NL + "\t\t<display-name>Ajax4jsf Filter</display-name>" + NL + "\t\t<filter-name>ajax4jsf</filter-name>" + NL + "\t\t<filter-class>org.ajax4jsf.Filter</filter-class>" + NL + "\t\t<init-param>" + NL + "\t\t\t<param-name>createTempFiles</param-name>" + NL + "\t\t\t<param-value>true</param-value>" + NL + "\t\t</init-param>" + NL + "\t</filter>" + NL + "\t<filter-mapping>" + NL + "\t\t<filter-name>ajax4jsf</filter-name>" + NL + "\t\t<servlet-name>Faces Servlet</servlet-name>" + NL + "\t\t<dispatcher>REQUEST</dispatcher>" + NL + "\t\t<dispatcher>FORWARD</dispatcher>" + NL + "\t\t<dispatcher>INCLUDE</dispatcher>" + NL + "\t</filter-mapping>" + NL + "\t<servlet>" + NL + "\t\t<servlet-name>Faces Servlet</servlet-name>" + NL + "\t\t<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>" + NL + "\t\t<load-on-startup>1</load-on-startup>" + NL + "\t</servlet>" + NL + "\t<servlet-mapping>" + NL + "\t\t<servlet-name>Faces Servlet</servlet-name>" + NL + "\t\t<url-pattern>*.jsf</url-pattern>" + NL + "\t</servlet-mapping>" + NL + "\t<login-config>" + NL + "\t\t<auth-method>BASIC</auth-method>" + NL + "\t</login-config>" + NL + "</web-app>";
  protected final String TEXT_2 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}