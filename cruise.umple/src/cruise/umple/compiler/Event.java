/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.957 modeling language!*/

package cruise.umple.compiler;

public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String name;
  private boolean isTimer;
  private String timerInSeconds;
  private boolean isInternal;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(String aName)
  {
    name = aName;
    isTimer = false;
    timerInSeconds = "0";
    isInternal = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
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

  public boolean getIsTimer()
  {
    return isTimer;
  }

  public String getTimerInSeconds()
  {
    return timerInSeconds;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsTimer()
  {
    return isTimer;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public void delete()
  {}

}