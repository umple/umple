package cruise.ui.jsf.templates.impl.GUI;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class BaseInsertable implements IGenerator {

  protected static String nl;
  public static synchronized BaseInsertable create(String lineSeparator)
  {
    nl = lineSeparator;
    BaseInsertable result = new BaseInsertable();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL + "<f:subview>" + NL + "\t<h:form>" + NL + "\t\t<rich:panel style=\"width:450px\" id=\"";
  protected final String TEXT_2 = "MainPanel#{uniqueId}\">" + NL + "\t\t\t<f:facet name=\"header\">" + NL + "\t\t\t#{";
  protected final String TEXT_3 = "Bundle.";
  protected final String TEXT_4 = "ClassName} " + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<h:panelGrid columns=\"1\" >" + NL + "\t\t\t\t<h:panelGrid columns=\"3\"  columnClasses=\"colStyle1\"  rendered=\"#{!";
  protected final String TEXT_5 = "Bean.editing}\" >" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t<h:graphicImage value=\"/images/icons/key.png\" style=\"border:0\" />" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t<h:outputText value=\" \" />" + NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t" + NL + "\t\t\t\t</h:panelGrid>" + NL + "\t\t\t\t<h:panelGrid columns=\"3\" columnClasses=\"colStyle1\"  rendered=\"#{";
  protected final String TEXT_13 = "Bean.editing}\">" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t<h:graphicImage value=\"/images/icons/key.png\" style=\"border:0\" />" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t<h:outputText value=\" \" />" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t</h:panelGrid>" + NL + "\t\t\t\t<h:panelGrid columns=\"2\" columnClasses=\"colStyle1\"  >";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = "\t\t";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = "\t\t";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t\t\t</h:panelGrid>";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = "\t\t" + NL + "" + NL + "\t\t\t<h:panelGrid columns=\"2\" style=\"width:100%; text-align:right;\">" + NL + "\t\t\t\t\t<a4j:commandButton action=\"#{";
  protected final String TEXT_31 = "Bean.createOrEdit}\"" + NL + "\t\t\t\t\t\tvalue=\"#{";
  protected final String TEXT_32 = "Bean.editing?'Update':'Add'}\"" + NL + "\t\t\t\t\t\treRender=\"";
  protected final String TEXT_33 = "GridContainer#{uniqueId}, ";
  protected final String TEXT_34 = "MainPanel#{uniqueId}\" />" + NL + "\t\t\t\t\t<a4j:commandButton action=\"#{";
  protected final String TEXT_35 = "Bean.cancel}\"  " + NL + "\t\t\t\t\t\tvalue=\"Cancel\" reRender=\"";
  protected final String TEXT_36 = "MainPanel#{uniqueId}\" />" + NL + "\t\t\t</h:panelGrid>" + NL + "\t\t\t</h:panelGrid>" + NL + "\t\t</rich:panel>" + NL + "\t</h:form>" + NL + "</f:subview>" + NL + "<f:subview>" + NL + "\t<rich:spacer height=\"3\" />" + NL + "\t\t<rich:panel style=\"border-style:none; background-color:transparent\" id=\"";
  protected final String TEXT_37 = "GridContainer#{uniqueId}\">" + NL + "\t\t<rich:spacer height=\"3\" />" + NL + "\t\t <ui:include src=\"grid.xhtml\">" + NL + "\t\t\t<ui:param name=\"mainPanel\" value=\"";
  protected final String TEXT_38 = "MainPanel#{uniqueId}\"/>" + NL + "\t\t\t<ui:param name=\"parentId\" value=\"#{uniqueId}\"/>" + NL + "\t\t\t<ui:param name=\"uniqueId\" value=\"";
  protected final String TEXT_39 = "\" />" + NL + "\t\t</ui:include>" + NL + "\t</rich:panel>" + NL + "</f:subview>";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "\t";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL;
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "</html>";

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
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_5);
     for (Attribute attVar: bckObject.getKeysAttributes()) {	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(bckObject.getFragmentProvider().getGUICreateFragment(attVar, "a"+bckObject.getClassName() ));
    stringBuffer.append(TEXT_7);
    } 
    stringBuffer.append(TEXT_8);
     for (Attribute attVar: bckObject.getAttVariables()) { 
					String frmt=bckObject.getFragmentProvider().getGUICreateFragment(attVar, "a"+bckObject.getClassName() ) ;
				if(frmt.trim().length()>0){		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(frmt);
    stringBuffer.append(TEXT_10);
     }
    stringBuffer.append(TEXT_11);
    } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_13);
     for (Attribute attVar: bckObject.getKeysAttributes()) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(bckObject.getFragmentProvider().getGUIEditFragment(attVar, "a"+bckObject.getClassName(),voName ) );
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
     for (Attribute attVar: bckObject.getAttVariables()) { 
					String frmt=bckObject.getFragmentProvider().getGUIEditFragment(attVar, "a"+bckObject.getClassName(),voName );
					if(frmt.trim().length()>0){
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(frmt);
    stringBuffer.append(TEXT_18);
     }
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroOrOneFormFragment(bckObject) );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocMandatorylToSingletonFormFragment(bckObject) );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocOptionalToSingletonFormFragment(bckObject) );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocManyToOneFormFragment(bckObject) );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroManyToOptionalFormFragment(bckObject) );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocNManyToOptionalFormFragment(bckObject) );
    stringBuffer.append(TEXT_30);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(JSFProvider.getNextId());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroOrOnePanelFragment(bckObject) );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocZeroManyToOptionalPanelFragment(bckObject) );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocNManyToOptionalPanelFragment(bckObject) );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(((JSFProvider)bckObject.getFragmentProvider()).getAssocManyToOnePanelFragment(bckObject) );
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}