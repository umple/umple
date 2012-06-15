/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class StateMachine_TraceItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachine_TraceItem Attributes
  private boolean entry;
  private boolean exit;
  private boolean traceStateMachineFlag;

  //StateMachine_TraceItem Associations
  private StateMachine stateMachine;
  private List<TraceDirective> traceDirectives;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachine_TraceItem(StateMachine aStateMachine)
  {
    entry = false;
    exit = false;
    traceStateMachineFlag = false;
    boolean didAddStateMachine = setStateMachine(aStateMachine);
    if (!didAddStateMachine)
    {
      throw new RuntimeException("Unable to create stateMachineTraceItem due to stateMachine");
    }
    traceDirectives = new ArrayList<TraceDirective>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEntry(boolean aEntry)
  {
    boolean wasSet = false;
    entry = aEntry;
    wasSet = true;
    return wasSet;
  }

  public boolean setExit(boolean aExit)
  {
    boolean wasSet = false;
    exit = aExit;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceStateMachineFlag(boolean aTraceStateMachineFlag)
  {
    boolean wasSet = false;
    traceStateMachineFlag = aTraceStateMachineFlag;
    wasSet = true;
    return wasSet;
  }

  public boolean getEntry()
  {
    return entry;
  }

  public boolean getExit()
  {
    return exit;
  }

  public boolean getTraceStateMachineFlag()
  {
    return traceStateMachineFlag;
  }

  public StateMachine getStateMachine()
  {
    return stateMachine;
  }

  public TraceDirective getTraceDirective(int index)
  {
    TraceDirective aTraceDirective = traceDirectives.get(index);
    return aTraceDirective;
  }

  public List<TraceDirective> getTraceDirectives()
  {
    List<TraceDirective> newTraceDirectives = Collections.unmodifiableList(traceDirectives);
    return newTraceDirectives;
  }

  public int numberOfTraceDirectives()
  {
    int number = traceDirectives.size();
    return number;
  }

  public boolean hasTraceDirectives()
  {
    boolean has = traceDirectives.size() > 0;
    return has;
  }

  public int indexOfTraceDirective(TraceDirective aTraceDirective)
  {
    int index = traceDirectives.indexOf(aTraceDirective);
    return index;
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
      existingStateMachine.removeStateMachineTraceItem(this);
    }
    stateMachine.addStateMachineTraceItem(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfTraceDirectives()
  {
    return 0;
  }

  public boolean addTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasAdded = false;
    if (traceDirectives.contains(aTraceDirective)) { return false; }
    traceDirectives.add(aTraceDirective);
    if (aTraceDirective.indexOfStateMachineTraceItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceDirective.addStateMachineTraceItem(this);
      if (!wasAdded)
      {
        traceDirectives.remove(aTraceDirective);
      }
    }
    return wasAdded;
  }

  public boolean removeTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasRemoved = false;
    if (!traceDirectives.contains(aTraceDirective))
    {
      return wasRemoved;
    }

    int oldIndex = traceDirectives.indexOf(aTraceDirective);
    traceDirectives.remove(oldIndex);
    if (aTraceDirective.indexOfStateMachineTraceItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceDirective.removeStateMachineTraceItem(this);
      if (!wasRemoved)
      {
        traceDirectives.add(oldIndex,aTraceDirective);
      }
    }
    return wasRemoved;
  }

  public void delete()
  {
    StateMachine placeholderStateMachine = stateMachine;
    this.stateMachine = null;
    placeholderStateMachine.removeStateMachineTraceItem(this);
    ArrayList<TraceDirective> copyOfTraceDirectives = new ArrayList<TraceDirective>(traceDirectives);
    traceDirectives.clear();
    for(TraceDirective aTraceDirective : copyOfTraceDirectives)
    {
      aTraceDirective.removeStateMachineTraceItem(this);
    }
  }

}