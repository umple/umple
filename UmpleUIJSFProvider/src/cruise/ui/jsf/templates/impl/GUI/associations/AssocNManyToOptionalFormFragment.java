package cruise.ui.jsf.templates.impl.GUI.associations;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.jsf.*;

public class AssocNManyToOptionalFormFragment
{
  protected static String nl;
  public static synchronized AssocNManyToOptionalFormFragment create(String lineSeparator)
  {
    nl = lineSeparator;
    AssocNManyToOptionalFormFragment result = new AssocNManyToOptionalFormFragment();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\t<h:panelGrid columns=\"2\" \t >" + NL + "<rich:simpleTogglePanel switchType=\"client\"  label=\"\" style=\"width:350px; text-align:center;\" >\t" + NL + "\t\t\t<f:facet name=\"openMarker\">" + NL + "\t\t\t\t<h:outputText value=\"Show #{";
  protected final String TEXT_3 = "Bundle.";
  protected final String TEXT_4 = "}s +\" style=\"font-weight:bold;color:black;\"/>" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<f:facet name=\"closeMarker\">" + NL + "\t\t\t\t<h:outputText value=\"Hide #{";
  protected final String TEXT_5 = "Bundle.";
  protected final String TEXT_6 = "}s -\" style=\"font-weight:bold;color:black;\"/>" + NL + "\t\t\t</f:facet>\t\t\t\t" + NL + "\t<rich:dataTable value=\"#{";
  protected final String TEXT_7 = "List}\" var=\"reg\"" + NL + "\t\tonRowMouseOver=\"this.style.backgroundColor='#F1F1F1'\" style=\"align:center;\"" + NL + "\t\tonRowMouseOut=\"this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'\" rows=\"10\" rowKeyVar=\"row\"\t>" + NL + "\t\t<f:facet name=\"header\">" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_8 = "Bundle.";
  protected final String TEXT_9 = "}\" />" + NL + "\t\t</f:facet>" + NL + "" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t<rich:column>\t" + NL + "\t\t\t<f:facet name=\"header\">Type</f:facet>" + NL + "\t\t\t<h:outputText value=\"#{reg.class.name}\" >" + NL + "\t\t\t</h:outputText>" + NL + "" + NL + "\t\t</rich:column>\t\t\t" + NL + "\t\t<f:facet name=\"footer\">" + NL + "\t\t\t<rich:datascroller renderIfSinglePage=\"false\" />" + NL + "" + NL + "\t\t</f:facet>" + NL + "\t</rich:dataTable>" + NL + "\t</rich:simpleTogglePanel>" + NL + "\t\t<a4j:commandLink value=\"\" reRender=\"";
  protected final String TEXT_16 = "PanelRichPanel#{uniqueId}\"" + NL + "\t\t\timmediate=\"true\" " + NL + "\t\t\taction=\"#{";
  protected final String TEXT_17 = "Bean.to";
  protected final String TEXT_18 = "}\"" + NL + "\t\t\toncomplete=\"Richfaces.showModalPanel('";
  protected final String TEXT_19 = "GridPanel#{uniqueId}');\">" + NL + "\t\t\t<h:outputText value=\"Manage\" />" + NL + "\t\t</a4j:commandLink>" + NL + "\t\t\t\t\t</h:panelGrid>\t\t\t\t" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
	List<AssociationVariable> multipleAsociations=bckObject.getNManyToOptionalAssociations();

     for (AssociationVariable assocVar: multipleAsociations) { 
    stringBuffer.append(TEXT_1);
     BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append("a"+bckObject.getClassName()+"Bean." + assocVar.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_9);
     for (Attribute attVar: assBck.getKeysAttributes()) { 
    stringBuffer.append(TEXT_10);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg","a" + assBck.getClassName() ); 
    stringBuffer.append(TEXT_11);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_19);
     } 
    return stringBuffer.toString();
  }
}
