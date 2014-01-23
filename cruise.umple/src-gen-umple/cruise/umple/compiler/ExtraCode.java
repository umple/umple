/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Umple.ump 306
 * @umplesource Umple_Code.ump 611
 */
// line 306 "../../../../src/Umple.ump"
// line 611 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={616},file={"Umple_Code.ump"},javaline={58},length={4})
   public void appendExtraCode(String newCode){
    code.add(new CodeBlock(newCode));
    setHasCode(true);
  }

  @umplesourcefile(line={622},file={"Umple_Code.ump"},javaline={64},length={4})
   public void appendExtraCode(CodeBlock cb){
    code.add(cb);
    setHasCode(true);
  }

  @umplesourcefile(line={628},file={"Umple_Code.ump"},javaline={70},length={12})
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