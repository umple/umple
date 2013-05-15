/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A block of code in an arbitrary language to be injected into generated code
 * @umplesource Umple.ump 269
 * @umplesource Umple_Code.ump 483
 */
// line 269 "../../../../src/Umple.ump"
// line 483 "../../../../src/Umple_Code.ump"
public class CodeBlock
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeBlock()
  {
    // line 485 "../../../../src/Umple_Code.ump"
    code = new Hashtable<String,String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 273 ../../../../src/Umple.ump
  public static String languageUsed = "";
  Hashtable<String,String> code;
  @umplesourcefile(line=275,file="Umple.ump",javaline=47,length=4)
 public CodeBlock(String add)  {
this();
    code.put("",add);
  }
  @umplesourcefile(line=279,file="Umple.ump",javaline=52,length=4)
 public CodeBlock(String lang,String add)  {
this();
    code.put(lang,add);
  }
// line 497 ../../../../src/Umple_Code.ump
  @umplesourcefile(line=497,file="Umple_Code.ump",javaline=58,length=7)
  public void setCode(String add)
  {
    if(add!=null)
      code.put("",add);
    else
      code.put("","");
  }
  @umplesourcefile(line=504,file="Umple_Code.ump",javaline=66,length=7)
  public void setCode(String lang, String add)
  {
    if(add!=null)
      code.put(lang,add);
    else
      code.put(lang,"");
  }
  @umplesourcefile(line=511,file="Umple_Code.ump",javaline=74,length=4)
  public String getCode()
  {
    return !code.containsKey(languageUsed) ? "".equals(languageUsed) ? null : code.get("") : code.get(languageUsed);
  }
  @umplesourcefile(line=515,file="Umple_Code.ump",javaline=79,length=4)
  public String getCode(String lang)
  {
    return code.containsKey(lang)? code.get(lang) : code.get("");
  }
  @umplesourcefile(line=519,file="Umple_Code.ump",javaline=84,length=10)
  public String toString()
  {
    Enumeration<String> enumer = code.elements();
    String out = "";
    while(enumer.hasMoreElements())
    {
      out += enumer.nextElement();
    }
    return out;
  }

}