/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 37 "DMMExtensionCTF.ump"
// line 151 "DMMExtensionCTF.ump"
public class PatternOccurrence
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatternOccurrence Associations
  private RoutineCallTrace routineCallTrace;
  private TracePattern tracePattern;
  private ComprehensionUnitInitiator initiator;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PatternOccurrence(RoutineCallTrace aRoutineCallTrace, TracePattern aTracePattern, ComprehensionUnitInitiator aInitiator)
  {
    boolean didAddRoutineCallTrace = setRoutineCallTrace(aRoutineCallTrace);
    if (!didAddRoutineCallTrace)
    {
      throw new RuntimeException("Unable to create patternOccurrence due to routineCallTrace");
    }
    if (!setTracePattern(aTracePattern))
    {
      throw new RuntimeException("Unable to create PatternOccurrence due to aTracePattern");
    }
    if (!setInitiator(aInitiator))
    {
      throw new RuntimeException("Unable to create PatternOccurrence due to aInitiator");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public RoutineCallTrace getRoutineCallTrace()
  {
    return routineCallTrace;
  }

  public TracePattern getTracePattern()
  {
    return tracePattern;
  }

  public ComprehensionUnitInitiator getInitiator()
  {
    return initiator;
  }

  public boolean setRoutineCallTrace(RoutineCallTrace aRoutineCallTrace)
  {
    boolean wasSet = false;
    if (aRoutineCallTrace == null)
    {
      return wasSet;
    }

    RoutineCallTrace existingRoutineCallTrace = routineCallTrace;
    routineCallTrace = aRoutineCallTrace;
    if (existingRoutineCallTrace != null && !existingRoutineCallTrace.equals(aRoutineCallTrace))
    {
      existingRoutineCallTrace.removePatternOccurrence(this);
    }
    routineCallTrace.addPatternOccurrence(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setTracePattern(TracePattern aNewTracePattern)
  {
    boolean wasSet = false;
    if (aNewTracePattern != null)
    {
      tracePattern = aNewTracePattern;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setInitiator(ComprehensionUnitInitiator aNewInitiator)
  {
    boolean wasSet = false;
    if (aNewInitiator != null)
    {
      initiator = aNewInitiator;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    RoutineCallTrace placeholderRoutineCallTrace = routineCallTrace;
    this.routineCallTrace = null;
    placeholderRoutineCallTrace.removePatternOccurrence(this);
    tracePattern = null;
    initiator = null;
  }

}