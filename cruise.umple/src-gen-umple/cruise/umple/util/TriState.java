/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;

/**
 * @umplesource Util_Code.ump 11
 */
// line 11 "../../../../src/Util_Code.ump"
public class TriState
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TriState Attributes
  private boolean isSet;
  private boolean status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TriState(boolean aStatus)
  {
    isSet = false;
    status = aStatus;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsSet(boolean aIsSet)
  {
    boolean wasSet = false;
    isSet = aIsSet;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={17},file={"Util_Code.ump"},javaline={52},length={1})
  public boolean setStatus(boolean aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    // line 17 "../../../../src/Util_Code.ump"
    isSet = true;
    return wasSet;
  }

  public boolean getIsSet()
  {
    return isSet;
  }

  public boolean getStatus()
  {
    return status;
  }

  public boolean isIsSet()
  {
    return isSet;
  }

  public boolean isStatus()
  {
    return status;
  }

  public void delete()
  {}

  @umplesourcefile(line={19},file={"Util_Code.ump"},javaline={81},length={3})
   public boolean isTrue(){
    return isSet && status;
  }

  @umplesourcefile(line={20},file={"Util_Code.ump"},javaline={86},length={3})
   public boolean isFalse(){
    return isSet && !status;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isSet" + ":" + getIsSet()+ "," +
            "status" + ":" + getStatus()+ "]"
     + outputString;
  }
}