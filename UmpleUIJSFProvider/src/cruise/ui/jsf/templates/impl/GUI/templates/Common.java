package cruise.ui.jsf.templates.impl.GUI.templates;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.ui.jsf.*;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.UmpleClass;
import cruise.model.abstractObjects.BackingObject;;

public class Common implements IGenerator {

  protected static String nl;
  public static synchronized Common create(String lineSeparator)
  {
    nl = lineSeparator;
    Common result = new Common();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL;
  protected final String TEXT_2 = NL + "<f:loadBundle basename=\"bundles.";
  protected final String TEXT_3 = "\" var=\"a";
  protected final String TEXT_4 = "Bundle\"/>\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_5 = "\t" + NL + "" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_6 = "</title>" + NL + "</head>" + NL + "<body bgcolor=\"#ffffff\">" + NL + "<f:view>" + NL + "<style type=\"text/css\">" + NL + "  .rich-stglpanel {" + NL + "  \t border-style: grooved;" + NL + "  \t background-color:transparent;" + NL + "\tpadding-top:2px;" + NL + "  \t " + NL + "\t}" + NL + "\t.rich-stglpanel-header {" + NL + "  \t border-style: none;" + NL + "  \tbackground-color:transparent;" + NL + "  \tbackground-image:none;" + NL + "  \tfont-weight:bold;" + NL + "\t}" + NL + "\t" + NL + "\t.rich-stglpanel-body{" + NL + "\tpadding-top:2px;" + NL + "  \t border-style: none;" + NL + "  \t background-color:transparent; " + NL + "  \t text-align:center;" + NL + "  \t vertical-align:text-top;" + NL + "\t}" + NL + "\t.rich-stglpnl-marker{" + NL + "  \t border-style: none;" + NL + "  \t background-color:transparent;" + NL + "  \t font-weight:bold;" + NL + "\t}" + NL + "\t" + NL + "\t.colStyle1 { " + NL + "    width: 150px;" + NL + "    text-align:right;" + NL + "    font-weight:bold;" + NL + "\t}" + NL + "\t" + NL + "\t.label1 { " + NL + "    \tfont-style: italic; " + NL + "\t}" + NL + "" + NL + "</style>" + NL + "\t<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"" + NL + "\t\twidth=\"100%\">" + NL + "\t\t<tbody>" + NL + "" + NL + "\t\t\t<tr>" + NL + "\t\t\t\t<td><f:subview>" + NL + "\t\t\t\t\t<h:form>" + NL + "\t\t\t\t\t\t<div style=\"padding: none;\">" + NL + "\t\t\t\t\t\t<div>" + NL + "\t\t\t\t\t\t<div align=\"right\"><h:outputText" + NL + "\t\t\t\t\t\t\tstyle=\"color:#000000;font-size:40px;font-family:Arial,Verdana,sans-serif;\"" + NL + "\t\t\t\t\t\t\tvalue=\"";
  protected final String TEXT_7 = "\" /></div>" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t<div><rich:toolBar width=\"100%\">" + NL + "\t\t\t\t\t\t\t<rich:toolBarGroup itemSeparator=\"line\" location=\"left\">" + NL + "\t\t\t\t\t\t\t\t<rich:dropDownMenu>" + NL + "\t\t\t\t\t\t\t\t\t<f:facet name=\"label\">" + NL + "\t\t\t\t\t\t\t\t\t\t<h:outputText value=\"OPTIONS\" />" + NL + "\t\t\t\t\t\t\t\t\t</f:facet>" + NL + "\t\t\t\t\t\t\t\t\t<rich:menuItem value=\"Home\" action=\"home\">" + NL + "\t\t\t\t\t\t\t\t\t</rich:menuItem>" + NL + "\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t\t\t\t<rich:menuItem value=\"#{";
  protected final String TEXT_9 = "Bundle.";
  protected final String TEXT_10 = "ClassName}\"" + NL + "\t\t\t\t\t\t\t\t\t\taction=\"#{mainBean.navigate}\">" + NL + "\t\t\t\t\t\t\t\t\t\t<f:setPropertyActionListener value=\"to";
  protected final String TEXT_11 = "Main\"" + NL + "\t\t\t\t\t\t\t\t\t\t\ttarget=\"#{mainBean.menuOption}\" />" + NL + "\t\t\t\t\t\t\t\t\t</rich:menuItem>" + NL + "\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\t\t\t</rich:dropDownMenu>" + NL + "\t\t\t\t\t\t\t</rich:toolBarGroup>" + NL + "\t\t\t\t\t\t\t\t<rich:toolBarGroup itemSeparator=\"line\" location=\"right\">" + NL + "\t\t\t\t\t\t\t<h:panelGrid columns=\"2\">" + NL + "\t\t\t\t\t\t\t\t<h:outputText" + NL + "\t\t\t\t\t\t\t\tvalue=\"Skin\" />" + NL + "\t\t\t\t\t\t\t   <h:selectOneMenu id=\"select\" value=\"#{skinBean.skin}\" onchange=\"document.forms[0].submit(); document.forms[1].submit();\" >" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"plain\" itemValue=\"plain\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"emeraldTown\" itemValue=\"emeraldTown\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"blueSky\" itemValue=\"blueSky\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"wine\" itemValue=\"wine\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"japanCherry\" itemValue=\"japanCherry\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"ruby\" itemValue=\"ruby\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"classic\" itemValue=\"classic\" />" + NL + "\t\t\t\t\t\t\t\t<f:selectItem itemLabel=\"deepMarine\" itemValue=\"deepMarine\" />" + NL + "\t\t\t\t\t\t\t   \t</h:selectOneMenu>" + NL + "        \t\t\t\t\t</h:panelGrid>" + NL + "\t\t\t\t\t\t\t" + NL + "\t" + NL + "\t\t\t\t\t\t\t\t<h:commandButton action=\"#{mainBean.invalidateSession}\"" + NL + "\t\t\t\t\t\t\t\t\tvalue=\"Invalidate Session\" />" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t</rich:toolBarGroup>" + NL + "\t\t\t\t\t\t</rich:toolBar></div>" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</h:form>" + NL + "\t\t\t\t</f:subview> <rich:spacer height=\"3\" /></td>" + NL + "\t\t\t</tr>" + NL + "" + NL + "\t\t\t<tr>" + NL + "\t\t\t\t<td><rich:messages passedLabel=\"\" layout=\"list\">" + NL + "\t\t\t\t\t<f:facet name=\"errorMarker\">" + NL + "\t\t\t\t\t\t<h:graphicImage value=\"/images/icons/error.gif\" />" + NL + "\t\t\t\t\t</f:facet>" + NL + "\t\t\t\t</rich:messages></td>" + NL + "\t\t\t</tr>" + NL + "" + NL + "\t\t\t<tr>" + NL + "" + NL + "\t\t\t\t<td><ui:insert name=\"body\">Page Body</ui:insert></td>" + NL + "\t\t\t</tr>" + NL + "" + NL + "\t\t</tbody>" + NL + "" + NL + "\t</table>" + NL + "" + NL + "</f:view>" + NL + "</body>" + NL + "" + NL + "</html>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List<BackingObject> clazzez=(List<BackingObject>)argument;
 String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX); 
    stringBuffer.append(TEXT_1);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
BackingObject bckObject= iterClazzez.next(); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append((bckObject.getPackageName()!=null?(bckObject.getPackageName()+"."):"" )+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(JSFProvider.properties.getProperty(cruise.model.Constants.PROJECT_NAME));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(JSFProvider.properties.getProperty(cruise.model.Constants.PROJECT_NAME));
    stringBuffer.append(TEXT_7);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  										UmpleClass clazz= iterClazzez.next().getUClazz(); 
    stringBuffer.append(TEXT_8);
    stringBuffer.append("a"+clazz.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(clazz.getName());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}