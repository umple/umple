package cruise.ui.jsf.templates.impl.GUI.associations;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.jsf.*;

public class AssocZeroManyToOptionalPanelFragment
{
  protected static String nl;
  public static synchronized AssocZeroManyToOptionalPanelFragment create(String lineSeparator)
  {
    nl = lineSeparator;
    AssocZeroManyToOptionalPanelFragment result = new AssocZeroManyToOptionalPanelFragment();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<rich:modalPanel id=\"";
  protected final String TEXT_2 = "GridPanel#{uniqueId}\" autosized=\"true\">" + NL + "\t<f:facet name=\"header\">" + NL + "\t\t<h:panelGroup>" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_3 = "Bundle.";
  protected final String TEXT_4 = "}\"></h:outputText>" + NL + "\t\t</h:panelGroup>" + NL + "\t</f:facet>" + NL + "\t<f:facet name=\"controls\">" + NL + "\t\t<h:panelGroup>" + NL + "" + NL + "\t\t\t<f:subview>" + NL + "\t\t\t\t<h:form>" + NL + "\t\t\t\t\t<a4j:commandLink" + NL + "\t\t\t\t\t\taction=\"#{";
  protected final String TEXT_5 = "Bean.to";
  protected final String TEXT_6 = "Cancel}\" value=\"\"" + NL + "\t\t\t\t\t\toncomplete=\"Richfaces.hideModalPanel('";
  protected final String TEXT_7 = "GridPanel#{uniqueId}');\">" + NL + "\t\t\t\t\t\t<h:graphicImage value=\"/images/icons/close.png\"" + NL + "\t\t\t\t\t\t\tstyleClass=\"hidelink\"  />" + NL + "\t\t\t\t\t</a4j:commandLink>" + NL + "\t\t\t\t</h:form>" + NL + "\t\t\t</f:subview>" + NL + "\t\t</h:panelGroup>" + NL + "\t</f:facet>" + NL + "" + NL + "\t<rich:panel id=\"";
  protected final String TEXT_8 = "PanelRichPanel#{uniqueId}\">" + NL;
  protected final String TEXT_9 = NL + "\t\t<ui:include src=\"/pages/";
  protected final String TEXT_10 = "/";
  protected final String TEXT_11 = "/gridSelectMany.xhtml\">" + NL + "\t\t\t<ui:param name=\"mainPanel\" value=\"";
  protected final String TEXT_12 = "MainPanel#{uniqueId}\"/>" + NL + "\t\t\t<ui:param name=\"uniqueId\" value=\"";
  protected final String TEXT_13 = "\"/>" + NL + "\t\t</ui:include>" + NL + "\t\t<f:subview>" + NL + "\t\t\t<h:form>" + NL + "\t\t\t\t<h:panelGrid columns=\"2\">" + NL + "\t\t\t\t\t<a4j:commandButton" + NL + "\t\t\t\t\t\taction=\"#{";
  protected final String TEXT_14 = "Bean.to";
  protected final String TEXT_15 = "Done}\" value=\"Confirm\"" + NL + "\t\t\t\t\t\treRender=\"";
  protected final String TEXT_16 = "MainPanel#{uniqueId}\"" + NL + "\t\t\t\t\t\toncomplete=\"Richfaces.hideModalPanel('";
  protected final String TEXT_17 = "GridPanel#{uniqueId}');\" />" + NL + "\t\t\t\t\t<a4j:commandButton" + NL + "\t\t\t\t\t\taction=\"#{";
  protected final String TEXT_18 = "Bean.to";
  protected final String TEXT_19 = "Cancel}\" value=\"Cancel\"" + NL + "\t\t\t\t\t\treRender=\"";
  protected final String TEXT_20 = "MainPanel#{uniqueId}\"" + NL + "\t\t\t\t\t\toncomplete=\"Richfaces.hideModalPanel('";
  protected final String TEXT_21 = "GridPanel#{uniqueId}');\" />" + NL + "\t\t\t\t</h:panelGrid>" + NL + "\t\t\t</h:form>" + NL + "\t\t</f:subview>" + NL + "\t</rich:panel>" + NL + "</rich:modalPanel>";
  protected final String TEXT_22 = "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
	List<AssociationVariable> multipleAsociations=bckObject.getZeroManyToOptionalAssociations();

     for (AssociationVariable assocVar: multipleAsociations) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_8);
    
String url=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()).getPackageName();
if (url==null)
	url="";
	url=url.replace('.', '/');	

    stringBuffer.append(TEXT_9);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(assocVar.getType());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(JSFProvider.getNextId());
    stringBuffer.append(TEXT_13);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
