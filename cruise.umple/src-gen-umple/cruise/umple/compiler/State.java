/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

// line 28 "../../../../src/StateMachine.ump"
// line 274 "../../../../src/StateMachine_Code.ump"
public class State
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //State Attributes
  private String name;
  private boolean isStartState;
  private boolean isInternal;
  private boolean isHistoryState;
  private boolean isDeepHistoryState;
  private boolean finalState;

  //State Associations
  private Activity activity;
  private List<Action> actions;
  private StateMachine stateMachine;
  private List<StateMachine> nestedStateMachines;
  private List<Transition> transitions;
  private List<Transition> nextTransition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public State(String aName, StateMachine aStateMachine)
  {
    name = aName;
    isStartState = false;
    isInternal = false;
    isHistoryState = false;
    isDeepHistoryState = false;
    finalState = false;
    actions = new ArrayList<Action>();
    boolean didAddStateMachine = setStateMachine(aStateMachine);
    if (!didAddStateMachine)
    {
      throw new RuntimeException("Unable to create state due to stateMachine");
    }
    nestedStateMachines = new ArrayList<StateMachine>();
    transitions = new ArrayList<Transition>();
    nextTransition = new ArrayList<Transition>();
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

  public boolean setIsHistoryState(boolean aIsHistoryState)
  {
    boolean wasSet = false;
    isHistoryState = aIsHistoryState;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDeepHistoryState(boolean aIsDeepHistoryState)
  {
    boolean wasSet = false;
    isDeepHistoryState = aIsDeepHistoryState;
    wasSet = true;
    return wasSet;
  }

  public boolean setFinalState(boolean aFinalState)
  {
    boolean wasSet = false;
    finalState = aFinalState;
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

  /**
   * for code generation only e.g. ouside scope of nested state
   */
  public boolean getIsHistoryState()
  {
    return isHistoryState;
  }

  public boolean getIsDeepHistoryState()
  {
    return isDeepHistoryState;
  }

  public boolean getFinalState()
  {
    return finalState;
  }

  public boolean isIsConcurrent()
  {
    return numberOfNestedStateMachines() > 1;
  }

  public boolean isIsStartState()
  {
    return isStartState;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public boolean isIsHistoryState()
  {
    return isHistoryState;
  }

  public boolean isIsDeepHistoryState()
  {
    return isDeepHistoryState;
  }

  public boolean isFinalState()
  {
    // line 43 "../../../../src/StateMachine.ump"
    if ("Final".equals(name)) { finalState = true; }
    return finalState;
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

  public Transition getNextTransition(int index)
  {
    Transition aNextTransition = nextTransition.get(index);
    return aNextTransition;
  }

  public List<Transition> getNextTransition()
  {
    List<Transition> newNextTransition = Collections.unmodifiableList(nextTransition);
    return newNextTransition;
  }

  public int numberOfNextTransition()
  {
    int number = nextTransition.size();
    return number;
  }

  public boolean hasNextTransition()
  {
    boolean has = nextTransition.size() > 0;
    return has;
  }

  public int indexOfNextTransition(Transition aNextTransition)
  {
    int index = nextTransition.indexOf(aNextTransition);
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

  public boolean addActionAt(Action aAction, int index)
  {  
    boolean wasAdded = false;
    if(addAction(aAction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActions()) { index = numberOfActions() - 1; }
      actions.remove(aAction);
      actions.add(index, aAction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveActionAt(Action aAction, int index)
  {
    boolean wasAdded = false;
    if(actions.contains(aAction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActions()) { index = numberOfActions() - 1; }
      actions.remove(aAction);
      actions.add(index, aAction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addActionAt(aAction, index);
    }
    return wasAdded;
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

  public boolean addNestedStateMachineAt(StateMachine aNestedStateMachine, int index)
  {  
    boolean wasAdded = false;
    if(addNestedStateMachine(aNestedStateMachine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNestedStateMachines()) { index = numberOfNestedStateMachines() - 1; }
      nestedStateMachines.remove(aNestedStateMachine);
      nestedStateMachines.add(index, aNestedStateMachine);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNestedStateMachineAt(StateMachine aNestedStateMachine, int index)
  {
    boolean wasAdded = false;
    if(nestedStateMachines.contains(aNestedStateMachine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNestedStateMachines()) { index = numberOfNestedStateMachines() - 1; }
      nestedStateMachines.remove(aNestedStateMachine);
      nestedStateMachines.add(index, aNestedStateMachine);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addNestedStateMachineAt(aNestedStateMachine, index);
    }
    return wasAdded;
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

  public boolean addTransitionAt(Transition aTransition, int index)
  {  
    boolean wasAdded = false;
    if(addTransition(aTransition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransitions()) { index = numberOfTransitions() - 1; }
      transitions.remove(aTransition);
      transitions.add(index, aTransition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransitionAt(Transition aTransition, int index)
  {
    boolean wasAdded = false;
    if(transitions.contains(aTransition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransitions()) { index = numberOfTransitions() - 1; }
      transitions.remove(aTransition);
      transitions.add(index, aTransition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransitionAt(aTransition, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfNextTransition()
  {
    return 0;
  }

  public Transition addNextTransition(State aFromState)
  {
    return new Transition(aFromState, this);
  }

  public boolean addNextTransition(Transition aNextTransition)
  {
    boolean wasAdded = false;
    if (nextTransition.contains(aNextTransition)) { return false; }
    State existingNextState = aNextTransition.getNextState();
    boolean isNewNextState = existingNextState != null && !this.equals(existingNextState);
    if (isNewNextState)
    {
      aNextTransition.setNextState(this);
    }
    else
    {
      nextTransition.add(aNextTransition);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeNextTransition(Transition aNextTransition)
  {
    boolean wasRemoved = false;
    //Unable to remove aNextTransition, as it must always have a nextState
    if (!this.equals(aNextTransition.getNextState()))
    {
      nextTransition.remove(aNextTransition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addNextTransitionAt(Transition aNextTransition, int index)
  {  
    boolean wasAdded = false;
    if(addNextTransition(aNextTransition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNextTransition()) { index = numberOfNextTransition() - 1; }
      nextTransition.remove(aNextTransition);
      nextTransition.add(index, aNextTransition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNextTransitionAt(Transition aNextTransition, int index)
  {
    boolean wasAdded = false;
    if(nextTransition.contains(aNextTransition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNextTransition()) { index = numberOfNextTransition() - 1; }
      nextTransition.remove(aNextTransition);
      nextTransition.add(index, aNextTransition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addNextTransitionAt(aNextTransition, index);
    }
    return wasAdded;
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
    for(int i=transitions.size(); i > 0; i--)
    {
      Transition aTransition = transitions.get(i - 1);
      aTransition.delete();
    }
    for(int i=nextTransition.size(); i > 0; i--)
    {
      Transition aNextTransition = nextTransition.get(i - 1);
      aNextTransition.delete();
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 277 ../../../../src/StateMachine_Code.ump
  public boolean isSameState(State state, StateMachine relativeTo)
  {
    if (this.equals(state))
    {
      return true;
    }
    
    State mySuper = findSuperState(this,relativeTo);
    State yourSuper = findSuperState(state,relativeTo);
    return mySuper != null && mySuper.equals(yourSuper); 
  }
  
  private State findSuperState(State me, StateMachine lookFor)
  {
    if (me == null || lookFor == null)
    {
      return null;
    }
    else if (lookFor.equals(me.getStateMachine()))
    {
      return me;
    }
    else
    {
      return findSuperState(me.getStateMachine().getParentState(),lookFor);
    }
  } 

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
    return numberOfTransitions() == 0 && numberOfNestedStateMachines() == 0 ? "Simple" : "Complex";
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
  
  public boolean getHasExitAction()
  {
    return getHasAction("exit");
  }
  
  public boolean getHasEntryAction()
  {
    return getHasAction("entry");
  }
  
  private boolean getHasAction(String actionType)
  {
    for(Action action : getActions())
    {
      if (actionType.equals(action.getActionType()))
      {
        return true;
      }
    }
    return false;
  }

  public StateMachine exitableStateMachine(State nextState)
  {
    if (getHasExitAction() && !equals(nextState))
    {
      return getStateMachine();
    }
    State currentState = getStateMachine().getParentState();
    while (currentState != null)
    {
      StateMachine sm = currentState.getStateMachine();
      if (currentState.getHasExitAction() && !currentState.equals(nextState))
      {
        return sm;
      }
      else
      {
        currentState = sm.getParentState();
      }
    }
    return null;
  }
}