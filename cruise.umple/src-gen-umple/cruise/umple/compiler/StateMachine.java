/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * An entity in a running program that can have a set of values (states) and which
 * changes values by taking transitions in response to various events.
 * @umplesource StateMachine.ump 18
 * @umplesource StateMachine_Code.ump 14
 */
// line 18 "../../../../src/StateMachine.ump"
// line 14 "../../../../src/StateMachine_Code.ump"
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
  private List<StateMachineTraceItem> stateMachineTraceItems;

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
    stateMachineTraceItems = new ArrayList<StateMachineTraceItem>();
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

  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    // line 29 "../../../../src/StateMachine.ump"
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

  public boolean addStateAt(State aState, int index)
  {  
    boolean wasAdded = false;
    if(addState(aState))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStates()) { index = numberOfStates() - 1; }
      states.remove(aState);
      states.add(index, aState);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateAt(State aState, int index)
  {
    boolean wasAdded = false;
    if(states.contains(aState))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStates()) { index = numberOfStates() - 1; }
      states.remove(aState);
      states.add(index, aState);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateAt(aState, index);
    }
    return wasAdded;
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

  public boolean addTraceRecordAt(TraceRecord aTraceRecord, int index)
  {  
    boolean wasAdded = false;
    if(addTraceRecord(aTraceRecord))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceRecords()) { index = numberOfTraceRecords() - 1; }
      traceRecords.remove(aTraceRecord);
      traceRecords.add(index, aTraceRecord);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceRecordAt(TraceRecord aTraceRecord, int index)
  {
    boolean wasAdded = false;
    if(traceRecords.contains(aTraceRecord))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceRecords()) { index = numberOfTraceRecords() - 1; }
      traceRecords.remove(aTraceRecord);
      traceRecords.add(index, aTraceRecord);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceRecordAt(aTraceRecord, index);
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
    StateMachine existingStateMachine = aStateMachineTraceItem.getStateMachine();
    if (existingStateMachine == null)
    {
      aStateMachineTraceItem.setStateMachine(this);
    }
    else if (!this.equals(existingStateMachine))
    {
      existingStateMachine.removeStateMachineTraceItem(aStateMachineTraceItem);
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
      aStateMachineTraceItem.setStateMachine(null);
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
    for(StateMachineTraceItem aStateMachineTraceItem : stateMachineTraceItems)
    {
      aStateMachineTraceItem.setStateMachine(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parentState" + "=" + getUmpleClass() != null ? !getUmpleClass() .equals(this)  ? getUmpleClass().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass" + "=" + getParentState() != null ? !getParentState() .equals(this)  ? getParentState().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 17 ../../../../src/StateMachine_Code.ump
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
    return getNestedStateMachines(true); // original - do it recursively
  }
  
  public List<StateMachine> getImmediateNestedStateMachines()
  {
    return getNestedStateMachines(false); // just next level
  }
  
  private List<StateMachine> getNestedStateMachines(boolean recursive)
  {
    ArrayList<StateMachine> all = new ArrayList<StateMachine>();
    addNestedStateMachinesTo(all,this, recursive);
    return all;
  }
  
  private void addNestedStateMachinesTo(List<StateMachine> all, StateMachine sm)
  {
    addNestedStateMachinesTo(all, sm, true);
  }

  private void addNestedStateMachinesTo(List<StateMachine> all, StateMachine sm, boolean recursive)
  {
    for (State s : sm.states)
    {
      for (StateMachine nestedSm : s.getNestedStateMachines())
      {
        all.add(nestedSm);
        if(recursive) addNestedStateMachinesTo(all, nestedSm, recursive);
      }
    }
  }  
  
  private State findState(String aName, boolean searchNestedStateMachines, boolean didFindRoot)
  {
  
    StateMachine root = this;
    if (!didFindRoot && searchNestedStateMachines)
    {
      root = getRootStateMachine();
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
  
  private StateMachine getRootStateMachine()
  {
    StateMachine root = this;
    
    State parent = getParentState();
    while (parent != null)
    {
      root = parent.getStateMachine();
      parent = root.getParentState();
    }
    
    return root;
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