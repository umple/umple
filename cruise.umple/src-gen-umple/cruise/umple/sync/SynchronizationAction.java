/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.sync;

// line 14 "../../../../src/UmpleSync.ump"
// line 14 "../../../../src/UmpleSync_Code.ump"
public class SynchronizationAction
{

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
  
  // line 17 ../../../../src/UmpleSync_Code.ump
  public void go()
  {
  
  }
}