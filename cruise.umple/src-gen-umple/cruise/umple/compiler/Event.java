/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;

// line 138 "../../../../src/StateMachine.ump"
// line 431 "../../../../src/StateMachine_Code.ump"
public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String name;
  private String args;
  private boolean isTimer;
  private boolean autoTransition;
  private String timerInSeconds;
  private boolean isInternal;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(String aName)
  {
    cachedHashCode = -1;
    canSetName = true;
    name = aName;
    args = null;
    isTimer = false;
    autoTransition = false;
    timerInSeconds = "0";
    isInternal = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    if (!canSetName) { return false; }
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setArgs(String aArgs)
  {
    boolean wasSet = false;
    args = aArgs;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsTimer(boolean aIsTimer)
  {
    boolean wasSet = false;
    isTimer = aIsTimer;
    wasSet = true;
    return wasSet;
  }

  public boolean setAutoTransition(boolean aAutoTransition)
  {
    boolean wasSet = false;
    autoTransition = aAutoTransition;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimerInSeconds(String aTimerInSeconds)
  {
    boolean wasSet = false;
    timerInSeconds = aTimerInSeconds;
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

  public String getName()
  {
    return name;
  }

  public String getArgs()
  {
    return args;
  }

  public boolean getIsTimer()
  {
    return isTimer;
  }

  public boolean getAutoTransition()
  {
    return autoTransition;
  }

  public String getTimerInSeconds()
  {
    return timerInSeconds;
  }

  /**
   * TODO: how do you specify milliseconds etc.
   */
  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsTimer()
  {
    return isTimer;
  }

  public boolean isAutoTransition()
  {
    return autoTransition;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Event compareTo = (Event)obj;
  
    if (name == null && compareTo.name != null)
    {
      return false;
    }
    else if (name != null && !name.equals(compareTo.name))
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
    if (name != null)
    {
      cachedHashCode = cachedHashCode * 23 + name.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetName = false;
    return cachedHashCode;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 433 ../../../../src/StateMachine_Code.ump
  private static int nextAutoTransitionId = 1;

  public static Event createAutoTransition()
  {
    Event e = new Event("__autotransition" + Event.nextAutoTransitionId + "__");
    e.setAutoTransition(true);
    Event.nextAutoTransitionId += 1;
    return e;
  }
}