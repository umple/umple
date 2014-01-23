/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.sync;

/**
 * @umplesource UmpleSync.ump 13
 * @umplesource UmpleSync_Code.ump 13
 */
// line 13 "../../../../src/UmpleSync.ump"
// line 13 "../../../../src/UmpleSync_Code.ump"
public class SynchronizationAction
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SynchronizationAction Attributes
  private String deltaCode;
  private String umpleCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SynchronizationAction(String aDeltaCode, String aUmpleCode)
  {
    deltaCode = aDeltaCode;
    umpleCode = aUmpleCode;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDeltaCode(String aDeltaCode)
  {
    boolean wasSet = false;
    deltaCode = aDeltaCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpleCode(String aUmpleCode)
  {
    boolean wasSet = false;
    umpleCode = aUmpleCode;
    wasSet = true;
    return wasSet;
  }

  public String getDeltaCode()
  {
    return deltaCode;
  }

  public String getUmpleCode()
  {
    return umpleCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={20},file={"UmpleSync_Code.ump"},javaline={70},length={3})
   public void go(){
    
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "deltaCode" + ":" + getDeltaCode()+ "," +
            "umpleCode" + ":" + getUmpleCode()+ "]"
     + outputString;
  }
}