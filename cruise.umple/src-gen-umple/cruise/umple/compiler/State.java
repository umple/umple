/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * One of the values in which a state machine can be at any given point in time
 * @umplesource StateMachine.ump 37
 * @umplesource StateMachine_Code.ump 303
 * @umplesource Trace_Code.ump 62
 */
// line 37 "../../../../src/StateMachine.ump"
// line 303 "../../../../src/StateMachine_Code.ump"
// line 62 "../../../../src/Trace_Code.ump"
public class State
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  private List<StateMachineTraceItem> stateMachineTraceItems;

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
    stateMachineTraceItems = new ArrayList<StateMachineTraceItem>();
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

  @umplesourcefile(line={40, 40},file={"StateMachine.ump", "StateMachine.ump"},javaline={127, 160},length={2, 2})
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

  @umplesourcefile(line={52},file={"StateMachine.ump"},javaline={185},length={1})
  public boolean isFinalState()
  {
    // line 52 "../../../../src/StateMachine.ump"
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

  public StateMachineTraceItem getStateMachineTraceItem(int index)
  {
    StateMachineTraceItem aStateMachineTraceItem = stateMachineTraceItems.get(index);
    return aStateMachineTraceItem;
  }

  public List<StateMachineTraceItem> getStateMachineTraceItems()
  {
    List<StateMachineTraceItem> newStateMachineTraceItems = Collections.unmodifiableList(stateMachineTraceItems);
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

  public int indexOfStateMachineTraceItem(StateMachineTraceItem aStateMachineTraceItem)
  {
    int index = stateMachineTraceItems.indexOf(aStateMachineTraceItem);
    return index;
  }

  public boolean setActivity(Activity aNewActivity)
  {
    boolean wasSet = false;
    if (activity != null && !activity.equals(aNewActivity) && equals(activity.getState()))
    {
      //Unable to setActivity, as existing activity would become an orphan
      return wasSet;
    }

    activity = aNewActivity;
    State anOldState = aNewActivity != null ? aNewActivity.getState() : null;

    if (!this.equals(anOldState))
    {
      if (anOldState != null)
      {
        anOldState.activity = null;
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

  public static int minimumNumberOfStateMachineTraceItems()
  {
    return 0;
  }

  public boolean addStateMachineTraceItem(StateMachineTraceItem aStateMachineTraceItem)
  {
    boolean wasAdded = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem)) { return false; }
    State existingState = aStateMachineTraceItem.getState();
    if (existingState == null)
    {
      aStateMachineTraceItem.setState(this);
    }
    else if (!this.equals(existingState))
    {
      existingState.removeStateMachineTraceItem(aStateMachineTraceItem);
      addStateMachineTraceItem(aStateMachineTraceItem);
    }
    else
    {
      stateMachineTraceItems.add(aStateMachineTraceItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStateMachineTraceItem(StateMachineTraceItem aStateMachineTraceItem)
  {
    boolean wasRemoved = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem))
    {
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      aStateMachineTraceItem.setState(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStateMachineTraceItemAt(StateMachineTraceItem aStateMachineTraceItem, int index)
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

  public boolean addOrMoveStateMachineTraceItemAt(StateMachineTraceItem aStateMachineTraceItem, int index)
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
    for(StateMachineTraceItem aStateMachineTraceItem : stateMachineTraceItems)
    {
      aStateMachineTraceItem.setState(null);
    }
  }


  /**
   * Retrieve the StateMachineTraceItem associated with this State
   * @params method: for example entry or entry or normal, each specifying the context to call the gotten trace item
   * @params uClass: the umple class to look within for the trace item
   * @return StateMachine_Traceitem for this UmpleVariable(either association or attribute);
   */
  @umplesourcefile(line={70},file={"Trace_Code.ump"},javaline={772},length={92})
  public TraceItem getTraced(String method, UmpleClass uClass){
    //go through all the trace directives of uClass
    for(TraceDirective td: uClass.getTraceDirectives())
    {
      //for all the statemachine trace items
      for(StateMachineTraceItem smti: td.getStateMachineTraceItems())
      {
      	StateMachine sm = smti.getStateMachine();
      	Transition  tsn = smti.getTransition();
      	State st = smti.getState();
        if(tsn!=null&&method.equals("transition"))
        {
          st = smti.getIsOut()?tsn.getFromState():tsn.getNextState();
		  if(this.equals(st)){
		  
            return smti;
          }
          for(StateMachine statemachine:getNestedStateMachines())
          {
            State found = statemachine.findState(st.getName());
            if(st.getName().equals(statemachine.getName()))
            {
              return smti;
            }
            if(found!=null)
            {            
              return smti;
            }
          }
        }
        else if(sm==null)
        {
          //if the trace item is not for a transition, and does not contain a state machine, return null
          return null;
        }
        else if(sm!=null&&smti.getTraceStateMachineFlag())
        { 
          return smti;
        }
        else if(method.equals("transition"))
        {
          if(smti.getIsOut()){
            if(this.equals(st))
            {
              return smti;
            }
            if(smti.getLevel()>0||smti.getLevel()==-1)
            {
              StateMachine root = this.getStateMachine();
              State parent = this;
              int level = -1;
              //System.out.println("start");
              while (parent != null)
              {
                level+=parent.getName().equals("Null")?0:1;
                if(st.getName().equals(parent.getName())&&(level<=smti.getLevel()||smti.getLevel()==-1))
                {
                  //System.out.println(this.getName()+" "+level);
                  return smti;
                }
                //System.out.println(parent.getName());
                root = parent.getStateMachine();
                parent = root.getParentState();
              }
              //System.out.println("end");
            }
          }
          
          if(smti.getIsIn())
		  {            
            for(Transition t:getTransitions())
            {
              if(t.getNextState().equals(st))
              {
                return smti;
              }              
            }
          }
        }
        else if((method.equals("exit")&&smti.getExit())||(method.equals("entry")&&smti.getEntry()))
        {
          if(this.equals(st))
          {
            return smti;
          }
        }
        
      }
    }
    
    return null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "isConcurrent" + ":" + getIsConcurrent()+ "," +
            "isStartState" + ":" + getIsStartState()+ "," +
            "isInternal" + ":" + getIsInternal()+ "," +
            "isHistoryState" + ":" + getIsHistoryState()+ "," +
            "isDeepHistoryState" + ":" + getIsDeepHistoryState()+ "," +
            "finalState" + ":" + getFinalState()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "activity = "+(getActivity()!=null?Integer.toHexString(System.identityHashCode(getActivity())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "stateMachine = "+(getStateMachine()!=null?Integer.toHexString(System.identityHashCode(getStateMachine())):"null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={305},file={"StateMachine_Code.ump"},javaline={892},length={127})
  @umplesourcefile(line={306},file={"StateMachine_Code.ump"},javaline={893},length={11})
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
  
  @umplesourcefile(line={318},file={"StateMachine_Code.ump"},javaline={906},length={15})
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

  @umplesourcefile(line={334},file={"StateMachine_Code.ump"},javaline={923},length={7})
  public Transition addTransition(State nextState, int index)
  {
    Transition newTransition = new Transition(this,nextState);
    transitions.remove(newTransition);
    transitions.add(index,newTransition);
    return newTransition;
  }

  @umplesourcefile(line={342},file={"StateMachine_Code.ump"},javaline={932},length={6})
  public void addAction(Action newAction, int index)
  {
    addAction(newAction);
    actions.remove(newAction);
    actions.add(index,newAction);
  }

  @umplesourcefile(line={349},file={"StateMachine_Code.ump"},javaline={940},length={4})
  public String getType()
  {
    return numberOfTransitions() == 0 && numberOfNestedStateMachines() == 0 ? "Simple" : "Complex";
  }
  
  @umplesourcefile(line={354},file={"StateMachine_Code.ump"},javaline={946},length={21})
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
  
  @umplesourcefile(line={376},file={"StateMachine_Code.ump"},javaline={969},length={12})
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
  
  @umplesourcefile(line={389},file={"StateMachine_Code.ump"},javaline={983},length={4})
  public boolean getHasExitAction()
  {
    return getHasAction("exit");
  }
  
  @umplesourcefile(line={394},file={"StateMachine_Code.ump"},javaline={989},length={4})
  public boolean getHasEntryAction()
  {
    return getHasAction("entry");
  }
  
  @umplesourcefile(line={399},file={"StateMachine_Code.ump"},javaline={995},length={11})
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

  @umplesourcefile(line={411},file={"StateMachine_Code.ump"},javaline={1008},length={21})
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