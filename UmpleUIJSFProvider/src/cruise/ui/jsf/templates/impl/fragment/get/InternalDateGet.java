package cruise.ui.jsf.templates.impl.fragment.get;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;;

public class InternalDateGet implements IGenerator {

  protected static String nl;
  public static synchronized InternalDateGet create(String lineSeparator)
  {
    nl = lineSeparator;
    InternalDateGet result = new InternalDateGet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tpublic ";
  protected final String TEXT_2 = " get";
  protected final String TEXT_3 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_4 = ";" + NL + "\t\t}";
  protected final String TEXT_5 = NL + "\t\tpublic ";
  protected final String TEXT_6 = " getInitial";
  protected final String TEXT_7 = "() {" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\ttry{" + NL + "\t\t\t\treturn new Date(format.parse(";
  protected final String TEXT_9 = ").getTime());" + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t    \treturn null;" + NL + "\t\t    ";
  protected final String TEXT_11 = NL + "\t\t}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
     if(attVar.getValue()==null) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("a"+ attVar.getUpperCaseName());
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_6);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_7);
     if (attVar.getValue()!=null){ 
    stringBuffer.append(TEXT_8);
    stringBuffer.append( attVar.getValue() );
    stringBuffer.append(TEXT_9);
     }  else{
    stringBuffer.append(TEXT_10);
     }
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}