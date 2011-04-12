/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.statemachine.test;

public class CourseB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseB Attributes
  private String log;

  //CourseB State Machines
  enum Status { Open, Closed }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseB()
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

    switch (status)
    {
      case Open:
        exitStatus();
        setStatus(Status.Closed);
        wasEventProcessed = true;
        break;
      case Closed:
        setStatus(Status.Open);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case Open:
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
        log = "entry called";
        break;
    }
  }

  public void delete()
  {}

}