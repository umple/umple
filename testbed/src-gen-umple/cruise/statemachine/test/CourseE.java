/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 41 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseE
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseE Attributes
  private List<String> logs;

  //CourseE State Machines
  enum Status { Off, Sleep, On }
  enum StatusOn { Null, Play, Pause }
  private Status status;
  private StatusOn statusOn;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseE()
  {
    logs = new ArrayList<String>();
    setStatusOn(StatusOn.Null);
    setStatus(Status.Off);
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

  public boolean turnOn()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Off:
        exitStatus();
        setStatus(Status.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean turnSleep()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Off:
        exitStatus();
        setStatus(Status.Sleep);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean wake()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Sleep:
        exitStatus();
        setStatusOn(StatusOn.Pause);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
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

  private boolean enterOn()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    switch (aStatusOn)
    {
      case Null:
        setStatusOn(StatusOn.Play);
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
      case Play:
        setStatusOn(StatusOn.Null);
        wasEventProcessed = true;
        break;
      case Pause:
        setStatusOn(StatusOn.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean push()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    switch (aStatusOn)
    {
      case Play:
        exitStatusOn();
        setStatusOn(StatusOn.Pause);
        wasEventProcessed = true;
        break;
      case Pause:
        exitStatusOn();
        setStatusOn(StatusOn.Play);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean standby()
  {
    boolean wasEventProcessed = false;
    
    StatusOn aStatusOn = statusOn;
    switch (aStatusOn)
    {
      case Pause:
        exitStatusOn();
        setStatus(Status.Sleep);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  @umplesourcefile(line={51,58,64}, file={"TestHarnessStateMachineJava.ump","TestHarnessStateMachineJava.ump","TestHarnessStateMachineJava.ump"}, javaline={268,273,279}, length={1,1,1})
  private void exitStatus()
  {
    switch(status)
    {
      case Off:
        // line 51 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Exit Off");
        break;
      case Sleep:
        // line 58 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Exit Sleep");
        break;
      case On:
        exitOn();
        // line 64 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Exit On");
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case Off:
        // line 50 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Enter Off");
        break;
      case Sleep:
        // line 57 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Enter Sleep");
        break;
      case On:
        // line 63 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Enter On");
        if (statusOn == StatusOn.Null) { setStatusOn(StatusOn.Play); }
        break;
    }
  }

  @umplesourcefile(line={70,76}, file={"TestHarnessStateMachineJava.ump","TestHarnessStateMachineJava.ump"}, javaline={312,317}, length={1,1})
  private void exitStatusOn()
  {
    switch(statusOn)
    {
      case Play:
        // line 70 "TestHarnessStateMachineJava.ump"
        addLog("Exit Play");
        break;
      case Pause:
        // line 76 "TestHarnessStateMachineJava.ump"
        addLog("Exit Pause");
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
      case Play:
        // line 69 "TestHarnessStateMachineJava.ump"
        addLog("Enter Play");
        break;
      case Pause:
        // line 75 "TestHarnessStateMachineJava.ump"
        addLog("Enter Pause");
        break;
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}