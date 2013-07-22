/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;

// line 9 "../../../../src/TestHarnessTracer.ump"
public class TraceStm
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceStm Attributes
  private String log;

  //TraceStm State Machines
  enum Status { Open, Close, HalfOpen, HalfClose }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceStm()
  {
    log = "initial value";
    setStatus(Status.Open);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLog(String aLog)
  {
    boolean wasSet = false;
    log = aLog;
    wasSet = true;
    return wasSet;
  }

  public String getLog()
  {
    return log;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean anEvent()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Open:
        exitStatus();
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/tejota/Documents/Umple/umple-read-only/testbed/src/TestHarnessTracer.ump,31,TraceStm,"+System.identityHashCode(this)+",sm_t,Open,anEvent,Close" );
        setStatus(Status.Close);
        wasEventProcessed = true;
        break;
      case Close:
        setStatus(Status.Open);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ev2()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case HalfOpen:
        setStatus(Status.HalfClose);
        wasEventProcessed = true;
        break;
      case HalfClose:
        setStatus(Status.HalfOpen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={16}, file={"TestHarnessTracer.ump"}, javaline={116}, length={1})
  private void exitStatus()
  {
    switch(status)
    {
      case Open:
        // line 16 "../../../../src/TestHarnessTracer.ump"
        log = "exit called";
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case Open:
        // line 15 "../../../../src/TestHarnessTracer.ump"
        log = "entry called";
        break;
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "log" + ":" + getLog()+ "]"
     + outputString;
  }
}