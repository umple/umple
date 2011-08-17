/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.util;

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
    for (char c : input.toCharArray())
    {
      String asIs = c + "";
      String upperCase = asIs.toUpperCase();
      String lowerCase = asIs.toLowerCase();
      
      if (asIs.equals(upperCase) && !"_".equals(asIs))
      {
        if (answer.length() > 0)
        {
          answer += "_";
        }
        answer += lowerCase;
      }
      else
      {
        answer += asIs;  
      }
    }
    return answer; 
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
  
  private static String clean(Object input)
  {
    return input == null ? "" : input.toString();
  }
}