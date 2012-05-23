/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

public class CourseL
{

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
    }

    switch (aStatusFanIdle)
    {
      case Null:
        setStatusFanIdle(StatusFanIdle.FanIdle);
        wasEventProcessed = true;
        break;
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

  public void delete()
  {
    addLog("deleted");
  }

}