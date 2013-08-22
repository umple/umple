/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A block of code in an arbitrary language to be injected into generated code
 * @umplesource Umple.ump 273
 * @umplesource Umple_Code.ump 493
 */
// line 273 "../../../../src/Umple.ump"
// line 493 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={495},file={"Umple_Code.ump"},javaline={31},length={1})
  public CodeBlock()
  {
    // line 495 "../../../../src/Umple_Code.ump"
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
  //  @umplesourcefile(line={276},file={"Umple.ump"},javaline={45},length={44})
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
//  @umplesourcefile(line={506},file={"Umple_Code.ump"},javaline={56},length={33})
  @umplesourcefile(line={507},file={"Umple_Code.ump"},javaline={57},length={7})
  public void setCode(String add)
  {
    if(add!=null)
      code.put("",add);
    else
      code.put("","");
  }
  @umplesourcefile(line={514},file={"Umple_Code.ump"},javaline={65},length={7})
  public void setCode(String lang, String add)
  {
    if(add!=null)
      code.put(lang,add);
    else
      code.put(lang,"");
  }
  @umplesourcefile(line={521},file={"Umple_Code.ump"},javaline={73},length={4})
  public String getCode()
  {
    return !code.containsKey(languageUsed) ? "".equals(languageUsed) ? null : code.get("") : code.get(languageUsed);
  }
  @umplesourcefile(line={525},file={"Umple_Code.ump"},javaline={78},length={4})
  public String getCode(String lang)
  {
    return code.containsKey(lang)? code.get(lang) : code.get("");
  }
  @umplesourcefile(line={529},file={"Umple_Code.ump"},javaline={83},length={10})
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