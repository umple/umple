/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Umple.ump 343
 * @umplesource Umple_Code.ump 595
 */
// line 343 "../../../../src/Umple.ump"
// line 595 "../../../../src/Umple_Code.ump"
public class ExtraCode
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ExtraCode Attributes
  private List<CodeBlock> code;
  private boolean hasCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ExtraCode()
  {
    code = new ArrayList<CodeBlock>();
    hasCode = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHasCode(boolean aHasCode)
  {
    boolean wasSet = false;
    hasCode = aHasCode;
    wasSet = true;
    return wasSet;
  }

  public boolean getHasCode()
  {
    return hasCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={597},file={"Umple_Code.ump"},javaline={57},length={4})
   public void appendExtraCode(String newCode){
    code.add(new CodeBlock(newCode));
    setHasCode(true);
  }

  @umplesourcefile(line={603},file={"Umple_Code.ump"},javaline={63},length={4})
   public void appendExtraCode(CodeBlock cb){
    code.add(cb);
    setHasCode(true);
  }

  @umplesourcefile(line={609},file={"Umple_Code.ump"},javaline={69},length={12})
   public String getExtraCode(){
    String returnCode = "";
    if(getHasCode())
    {
      for(CodeBlock cb : code)
      {
        String temp = cb.getCode();
        returnCode += (temp == null ? "" : temp);
      }
    }
    return returnCode;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "hasCode" + ":" + getHasCode()+ "]"
     + outputString;
  }
}