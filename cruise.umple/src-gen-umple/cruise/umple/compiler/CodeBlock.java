/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A block of code in an arbitrary language to be injected into generated code
 * 
 * @umplesource Umple.ump 281
 * @umplesource Umple_Code.ump 509
 */
// line 281 "../../../../src/Umple.ump"
// line 509 "../../../../src/Umple_Code.ump"
public class CodeBlock
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeBlock Attributes
  private HashMap<String,String> codes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeBlock()
  {
    codes = new HashMap<String,String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={515},file={"Umple_Code.ump"},javaline={45},length={4})
   public  CodeBlock(String add){
    this();
    codes.put("",add);
  }

  @umplesourcefile(line={520},file={"Umple_Code.ump"},javaline={51},length={4})
   public  CodeBlock(String lang, String add){
    this();
    codes.put(lang,add);
  }

  @umplesourcefile(line={525},file={"Umple_Code.ump"},javaline={57},length={6})
   public void setCode(String add){
    if(add!=null)
      codes.put("",add);
    else
      codes.put("","");
  }

  @umplesourcefile(line={532},file={"Umple_Code.ump"},javaline={65},length={6})
   public void setCode(String lang, String add){
    if(add!=null)
      codes.put(lang,add);
    else
      codes.put(lang,"");
  }

  @umplesourcefile(line={539},file={"Umple_Code.ump"},javaline={73},length={3})
   public String getCode(){
    return !codes.containsKey(languageUsed) ? "".equals(languageUsed) ? null : codes.get("") : codes.get(languageUsed);
  }

  @umplesourcefile(line={543},file={"Umple_Code.ump"},javaline={78},length={3})
   public String getCode(String lang){
    return codes.containsKey(lang)? codes.get(lang) : codes.get("");
  }

  @umplesourcefile(line={546},file={"Umple_Code.ump"},javaline={83},length={8})
   public String toString(){
    String out = "";
    for(String next:codes.values())
    {
      out += next;
    }
    return out;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={286},file={"Umple.ump"},javaline={95},length={2})
  public static String languageUsed = "" ;

  
}