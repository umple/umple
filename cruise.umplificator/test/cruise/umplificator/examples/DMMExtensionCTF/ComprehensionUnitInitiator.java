/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 47 "DMMExtensionCTF.ump"
// line 115 "DMMExtensionCTF.ump"
public class ComprehensionUnitInitiator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ComprehensionUnitInitiator Associations
  private List<TraceEdge> trace;
  private TraceEdge traceEdge;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ComprehensionUnitInitiator(TraceEdge aTraceEdge)
  {
    trace = new ArrayList<TraceEdge>();
    if (aTraceEdge == null || aTraceEdge.getChild() != null)
    {
      throw new RuntimeException("Unable to create ComprehensionUnitInitiator due to aTraceEdge");
    }
    traceEdge = aTraceEdge;
  }

  public ComprehensionUnitInitiator(int aRepetitionsDueToLoopsForTraceEdge, ComprehensionUnitInitiator aParentForTraceEdge)
  {
    trace = new ArrayList<TraceEdge>();
    traceEdge = new TraceEdge(aRepetitionsDueToLoopsForTraceEdge, aParentForTraceEdge, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public TraceEdge getTrace(int index)
  {
    TraceEdge aTrace = trace.get(index);
    return aTrace;
  }

  public List<TraceEdge> getTrace()
  {
    List<TraceEdge> newTrace = Collections.unmodifiableList(trace);
    return newTrace;
  }

  public int numberOfTrace()
  {
    int number = trace.size();
    return number;
  }

  public boolean hasTrace()
  {
    boolean has = trace.size() > 0;
    return has;
  }

  public int indexOfTrace(TraceEdge aTrace)
  {
    int index = trace.indexOf(aTrace);
    return index;
  }

  public TraceEdge getTraceEdge()
  {
    return traceEdge;
  }

  public static int minimumNumberOfTrace()
  {
    return 0;
  }

  public TraceEdge addTrace(int aRepetitionsDueToLoops, ComprehensionUnitInitiator aChild)
  {
    return new TraceEdge(aRepetitionsDueToLoops, this, aChild);
  }

  public boolean addTrace(TraceEdge aTrace)
  {
    boolean wasAdded = false;
    if (trace.contains(aTrace)) { return false; }
    if (trace.contains(aTrace)) { return false; }
    if (trace.contains(aTrace)) { return false; }
    if (trace.contains(aTrace)) { return false; }
    ComprehensionUnitInitiator existingParent = aTrace.getParent();
    boolean isNewParent = existingParent != null && !this.equals(existingParent);
    if (isNewParent)
    {
      aTrace.setParent(this);
    }
    else
    {
      trace.add(aTrace);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTrace(TraceEdge aTrace)
  {
    boolean wasRemoved = false;
    //Unable to remove aTrace, as it must always have a parent
    if (!this.equals(aTrace.getParent()))
    {
      trace.remove(aTrace);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTraceAt(TraceEdge aTrace, int index)
  {  
    boolean wasAdded = false;
    if(addTrace(aTrace))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrace()) { index = numberOfTrace() - 1; }
      trace.remove(aTrace);
      trace.add(index, aTrace);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceAt(TraceEdge aTrace, int index)
  {
    boolean wasAdded = false;
    if(trace.contains(aTrace))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrace()) { index = numberOfTrace() - 1; }
      trace.remove(aTrace);
      trace.add(index, aTrace);
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
    for(int i=trace.size(); i > 0; i--)
    {
      TraceEdge aTrace = trace.get(i - 1);
      aTrace.delete();
    }
    TraceEdge existingTraceEdge = traceEdge;
    traceEdge = null;
    if (existingTraceEdge != null)
    {
      existingTraceEdge.delete();
    }
  }

}