/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;

public class TraceRecord
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceRecord Attributes
  private String record;

  //TraceRecord Associations
  private TraceDirective traceDirective;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceRecord(TraceDirective aTraceDirective)
  {
    record = null;
    boolean didAddTraceDirective = setTraceDirective(aTraceDirective);
    if (!didAddTraceDirective)
    {
      throw new RuntimeException("Unable to create traceRecord due to traceDirective");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRecord(String aRecord)
  {
    boolean wasSet = false;
    record = aRecord;
    wasSet = true;
    return wasSet;
  }

  public String getRecord()
  {
    return record;
  }

  public TraceDirective getTraceDirective()
  {
    return traceDirective;
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
    TraceDirective existingTraceDirective = traceDirective;
    traceDirective = null;
    if (existingTraceDirective != null)
    {
      existingTraceDirective.setTraceRecord(null);
    }
  }

}