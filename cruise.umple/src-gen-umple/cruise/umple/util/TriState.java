/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.util;

// line 12 "../../../../src/Util_Code.ump"
public class TriState
{

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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 19 ../../../../src/Util_Code.ump
  public boolean isTrue() { return isSet && status; }
  public boolean isFalse() { return isSet && !status; }
}