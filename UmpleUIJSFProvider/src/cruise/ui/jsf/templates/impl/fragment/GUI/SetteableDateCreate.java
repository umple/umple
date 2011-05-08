package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class SetteableDateCreate implements IGenerator {

  protected static String nl;
  public static synchronized SetteableDateCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableDateCreate result = new SetteableDateCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />";
  protected final String TEXT_3 = NL + "\t<rich:calendar value=\"#{#1#Bean.";
  protected final String TEXT_4 = "}\" popup=\"true\"" + NL + "\t\t\t\t\t\tdatePattern=\"yyyy-MM-dd\" showApplyButton=\"false\" cellWidth=\"24px\"" + NL + "\t\t\t\t\t\tcellHeight=\"22px\" style=\"width:200px\" />";
  protected final String TEXT_5 = NL + "\t<h:outputText value=\"#{#1#Bean.initial";
  protected final String TEXT_6 = "}\"  style=\"text-align:right;\" >" + NL + "\t\t<f:convertDateTime type=\"date\" pattern=\"yyyy-MM-dd\"/>" + NL + "\t</h:outputText>";

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