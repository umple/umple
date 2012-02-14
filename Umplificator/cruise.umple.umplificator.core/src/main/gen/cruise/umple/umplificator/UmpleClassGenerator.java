package cruise.umple.umplificator;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class UmpleClassGenerator
{

  protected static String nl;
  public static synchronized UmpleClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    UmpleClassGenerator result = new UmpleClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the Java Umplificator!*/" + NL + "" + NL + "namespace ";
  protected final String TEXT_2 = " ;" + NL + "" + NL + "class ";
  protected final String TEXT_3 = " " + NL + "{";
  protected final String TEXT_4 = NL + "  isA ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "  ";
  protected final String TEXT_8 = NL + "}";

  // Add a newline to the end of the input
  private void appendln(StringBuffer buffer, String input, Object... variables)
  {
    append(buffer, input + "\n", variables);
  }  

  // This method will be used to append formatted strings
  // i.e. format("Hello {0} {1}", "andrew","forward");
  private void append(StringBuffer buffer, String input, Object... variables)
  {
    buffer.append(StringFormatter.format(input,variables));
  }

  /* 
  * This method will return the generated code.
  */
  public String getCode(UmpleModel model, UmpleClass uClass)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(uClass.getNamespace(0) );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_3);
    
  for (Depend depend : uClass.getDepends())
  {
  	if (depend != null) {
   	    appendln(stringBuffer, "");
    	append(stringBuffer, "depend {0};",depend.getName());
    }
  }

    if (uClass.getExtendsClass() != null){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uClass.getExtendsClass().getName() );
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    
  for (Attribute av : uClass.getAttributes()) 
  {
  	if (av != null){
  		String name = av.getName();
		String type = av.getType();
		String value= (av.getValue().length() > 0) ?  "= " + av.getValue() : "" ;
		String attr  = type + " " + name + value + ";";
	    appendln(stringBuffer, "");
	    append(stringBuffer, attr);
	}			
  }

    

    stringBuffer.append(TEXT_7);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}