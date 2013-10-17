/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;

// line 69 "../../../../src/TestHarnessTracer.ump"
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

  public boolean ev1()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Open:
        exitStatus();
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,92,TraceStm,"+System.identityHashCode(this)+",sm_t,Open,ev1,Close" );
        setStatus(Status.Close);
        wasEventProcessed = true;
        break;
      case Close:
        exitStatus();
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
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,97,TraceStm,"+System.identityHashCode(this)+",sm_t,HalfOpen,ev2,HalfClose" );
        setStatus(Status.HalfClose);
        wasEventProcessed = true;
        break;
      case HalfClose:
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,97,TraceStm,"+System.identityHashCode(this)+",sm_t,HalfClose,ev2,HalfOpen" );
        setStatus(Status.HalfOpen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={76,81}, file={"TestHarnessTracer.ump","TestHarnessTracer.ump"}, javaline={119,124}, length={1,1})
  private void exitStatus()
  {
    switch(status)
    {
      case Open:
        // line 76 "../../../../src/TestHarnessTracer.ump"
        log = "exit called";
        break;
      case Close:
        // line 81 "../../../../src/TestHarnessTracer.ump"
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
        // line 75 "../../../../src/TestHarnessTracer.ump"
        log = "entry called";
        break;
      case Close:
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,94,TraceStm,"+System.identityHashCode(this)+",sm_e,Close,status" );
        // line 80 "../../../../src/TestHarnessTracer.ump"
        log = "Close entry called";
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