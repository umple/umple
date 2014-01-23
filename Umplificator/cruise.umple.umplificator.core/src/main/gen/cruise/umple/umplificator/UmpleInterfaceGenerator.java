package cruise.umple.umplificator;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class UmpleInterfaceGenerator
{

  protected static String nl;
  public static synchronized UmpleInterfaceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    UmpleInterfaceGenerator result = new UmpleInterfaceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the Java Umplificator 1.0.0!*/";
  protected final String TEXT_2 = NL + NL + "interface ";
  protected final String TEXT_3 = " " + NL + "{";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "}";

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
  public String getCode(UmpleModel model, UmpleElement uElement)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	 UmpleInterface uInterface = (UmpleInterface) uElement;	 
	 if (uElement.hasNamespaces()) {
   	    appendln(stringBuffer, "");
    	append(stringBuffer, "namespace {0};",uInterface.getNamespace(0));
  	 }
  	 String extraCode = "";
  	 if (uInterface.getExtraCode() != null)
  	 {
    	extraCode = uInterface.getExtraCode();
  	 }


    stringBuffer.append(TEXT_2);
    stringBuffer.append(uInterface.getName());
    stringBuffer.append(TEXT_3);
    
  for (Depend depend : uInterface.getDepends())
  {
  	if (depend != null) {
   	    appendln(stringBuffer, "");
    	append(stringBuffer, "depend {0};",depend.getName());
    }
  }

    
  String extendedInterfaces="";
  String isAString = "";
  if (uInterface.hasExtendsInterface() == false){
      isAString =  "";
  }
  else{
      for (UmpleInterface anInterface : uInterface.getExtendsInterface())
      {
    	  extendedInterfaces += anInterface.getName() + "," ; 
      }
      extendedInterfaces = extendedInterfaces.substring(0, extendedInterfaces.length()-1); 
      isAString =  " extends " + extendedInterfaces;
  }
  appendln(stringBuffer, "");
  appendln(stringBuffer, isAString);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(extraCode);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}