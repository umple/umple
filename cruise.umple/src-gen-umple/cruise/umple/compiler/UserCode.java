/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * It is used to track user code when processing objects information
 * @umplesource Generator_UmpleModelWalker.ump 29
 */
// line 29 "../../../../src/Generator_UmpleModelWalker.ump"
public class UserCode
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UserCode Attributes
  private String userCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UserCode(String aUserCode)
  {
    userCode = aUserCode;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserCode(String aUserCode)
  {
    boolean wasSet = false;
    userCode = aUserCode;
    wasSet = true;
    return wasSet;
  }

  public String getUserCode()
  {
    return userCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "userCode" + ":" + getUserCode()+ "]"
     + outputString;
  }
}