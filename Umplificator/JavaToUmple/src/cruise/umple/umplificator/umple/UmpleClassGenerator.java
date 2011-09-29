package cruise.umple.umplificator.umple;

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
  protected final String TEXT_3 = NL + "{";
  protected final String TEXT_4 = NL + "  isA ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "}";

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
    appendln(stringBuffer, "");
    append(stringBuffer, "depend {0};",depend.getName());
  }

    if (uClass.getExtendsClass() != null){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uClass.getExtendsClass().getName() );
    stringBuffer.append(TEXT_5);
    }
    
  for (Attribute av : uClass.getAttributes()) 
  {
  	String name = av.getName();
	String type = av.getType();
	String value= "= " + av.getValue();
	String attr  = type + " " + name + value + ";" +  "\n";			
  }

    

    


    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}