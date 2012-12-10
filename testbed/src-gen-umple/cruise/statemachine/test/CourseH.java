/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.statemachine.test;

// line 84 "../../../../src/TestHarnessStateMachine.ump"
public class CourseH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseH State Machines
  enum Status { On, Off }
  enum StatusOn { Null, Running }
  enum StatusOnRunning { Null, Play }
  enum StatusOff { Null, Idle, Full }
  private Status status;
  private StatusOn statusOn;
  private StatusOnRunning statusOnRunning;
  private StatusOff statusOff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseH()
  {
    setStatusOn(StatusOn.Null);
    setStatusOnRunning(StatusOnRunning.Null);
    setStatusOff(StatusOff.Null);
    setStatus(Status.On);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    if (statusOn != StatusOn.Null) { answer += "." + statusOn.toString(); }
    if (statusOnRunning != StatusOnRunning.Null) { answer += "." + statusOnRunning.toString(); }
    if (statusOff != StatusOff.Null) { answer += "." + statusOff.toString(); }
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

  public StatusOnRunning getStatusOnRunning()
  {
    return statusOnRunning;
  }

  public StatusOff getStatusOff()
  {
    return statusOff;
  }

  public boolean flip()
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
    }

    return wasEventProcessed;
  }

  private boolean enterOn()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    StatusOnRunning aStatusOnRunning = statusOnRunning;
    switch (aStatusOn)
    {
      case Null:
        setStatusOn(StatusOn.Running);
        wasEventProcessed = true;
        break;
    }

    switch (aStatusOnRunning)
    {
      case Null:
        setStatusOnRunning(StatusOnRunning.Play);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean exitOn()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    StatusOnRunning aStatusOnRunning = statusOnRunning;
    switch (aStatusOn)
    {
      case Running:
        setStatusOn(StatusOn.Null);
        wasEventProcessed = true;
        break;
    }

    switch (aStatusOnRunning)
    {
      case Play:
        setStatusOnRunning(StatusOnRunning.Null);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean enterOff()
  {
    boolean wasEventProcessed = false;
    
    StatusOff aStatusOff = statusOff;
    switch (aStatusOff)
    {
      case Null:
        setStatusOff(StatusOff.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean exitOff()
  {
    boolean wasEventProcessed = false;
    
    StatusOff aStatusOff = statusOff;
    switch (aStatusOff)
    {
      case Idle:
        setStatusOff(StatusOff.Null);
        wasEventProcessed = true;
        break;
      case Full:
        setStatusOff(StatusOff.Null);
        wasEventProcessed = true;
        break;
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
      case Off:
        exitOff();
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
        if (statusOn == StatusOn.Null) { setStatusOn(StatusOn.Running); }
        break;
      case Off:
        if (statusOff == StatusOff.Null) { setStatusOff(StatusOff.Idle); }
        break;
    }
  }

  private void exitStatusOn()
  {
    switch(statusOn)
    {
      case Running:
        exitOn();
        break;
    }
  }

  private void setStatusOn(StatusOn aStatusOn)
  {
    statusOn = aStatusOn;
    if (status != Status.On && aStatusOn != StatusOn.Null) { setStatus(Status.On); }

    // entry actions and do activities
    switch(statusOn)
    {
      case Running:
        if (statusOnRunning == StatusOnRunning.Null) { setStatusOnRunning(StatusOnRunning.Play); }
        break;
    }
  }

  private void setStatusOnRunning(StatusOnRunning aStatusOnRunning)
  {
    statusOnRunning = aStatusOnRunning;
    if (statusOn != StatusOn.Running && aStatusOnRunning != StatusOnRunning.Null) { setStatusOn(StatusOn.Running); }
  }

  private void setStatusOff(StatusOff aStatusOff)
  {
    statusOff = aStatusOff;
    if (status != Status.Off && aStatusOff != StatusOff.Null) { setStatus(Status.Off); }
  }

  public void delete()
  {}

}