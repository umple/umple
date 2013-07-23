/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A block of code in an arbitrary language to be injected into generated code
 * @umplesource Umple.ump 273
 * @umplesource Umple_Code.ump 494
 */
// line 273 "../../../../src/Umple.ump"
// line 494 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={496},file={"Umple_Code.ump"},javaline={31},length={1})
  public CodeBlock()
  {
    // line 496 "../../../../src/Umple_Code.ump"
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
  @umplesourcefile(line={279},file={"Umple.ump"},javaline={48},length={4})
 public CodeBlock(String add)  {
this();
    code.put("",add);
  }
  @umplesourcefile(line={283},file={"Umple.ump"},javaline={53},length={4})
 public CodeBlock(String lang,String add)  {
this();
    code.put(lang,add);
  }
//  @umplesourcefile(line={507},file={"Umple_Code.ump"},javaline={58},length={33})
  @umplesourcefile(line={508},file={"Umple_Code.ump"},javaline={59},length={7})
  public void setCode(String add)
  {
    if(add!=null)
      code.put("",add);
    else
      code.put("","");
  }
  @umplesourcefile(line={515},file={"Umple_Code.ump"},javaline={67},length={7})
  public void setCode(String lang, String add)
  {
    if(add!=null)
      code.put(lang,add);
    else
      code.put(lang,"");
  }
  @umplesourcefile(line={522},file={"Umple_Code.ump"},javaline={75},length={4})
  public String getCode()
  {
    return !code.containsKey(languageUsed) ? "".equals(languageUsed) ? null : code.get("") : code.get(languageUsed);
  }
  @umplesourcefile(line={526},file={"Umple_Code.ump"},javaline={80},length={4})
  public String getCode(String lang)
  {
    return code.containsKey(lang)? code.get(lang) : code.get("");
  }
  @umplesourcefile(line={530},file={"Umple_Code.ump"},javaline={85},length={10})
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