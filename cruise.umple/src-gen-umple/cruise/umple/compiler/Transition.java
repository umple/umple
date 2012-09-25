/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;

public class Transition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transition Attributes
  private boolean isInternal;
  private boolean autoTransition;

  //Transition Associations
  private Event event;
  private State fromState;
  private State nextState;
  private Guard guard;
  private Action action;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetEvent;
  private boolean canSetNextState;
  private boolean canSetGuard;
  private boolean canSetAction;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transition(State aFromState, State aNextState)
  {
    cachedHashCode = -1;
    canSetEvent = true;
    canSetNextState = true;
    canSetGuard = true;
    canSetAction = true;
    isInternal = false;
    autoTransition = false;
    boolean didAddFromState = setFromState(aFromState);
    if (!didAddFromState)
    {
      throw new RuntimeException("Unable to create transition due to fromState");
    }
    boolean didAddNextState = setNextState(aNextState);
    if (!didAddNextState)
    {
      throw new RuntimeException("Unable to create nextTransition due to nextState");
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

  public boolean setAutoTransition(boolean aAutoTransition)
  {
    boolean wasSet = false;
    autoTransition = aAutoTransition;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean getAutoTransition()
  {
    return autoTransition;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public boolean isAutoTransition()
  {
    return autoTransition;
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
    if (!canSetEvent) { return false; }
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

  public boolean setNextState(State aNextState)
  {
    boolean wasSet = false;
    if (!canSetNextState) { return false; }
    if (aNextState == null)
    {
      return wasSet;
    }

    State existingNextState = nextState;
    nextState = aNextState;
    if (existingNextState != null && !existingNextState.equals(aNextState))
    {
      existingNextState.removeNextTransition(this);
    }
    nextState.addNextTransition(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setGuard(Guard newGuard)
  {
    boolean wasSet = false;
    if (!canSetGuard) { return false; }
    guard = newGuard;
    wasSet = true;
    return wasSet;
  }

  public boolean setAction(Action newAction)
  {
    boolean wasSet = false;
    if (!canSetAction) { return false; }
    action = newAction;
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Transition compareTo = (Transition)obj;
  
    if (event == null && compareTo.event != null)
    {
      return false;
    }
    else if (event != null && !event.equals(compareTo.event))
    {
      return false;
    }

    if (nextState == null && compareTo.nextState != null)
    {
      return false;
    }
    else if (nextState != null && !nextState.equals(compareTo.nextState))
    {
      return false;
    }

    if (guard == null && compareTo.guard != null)
    {
      return false;
    }
    else if (guard != null && !guard.equals(compareTo.guard))
    {
      return false;
    }

    if (action == null && compareTo.action != null)
    {
      return false;
    }
    else if (action != null && !action.equals(compareTo.action))
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
    if (event != null)
    {
      cachedHashCode = cachedHashCode * 23 + event.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (nextState != null)
    {
      cachedHashCode = cachedHashCode * 23 + nextState.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (guard != null)
    {
      cachedHashCode = cachedHashCode * 23 + guard.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (action != null)
    {
      cachedHashCode = cachedHashCode * 23 + action.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetEvent = false;
    canSetNextState = false;
    canSetGuard = false;
    canSetAction = false;
    return cachedHashCode;
  }

  public void delete()
  {
    event = null;
    State placeholderFromState = fromState;
    this.fromState = null;
    placeholderFromState.removeTransition(this);
    State placeholderNextState = nextState;
    this.nextState = null;
    placeholderNextState.removeNextTransition(this);
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