/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.util;
import java.io.File;

/**
 * @umplesource Util_Code.ump 305
 */
// line 305 "../../../../src/Util_Code.ump"
public class StringFormatter
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  //  @umplesourcefile(line={308},file={"Util_Code.ump"},javaline={38},length={257})
  @umplesourcefile(line={309},file={"Util_Code.ump"},javaline={39},length={32})
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

  @umplesourcefile(line={342},file={"Util_Code.ump"},javaline={73},length={56})
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

  @umplesourcefile(line={399},file={"Util_Code.ump"},javaline={131},length={20})
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


  @umplesourcefile(line={421},file={"Util_Code.ump"},javaline={154},length={18})
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
  
  @umplesourcefile(line={440},file={"Util_Code.ump"},javaline={174},length={22})
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
  
  @umplesourcefile(line={463},file={"Util_Code.ump"},javaline={198},length={40})
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
  
  @umplesourcefile(line={504},file={"Util_Code.ump"},javaline={240},length={4})
  public static String format(String input)
  {
    return input;
  }
  
  @umplesourcefile(line={509},file={"Util_Code.ump"},javaline={246},length={11})
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
  
  @umplesourcefile(line={521},file={"Util_Code.ump"},javaline={259},length={7})
  public static String addPathOrAbsolute(String prePath, String path)
  {
  	if(path.startsWith("/") || path.matches("^[a-zA-Z]:.*"))
  		return path + File.separator;
  	
  	return prePath + File.separator + path + File.separator;
  }
  
  @umplesourcefile(line={529},file={"Util_Code.ump"},javaline={268},length={7})
  public static String stripLeadingPath(String filename)
  {  	
	int index = 0;
	while(filename.indexOf(File.separatorChar, index) != -1)
	  index = filename.indexOf(File.separatorChar, index) + 1;
  	return filename.substring(index);
  }
  
  @umplesourcefile(line={537},file={"Util_Code.ump"},javaline={277},length={24})
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
  @umplesourcefile(line={561},file={"Util_Code.ump"},javaline={302},length={4})
  private static String clean(Object input)
  {
    return input == null ? "" : input.toString();
  }

}