package cruise.data.impl.bundles;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.Attribute;
import cruise.model.abstractObjects.BackingObject;

public class ResourceBundle implements IGenerator {

  protected static String nl;
  public static synchronized ResourceBundle create(String lineSeparator)
  {
    nl = lineSeparator;
    ResourceBundle result = new ResourceBundle();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "=";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "= ";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "= ";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "=";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = "=";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = "=";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = "=";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = "=";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = "=";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = "=";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
     	
	BackingObject bckObject =(BackingObject)argument;
	ArrayList<Attribute> keyClasses = bckObject.getKeysAttributes(); 
	List<AssociationVariable> mergeList= new ArrayList<AssociationVariable>();
	mergeList.addAll( bckObject.getConstructorOneAsociations());
	mergeList.addAll(bckObject.getZeroOrOneAsociations());
	List<AssociationVariable> zeroManyToOptionalAssociations=bckObject.getZeroManyToOptionalAssociations();
	List<AssociationVariable> nManyToOptionalAssociations=bckObject.getNManyToOptionalAssociations();
	List<AssociationVariable> manyToOneAssociations=bckObject.getManyToOneAssociations();
	List<AssociationVariable> mandatoryToSingletonAssociations= bckObject.getMandatoryToSingletonAssociations();
    List<AssociationVariable> optionalToSingletonAssociations= bckObject.getOptionalToSingletonAssociations();
	List<AssociationVariable> manyToOneSingletonAssociations=bckObject.getManyToOneSingletonAssociations();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(bckObject.getClassName()+"ClassName");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(bckObject.getClassName().trim());
     for (Attribute attVar: keyClasses) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append( attVar.getUpperCaseName().trim());
     } 
     for (Attribute attVar: bckObject.getAttVariables()) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append( attVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: mergeList) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: zeroManyToOptionalAssociations) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: nManyToOptionalAssociations) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: manyToOneAssociations) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: mandatoryToSingletonAssociations) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: optionalToSingletonAssociations) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
     for (AssociationVariable assocVar: manyToOneSingletonAssociations) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(assocVar.getUpperCaseName().trim());
     } 
    return stringBuffer.toString();
  }
}