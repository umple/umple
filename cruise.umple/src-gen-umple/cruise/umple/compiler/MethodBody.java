/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * The contents of a method, such as the code within it.
 * @umplesource Umple.ump 147
 * @umplesource Umple_Code.ump 461
 */
// line 147 "../../../../src/Umple.ump"
// line 461 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={150},file={"Umple.ump"},javaline={50},length={2})
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "extraCode" + ":" + getExtraCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + (getCodeblock() != null ? !getCodeblock().equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
    @umplesourcefile(line={0},file={""},javaline={74},length={3})
 public MethodBody(String aValue)  {
this(new CodeBlock(aValue!=null ? aValue : ""));
  }
//  @umplesourcefile(line={466},file={"Umple_Code.ump"},javaline={78},length={13})
  @umplesourcefile(line={467},file={"Umple_Code.ump"},javaline={79},length={4})
  public String getExtraCode(String lang)
  {
  return codeblock.getCode(lang);
  }
  @umplesourcefile(line={471},file={"Umple_Code.ump"},javaline={84},length={4})
  public void setExtraCode(String code)
  {
    codeblock.setCode(code);
  }
  @umplesourcefile(line={475},file={"Umple_Code.ump"},javaline={89},length={4})
  public void setExtraCode(String lang, String code)
  {
    codeblock.setCode(lang,code);
  }

}