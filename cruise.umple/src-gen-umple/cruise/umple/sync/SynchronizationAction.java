/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.sync;

/**
 * @umplesource UmpleSync.ump 14
 * @umplesource UmpleSync_Code.ump 14
 */
// line 14 "../../../../src/UmpleSync.ump"
// line 14 "../../../../src/UmpleSync_Code.ump"
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "deltaCode" + ":" + getDeltaCode()+ "," +
            "umpleCode" + ":" + getUmpleCode()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={16},file={"UmpleSync_Code.ump"},javaline={82},length={5})
  @umplesourcefile(line={17},file={"UmpleSync_Code.ump"},javaline={83},length={4})
  public void go()
  {
  
  }

}