package cruise.ui.jsf.templates.impl.GUI;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;
import cruise.model.abstractObjects.BackingObject;

public class BaseMain implements IGenerator {

  protected static String nl;
  public static synchronized BaseMain create(String lineSeparator)
  {
    nl = lineSeparator;
    BaseMain result = new BaseMain();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL + "<ui:composition template=\"/pages/templates/common.xhtml\">" + NL + "\t<ui:define name=\"pageHeader\">";
  protected final String TEXT_2 = " CRUD</ui:define>" + NL + "\t<ui:define name=\"body\">" + NL + "\t\t<ui:include src=\"";
  protected final String TEXT_3 = "Insertable.xhtml\">" + NL + "\t\t<ui:param name=\"uniqueId\" value=\"";
  protected final String TEXT_4 = "\"/>" + NL + "\t\t</ui:include>" + NL + "\t</ui:define>" + NL + "</ui:composition>" + NL + "</html>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(JSFProvider.getNextId());
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}