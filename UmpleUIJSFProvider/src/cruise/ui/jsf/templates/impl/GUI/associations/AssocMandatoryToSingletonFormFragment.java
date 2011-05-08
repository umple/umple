package cruise.ui.jsf.templates.impl.GUI.associations;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.jsf.*;

public class AssocMandatoryToSingletonFormFragment
{
  protected static String nl;
  public static synchronized AssocMandatoryToSingletonFormFragment create(String lineSeparator)
  {
    nl = lineSeparator;
    AssocMandatoryToSingletonFormFragment result = new AssocMandatoryToSingletonFormFragment();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\t\t\t<h:outputText value=\"#{";
  protected final String TEXT_2 = "Bundle.";
  protected final String TEXT_3 = "}\"  />" + NL + "\t\t\t\t<h:graphicImage value=\"/images/icons/checkmark.gif\" style=\"border:0\"  />";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
      BackingObject bckObject = (BackingObject) argument; 
    List<AssociationVariable> mandatoryToSingletonAssociations= bckObject.getMandatoryToSingletonAssociations();

     for (AssociationVariable assocVar: mandatoryToSingletonAssociations) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append("a"+bckObject.getClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
     } 
    return stringBuffer.toString();
  }
}
