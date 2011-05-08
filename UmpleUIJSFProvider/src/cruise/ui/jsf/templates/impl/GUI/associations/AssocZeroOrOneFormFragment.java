package cruise.ui.jsf.templates.impl.GUI.associations;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.jsf.*;

public class AssocZeroOrOneFormFragment
{
  protected static String nl;
  public static synchronized AssocZeroOrOneFormFragment create(String lineSeparator)
  {
    nl = lineSeparator;
    AssocZeroOrOneFormFragment result = new AssocZeroOrOneFormFragment();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_2 = "\t" + NL + "\t\t\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_3 = "Bundle.";
  protected final String TEXT_4 = "}\"  />" + NL + "\t\t\t\t\t<h:panelGrid columns=\"2\" style=\"text-align:right;\"\t  >" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t<rich:simpleTogglePanel switchType=\"client\"  label=\"\" style=\"width:220px\" rendered=\"#{";
  protected final String TEXT_6 = "Bean.";
  protected final String TEXT_7 = "!=null}\">\t" + NL + "\t\t\t<f:facet name=\"openMarker\">" + NL + "\t\t\t\t<h:outputText value=\"Show +\" style=\"font-weight:bold;color:black;\"/>" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<f:facet name=\"closeMarker\">" + NL + "\t\t\t\t<h:outputText value=\"Hide -\" style=\"font-weight:bold;color:black;\"/>" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<h:panelGrid columns=\"2\" style=\"text-align:left;\"\t>" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t<h:outputText styleClass=\"label1\" value=\"#{";
  protected final String TEXT_9 = "Bundle.";
  protected final String TEXT_10 = "}\" />" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t<f:facet name=\"header\">" + NL + "\t\t\t<h:outputText value=\" \" />" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t</h:panelGrid>" + NL + "\t\t\t</rich:simpleTogglePanel>" + NL + "\t\t\t\t\t\t<a4j:commandLink value=\"\" reRender=\"";
  protected final String TEXT_13 = "PanelRichPanel#{uniqueId}\"" + NL + "\t\t\t\t\t\t\trendered=\"#{!";
  protected final String TEXT_14 = "Bean.from";
  protected final String TEXT_15 = "}\" immediate=\"true\" " + NL + "\t\t\t\t\t\t\taction=\"#{";
  protected final String TEXT_16 = "Bean.to";
  protected final String TEXT_17 = "s}\"" + NL + "\t\t\t\t\t\t\toncomplete=\"Richfaces.showModalPanel('";
  protected final String TEXT_18 = "GridPanel#{uniqueId}');\">" + NL + "\t\t\t\t\t\t\t<h:outputText value=\"Select\" />" + NL + "\t\t\t\t\t\t</a4j:commandLink>" + NL + "\t\t\t\t\t</h:panelGrid>\t\t\t\t" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    List<AssociationVariable> mergeList= new ArrayList<AssociationVariable>();
	mergeList.addAll( bckObject.getConstructorOneAsociations());
	mergeList.addAll(bckObject.getZeroOrOneAsociations());

    stringBuffer.append(TEXT_1);
     for (AssociationVariable assocVar: mergeList) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
     BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()); 
    stringBuffer.append(TEXT_5);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_7);
     for (Attribute attVar: assBck.getKeysAttributes()) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append("a"+assBck.getClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(bckObject.getFragmentProvider().getGUIGridFragment(attVar, "a"+bckObject.getClassName()+"Bean." + assocVar.getName(), "a" + assBck.getClassName()  ) );
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_18);
     } 
    return stringBuffer.toString();
  }
}
