package cruise.ui.jsf.templates.impl.GUI;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class BaseInsertableSingleton implements IGenerator {

  protected static String nl;
  public static synchronized BaseInsertableSingleton create(String lineSeparator)
  {
    nl = lineSeparator;
    BaseInsertableSingleton result = new BaseInsertableSingleton();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL + "<f:subview>" + NL + "\t<h:form>" + NL + "\t\t<rich:panel style=\"width:450px\" id=\"";
  protected final String TEXT_2 = "MainPanel#{uniqueId}\">" + NL + "\t\t\t<f:facet name=\"header\">" + NL + "\t\t\t\t#{";
  protected final String TEXT_3 = "Bundle.";
  protected final String TEXT_4 = "ClassName} " + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<h:panelGrid columns=\"1\" >" + NL + "\t\t\t\t<h:panelGrid columns=\"3\" columnClasses=\"colStyle1\"  >" + NL + "\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\t<h:graphicImage value=\"/images/icons/key.png\" style=\"border:0\" />" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t<h:outputText value=\" \" />" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t</h:panelGrid>" + NL + "\t\t\t\t<h:panelGrid columns=\"2\" columnClasses=\"colStyle1\"  >";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "\t\t" + NL + "\t\t\t</h:panelGrid>";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = "\t\t";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL + "\t\t\t<h:panelGrid columns=\"2\" style=\"width:100%; text-align:right;\">" + NL + "\t\t\t\t\t<a4j:commandButton action=\"#{";
  protected final String TEXT_20 = "Bean.edit}\"" + NL + "\t\t\t\t\t\tvalue=\"Update\"" + NL + "\t\t\t\t\t\treRender=\"";
  protected final String TEXT_21 = "MainPanel#{uniqueId}\" />" + NL + "\t\t\t\t\t<a4j:commandButton action=\"#{";
  protected final String TEXT_22 = "Bean.cancel}\"  " + NL + "\t\t\t\t\t\tvalue=\"Cancel\" reRender=\"";
  protected final String TEXT_23 = "MainPanel#{uniqueId}\" />" + NL + "\t\t\t</h:panelGrid>" + NL + "\t\t\t</h:panelGrid>" + NL + "\t\t</rich:panel>" + NL + "\t</h:form>" + NL + "</f:subview>";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = "\t";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "</html>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    String voName= bckObject.getClassName()+"VO";
    String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_4);
     for (Attribute attVar: bckObject.getKeysAttributes()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(bckObject.getFragmentProvider().getGUIEditFragment(attVar, "a"+bckObject.getClassName(),voName ) );
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
     for (Attribute attVar: bckObject.getAttVariables()) { 
					String frmt=bckObject.getFragmentProvider().getGUIEditFragment(attVar, "a"+bckObject.getClassName(),voName );
					if(frmt.trim().length()>0){
					
    stringBuffer.append(TEXT_8);
    stringBuffer.append(frmt);
    stringBuffer.append(TEXT_9);
     }
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroOrOneFormFragment(bckObject) );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocManyToOneFormFragment(bckObject) );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroManyToOptionalFormFragment(bckObject) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocNManyToOptionalFormFragment(bckObject) );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocManyToOneSingletonFormFragment(bckObject) );
    stringBuffer.append(TEXT_19);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroOrOnePanelFragment(bckObject) );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroManyToOptionalPanelFragment(bckObject) );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocNManyToOptionalPanelFragment(bckObject) );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocManyToOnePanelFragment(bckObject) );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocManyToOneSingletonPanelFragment(bckObject) );
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}