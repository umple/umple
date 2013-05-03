package cruise.umple.compiler.cpp;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class CppInterfaceGenerator implements ILang 
{

  protected static String nl;
  public static synchronized CppInterfaceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CppInterfaceGenerator result = new CppInterfaceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */" + NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "class ";
  protected final String TEXT_4 = NL + "{";
  protected final String TEXT_5 = NL + "  ";
  protected final String TEXT_6 = NL + "};";

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
  //GeneratedInterface gInterface = uInterface.getGeneratedInterface();
  CppGenerator gen = new CppGenerator();
  gen.setModel(model);

  String extraCode = "";
  if (uInterface.getExtraCode() != null)
  {
    extraCode = uInterface.getExtraCode();
  }


    stringBuffer.append(TEXT_2);
    stringBuffer.append(gen.translate("packageDefinition",uInterface));
    
  for (Depend depend : uInterface.getDepends())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "#include <{0}>;",depend.getName());
  }
  
  // TODO: No test failed from removing this
  // for (String anImport : gInterface.getMultiLookup("import"))
  // {
  //  appendln(stringBuffer, "");
  //  append(stringBuffer, "import {0};",anImport);
  // }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(uInterface.getName());
    stringBuffer.append( gen.translate("isA",uInterface) );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(extraCode);
     if (uInterface.hasConstants()) { 
    
appendln(stringBuffer, "");
appendln(stringBuffer,"  // CONSTANT MEMBERS  ");
 for (Constant aConstant : uInterface.getConstants()) 
 {
 	String constantName = aConstant.getName();
 	String constantModifier = "static const";
 	String constantType =  aConstant.getType();
 	String constantValue =  aConstant.getValue();
 
 if (!(constantValue.equals(""))){
 	appendln(stringBuffer, "");
 	append(stringBuffer, " {0} {1} {2} = {3};", constantModifier, constantType, constantName, constantValue);
 }
 else{
 	appendln(stringBuffer, "");
 	append(stringBuffer, " {0} {1} {2};", constantModifier, constantType, constantName);
 }
 }

     } 
     if (uInterface.hasMethods()) { 
    
	 appendln(stringBuffer, "");
     appendln(stringBuffer,"  // ABSTRACT METHODS ");
     appendln(stringBuffer,"  public: ");
     appendln(stringBuffer, "");
    	for (Method aMethod : uInterface.getMethods()) 
    	{
    		String methodModifier = aMethod.getModifier().equals("") ? "" : aMethod.getModifier();
    		String methodName = aMethod.getName();
    		String methodType = aMethod.getType();
    		String paramName="";
    		String paramType="";
    		String aSingleParameter="";
    		String isList="";
    	    String parameters = "";
    		if (aMethod.hasMethodParameters())
    		{
    			for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
    			{
    				paramName = aMethodParam.getName();
    				paramType = aMethodParam.getType();
        			isList = aMethodParam.getIsList() ? " [] " : " ";
    				aSingleParameter = paramType + isList + paramName;
        			parameters += aSingleParameter + ", ";
    			}
    			String finalParams = parameters.substring(0, parameters.length()-2);
    			appendln(stringBuffer, "");
    			append(stringBuffer, " virtual {0} {1} {2}({3}) = 0;", methodModifier, methodType, methodName, finalParams);	
    		}
    		else{
    			appendln(stringBuffer, "");
    			append(stringBuffer, " virtual {0} {1} {2}() = 0;", methodModifier, methodType, methodName);
    		}
    	}

    appendln(stringBuffer, "");
 append(stringBuffer," virtual ~{0}(){}",new Object[] {uInterface.getName()});

     } 
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}