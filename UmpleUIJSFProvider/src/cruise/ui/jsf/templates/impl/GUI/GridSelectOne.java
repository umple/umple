package cruise.ui.jsf.templates.impl.GUI;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;
import cruise.model.abstractObjects.BackingObject;

public class GridSelectOne implements IGenerator {

  protected static String nl;
  public static synchronized GridSelectOne create(String lineSeparator)
  {
    nl = lineSeparator;
    GridSelectOne result = new GridSelectOne();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL + "<h:form>" + NL + "\t<rich:panel header=\"Current Selection\"" + NL + "\t\tid=\"";
  protected final String TEXT_2 = "SelectionPanel#{uniqueId}\" style=\"width:300px\">" + NL + "\t\t<h:panelGrid columns=\"2\" style=\"text-align:left; width:100%\" " + NL + "\t\t\trendered=\"#{";
  protected final String TEXT_3 = "Bean.selected";
  protected final String TEXT_4 = "!=null}\">" + NL + "\t\t\t<rich:simpleTogglePanel switchType=\"client\"  label=\"\">\t" + NL + "\t\t\t<f:facet name=\"openMarker\">" + NL + "\t\t\t\t<h:outputText value=\"Show +\" style=\"font-weight:bold;color:black;\"/>" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<f:facet name=\"closeMarker\">" + NL + "\t\t\t\t<h:outputText value=\"Hide -\" style=\"font-weight:bold;color:black;\"/>" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t<h:panelGrid columns=\"2\" style=\"text-align:left;\"\t>" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t<h:outputText styleClass=\"label1\" value=\"#{";
  protected final String TEXT_6 = "Bundle.";
  protected final String TEXT_7 = "}\" />" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t<f:facet name=\"header\">" + NL + "\t\t\t<h:outputText value=\" \" />" + NL + "\t\t\t</f:facet>" + NL + "\t\t\t</h:panelGrid>" + NL + "\t\t</rich:simpleTogglePanel>" + NL + "\t\t<a4j:commandLink" + NL + "\t\t\t\taction=\"#{";
  protected final String TEXT_10 = "Bean.removeLinker}\"" + NL + "\t\t\t\treRender=\"";
  protected final String TEXT_11 = "SelectionPanel#{uniqueId}\"  >" + NL + "\t\t\t\t<h:graphicImage value=\"/images/icons/delete.gif\" style=\"border:0\" />" + NL + "\t\t</a4j:commandLink>" + NL + "\t\t</h:panelGrid>" + NL + "\t\t<h:outputText value=\"No Item Selected\"" + NL + "\t\t\trendered=\"#{";
  protected final String TEXT_12 = "Bean.selected";
  protected final String TEXT_13 = "==null}\" />" + NL + "\t</rich:panel>" + NL + "\t<rich:spacer height=\"3\" />" + NL + "\t";
  protected final String TEXT_14 = NL + "\t<rich:dataTable value=\"#{";
  protected final String TEXT_15 = "Bean.";
  protected final String TEXT_16 = "}\" var=\"reg\"" + NL + "\t\tonRowMouseOver=\"this.style.backgroundColor='#F1F1F1'\"" + NL + "\t\tonRowMouseOut=\"this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'\"" + NL + "\t\trows=\"10\" rowKeyVar=\"row\" id=\"";
  protected final String TEXT_17 = "Grid#{uniqueId}\"" + NL + "\t\tstyle=\"align:center; width:400px;\">";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = "\t\t<f:facet name=\"header\">" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_21 = "Bundle.";
  protected final String TEXT_22 = "ClassName}\" />" + NL + "\t\t";
  protected final String TEXT_23 = NL + "  \t\t<rich:columnGroup>" + NL + "\t\t <rich:column  colspan=\"";
  protected final String TEXT_24 = "\" >" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_25 = "Bundle.";
  protected final String TEXT_26 = "ClassName}\" />" + NL + "\t\t</rich:column>\t\t\t" + NL + "\t\t<rich:column  colspan=\"";
  protected final String TEXT_27 = "\" breakBefore=\"true\" >" + NL + "\t\t\t<h:outputText value=\"\" />" + NL + "\t\t</rich:column>";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = NL + "\t\t<rich:column  colspan=\"";
  protected final String TEXT_31 = "\" >" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_32 = "Bundle.";
  protected final String TEXT_33 = "}\" />" + NL + "\t\t</rich:column>\t\t\t" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\t<rich:column >" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_35 = "Bundle.";
  protected final String TEXT_36 = "}\" />" + NL + "\t\t</rich:column>\t\t" + NL + "\t";
  protected final String TEXT_37 = NL + "\t\t<rich:column  >" + NL + "\t\t\t<h:outputText value=\"\" />" + NL + "\t\t</rich:column>" + NL + "\t\t</rich:columnGroup>" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t</f:facet>" + NL + "\t\t";
  protected final String TEXT_39 = NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_49 = "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t<f:facet name=\"header\">Type</f:facet>" + NL + "\t\t\t<h:outputText value=\"#{reg.class.name}\" >" + NL + "\t\t\t</h:outputText>" + NL + "\t\t</rich:column>\t";
  protected final String TEXT_51 = NL + "\t";
  protected final String TEXT_52 = "\t" + NL + "\t";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_60 = NL + "\t\t\t<rich:column>" + NL + "\t\t\t<f:facet name=\"header\">Instance</f:facet>" + NL + "\t\t\t<h:outputText value=\"N/A\" rendered=\"#{reg.";
  protected final String TEXT_61 = "==null}\"></h:outputText>" + NL + "\t\t\t<h:graphicImage value=\"/images/icons/checkmark.gif\" style=\"border:0\" rendered=\"#{reg.";
  protected final String TEXT_62 = "!=null}\"  />" + NL + "\t\t\t</rich:column>\t" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_63 = "\t\t";
  protected final String TEXT_64 = NL + "\t\t" + NL + "\t\t<rich:column>" + NL + "\t\t\t<a4j:commandLink value=\"\" " + NL + "\t\t\t\taction=\"#{";
  protected final String TEXT_65 = "Bean.bind}\"" + NL + "\t\t\t\treRender=\"";
  protected final String TEXT_66 = "SelectionPanel#{uniqueId}\">" + NL + "\t\t\t\t<h:outputText value=\"Select\" />" + NL + "\t\t\t\t<f:setPropertyActionListener value=\"#{reg}\"" + NL + "\t\t\t\t\ttarget=\"#{";
  protected final String TEXT_67 = "Bean.selected";
  protected final String TEXT_68 = "}\" />" + NL + "\t\t\t</a4j:commandLink>\t\t\t" + NL + "\t\t</rich:column>" + NL + "\t\t\t\t\t" + NL + "\t\t<f:facet name=\"footer\">" + NL + "\t\t\t<rich:datascroller renderIfSinglePage=\"false\" />" + NL + "" + NL + "\t\t</f:facet>" + NL + "\t</rich:dataTable>" + NL + "</h:form>" + NL + "</html>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    String voName= bckObject.getClassName()+"VO";
    String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);
    String completeClassName=(bckObject.getPackageName()!=null?(bckObject.getPackageName()+"."):"") + bckObject.getClassName();
    List<AssociationVariable> assocList= new ArrayList<AssociationVariable>();
	assocList.addAll( bckObject.getConstructorOneAsociations());
	assocList.addAll(bckObject.getZeroOrOneAsociations());
	assocList.addAll(bckObject.getMandatoryToSingletonAssociations());
	assocList.addAll(bckObject.getOptionalToSingletonAssociations());

    stringBuffer.append(TEXT_1);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(voName);
    stringBuffer.append(TEXT_4);
     for (Attribute attVar: bckObject.getKeysAttributes()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(bckObject.getFragmentProvider().getGUIGridFragment(attVar, "a"+bckObject.getClassName()+"Bean.selected"+ voName, "a"+bckObject.getClassName()) );
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(voName);
    stringBuffer.append(TEXT_13);
    
	String collectionU=  bckObject.getClassName()+"s";
	String collection =collectionU.substring(0,1).toLowerCase() + collectionU.substring(1);
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    if (assocList.size()==0) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_22);
    } else{
		int span= bckObject.getKeysAttributes().size()+1;
		for (Attribute attVar: bckObject.getAttVariables()) { 
		String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg", "a"+bckObject.getClassName() );
			 if (gridFmt.trim().length()>0){
			span++;
		}
		}
		int totalSpan= span+1;
		for (AssociationVariable assocVar: assocList) {
		BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType());	
			if(!assBck.getUClazz().getIsSingleton()){
				totalSpan+= assBck.getKeysAttributes().size();
			}else{
		 		totalSpan++;
			}
		}
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(totalSpan);
    stringBuffer.append(TEXT_24);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(span);
    stringBuffer.append(TEXT_27);
     for (AssociationVariable assocVar: assocList) { 
    stringBuffer.append(TEXT_28);
     BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()); 
    stringBuffer.append(TEXT_29);
     if(assBck.getKeysAttributes().size()>0 && !assBck.getUClazz().getIsSingleton() ) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(assBck.getKeysAttributes().size());
    stringBuffer.append(TEXT_31);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_33);
    } else if (assBck.getUClazz().getIsSingleton()){
    stringBuffer.append(TEXT_34);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_36);
    } }
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
     for (Attribute attVar: bckObject.getKeysAttributes()) { 
    stringBuffer.append(TEXT_39);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg", "a"+bckObject.getClassName() ); 
    stringBuffer.append(TEXT_40);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_42);
     } 
    stringBuffer.append(TEXT_43);
     } 
    stringBuffer.append(TEXT_44);
     for (Attribute attVar: bckObject.getAttVariables()) { 
    stringBuffer.append(TEXT_45);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg", "a"+bckObject.getClassName() ); 
    stringBuffer.append(TEXT_46);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_48);
     } 
    stringBuffer.append(TEXT_49);
     } 
    stringBuffer.append(TEXT_50);
     for (AssociationVariable assocVar: assocList) { 
    stringBuffer.append(TEXT_51);
     BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()); 
    stringBuffer.append(TEXT_52);
    if (!assBck.getUClazz().getIsSingleton()){ 
    stringBuffer.append(TEXT_53);
     for (Attribute attVar: assBck.getKeysAttributes()) { 
    stringBuffer.append(TEXT_54);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg."+ assocVar.getName(), "a"+assBck.getClassName() ); 
    stringBuffer.append(TEXT_55);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_57);
     } 
    stringBuffer.append(TEXT_58);
     } 
    stringBuffer.append(TEXT_59);
     }else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_62);
     } 
    stringBuffer.append(TEXT_63);
     } 
    stringBuffer.append(TEXT_64);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(voName);
    stringBuffer.append(TEXT_68);
    return stringBuffer.toString();
  }
}