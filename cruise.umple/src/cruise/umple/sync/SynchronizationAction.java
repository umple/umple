/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.umple.sync;

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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void go()
  {
  
  }
}