/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-3bd2bc7 modeling language!*/

package cruise.umple.compiler.php;
import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;
import java.util.regex.Pattern;

// line 9 "../../../../../UmpleTLTemplates/phpInterfaceGenerator.ump"
public class PhpInterfaceGenerator implements ILang
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String NL = System.getProperty("line.separator");
  public static final String TEXT_0 = "<?php";
  public static final String TEXT_1 = NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  public static final String TEXT_2 = NL + NL + "interface ";
  public static final String TEXT_3 = NL + "{";
  public static final String TEXT_4 = "";
  public static final String TEXT_5 = "";
  public static final String TEXT_6 = "";
  public static final String TEXT_7 = NL + "  ";
  public static final String TEXT_8 = NL + "}" + NL + "?>";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhpInterfaceGenerator()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  /**
   * Add a newline to the end of the input
   */
  // line 19 "../../../../../UmpleTLTemplates/phpInterfaceGenerator.ump"
   private void appendln(StringBuilder buffer, String input, Object... variables){
    append(buffer, input + "\n", variables);
  }


  /**
   * This method will be used to append formatted strings
   * i.e. format("Hello {0} {1}", "andrew","forward");
   */
  // line 26 "../../../../../UmpleTLTemplates/phpInterfaceGenerator.ump"
   private void append(StringBuilder buffer, String input, Object... variables){
    buffer.append(StringFormatter.format(input,variables));
  }

  private String _createSpacesString(int numSpaces){
    
  StringBuilder spaces =  new StringBuilder();
      for(int i=0; i <numSpaces; i++) {
          spaces.append(" ");
      }
      return spaces.toString();
  }

  public StringBuilder _getCode(Integer numSpaces, StringBuilder sb, UmpleModel model, UmpleElement uElement){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    /*phpInterfaceGenerator*/
    
  UmpleInterface uInterface = (UmpleInterface) uElement;
  // GeneratedInterface gInterface = uInterface.getGeneratedInterface();
  PhpGenerator gen = new PhpGenerator();
  gen.setModel(model);
  
  String extraCode = "";
  if (uInterface.getExtraCode() != null)
  {
    extraCode = uInterface.getExtraCode();
  }  

    realSb.append(TEXT_0);
    /*UmpleNotice*/
    realSb.append(TEXT_1);
    realSb.append(TEXT_2);
    realSb.append(uInterface.getName());
    realSb.append(TEXT_3);
     if (uInterface.hasConstants()) { 
    /*interface_constantDeclaration*/
    
appendln(realSb, "");
appendln(realSb,"  // CONSTANT MEMBERS  ");
appendln(realSb, "");
 for (Constant aConstant : uInterface.getConstants()) 
 {
 	String constantName = aConstant.getName();
 	String constantValue =  aConstant.getValue();

 	append(realSb, " const {0} = {1};", constantName, constantValue);
  	appendln(realSb, "");
 }

    realSb.append(TEXT_4);
     } 
    realSb.append(TEXT_5);
     if (uInterface.hasMethods()) { 
    /*interface_AbstractMethodDeclaration*/
    
	 appendln(realSb, "");	
     appendln(realSb,"  // ABSTRACT METHODS ");
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
    			appendln(realSb, "");
    			append(realSb, " public function {0} ({1});", methodName, finalParams);	
    		}
    		else{
    			appendln(realSb, "");
    			append(realSb, " public function {0} ();", methodName);
    		}
    	}

    realSb.append(TEXT_6);
     } 
    realSb.append(TEXT_7);
    realSb.append(extraCode);
    realSb.append(TEXT_8);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String getCode(UmpleModel model, UmpleElement uElement){
        StringBuilder sb = new StringBuilder();
    return this._getCode(0,sb,model,uElement).toString(); 
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}