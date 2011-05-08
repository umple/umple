package cruise.ui.jsf.templates.impl.GUI;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;
import cruise.model.abstractObjects.BackingObject;

public class Grid implements IGenerator {

  protected static String nl;
  public static synchronized Grid create(String lineSeparator)
  {
    nl = lineSeparator;
    Grid result = new Grid();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<html xmlns=\"http://www.w3.org/1999/xhtml\"" + NL + "\txmlns:ui=\"http://java.sun.com/jsf/facelets\"" + NL + "\txmlns:h=\"http://java.sun.com/jsf/html\"" + NL + "\txmlns:f=\"http://java.sun.com/jsf/core\"" + NL + "\txmlns:rich=\"http://richfaces.org/rich\"" + NL + "\txmlns:a4j=\"http://richfaces.org/a4j\">" + NL + "<h:form>" + NL + "\t" + NL + "\t<rich:spacer height=\"3\" />" + NL + "\t";
  protected final String TEXT_2 = NL + "\t<rich:dataTable value=\"#{";
  protected final String TEXT_3 = "Bean.";
  protected final String TEXT_4 = "}\" var=\"reg\"" + NL + "\t\tonRowMouseOver=\"this.style.backgroundColor='#F1F1F1'\"" + NL + "\t\tonRowMouseOut=\"this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'\"" + NL + "\t\trows=\"10\" rowKeyVar=\"row\" id=\"";
  protected final String TEXT_5 = "Grid#{uniqueId}\"" + NL + "\t\tstyle=\"align:center; width:400px;\">";
  protected final String TEXT_6 = NL + " ";
  protected final String TEXT_7 = "\t\t<f:facet name=\"header\">" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_9 = "Bundle.";
  protected final String TEXT_10 = "ClassName}\" />" + NL + "\t\t";
  protected final String TEXT_11 = NL + "  \t\t<rich:columnGroup>" + NL + "\t\t <rich:column  colspan=\"";
  protected final String TEXT_12 = "\" >" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_13 = "Bundle.";
  protected final String TEXT_14 = "ClassName}\" />" + NL + "\t\t</rich:column>\t\t\t" + NL + "\t\t<rich:column  colspan=\"";
  protected final String TEXT_15 = "\" breakBefore=\"true\" >" + NL + "\t\t\t<h:outputText value=\"\" />" + NL + "\t\t</rich:column>";
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = NL + "\t";
  protected final String TEXT_18 = NL + "\t\t<rich:column  colspan=\"";
  protected final String TEXT_19 = "\" >" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_20 = "Bundle.";
  protected final String TEXT_21 = "}\" />" + NL + "\t\t</rich:column>\t\t\t" + NL + "\t";
  protected final String TEXT_22 = NL + "\t\t<rich:column >" + NL + "\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_23 = "Bundle.";
  protected final String TEXT_24 = "}\" />" + NL + "\t\t</rich:column>\t\t" + NL + "\t";
  protected final String TEXT_25 = NL + "\t\t<rich:column  >" + NL + "\t\t\t<h:outputText value=\"\" />" + NL + "\t\t</rich:column>" + NL + "\t\t</rich:columnGroup>" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t</f:facet>" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_37 = "\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t<rich:column>\t" + NL + "\t\t\t<f:facet name=\"header\">Type</f:facet>" + NL + "\t\t\t<h:outputText value=\"#{reg.class.name}\" >" + NL + "\t\t\t</h:outputText>" + NL + "\t\t</rich:column>\t";
  protected final String TEXT_39 = NL + "\t";
  protected final String TEXT_40 = "\t" + NL + "\t";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t<rich:column>\t" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t</rich:column>\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\t\t<rich:column>" + NL + "\t\t\t<f:facet name=\"header\">Instance</f:facet>" + NL + "\t\t\t<h:outputText value=\"N/A\" rendered=\"#{reg.";
  protected final String TEXT_49 = "==null}\"></h:outputText>" + NL + "\t\t\t<h:graphicImage value=\"/images/icons/checkmark.gif\" style=\"border:0\" rendered=\"#{reg.";
  protected final String TEXT_50 = "!=null}\"  />" + NL + "\t\t\t</rich:column>\t" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_51 = "\t\t";
  protected final String TEXT_52 = NL + "\t\t" + NL + "\t\t<rich:column>" + NL + "\t\t\t<a4j:commandLink rendered=\"#{reg.class.name=='";
  protected final String TEXT_53 = "'}\"" + NL + "\t\t\t\taction=\"#{";
  protected final String TEXT_54 = "Bean.delete}\"" + NL + "\t\t\t\treRender=\"";
  protected final String TEXT_55 = "Grid#{uniqueId}\"  >" + NL + "\t\t\t\t<h:graphicImage value=\"/images/icons/delete.gif\" style=\"border:0\" />" + NL + "\t\t\t\t<f:setPropertyActionListener value=\"#{reg}\"" + NL + "\t\t\t\t\ttarget=\"#{";
  protected final String TEXT_56 = "Bean.edited";
  protected final String TEXT_57 = "}\" />" + NL + "\t\t\t</a4j:commandLink>" + NL + "\t\t\t<a4j:commandLink " + NL + "\t\t\t\taction=\"#{";
  protected final String TEXT_58 = "Bean.prepareForEdit}\"" + NL + "\t\t\t\treRender=\"#{mainPanel}\">" + NL + "\t\t\t\t<h:graphicImage value=\"/images/icons/edit.gif\" style=\"border:0\" />" + NL + "\t\t\t\t<f:setPropertyActionListener value=\"#{reg}\"" + NL + "\t\t\t\t\ttarget=\"#{";
  protected final String TEXT_59 = "Bean.edited";
  protected final String TEXT_60 = "}\"/>" + NL + "\t\t\t</a4j:commandLink>" + NL + "\t\t</rich:column>" + NL + "\t\t\t\t\t" + NL + "\t\t<f:facet name=\"footer\">" + NL + "\t\t\t<rich:datascroller renderIfSinglePage=\"false\" />" + NL + "" + NL + "\t\t</f:facet>" + NL + "\t</rich:dataTable>" + NL + "</h:form>" + NL + "</html>";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    if(bckObject.getUClazz().getIsSingleton())
    	return "";
    String voName= bckObject.getClassName()+"VO";
    String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);
    String completeClassName=(bckObject.getPackageName()!=null?(bckObject.getPackageName()+"."):"") + bckObject.getClassName();
    List<AssociationVariable> assocList= new ArrayList<AssociationVariable>();
	assocList.addAll( bckObject.getConstructorOneAsociations());
	assocList.addAll(bckObject.getZeroOrOneAsociations());
	assocList.addAll(bckObject.getMandatoryToSingletonAssociations());
	assocList.addAll(bckObject.getOptionalToSingletonAssociations());

    stringBuffer.append(TEXT_1);
    
	String collectionU=  bckObject.getClassName()+"s";
	String collection =collectionU.substring(0,1).toLowerCase() + collectionU.substring(1);
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    if (assocList.size()==0) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_10);
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
		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(totalSpan);
    stringBuffer.append(TEXT_12);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(span);
    stringBuffer.append(TEXT_15);
     for (AssociationVariable assocVar: assocList) { 
    stringBuffer.append(TEXT_16);
     BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()); 
    stringBuffer.append(TEXT_17);
     if(assBck.getKeysAttributes().size()>0 && !assBck.getUClazz().getIsSingleton() ) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(assBck.getKeysAttributes().size());
    stringBuffer.append(TEXT_19);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_21);
    } else if (assBck.getUClazz().getIsSingleton()){
    stringBuffer.append(TEXT_22);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_24);
    } }
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
     for (Attribute attVar: bckObject.getKeysAttributes()) { 
    stringBuffer.append(TEXT_27);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg", "a"+bckObject.getClassName() ); 
    stringBuffer.append(TEXT_28);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_30);
     } 
    stringBuffer.append(TEXT_31);
     } 
    stringBuffer.append(TEXT_32);
     for (Attribute attVar: bckObject.getAttVariables()) { 
    stringBuffer.append(TEXT_33);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg", "a"+bckObject.getClassName() ); 
    stringBuffer.append(TEXT_34);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_36);
     } 
    stringBuffer.append(TEXT_37);
     } 
    stringBuffer.append(TEXT_38);
     for (AssociationVariable assocVar: assocList) { 
    stringBuffer.append(TEXT_39);
     BackingObject assBck=bckObject.getFragmentProvider().getClassMap().get(assocVar.getType()); 
    stringBuffer.append(TEXT_40);
    if (!assBck.getUClazz().getIsSingleton()){ 
    stringBuffer.append(TEXT_41);
     for (Attribute attVar: assBck.getKeysAttributes()) { 
    stringBuffer.append(TEXT_42);
     String gridFmt=bckObject.getFragmentProvider().getGUIGridFragment(attVar, "reg."+ assocVar.getName(), "a"+assBck.getClassName() ); 
    stringBuffer.append(TEXT_43);
     if (gridFmt.trim().length()>0){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gridFmt );
    stringBuffer.append(TEXT_45);
     } 
    stringBuffer.append(TEXT_46);
     } 
    stringBuffer.append(TEXT_47);
     }else {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_50);
     } 
    stringBuffer.append(TEXT_51);
     } 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(completeClassName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(bckObject.getClassName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(voName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(voName);
    stringBuffer.append(TEXT_60);
    return stringBuffer.toString();
  }
}