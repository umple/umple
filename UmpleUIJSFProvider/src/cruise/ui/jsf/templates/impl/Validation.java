package cruise.ui.jsf.templates.impl;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class Validation implements IGenerator {

  protected static String nl;
  public static synchronized Validation create(String lineSeparator)
  {
    nl = lineSeparator;
    Validation result = new Validation();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\tpublic boolean validate(){" + NL + "\t\tboolean success=true;" + NL + "\t   ";
  protected final String TEXT_2 = NL + "\t   if(getSelected";
  protected final String TEXT_3 = "()==null){" + NL + "\t   \t  \tFacesMessage fm = new FacesMessage( resourceBundle.getString(\"";
  protected final String TEXT_4 = "\")+\" cannot be null!\");" + NL + "\t   \t  \tfm.setSeverity(FacesMessage.SEVERITY_ERROR);" + NL + "            FacesContext.getCurrentInstance().addMessage(null, fm);" + NL + "\t   \t\tsuccess=false;" + NL + "\t   \t}" + NL + "\t   ";
  protected final String TEXT_5 = NL + "\t   ";
  protected final String TEXT_6 = NL + "\t   if(getSelected";
  protected final String TEXT_7 = "()==null){" + NL + "\t   \t  \tFacesMessage fm = new FacesMessage( resourceBundle.getString(\"";
  protected final String TEXT_8 = "\")+\" cannot be null!\");" + NL + "\t   \t  \tfm.setSeverity(FacesMessage.SEVERITY_ERROR);" + NL + "            FacesContext.getCurrentInstance().addMessage(null, fm);" + NL + "\t   \t\tsuccess=false;" + NL + "\t   \t}" + NL + "\t   ";
  protected final String TEXT_9 = "\t " + NL + "\t   " + NL + "\t   ";
  protected final String TEXT_10 = NL + NL + "\t   if(";
  protected final String TEXT_11 = " ) {" + NL + "\t   \t  \tFacesMessage fm = new FacesMessage(";
  protected final String TEXT_12 = "\");" + NL + "\t   \t  \tfm.setSeverity(FacesMessage.SEVERITY_ERROR);" + NL + "            FacesContext.getCurrentInstance().addMessage(null, fm);" + NL + "\t   \t\tsuccess=false;" + NL + "\t   \t}" + NL + "\t   ";
  protected final String TEXT_13 = "\t" + NL;
  protected final String TEXT_14 = NL + NL + "\t   if(";
  protected final String TEXT_15 = " ) {" + NL + "\t   \t  \tFacesMessage fm = new FacesMessage(";
  protected final String TEXT_16 = "\");" + NL + "\t   \t  \tfm.setSeverity(FacesMessage.SEVERITY_ERROR);" + NL + "            FacesContext.getCurrentInstance().addMessage(null, fm);" + NL + "\t   \t\tsuccess=false;" + NL + "\t   \t}" + NL + "\t   ";
  protected final String TEXT_17 = "\t" + NL + "" + NL + "\t   " + NL + "\t   \t     " + NL + "\treturn success;" + NL + "\t" + NL + "\t" + NL + "\t" + NL + "\t}" + NL + NL;
  protected final String TEXT_18 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    List<AssociationVariable> constructorOneAsociations= bckObject.getConstructorOneAsociations();
	List<AssociationVariable> multipleZeroManyToOptionalAssociations=bckObject.getZeroManyToOptionalAssociations();
	List<AssociationVariable> multipleNManyToOptionalAssociations=bckObject.getNManyToOptionalAssociations();
	List<AssociationVariable> multipleManyToOneAsociations =bckObject.getManyToOneAssociations();
	List<AssociationVariable> mandatoryToSingletonAssociations=bckObject.getMandatoryToSingletonAssociations();
	List<AssociationVariable> optionalToSingletonAssociations=bckObject.getOptionalToSingletonAssociations();
	

    stringBuffer.append(TEXT_1);
     for (AssociationVariable assocVar: constructorOneAsociations) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
     for (AssociationVariable assocVar: mandatoryToSingletonAssociations) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
     for (AssociationVariable assocVar: multipleNManyToOptionalAssociations) { 
	   
	   	boolean addtoValidation=false;
	    String ifClause="getSelected"+assocVar.getUpperCaseName()+"List()==null ||";
	    String ifMinBound="";
	    String ifMaxBound="";
	   	String msg="resourceBundle.getString(\"" + bckObject.getClassName()+"ClassName\")+\" \" ";

	   	if (assocVar.getMultiplicity().getLowerBound() > 0){
	   		ifMinBound ="getSelected"+assocVar.getUpperCaseName()+"List().size()<"+assocVar.getMultiplicity().getLowerBound();
	   		msg=msg +"+\"should have at least "+assocVar.getMultiplicity().getLowerBound() + " \"+"  +  "resourceBundle.getString(\"" + assocVar.getUpperCaseName()+"\")" + "+\"(s)" ;
	   		addtoValidation=true;
	   	} 
   		
	   	if (assocVar.getMultiplicity().getUpperBound() > 0){
	   		ifMaxBound =((ifMinBound.length()>0)?" || ":"")+ " getSelected"+assocVar.getUpperCaseName()+"List().size()>"+assocVar.getMultiplicity().getUpperBound();
	   		msg=msg+((ifMinBound.length()>0)?" and it ":"+\"")+ "should have up to "+assocVar.getMultiplicity().getUpperBound() + " \"+"  +  "resourceBundle.getString(\"" + assocVar.getUpperCaseName()+"\")" + "+\"(s)" ;
	   		addtoValidation=true;
	   	}
	   	
		if(addtoValidation){
		  ifClause=ifClause+ ifMinBound+ ifMaxBound;   
	   
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ifClause);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(msg);
    stringBuffer.append(TEXT_12);
    }
	    } 
    stringBuffer.append(TEXT_13);
     for (AssociationVariable assocVar: multipleZeroManyToOptionalAssociations) { 
	   
	   	boolean addtoValidation=false;
	    String ifClause="getSelected"+assocVar.getUpperCaseName()+"List()!=null &&";
	    String ifMaxBound="";
	   	String msg="resourceBundle.getString(\"" + bckObject.getClassName()+"ClassName\")+\" \" ";

   		
	   	if (assocVar.getMultiplicity().getUpperBound() > 0){
	   		ifMaxBound =" getSelected"+assocVar.getUpperCaseName()+"List().size()>"+assocVar.getMultiplicity().getUpperBound();
	   		msg=msg+ "+\""+ "should have up to "+assocVar.getMultiplicity().getUpperBound() + " \"+"  +  "resourceBundle.getString(\"" + assocVar.getUpperCaseName()+"\")" + "+\"(s)" ;
	   		addtoValidation=true;
	   	}
	   	
		if(addtoValidation){
		  ifClause=ifClause+  ifMaxBound;   
	   
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ifClause);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(msg);
    stringBuffer.append(TEXT_16);
    }
	    } 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}