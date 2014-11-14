/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 20 "DMMExtensionCTF.ump"
// line 110 "DMMExtensionCTF.ump"
public class Scenario
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Scenario Attributes
  private String description;

  //Scenario Associations
  private List<Trace> traces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Scenario(String aDescription)
  {
    description = aDescription;
    traces = new ArrayList<Trace>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public Trace getTrace(int index)
  {
    Trace aTrace = traces.get(index);
    return aTrace;
  }

  public List<Trace> getTraces()
  {
    List<Trace> newTraces = Collections.unmodifiableList(traces);
    return newTraces;
  }

  public int numberOfTraces()
  {
    int number = traces.size();
    return number;
  }

  public boolean hasTraces()
  {
    boolean has = traces.size() > 0;
    return has;
  }

  public int indexOfTrace(Trace aTrace)
  {
    int index = traces.indexOf(aTrace);
    return index;
  }

  public static int minimumNumberOfTraces()
  {
    return 0;
  }

  public boolean addTrace(Trace aTrace)
  {
    boolean wasAdded = false;
    if (traces.contains(aTrace)) { return false; }
    Scenario existingScenario = aTrace.getScenario();
    if (existingScenario == null)
    {
      aTrace.setScenario(this);
    }
    else if (!this.equals(existingScenario))
    {
      existingScenario.removeTrace(aTrace);
      addTrace(aTrace);
    }
    else
    {
      traces.add(aTrace);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTrace(Trace aTrace)
  {
    boolean wasRemoved = false;
    if (traces.contains(aTrace))
    {
      traces.remove(aTrace);
      aTrace.setScenario(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTraceAt(Trace aTrace, int index)
  {  
    boolean wasAdded = false;
    if(addTrace(aTrace))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraces()) { index = numberOfTraces() - 1; }
      traces.remove(aTrace);
      traces.add(index, aTrace);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceAt(Trace aTrace, int index)
  {
    boolean wasAdded = false;
    if(traces.contains(aTrace))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraces()) { index = numberOfTraces() - 1; }
      traces.remove(aTrace);
      traces.add(index, aTrace);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceAt(aTrace, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !traces.isEmpty() )
    {
      traces.get(0).setScenario(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}