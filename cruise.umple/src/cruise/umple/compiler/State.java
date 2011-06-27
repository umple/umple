/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class State
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //State Attributes
  private String name;
  private boolean isStartState;
  private boolean isInternal;

  //State Associations
  private Activity activity;
  private List<Action> actions;
  private StateMachine stateMachine;
  private List<StateMachine> nestedStateMachines;
  private List<Transition> transitions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public State(String aName, StateMachine aStateMachine)
  {
    name = aName;
    isStartState = false;
    isInternal = false;
    actions = new ArrayList<Action>();
    boolean didAddStateMachine = setStateMachine(aStateMachine);
    if (!didAddStateMachine)
    {
      throw new RuntimeException("Unable to create state due to stateMachine");
    }
    nestedStateMachines = new ArrayList<StateMachine>();
    transitions = new ArrayList<Transition>();
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

  public boolean setIsStartState(boolean aIsStartState)
  {
    boolean wasSet = false;
    isStartState = aIsStartState;
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

  public boolean getIsConcurrent()
  {
    return numberOfNestedStateMachines() > 1;
  }

  public boolean getIsStartState()
  {
    return isStartState;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public Activity getActivity()
  {
    return activity;
  }

  public Action getAction(int index)
  {
    Action aAction = actions.get(index);
    return aAction;
  }

  public List<Action> getActions()
  {
    List<Action> newActions = Collections.unmodifiableList(actions);
    return newActions;
  }

  public int numberOfActions()
  {
    int number = actions.size();
    return number;
  }

  public boolean hasActions()
  {
    boolean has = actions.size() > 0;
    return has;
  }

  public int indexOfAction(Action aAction)
  {
    int index = actions.indexOf(aAction);
    return index;
  }

  public StateMachine getStateMachine()
  {
    return stateMachine;
  }

  public StateMachine getNestedStateMachine(int index)
  {
    StateMachine aNestedStateMachine = nestedStateMachines.get(index);
    return aNestedStateMachine;
  }

  public List<StateMachine> getNestedStateMachines()
  {
    List<StateMachine> newNestedStateMachines = Collections.unmodifiableList(nestedStateMachines);
    return newNestedStateMachines;
  }

  public int numberOfNestedStateMachines()
  {
    int number = nestedStateMachines.size();
    return number;
  }

  public boolean hasNestedStateMachines()
  {
    boolean has = nestedStateMachines.size() > 0;
    return has;
  }

  public int indexOfNestedStateMachine(StateMachine aNestedStateMachine)
  {
    int index = nestedStateMachines.indexOf(aNestedStateMachine);
    return index;
  }

  public Transition getTransition(int index)
  {
    Transition aTransition = transitions.get(index);
    return aTransition;
  }

  public List<Transition> getTransitions()
  {
    List<Transition> newTransitions = Collections.unmodifiableList(transitions);
    return newTransitions;
  }

  public int numberOfTransitions()
  {
    int number = transitions.size();
    return number;
  }

  public boolean hasTransitions()
  {
    boolean has = transitions.size() > 0;
    return has;
  }

  public int indexOfTransition(Transition aTransition)
  {
    int index = transitions.indexOf(aTransition);
    return index;
  }

  public boolean setActivity(Activity newActivity)
  {
    boolean wasSet = false;
    if (activity != null && !activity.equals(newActivity) && equals(activity.getState()))
    {
      //Unable to setActivity, as existing activity would become an orphan
      return wasSet;
    }

    activity = newActivity;
    State oldState = newActivity != null ? newActivity.getState() : null;

    if (!this.equals(oldState))
    {
      if (oldState != null)
      {
        oldState.activity = null;
      }
      if (activity != null)
      {
        activity.setState(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfActions()
  {
    return 0;
  }

  public boolean addAction(Action aAction)
  {
    boolean wasAdded = false;
    if (actions.contains(aAction)) { return false; }
    actions.add(aAction);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAction(Action aAction)
  {
    boolean wasRemoved = false;
    if (actions.contains(aAction))
    {
      actions.remove(aAction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setStateMachine(StateMachine aStateMachine)
  {
    boolean wasSet = false;
    if (aStateMachine == null)
    {
      return wasSet;
    }

    StateMachine existingStateMachine = stateMachine;
    stateMachine = aStateMachine;
    if (existingStateMachine != null && !existingStateMachine.equals(aStateMachine))
    {
      existingStateMachine.removeState(this);
    }
    stateMachine.addState(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfNestedStateMachines()
  {
    return 0;
  }

  public boolean addNestedStateMachine(StateMachine aNestedStateMachine)
  {
    boolean wasAdded = false;
    if (nestedStateMachines.contains(aNestedStateMachine)) { return false; }
    State existingParentState = aNestedStateMachine.getParentState();
    if (existingParentState == null)
    {
      aNestedStateMachine.setParentState(this);
    }
    else if (!this.equals(existingParentState))
    {
      existingParentState.removeNestedStateMachine(aNestedStateMachine);
      addNestedStateMachine(aNestedStateMachine);
    }
    else
    {
      nestedStateMachines.add(aNestedStateMachine);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeNestedStateMachine(StateMachine aNestedStateMachine)
  {
    boolean wasRemoved = false;
    if (nestedStateMachines.contains(aNestedStateMachine))
    {
      nestedStateMachines.remove(aNestedStateMachine);
      aNestedStateMachine.setParentState(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfTransitions()
  {
    return 0;
  }

  public Transition addTransition(State aNextState)
  {
    return new Transition(this, aNextState);
  }

  public boolean addTransition(Transition aTransition)
  {
    boolean wasAdded = false;
    if (transitions.contains(aTransition)) { return false; }
    if (transitions.contains(aTransition)) { return false; }
    State existingFromState = aTransition.getFromState();
    boolean isNewFromState = existingFromState != null && !this.equals(existingFromState);
    if (isNewFromState)
    {
      aTransition.setFromState(this);
    }
    else
    {
      transitions.add(aTransition);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransition(Transition aTransition)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransition, as it must always have a fromState
    if (!this.equals(aTransition.getFromState()))
    {
      transitions.remove(aTransition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    Activity existingActivity = activity;
    activity = null;
    if (existingActivity != null)
    {
      existingActivity.delete();
    }
    actions.clear();
    StateMachine placeholderStateMachine = stateMachine;
    this.stateMachine = null;
    placeholderStateMachine.removeState(this);
    for(StateMachine aNestedStateMachine : nestedStateMachines)
    {
      aNestedStateMachine.setParentState(null);
    }
    for(Transition aTransition : transitions)
    {
      aTransition.delete();
    }
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public Transition addTransition(State nextState, int index)
  {
    Transition newTransition = new Transition(this,nextState);
    transitions.remove(newTransition);
    transitions.add(index,newTransition);
    return newTransition;
  }

  public void addAction(Action newAction, int index)
  {
    addAction(newAction);
    actions.remove(newAction);
    actions.add(index,newAction);
  }

  public String getType()
  {
    return numberOfTransitions() == 0 ? "Simple" : "Complex";
  }
  
  public String newTimedEventName(State toState)
  {
    String templateName;
    if (toState == null)
    {
      templateName = "timeout"+ name  + "To";
    }
    else
    {
      templateName = "timeout"+ name  + "To" + toState.name;
    }
  
    String currentName = templateName;
    int index = 2;
    while (stateMachine.getEvent(currentName) != null)
    {
      currentName = templateName + index;
      index += 1;
    }
    return currentName;
  }
  
  public List<Transition> getTransitionsFor(Event e)
  {
    List<Transition> all = new ArrayList<Transition>();
    for(Transition aTransition : transitions)
    {
      if (e.equals(aTransition.getEvent()))
      {
        all.add(aTransition);
      }
    }
    return all;
  }
}