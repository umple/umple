/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import java.io.File;

/**
 * @umplesource Util_Code.ump 305
 */
// line 305 "../../../../src/Util_Code.ump"
public class StringFormatter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StringFormatter()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 309 ../../../../src/Util_Code.ump
  public static String toCamelCase(String input)
  {
    if (input == null || input.length() == 0)
    {
      return input;
    }
    String answer = "";
    boolean isUpperCase = false;
    for (char c : input.toCharArray())
    {
      String asIs = c + "";

      if (answer.length() == 0)
      {
        answer += asIs.toLowerCase();
      }
      else if (isUpperCase)
      {
        answer += asIs.toUpperCase();
        isUpperCase = false;
      }
      else if ("_".equals(asIs))
      {
        isUpperCase = true;
      }
      else
      {
        answer += asIs;
      }
    }
    return answer; 
  }

  public static String toUnderscore(String input)
  {
    if (input == null || input.length() == 0)
    {
      return input;
    }
    String answer = "";
    String lastToken = "";
    String lastTokenType = "underscore";
    for (char c : input.toCharArray())
    {
      String asIs = c + "";
      String upperCase = asIs.toUpperCase();
      String lowerCase = asIs.toLowerCase();
      
      if ("_".equals(asIs))
      {
        answer += lastToken + asIs;
        lastToken = "";
        lastTokenType = "underscore";
      }
      else if (asIs.equals(upperCase)) //Is upperCase or a number
      {
        if (lastTokenType.equals("lower") || (lastTokenType.equals("upper") && Character.isDigit(c)) || (lastTokenType.equals("number") && !Character.isDigit(c)))
        {
          answer += lastToken + "_";
          lastToken = "";
        }
        lastToken += lowerCase;
        lastTokenType = Character.isDigit(c) ? "number" : "upper";
      }
      else //Must be lowerCase
      {
        if (lastTokenType.equals("upper"))
        {
          if (lastToken.length() > 1)
          {
            answer += lastToken.substring(0,lastToken.length()-1) + "_" + lastToken.charAt(lastToken.length()-1);
          }
          else
          {
            answer += lastToken;
          }
          lastToken = "";
        }
        else if (lastTokenType.equals("number"))
        {
          answer += lastToken + "_";
          lastToken = "";
        }
        lastToken += asIs;
        lastTokenType = "lower";
      }
    }
    return answer + lastToken;
  }

  public static String toPascalCase(String input)
  {
    if (input == null || input.length() == 0)
    {
      return input;
    }
    String answer = "";
    for(String section : input.split("\\."))
    {
      if (section.length() == 1)
      {
        answer += section.toUpperCase();
      }
      else
      {
        answer += section.substring(0,1).toUpperCase() + section.substring(1);
      }
    }
    return answer; 
  }


  public static String joinParameters(String first, String second)
  {
    first = first == null ?  "" : first;
    second = second == null ?  "" : second;
    
    if ("".equals(first))
    {
      return second;
    }
    else if ("".equals(second))
    {
      return first;
    }
    else
    {
      return first + ", " + second;
    }
  }
  
  public static String appendParameter(String input, String endingText)
  {
    if (input == null || "".equals(input))
    {
      return "";
    }

    String[] allParameters = input.split(",");
    StringBuffer answer = new StringBuffer();
    for (int i=0; i<allParameters.length; i++)
    {
      String currentParameter = allParameters[i].trim();
      
      if (answer.length() > 0)
      {
        answer.append(", ");
      }
      answer.append(currentParameter);
      answer.append(endingText);
    }
    return answer.toString();
  }
  
  public static String replaceParameter(String input, String oldParameter, String newParameter)
  {
    if (input == null || "".equals(input))
    {
      return "";
    }
    
    boolean shouldKeep = newParameter != null && !newParameter.equals("");
    
    String[] allParameters = input.split(",");
    StringBuffer answer = new StringBuffer();
    for (int i=0; i<allParameters.length; i++)
    {
      String currentParameter = allParameters[i].trim();
      String nextParameter = null;
      
      if (!oldParameter.equals(currentParameter))
      {
        nextParameter = currentParameter;
      }
      else if (shouldKeep)
      {
        nextParameter = newParameter;
      }
      
      if (nextParameter == null)
      {
        continue;
      }
      
      
      if (answer.length() > 0)
      {
        answer.append(", ");
      }
      answer.append(nextParameter);
      
    }
    return answer.toString();
  }
  
  public static String format(String input)
  {
    return input;
  }
  
  public static String format(String input, Object... variables)
  {
    String answer = input;
    for (int i=0; i<variables.length; i++)
    {
      String toReplace = "{" + i + "}";
      answer = answer.replace(toReplace, clean(variables[i]));
    }
    
    return answer;
  }
  
  public static String addPathOrAbsolute(String prePath, String path)
  {
  	if(path.startsWith("/") || path.matches("^[a-zA-Z]:.*"))
  		return path + File.separator;
  	
  	return prePath + File.separator + path + File.separator;
  }
  
  public static String stripLeadingPath(String filename)
  {  	
	int index = 0;
	while(filename.indexOf(File.separatorChar, index) != -1)
	  index = filename.indexOf(File.separatorChar, index) + 1;
  	return filename.substring(index);
  }
  
  public static String sanitizeForJson(String input){
	 String ret = "";
     for (int i=0; i<input.length(); i++)
	 {
         switch(input.charAt(i))
         {
         	case '\\':         		
         		ret += "\\\\";
     		break;

         	/*case '\'':
         		ret += "\\'";
         		break;*/

         	case  '"':
         		ret += "\\\"";
         		break;
         		default:
         			ret += input.charAt(i);
         			break;
         }
	 }
	 return ret;   
  }
  private static String clean(Object input)
  {
    return input == null ? "" : input.toString();
  }
}