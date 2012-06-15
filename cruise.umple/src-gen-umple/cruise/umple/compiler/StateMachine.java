/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

public class StateMachine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachine Attributes
  private String name;

  //StateMachine Associations
  private UmpleClass umpleClass;
  private State parentState;
  private List<State> states;
  private List<TraceRecord> traceRecords;
  private List<StateMachine_TraceItem> stateMachineTraceItems;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetParentState;
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachine(String aName)
  {
    cachedHashCode = -1;
    canSetParentState = true;
    canSetName = true;
    name = aName;
    states = new ArrayList<State>();
    traceRecords = new ArrayList<TraceRecord>();
    stateMachineTraceItems = new ArrayList<StateMachine_TraceItem>();
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

  public String getName()
  {
    return name;
  }

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public State getParentState()
  {
    return parentState;
  }

  public State getState(int index)
  {
    State aState = states.get(index);
    return aState;
  }

  public List<State> getStates()
  {
    List<State> newStates = Collections.unmodifiableList(states);
    return newStates;
  }

  public int numberOfStates()
  {
    int number = states.size();
    return number;
  }

  public boolean hasStates()
  {
    boolean has = states.size() > 0;
    return has;
  }

  public int indexOfState(State aState)
  {
    int index = states.indexOf(aState);
    return index;
  }

  public TraceRecord getTraceRecord(int index)
  {
    TraceRecord aTraceRecord = traceRecords.get(index);
    return aTraceRecord;
  }

  public List<TraceRecord> getTraceRecords()
  {
    List<TraceRecord> newTraceRecords = Collections.unmodifiableList(traceRecords);
    return newTraceRecords;
  }

  public int numberOfTraceRecords()
  {
    int number = traceRecords.size();
    return number;
  }

  public boolean hasTraceRecords()
  {
    boolean has = traceRecords.size() > 0;
    return has;
  }

  public int indexOfTraceRecord(TraceRecord aTraceRecord)
  {
    int index = traceRecords.indexOf(aTraceRecord);
    return index;
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

  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    if (aUmpleClass != null && aUmpleClass.isImmutable()) { return false; }
    UmpleClass existingUmpleClass = umpleClass;
    umpleClass = aUmpleClass;
    if (existingUmpleClass != null && !existingUmpleClass.equals(aUmpleClass))
    {
      existingUmpleClass.removeStateMachine(this);
    }
    if (aUmpleClass != null)
    {
      aUmpleClass.addStateMachine(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setParentState(State aParentState)
  {
    boolean wasSet = false;
    if (!canSetParentState) { return false; }
    State existingParentState = parentState;
    parentState = aParentState;
    if (existingParentState != null && !existingParentState.equals(aParentState))
    {
      existingParentState.removeNestedStateMachine(this);
    }
    if (aParentState != null)
    {
      aParentState.addNestedStateMachine(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfStates()
  {
    return 0;
  }

  public State addState(String aName)
  {
    return new State(aName, this);
  }

  public boolean addState(State aState)
  {
    boolean wasAdded = false;
    if (states.contains(aState)) { return false; }
    StateMachine existingStateMachine = aState.getStateMachine();
    boolean isNewStateMachine = existingStateMachine != null && !this.equals(existingStateMachine);
    if (isNewStateMachine)
    {
      aState.setStateMachine(this);
    }
    else
    {
      states.add(aState);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeState(State aState)
  {
    boolean wasRemoved = false;
    //Unable to remove aState, as it must always have a stateMachine
    if (!this.equals(aState.getStateMachine()))
    {
      states.remove(aState);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfTraceRecords()
  {
    return 0;
  }

  public boolean addTraceRecord(TraceRecord aTraceRecord)
  {
    boolean wasAdded = false;
    if (traceRecords.contains(aTraceRecord)) { return false; }
    traceRecords.add(aTraceRecord);
    if (aTraceRecord.indexOfStateMachine(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceRecord.addStateMachine(this);
      if (!wasAdded)
      {
        traceRecords.remove(aTraceRecord);
      }
    }
    return wasAdded;
  }

  public boolean removeTraceRecord(TraceRecord aTraceRecord)
  {
    boolean wasRemoved = false;
    if (!traceRecords.contains(aTraceRecord))
    {
      return wasRemoved;
    }

    int oldIndex = traceRecords.indexOf(aTraceRecord);
    traceRecords.remove(oldIndex);
    if (aTraceRecord.indexOfStateMachine(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceRecord.removeStateMachine(this);
      if (!wasRemoved)
      {
        traceRecords.add(oldIndex,aTraceRecord);
      }
    }
    return wasRemoved;
  }

  public static int minimumNumberOfStateMachineTraceItems()
  {
    return 0;
  }

  public StateMachine_TraceItem addStateMachineTraceItem()
  {
    return new StateMachine_TraceItem(this);
  }

  public boolean addStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
  {
    boolean wasAdded = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem)) { return false; }
    StateMachine existingStateMachine = aStateMachineTraceItem.getStateMachine();
    boolean isNewStateMachine = existingStateMachine != null && !this.equals(existingStateMachine);
    if (isNewStateMachine)
    {
      aStateMachineTraceItem.setStateMachine(this);
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
    //Unable to remove aStateMachineTraceItem, as it must always have a stateMachine
    if (!this.equals(aStateMachineTraceItem.getStateMachine()))
    {
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    StateMachine compareTo = (StateMachine)obj;
  
    if (parentState == null && compareTo.parentState != null)
    {
      return false;
    }
    else if (parentState != null && !parentState.equals(compareTo.parentState))
    {
      return false;
    }

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
    if (parentState != null)
    {
      cachedHashCode = cachedHashCode * 23 + parentState.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (name != null)
    {
      cachedHashCode = cachedHashCode * 23 + name.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetParentState = false;
    canSetName = false;
    return cachedHashCode;
  }

  public void delete()
  {
    if (umpleClass != null)
    {
      UmpleClass placeholderUmpleClass = umpleClass;
      this.umpleClass = null;
      placeholderUmpleClass.removeStateMachine(this);
    }
    if (parentState != null)
    {
      State placeholderParentState = parentState;
      this.parentState = null;
      placeholderParentState.removeNestedStateMachine(this);
    }
    for(int i=states.size(); i > 0; i--)
    {
      State aState = states.get(i - 1);
      aState.delete();
    }
    ArrayList<TraceRecord> copyOfTraceRecords = new ArrayList<TraceRecord>(traceRecords);
    traceRecords.clear();
    for(TraceRecord aTraceRecord : copyOfTraceRecords)
    {
      aTraceRecord.removeStateMachine(this);
    }
    for(int i=stateMachineTraceItems.size(); i > 0; i--)
    {
      StateMachine_TraceItem aStateMachineTraceItem = stateMachineTraceItems.get(i - 1);
      aStateMachineTraceItem.delete();
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
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
    for(State state : getStates())
    {
      for(Action action : state.getActions())
      {
        if (actionType.equals(action.getActionType()))
        {
          return true;
        }
      }
    }
    return false;
  }
  
  public Event getEvent(String eventName)
  {
    if (eventName == null)
    {
      return null;
    }
    for (State aState : states)
    {
      for (int i=0; i<aState.numberOfTransitions(); i++)
      {
        Transition aTransition = aState.getTransition(i);
        Event e = aTransition.getEvent();
        if (e != null && eventName.equals(e.getName()))
        {
          return e;
        }
      }
    }
    return null;
  }
  
  public List<Event> getAllEvents()
  {
    ArrayList<Event> allEvents = new ArrayList<Event>();
    ArrayList<StateMachine> allSearch = new ArrayList<StateMachine>();
    ArrayList<StateMachine> alreadySearched = new ArrayList<StateMachine>();
    allSearch.add(this);
    while (!allSearch.isEmpty())
    {
      StateMachine sm = allSearch.remove(0);
      if (alreadySearched.contains(sm))
      {
        continue;
      }
      alreadySearched.add(sm);
      if (sm.getParentState() != null)
      {
        allSearch.add(sm.getParentState().getStateMachine());
        allSearch.addAll(sm.getParentState().getNestedStateMachines());
      }
      for (State aState : sm.states)
      {
        allSearch.addAll(aState.getNestedStateMachines());
        for (int i=0; i<aState.numberOfTransitions(); i++)
        {
          
          Transition aTransition = aState.getTransition(i);
          Event e = aTransition.getEvent();
          if (e != null && !allEvents.contains(e))
          {
            allEvents.add(e);
          }
        }
      }
    }
    return allEvents;
  }
  
  public List<Event> getEvents()
  {
    ArrayList<Event> allEvents = new ArrayList<Event>();
    
    for (State aState : states)
    {
      for (int i=0; i<aState.numberOfTransitions(); i++)
      {
        Transition aTransition = aState.getTransition(i);
        Event e = aTransition.getEvent();
        if (e != null && !allEvents.contains(e))
        {
          allEvents.add(e);
        }
      }
    }
    return allEvents;
  }

  public State findState(String aName)
  {
    boolean isFinal = "Final".equals(aName);
    boolean searchNestedStateMachines = !isFinal;
    boolean isAtRoot = isFinal;
    return findState(aName,searchNestedStateMachines,isAtRoot);
  }

  public State findState(String aName, boolean searchNestedStateMachines)
  {
    boolean isFinal = "Final".equals(aName);
    searchNestedStateMachines = !isFinal && searchNestedStateMachines;
    boolean isAtRoot = isFinal;
    return findState(aName,searchNestedStateMachines,isAtRoot); 
  } 
  
  public List<State> getFinalStates()
  {
    List<StateMachine> all = new ArrayList<StateMachine>();
    all.addAll(getNestedStateMachines());
    return getFinalStatesIn(all);
  }
  
  public boolean hasFinalStates()
  {
    return !getFinalStates().isEmpty();
  }
  
  private List<State> getFinalStatesIn(List<StateMachine> allStateMachines)
  {
    List<State> all = new ArrayList<State>();
    for (StateMachine sm : allStateMachines)
    {
      for(State s : sm.getStates())
      {
        if (s.isFinalState())
        {
          all.add(s);
          break;
        }
      }
    }
    return all;    
  }

  public Event findOrCreateEvent(String aName)
  {
    for (Event aEvent : getAllEvents())
    {
      if (aEvent.getName().equals(aName))
      {
        return aEvent;
      }
    }  
    return new Event(aName);
  }
  
  public State getStartState()
  {
    for (State aState : states)
    {
      if (aState.getIsStartState())
      {
        return aState;
      }
    }
    return null;
  }
  
  public String getType()
  {
    for (State aState : states)
    {
      if (aState.getType() == "Complex")
      {
        return "Complex";
      }
    }
    return "Simple";
  }
  
  public List<StateMachine> getNestedStateMachines()
  {
    ArrayList<StateMachine> all = new ArrayList<StateMachine>();
    addNestedStateMachinesTo(all,this);
    return all;
  }
  
  private void addNestedStateMachinesTo(List<StateMachine> all, StateMachine sm)
  {
    for (State s : sm.states)
    {
      for (StateMachine nestedSm : s.getNestedStateMachines())
      {
        all.add(nestedSm);
        addNestedStateMachinesTo(all,nestedSm);
      }
    }
  }
  
  private State findState(String aName, boolean searchNestedStateMachines, boolean didFindRoot)
  {
  
    StateMachine root = this;
    State parent = getParentState();
    if (!didFindRoot && searchNestedStateMachines && parent != null)
    {
      root = parent.getStateMachine();
      parent = root.getParentState();
    }
    
    for (State aState : root.states)
    {
      if (aState.getName().equals(aName))
      {
        return aState;
      }
      
      if (searchNestedStateMachines)
      {
        for (StateMachine nestedSm : aState.getNestedStateMachines()) 
        {
          State potentialMatch = nestedSm.findState(aName,true,true);
          if (potentialMatch != null)
          {
            return potentialMatch;
          } 
        }
      }
    }
    return null;
  }
  
  public String getFullName()
  {
    if (getParentState() == null)
    {
      return name;
    }
    else
    {
      return getParentState().getStateMachine().getFullName() + StringFormatter.toPascalCase(name);
    }
  }
  
  public State addState(String aName, int index)
  {
    State newState = new State(aName,this);
    states.remove(newState);
    states.add(index,newState);
    return newState;
  }
}