/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A block of code in an arbitrary language to be injected into generated code
 * 
 * @umplesource Umple.ump 280
 * @umplesource Umple_Code.ump 485
 */
// line 280 "../../../../src/Umple.ump"
// line 485 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={489},file={"Umple_Code.ump"},javaline={44},length={4})
   public  CodeBlock(String add){
    this();
    codes.put("",add);
  }

  @umplesourcefile(line={494},file={"Umple_Code.ump"},javaline={50},length={4})
   public  CodeBlock(String lang, String add){
    this();
    codes.put(lang,add);
  }

  @umplesourcefile(line={499},file={"Umple_Code.ump"},javaline={56},length={6})
   public void setCode(String add){
    if(add!=null)
      codes.put("",add);
    else
      codes.put("","");
  }

  @umplesourcefile(line={506},file={"Umple_Code.ump"},javaline={64},length={6})
   public void setCode(String lang, String add){
    if(add!=null)
      codes.put(lang,add);
    else
      codes.put(lang,"");
  }

  @umplesourcefile(line={513},file={"Umple_Code.ump"},javaline={72},length={3})
   public String getCode(){
    return !codes.containsKey(languageUsed) ? "".equals(languageUsed) ? null : codes.get("") : codes.get(languageUsed);
  }

  @umplesourcefile(line={517},file={"Umple_Code.ump"},javaline={77},length={3})
   public String getCode(String lang){
    return codes.containsKey(lang)? codes.get(lang) : codes.get("");
  }

  @umplesourcefile(line={521},file={"Umple_Code.ump"},javaline={82},length={8})
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
  //  @umplesourcefile(line={285},file={"Umple.ump"},javaline={95},length={2})
  public static String languageUsed = "" ;

  
}