/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

public class Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Action Attributes
  private String actionType;
  private String actionCode;
  private boolean isInternal;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Action(String aActionCode)
  {
    actionType = null;
    actionCode = aActionCode;
    isInternal = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setActionType(String aActionType)
  {
    boolean wasSet = false;
    actionType = aActionType;
    wasSet = true;
    return wasSet;
  }

  public boolean setActionCode(String aActionCode)
  {
    boolean wasSet = false;
    actionCode = aActionCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  public String getActionType()
  {
    return actionType;
  }

  public String getActionCode()
  {
    return actionCode;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public void delete()
  {}

}