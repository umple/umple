/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Trace.ump 75
 */
// line 75 "../../../../src/Trace.ump"
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
  private Transition transition;
  private List<TraceDirective> traceDirectives;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachine_TraceItem()
  {
    entry = false;
    exit = false;
    traceStateMachineFlag = false;
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

  public Transition getTransition()
  {
    return transition;
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
    StateMachine existingStateMachine = stateMachine;
    stateMachine = aStateMachine;
    if (existingStateMachine != null && !existingStateMachine.equals(aStateMachine))
    {
      existingStateMachine.removeStateMachineTraceItem(this);
    }
    if (aStateMachine != null)
    {
      aStateMachine.addStateMachineTraceItem(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTransition(Transition aTransition)
  {
    boolean wasSet = false;
    Transition existingTransition = transition;
    transition = aTransition;
    if (existingTransition != null && !existingTransition.equals(aTransition))
    {
      existingTransition.removeStateMachineTraceItem(this);
    }
    if (aTransition != null)
    {
      aTransition.addStateMachineTraceItem(this);
    }
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

  public boolean addTraceDirectiveAt(TraceDirective aTraceDirective, int index)
  {  
    boolean wasAdded = false;
    if(addTraceDirective(aTraceDirective))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceDirectives()) { index = numberOfTraceDirectives() - 1; }
      traceDirectives.remove(aTraceDirective);
      traceDirectives.add(index, aTraceDirective);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceDirectiveAt(TraceDirective aTraceDirective, int index)
  {
    boolean wasAdded = false;
    if(traceDirectives.contains(aTraceDirective))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceDirectives()) { index = numberOfTraceDirectives() - 1; }
      traceDirectives.remove(aTraceDirective);
      traceDirectives.add(index, aTraceDirective);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceDirectiveAt(aTraceDirective, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (stateMachine != null)
    {
      StateMachine placeholderStateMachine = stateMachine;
      this.stateMachine = null;
      placeholderStateMachine.removeStateMachineTraceItem(this);
    }
    if (transition != null)
    {
      Transition placeholderTransition = transition;
      this.transition = null;
      placeholderTransition.removeStateMachineTraceItem(this);
    }
    ArrayList<TraceDirective> copyOfTraceDirectives = new ArrayList<TraceDirective>(traceDirectives);
    traceDirectives.clear();
    for(TraceDirective aTraceDirective : copyOfTraceDirectives)
    {
      aTraceDirective.removeStateMachineTraceItem(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "entry" + ":" + getEntry()+ "," +
            "exit" + ":" + getExit()+ "," +
            "traceStateMachineFlag" + ":" + getTraceStateMachineFlag()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "transition" + "=" + getStateMachine() != null ? !getStateMachine() .equals(this)  ? getStateMachine().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "stateMachine" + "=" + getTransition() != null ? !getTransition() .equals(this)  ? getTransition().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}