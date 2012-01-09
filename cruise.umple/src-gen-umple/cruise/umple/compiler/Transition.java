/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;

public class Transition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transition Attributes
  private boolean isInternal;

  //Transition Associations
  private Event event;
  private State fromState;
  private State nextState;
  private Guard guard;
  private Action action;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetNextState;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transition(State aFromState, State aNextState)
  {
    cachedHashCode = -1;
    canSetNextState = true;
    isInternal = false;
    boolean didAddFromState = setFromState(aFromState);
    if (!didAddFromState)
    {
      throw new RuntimeException("Unable to create transition due to fromState");
    }
    if (!setNextState(aNextState))
    {
      throw new RuntimeException("Unable to create Transition due to aNextState");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public Event getEvent()
  {
    return event;
  }

  public State getFromState()
  {
    return fromState;
  }

  public State getNextState()
  {
    return nextState;
  }

  public Guard getGuard()
  {
    return guard;
  }

  public Action getAction()
  {
    return action;
  }

  public boolean setEvent(Event newEvent)
  {
    boolean wasSet = false;
    event = newEvent;
    wasSet = true;
    return wasSet;
  }

  public boolean setFromState(State aFromState)
  {
    boolean wasSet = false;
    if (aFromState == null)
    {
      return wasSet;
    }

    State existingFromState = fromState;
    fromState = aFromState;
    if (existingFromState != null && !existingFromState.equals(aFromState))
    {
      existingFromState.removeTransition(this);
    }
    fromState.addTransition(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setNextState(State newNextState)
  {
    boolean wasSet = false;
    if (!canSetNextState) { return false; }
    if (newNextState != null)
    {
      nextState = newNextState;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setGuard(Guard newGuard)
  {
    boolean wasSet = false;
    guard = newGuard;
    wasSet = true;
    return wasSet;
  }

  public boolean setAction(Action newAction)
  {
    boolean wasSet = false;
    action = newAction;
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Transition compareTo = (Transition)obj;
  
    if (nextState == null && compareTo.nextState != null)
    {
      return false;
    }
    else if (nextState != null && !nextState.equals(compareTo.nextState))
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
    if (nextState != null)
    {
      cachedHashCode = cachedHashCode * 23 + nextState.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetNextState = false;
    return cachedHashCode;
  }

  public void delete()
  {
    event = null;
    State placeholderFromState = fromState;
    this.fromState = null;
    placeholderFromState.removeTransition(this);
    nextState = null;
    guard = null;
    action = null;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static Transition createPlaceholder(State nextState)
  {
    StateMachine nullSm = new StateMachine("null");
    State nullState = new State("null",nullSm);
    return new Transition(nullState, nextState);
  }
}