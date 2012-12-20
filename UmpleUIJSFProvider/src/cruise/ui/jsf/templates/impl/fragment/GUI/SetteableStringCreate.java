package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

import cruise.umple.compiler.Attribute;;

public class SetteableStringCreate implements IGenerator {

  protected static String nl;
  public static synchronized SetteableStringCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableStringCreate result = new SetteableStringCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<h:outputText value=\"#{#1#Bundle.";
  protected final String TEXT_2 = "}\" />";
  protected final String TEXT_3 = NL + "<h:inputText value=\"#{#1#Bean.";
  protected final String TEXT_4 = "}\" ></h:inputText>";
  protected final String TEXT_5 = NL + "<h:outputText value=";
  protected final String TEXT_6 = "  style=\"text-align:right;\" ></h:outputText>";
  protected final String TEXT_7 = NL;

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
    stringBuffer.append(attVar.getValue());
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}