package cruise.ui.jsf.templates.impl.GUI.associations;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.jsf.*;

public class AssocOptionalToSingletonFormFragment
{
  protected static String nl;
  public static synchronized AssocOptionalToSingletonFormFragment create(String lineSeparator)
  {
    nl = lineSeparator;
    AssocOptionalToSingletonFormFragment result = new AssocOptionalToSingletonFormFragment();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_2 = "Bundle.";
  protected final String TEXT_3 = "}\"  />" + NL + "\t\t\t\t\t<h:panelGrid columns=\"3\" style=\"text-align:left;\"\t  >" + NL + "\t\t\t\t\t\t<h:graphicImage value=\"/images/icons/checkmark.gif\" style=\"border:0\"  rendered=\"#{";
  protected final String TEXT_4 = "Bean.selected";
  protected final String TEXT_5 = "!=null}\"/>" + NL + "\t\t\t\t\t\t<a4j:commandLink value=\"\" reRender=\"";
  protected final String TEXT_6 = "MainPanel#{uniqueId}\"" + NL + "\t\t\t\t\t\t\trendered=\"#{";
  protected final String TEXT_7 = "Bean.selected";
  protected final String TEXT_8 = "!=null}\" immediate=\"true\" " + NL + "\t\t\t\t\t\t\taction=\"#{";
  protected final String TEXT_9 = "Bean.removeSelected";
  protected final String TEXT_10 = "}\" >" + NL + "\t\t\t\t\t\t\t<h:graphicImage value=\"/images/icons/delete.gif\" style=\"border:0\" />" + NL + "\t\t\t\t\t\t</a4j:commandLink>" + NL + "\t\t\t\t\t\t<a4j:commandLink value=\"\" reRender=\"";
  protected final String TEXT_11 = "MainPanel#{uniqueId}\"" + NL + "\t\t\t\t\t\t\trendered=\"#{";
  protected final String TEXT_12 = "Bean.selected";
  protected final String TEXT_13 = "==null}\" immediate=\"true\" " + NL + "\t\t\t\t\t\t\taction=\"#{";
  protected final String TEXT_14 = "Bean.getInstance";
  protected final String TEXT_15 = "}\" >" + NL + "\t\t\t\t\t\t\t<h:outputText value=\"Instance\" />" + NL + "\t\t\t\t\t\t</a4j:commandLink>" + NL + "\t\t\t\t\t</h:panelGrid>\t\t\t\t" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    List<AssociationVariable> optionalToSingletonAssociations= bckObject.getOptionalToSingletonAssociations();

     for (AssociationVariable assocVar: optionalToSingletonAssociations) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_15);
     } 
    return stringBuffer.toString();
  }
}
