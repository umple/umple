/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;

/**
 * The contents of a method, such as the code within it.
 * @umplesource Umple.ump 146
 * @umplesource Umple_Code.ump 464
 */
// line 149 "../../../../src/Umple.ump"
// line 466 "../../../../src/Umple_Code.ump"
public class MethodBody
{

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
            "  " + "codeblock" + "=" + getCodeblock() != null ? !getCodeblock() .equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public MethodBody(String aValue)  {
this(new CodeBlock(aValue!=null ? aValue : ""));
  }
// line 472 ../../../../src/Umple_Code.ump
  public String getExtraCode(String lang)
  {
  return codeblock.getCode(lang);
  }
  public void setExtraCode(String code)
  {
    codeblock.setCode(code);
  }
  public void setExtraCode(String lang, String code)
  {
    codeblock.setCode(lang,code);
  }
}