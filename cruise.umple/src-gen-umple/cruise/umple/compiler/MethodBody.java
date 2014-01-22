/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * The contents of a method, such as the code within it.
 * 
 * @umplesource Umple.ump 155
 * @umplesource Umple_Code.ump 473
 */
// line 155 "../../../../src/Umple.ump"
// line 473 "../../../../src/Umple_Code.ump"
public class MethodBody
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MethodBody Attributes
  private CodeBlock codeblock;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MethodBody(CodeBlock aCodeblock)
  {
    codeblock = aCodeblock;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCodeblock(CodeBlock aCodeblock)
  {
    boolean wasSet = false;
    codeblock = aCodeblock;
    wasSet = true;
    return wasSet;
  }

  /**
   * The code within the method body.
   */

  @umplesourcefile(line={159},file={"Umple.ump"},javaline={55},length={2})
  public String getExtraCode()
  {
    return codeblock.getCode() != null ? codeblock.getCode() : "";
  }

  public CodeBlock getCodeblock()
  {
    return codeblock;
  }

  public void delete()
  {}

  @umplesourcefile(line={478},file={"Umple_Code.ump"},javaline={67},length={3})
   public  MethodBody(String aValue){
    this(new CodeBlock(aValue!=null ? aValue : ""));
  }

  @umplesourcefile(line={482},file={"Umple_Code.ump"},javaline={72},length={3})
   public String getExtraCode(String lang){
    return codeblock.getCode(lang);
  }

  @umplesourcefile(line={486},file={"Umple_Code.ump"},javaline={77},length={3})
   public void setExtraCode(String code){
    codeblock.setCode(code);
  }

  @umplesourcefile(line={490},file={"Umple_Code.ump"},javaline={82},length={3})
   public void setExtraCode(String lang, String code){
    codeblock.setCode(lang,code);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "extraCode" + ":" + getExtraCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + (getCodeblock() != null ? !getCodeblock().equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}