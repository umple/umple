/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.statemachine.test;

// line 3 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseB
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
    
    Status aStatus = status;
    switch (aStatus)
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
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={11}, file={"TestHarnessStateMachineJava.ump"}, javaline={91}, length={1})
  private void exitStatus()
  {
    switch(status)
    {
      case Open:
        // line 11 "../../../../src/TestHarnessStateMachineJava.ump"
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
        // line 10 "../../../../src/TestHarnessStateMachineJava.ump"
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