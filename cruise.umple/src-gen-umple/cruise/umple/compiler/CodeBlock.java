/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A block of code in an arbitrary language to be injected into generated code
 * @umplesource Umple.ump 270
 * @umplesource Umple_Code.ump 483
 */
// line 270 "../../../../src/Umple.ump"
// line 483 "../../../../src/Umple_Code.ump"
public class CodeBlock
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  // line 274 ../../../../src/Umple.ump
  public static String languageUsed = "";
  Hashtable<String,String> code;
 public CodeBlock(String add)  {
this();
    code.put("",add);
  }
 public CodeBlock(String lang,String add)  {
this();
    code.put(lang,add);
  }
// line 497 ../../../../src/Umple_Code.ump
  @umplesourcefile(line={497},file={"Umple_Code.ump"},javaline={56},length={7})
  public void setCode(String add)
  {
    if(add!=null)
      code.put("",add);
    else
      code.put("","");
  }
  @umplesourcefile(line={504},file={"Umple_Code.ump"},javaline={64},length={7})
  public void setCode(String lang, String add)
  {
    if(add!=null)
      code.put(lang,add);
    else
      code.put(lang,"");
  }
  @umplesourcefile(line={511},file={"Umple_Code.ump"},javaline={72},length={4})
  public String getCode()
  {
    return !code.containsKey(languageUsed) ? "".equals(languageUsed) ? null : code.get("") : code.get(languageUsed);
  }
  @umplesourcefile(line={515},file={"Umple_Code.ump"},javaline={77},length={4})
  public String getCode(String lang)
  {
    return code.containsKey(lang)? code.get(lang) : code.get("");
  }
  @umplesourcefile(line={519},file={"Umple_Code.ump"},javaline={82},length={10})
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