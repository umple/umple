/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Specifies, within a state, what happens with a certain event (method call) occurs
 * Normally the state machine will go to a new state after executing various actions and
 * activities.
 * The guard is a boolean condition that may prevent triggering the transition
 * @umplesource StateMachine.ump 103
 * @umplesource StateMachine_Code.ump 433
 */
// line 103 "../../../../src/StateMachine.ump"
// line 433 "../../../../src/StateMachine_Code.ump"
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
  private List<StateMachine_TraceItem> stateMachineTraceItems;

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
    stateMachineTraceItems = new ArrayList<StateMachine_TraceItem>();
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

  public StateMachine_TraceItem getStateMachineTraceItem(int index)
  {
    StateMachine_TraceItem aStateMachineTraceItem = stateMachineTraceItems.get(index);
    return aStateMachineTraceItem;
  }

  public List<StateMachine_TraceItem> getStateMachineTraceItems()
  {
    List<StateMachine_TraceItem> newStateMachineTraceItems = Collections.unmodifiableList(stateMachineTraceItems);
    return newStateMachineTraceItems;
  }

  public int numberOfStateMachineTraceItems()
  {
    int number = stateMachineTraceItems.size();
    return number;
  }

  public boolean hasStateMachineTraceItems()
  {
    boolean has = stateMachineTraceItems.size() > 0;
    return has;
  }

  public int indexOfStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
  {
    int index = stateMachineTraceItems.indexOf(aStateMachineTraceItem);
    return index;
  }

  public boolean setEvent(Event aNewEvent)
  {
    boolean wasSet = false;
    if (!canSetEvent) { return false; }
    event = aNewEvent;
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

  public boolean setGuard(Guard aNewGuard)
  {
    boolean wasSet = false;
    if (!canSetGuard) { return false; }
    guard = aNewGuard;
    wasSet = true;
    return wasSet;
  }

  public boolean setAction(Action aNewAction)
  {
    boolean wasSet = false;
    if (!canSetAction) { return false; }
    action = aNewAction;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfStateMachineTraceItems()
  {
    return 0;
  }

  public boolean addStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
  {
    boolean wasAdded = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem)) { return false; }
    Transition existingTransition = aStateMachineTraceItem.getTransition();
    if (existingTransition == null)
    {
      aStateMachineTraceItem.setTransition(this);
    }
    else if (!this.equals(existingTransition))
    {
      existingTransition.removeStateMachineTraceItem(aStateMachineTraceItem);
      addStateMachineTraceItem(aStateMachineTraceItem);
    }
    else
    {
      stateMachineTraceItems.add(aStateMachineTraceItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
  {
    boolean wasRemoved = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem))
    {
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      aStateMachineTraceItem.setTransition(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStateMachineTraceItemAt(StateMachine_TraceItem aStateMachineTraceItem, int index)
  {  
    boolean wasAdded = false;
    if(addStateMachineTraceItem(aStateMachineTraceItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachineTraceItems()) { index = numberOfStateMachineTraceItems() - 1; }
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      stateMachineTraceItems.add(index, aStateMachineTraceItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateMachineTraceItemAt(StateMachine_TraceItem aStateMachineTraceItem, int index)
  {
    boolean wasAdded = false;
    if(stateMachineTraceItems.contains(aStateMachineTraceItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachineTraceItems()) { index = numberOfStateMachineTraceItems() - 1; }
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      stateMachineTraceItems.add(index, aStateMachineTraceItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateMachineTraceItemAt(aStateMachineTraceItem, index);
    }
    return wasAdded;
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
    for(StateMachine_TraceItem aStateMachineTraceItem : stateMachineTraceItems)
    {
      aStateMachineTraceItem.setTransition(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "isInternal" + ":" + getIsInternal()+ "," +
            "autoTransition" + ":" + getAutoTransition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "action" + "=" + getEvent() != null ? !getEvent() .equals(this)  ? getEvent().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "guard" + "=" + getFromState() != null ? !getFromState() .equals(this)  ? getFromState().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "nextState" + "=" + getNextState() != null ? !getNextState() .equals(this)  ? getNextState().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "fromState" + "=" + getGuard() != null ? !getGuard() .equals(this)  ? getGuard().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "event" + "=" + getAction() != null ? !getAction() .equals(this)  ? getAction().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 435 ../../../../src/StateMachine_Code.ump
  public static Transition createPlaceholder(State nextState)
  {
    StateMachine nullSm = new StateMachine("null");
    State nullState = new State("null",nullSm);
    return new Transition(nullState, nextState);
  }
}