/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

// line 72 "../../../../src/StateMachine.ump"
public class Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Action Attributes
  private String actionType;
  private Position position;
  private String actionCode;
  private boolean isInternal;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetActionType;
  private boolean canSetActionCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Action(String aActionCode)
  {
    cachedHashCode = -1;
    canSetActionType = true;
    canSetActionCode = true;
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
    if (!canSetActionType) { return false; }
    actionType = aActionType;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setActionCode(String aActionCode)
  {
    boolean wasSet = false;
    if (!canSetActionCode) { return false; }
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

  public Position getPosition()
  {
    return position;
  }

  public String getActionCode()
  {
    return actionCode;
  }

  /**
   * target language code
   */
  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Action compareTo = (Action)obj;
  
    if (actionType == null && compareTo.actionType != null)
    {
      return false;
    }
    else if (actionType != null && !actionType.equals(compareTo.actionType))
    {
      return false;
    }

    if (actionCode == null && compareTo.actionCode != null)
    {
      return false;
    }
    else if (actionCode != null && !actionCode.equals(compareTo.actionCode))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (actionType != null)
    {
      cachedHashCode = cachedHashCode * 23 + actionType.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (actionCode != null)
    {
      cachedHashCode = cachedHashCode * 23 + actionCode.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetActionType = false;
    canSetActionCode = false;
    return cachedHashCode;
  }

  public void delete()
  {}

}