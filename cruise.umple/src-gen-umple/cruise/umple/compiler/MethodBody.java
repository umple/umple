/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * The contents of a method, such as the code within it.
 * @umplesource Umple.ump 150
 * @umplesource Umple_Code.ump 471
 */
// line 150 "../../../../src/Umple.ump"
// line 471 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={153},file={"Umple.ump"},javaline={50},length={2})
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

  @umplesourcefile(line={473},file={"Umple_Code.ump"},javaline={61},length={3})
   public  MethodBody(String aValue){
    this(new CodeBlock(aValue!=null ? aValue : ""));
  }

  @umplesourcefile(line={477},file={"Umple_Code.ump"},javaline={66},length={3})
   public String getExtraCode(String lang){
    return codeblock.getCode(lang);
  }

  @umplesourcefile(line={481},file={"Umple_Code.ump"},javaline={71},length={3})
   public void setExtraCode(String code){
    codeblock.setCode(code);
  }

  @umplesourcefile(line={485},file={"Umple_Code.ump"},javaline={76},length={3})
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