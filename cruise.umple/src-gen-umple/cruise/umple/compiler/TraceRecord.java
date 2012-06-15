/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class TraceRecord
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceRecord Attributes
  private boolean recordOnly;
  private String record;

  //TraceRecord Associations
  private List<Attribute> attributes;
  private List<StateMachine> stateMachines;
  private TraceDirective traceDirective;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceRecord(TraceDirective aTraceDirective)
  {
    recordOnly = false;
    record = null;
    attributes = new ArrayList<Attribute>();
    stateMachines = new ArrayList<StateMachine>();
    boolean didAddTraceDirective = setTraceDirective(aTraceDirective);
    if (!didAddTraceDirective)
    {
      throw new RuntimeException("Unable to create traceRecord due to traceDirective");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRecordOnly(boolean aRecordOnly)
  {
    boolean wasSet = false;
    recordOnly = aRecordOnly;
    wasSet = true;
    return wasSet;
  }

  public boolean setRecord(String aRecord)
  {
    boolean wasSet = false;
    record = aRecord;
    wasSet = true;
    return wasSet;
  }

  public boolean getRecordOnly()
  {
    return recordOnly;
  }

  public String getRecord()
  {
    return record;
  }

  public Attribute getAttribute(int index)
  {
    Attribute aAttribute = attributes.get(index);
    return aAttribute;
  }

  public List<Attribute> getAttributes()
  {
    List<Attribute> newAttributes = Collections.unmodifiableList(attributes);
    return newAttributes;
  }

  public int numberOfAttributes()
  {
    int number = attributes.size();
    return number;
  }

  public boolean hasAttributes()
  {
    boolean has = attributes.size() > 0;
    return has;
  }

  public int indexOfAttribute(Attribute aAttribute)
  {
    int index = attributes.indexOf(aAttribute);
    return index;
  }

  public StateMachine getStateMachine(int index)
  {
    StateMachine aStateMachine = stateMachines.get(index);
    return aStateMachine;
  }

  public List<StateMachine> getStateMachines()
  {
    List<StateMachine> newStateMachines = Collections.unmodifiableList(stateMachines);
    return newStateMachines;
  }

  public int numberOfStateMachines()
  {
    int number = stateMachines.size();
    return number;
  }

  public boolean hasStateMachines()
  {
    boolean has = stateMachines.size() > 0;
    return has;
  }

  public int indexOfStateMachine(StateMachine aStateMachine)
  {
    int index = stateMachines.indexOf(aStateMachine);
    return index;
  }

  public TraceDirective getTraceDirective()
  {
    return traceDirective;
  }

  public static int minimumNumberOfAttributes()
  {
    return 0;
  }

  public boolean addAttribute(Attribute aAttribute)
  {
    boolean wasAdded = false;
    if (attributes.contains(aAttribute)) { return false; }
    attributes.add(aAttribute);
    if (aAttribute.indexOfTraceRecord(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttribute.addTraceRecord(this);
      if (!wasAdded)
      {
        attributes.remove(aAttribute);
      }
    }
    return wasAdded;
  }

  public boolean removeAttribute(Attribute aAttribute)
  {
    boolean wasRemoved = false;
    if (!attributes.contains(aAttribute))
    {
      return wasRemoved;
    }

    int oldIndex = attributes.indexOf(aAttribute);
    attributes.remove(oldIndex);
    if (aAttribute.indexOfTraceRecord(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttribute.removeTraceRecord(this);
      if (!wasRemoved)
      {
        attributes.add(oldIndex,aAttribute);
      }
    }
    return wasRemoved;
  }

  public static int minimumNumberOfStateMachines()
  {
    return 0;
  }

  public boolean addStateMachine(StateMachine aStateMachine)
  {
    boolean wasAdded = false;
    if (stateMachines.contains(aStateMachine)) { return false; }
    stateMachines.add(aStateMachine);
    if (aStateMachine.indexOfTraceRecord(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStateMachine.addTraceRecord(this);
      if (!wasAdded)
      {
        stateMachines.remove(aStateMachine);
      }
    }
    return wasAdded;
  }

  public boolean removeStateMachine(StateMachine aStateMachine)
  {
    boolean wasRemoved = false;
    if (!stateMachines.contains(aStateMachine))
    {
      return wasRemoved;
    }

    int oldIndex = stateMachines.indexOf(aStateMachine);
    stateMachines.remove(oldIndex);
    if (aStateMachine.indexOfTraceRecord(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStateMachine.removeTraceRecord(this);
      if (!wasRemoved)
      {
        stateMachines.add(oldIndex,aStateMachine);
      }
    }
    return wasRemoved;
  }

  public boolean setTraceDirective(TraceDirective newTraceDirective)
  {
    boolean wasSet = false;
    if (newTraceDirective == null)
    {
      //Unable to setTraceDirective to null, as traceRecord must always be associated to a traceDirective
      return wasSet;
    }
    
    TraceRecord existingTraceRecord = newTraceDirective.getTraceRecord();
    if (existingTraceRecord != null && !equals(existingTraceRecord))
    {
      //Unable to setTraceDirective, the current traceDirective already has a traceRecord, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    TraceDirective oldTraceDirective = traceDirective;
    traceDirective = newTraceDirective;
    traceDirective.setTraceRecord(this);

    if (oldTraceDirective != null)
    {
      oldTraceDirective.setTraceRecord(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Attribute> copyOfAttributes = new ArrayList<Attribute>(attributes);
    attributes.clear();
    for(Attribute aAttribute : copyOfAttributes)
    {
      aAttribute.removeTraceRecord(this);
    }
    ArrayList<StateMachine> copyOfStateMachines = new ArrayList<StateMachine>(stateMachines);
    stateMachines.clear();
    for(StateMachine aStateMachine : copyOfStateMachines)
    {
      aStateMachine.removeTraceRecord(this);
    }
    TraceDirective existingTraceDirective = traceDirective;
    traceDirective = null;
    if (existingTraceDirective != null)
    {
      existingTraceDirective.setTraceRecord(null);
    }
  }

}