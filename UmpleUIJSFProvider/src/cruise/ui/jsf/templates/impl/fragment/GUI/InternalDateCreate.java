package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class InternalDateCreate implements IGenerator {

  protected static String nl;
  public static synchronized InternalDateCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    InternalDateCreate result = new InternalDateCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />" + NL + "<rich:calendar value=\"#{#1#Bean.";
  protected final String TEXT_3 = "}\" popup=\"true\"" + NL + "\t\t\t\t\t\tdatePattern=\"yyyy-MM-dd\" showApplyButton=\"false\" cellWidth=\"24px\"" + NL + "\t\t\t\t\t\tcellHeight=\"22px\" style=\"width:200px\" />";
  protected final String TEXT_4 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
     if (attVar.getValue()==null){ 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attVar.getName());
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}