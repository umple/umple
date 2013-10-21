/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.statemachine.test;

// line 58 "../../../../src/TestHarnessStateMachine.ump"
public class CourseG
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseG State Machines
  enum Status { On, Off }
  enum StatusOn { Null, Idle, Running }
  private Status status;
  private StatusOn statusOn;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseG()
  {
    setStatusOn(StatusOn.Null);
    setStatus(Status.On);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    if (statusOn != StatusOn.Null) { answer += "." + statusOn.toString(); }
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public StatusOn getStatusOn()
  {
    return statusOn;
  }

  public boolean turnOff()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case On:
        exitStatus();
        setStatus(Status.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean flip()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    StatusOn aStatusOn = statusOn;
    switch (aStatus)
    {
      case Off:
        setStatusOn(StatusOn.Idle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusOn)
    {
      case Idle:
        setStatusOn(StatusOn.Running);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterOn()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    switch (aStatusOn)
    {
      case Null:
        setStatusOn(StatusOn.Idle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitOn()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    switch (aStatusOn)
    {
      case Idle:
        setStatusOn(StatusOn.Null);
        wasEventProcessed = true;
        break;
      case Running:
        setStatusOn(StatusOn.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case On:
        exitOn();
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case On:
        if (statusOn == StatusOn.Null) { setStatusOn(StatusOn.Idle); }
        break;
    }
  }

  private void setStatusOn(StatusOn aStatusOn)
  {
    statusOn = aStatusOn;
    if (status != Status.On && aStatusOn != StatusOn.Null) { setStatus(Status.On); }
  }

  public void delete()
  {}

}