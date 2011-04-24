package cruise.umple.compiler.php;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class PhpInterfaceGenerator implements ILang
{

  protected static String nl;
  public static synchronized PhpInterfaceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PhpInterfaceGenerator result = new PhpInterfaceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?php";
  protected final String TEXT_2 = NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/" + NL + "" + NL + "interface ";
  protected final String TEXT_3 = NL + "{";
  protected final String TEXT_4 = NL + "  ";
  protected final String TEXT_5 = NL + "}" + NL + "?>";

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
    
  UmpleInterface uInterface = (UmpleInterface) uElement;
  // GeneratedInterface gInterface = uInterface.getGeneratedInterface();
  PhpGenerator gen = new PhpGenerator();
  gen.setModel(model);
  
  String extraCode = "";
  if (uInterface.getExtraCode() != null)
  {
    extraCode = uInterface.getExtraCode();
  }  

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( uInterface.getName() );
    stringBuffer.append(TEXT_3);
     if (uInterface.hasConstants()) { 
    
appendln(stringBuffer, "");
appendln(stringBuffer,"  // CONSTANT MEMBERS  ");
appendln(stringBuffer, "");
 for (Constant aConstant : uInterface.getConstants()) 
 {
 	String constantName = aConstant.getName();
 	String constantValue =  aConstant.getValue();

 	append(stringBuffer, " const {0} = {1};", constantName, constantValue);
  	appendln(stringBuffer, "");
 }

     } 
     if (uInterface.hasMethods()) { 
    
	 appendln(stringBuffer, "");	
     appendln(stringBuffer,"  // ABSTRACT METHODS ");
    	for (Method aMethod : uInterface.getMethods()) 
    	{
    		String methodName = aMethod.getName();
    		String paramName = "";
    	    String parameters = "";
    		if (aMethod.hasMethodParameters())
    		{
    			for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
    			{
    				paramName = "$" + aMethodParam.getName();
        			parameters += paramName + ",";
    			}
    			String finalParams = parameters.substring(0, parameters.length()-1);
    			appendln(stringBuffer, "");
    			append(stringBuffer, " public function {0} ({1});", methodName, finalParams);	
    		}
    		else{
    			appendln(stringBuffer, "");
    			append(stringBuffer, " public function {0} ();", methodName);
    		}
    	}

     } 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(extraCode);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}