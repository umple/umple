package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class SetteableBooleanCreate implements IGenerator {

  protected static String nl;
  public static synchronized SetteableBooleanCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableBooleanCreate result = new SetteableBooleanCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />";
  protected final String TEXT_3 = NL + "\t<h:selectBooleanCheckbox  value=\"#{#1#Bean.";
  protected final String TEXT_4 = "}\" />";
  protected final String TEXT_5 = NL + "\t<h:selectBooleanCheckbox  value=\"#{#1#Bean.initial";
  protected final String TEXT_6 = "}\" disabled=\"true\" />";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
     if (attVar.getValue()==null){ 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(attVar.getName());
    stringBuffer.append(TEXT_4);
     } else {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_6);
    }
    return stringBuffer.toString();
  }
}