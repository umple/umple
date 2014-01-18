/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 99 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseL
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseL Attributes
  private List<String> logs;

  //CourseL State Machines
  enum Status { On }
  enum StatusMotorIdle { Null, MotorIdle, Final }
  enum StatusFanIdle { Null, FanIdle, Final }
  private Status status;
  private StatusMotorIdle statusMotorIdle;
  private StatusFanIdle statusFanIdle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseL()
  {
    logs = new ArrayList<String>();
    setStatusMotorIdle(StatusMotorIdle.Null);
    setStatusFanIdle(StatusFanIdle.Null);
    setStatus(Status.On);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addLog(String aLog)
  {
    boolean wasAdded = false;
    wasAdded = logs.add(aLog);
    return wasAdded;
  }

  public boolean removeLog(String aLog)
  {
    boolean wasRemoved = false;
    wasRemoved = logs.remove(aLog);
    return wasRemoved;
  }

  public String getLog(int index)
  {
    String aLog = logs.get(index);
    return aLog;
  }

  public String[] getLogs()
  {
    String[] newLogs = logs.toArray(new String[logs.size()]);
    return newLogs;
  }

  public int numberOfLogs()
  {
    int number = logs.size();
    return number;
  }

  public boolean hasLogs()
  {
    boolean has = logs.size() > 0;
    return has;
  }

  public int indexOfLog(String aLog)
  {
    int index = logs.indexOf(aLog);
    return index;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    if (statusMotorIdle != StatusMotorIdle.Null) { answer += "." + statusMotorIdle.toString(); }
    if (statusFanIdle != StatusFanIdle.Null) { answer += "." + statusFanIdle.toString(); }
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public StatusMotorIdle getStatusMotorIdle()
  {
    return statusMotorIdle;
  }

  public StatusFanIdle getStatusFanIdle()
  {
    return statusFanIdle;
  }

  private boolean enterOn()
  {
    boolean wasEventProcessed = false;
    
    StatusMotorIdle aStatusMotorIdle = statusMotorIdle;
    StatusFanIdle aStatusFanIdle = statusFanIdle;
    switch (aStatusMotorIdle)
    {
      case Null:
        setStatusMotorIdle(StatusMotorIdle.MotorIdle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusFanIdle)
    {
      case Null:
        setStatusFanIdle(StatusFanIdle.FanIdle);
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
    
    StatusMotorIdle aStatusMotorIdle = statusMotorIdle;
    StatusFanIdle aStatusFanIdle = statusFanIdle;
    switch (aStatusMotorIdle)
    {
      case MotorIdle:
        setStatusMotorIdle(StatusMotorIdle.Null);
        wasEventProcessed = true;
        break;
      case Final:
        setStatusMotorIdle(StatusMotorIdle.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusFanIdle)
    {
      case FanIdle:
        setStatusFanIdle(StatusFanIdle.Null);
        wasEventProcessed = true;
        break;
      case Final:
        setStatusFanIdle(StatusFanIdle.Null);
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
    
    StatusMotorIdle aStatusMotorIdle = statusMotorIdle;
    switch (aStatusMotorIdle)
    {
      case MotorIdle:
        setStatusMotorIdle(StatusMotorIdle.Final);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean flop()
  {
    boolean wasEventProcessed = false;
    
    StatusFanIdle aStatusFanIdle = statusFanIdle;
    switch (aStatusFanIdle)
    {
      case FanIdle:
        setStatusFanIdle(StatusFanIdle.Final);
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
        if (statusMotorIdle == StatusMotorIdle.Null) { setStatusMotorIdle(StatusMotorIdle.MotorIdle); }
        if (statusFanIdle == StatusFanIdle.Null) { setStatusFanIdle(StatusFanIdle.FanIdle); }
        break;
    }
  }

  private void setStatusMotorIdle(StatusMotorIdle aStatusMotorIdle)
  {
    statusMotorIdle = aStatusMotorIdle;
    if (status != Status.On && aStatusMotorIdle != StatusMotorIdle.Null) { setStatus(Status.On); }

    // entry actions and do activities
    switch(statusMotorIdle)
    {
      case Final:
        delete();
        break;
    }
  }

  private void setStatusFanIdle(StatusFanIdle aStatusFanIdle)
  {
    statusFanIdle = aStatusFanIdle;
    if (status != Status.On && aStatusFanIdle != StatusFanIdle.Null) { setStatus(Status.On); }

    // entry actions and do activities
    switch(statusFanIdle)
    {
      case Final:
        delete();
        break;
    }
  }

  @umplesourcefile(line={124},file={"TestHarnessStateMachineJava.ump"},javaline={269},length={1})
  public void delete()
  {
    // line 124 "../../../../src/TestHarnessStateMachineJava.ump"
    addLog("deleted");
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}