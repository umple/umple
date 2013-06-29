/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 253 "../../../../src/TestHarnessStateMachine.ump"
public class CourseX
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseX Attributes
  private List<String> logs;

  //CourseX State Machines
  enum Status { Open }
  enum StatusOpen { Null, white, green, black }
  enum StatusOpenGreen { Null, greenStatus }
  enum StatusOpenGreenGreenStatus { Null, greenStatusOn }
  private Status status;
  private StatusOpen statusOpen;
  private StatusOpenGreen statusOpenGreen;
  private StatusOpenGreenGreenStatus statusOpenGreenGreenStatus;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseX()
  {
    logs = new ArrayList<String>();
    setStatusOpen(StatusOpen.Null);
    setStatusOpenGreen(StatusOpenGreen.Null);
    setStatusOpenGreenGreenStatus(StatusOpenGreenGreenStatus.Null);
    setStatus(Status.Open);
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
    if (statusOpen != StatusOpen.Null) { answer += "." + statusOpen.toString(); }
    if (statusOpenGreen != StatusOpenGreen.Null) { answer += "." + statusOpenGreen.toString(); }
    if (statusOpenGreenGreenStatus != StatusOpenGreenGreenStatus.Null) { answer += "." + statusOpenGreenGreenStatus.toString(); }
    if (statusOpenGreenGreenStatus != StatusOpenGreenGreenStatus.Null) { answer += "." + statusOpenGreenGreenStatus.toString(); }
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public StatusOpen getStatusOpen()
  {
    return statusOpen;
  }

  public StatusOpenGreen getStatusOpenGreen()
  {
    return statusOpenGreen;
  }

  public StatusOpenGreenGreenStatus getStatusOpenGreenGreenStatus()
  {
    return statusOpenGreenGreenStatus;
  }

  private boolean enterOpen()
  {
    boolean wasEventProcessed = false;
    
    StatusOpen aStatusOpen = statusOpen;
    StatusOpenGreen aStatusOpenGreen = statusOpenGreen;
    StatusOpenGreenGreenStatus aStatusOpenGreenGreenStatus = statusOpenGreenGreenStatus;
    switch (aStatusOpen)
    {
      case Null:
        setStatusOpen(StatusOpen.white);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusOpenGreen)
    {
      case Null:
        setStatusOpenGreen(StatusOpenGreen.greenStatus);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusOpenGreenGreenStatus)
    {
      case Null:
        setStatusOpenGreenGreenStatus(StatusOpenGreenGreenStatus.greenStatusOn);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitOpen()
  {
    boolean wasEventProcessed = false;
    
    StatusOpen aStatusOpen = statusOpen;
    StatusOpenGreen aStatusOpenGreen = statusOpenGreen;
    StatusOpenGreenGreenStatus aStatusOpenGreenGreenStatus = statusOpenGreenGreenStatus;
    switch (aStatusOpen)
    {
      case white:
        setStatusOpen(StatusOpen.Null);
        wasEventProcessed = true;
        break;
      case green:
        setStatusOpen(StatusOpen.Null);
        wasEventProcessed = true;
        break;
      case black:
        setStatusOpen(StatusOpen.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusOpenGreen)
    {
      case greenStatus:
        setStatusOpenGreen(StatusOpenGreen.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusOpenGreenGreenStatus)
    {
      case greenStatusOn:
        setStatusOpenGreenGreenStatus(StatusOpenGreenGreenStatus.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean e()
  {
    boolean wasEventProcessed = false;
    
    StatusOpen aStatusOpen = statusOpen;
    switch (aStatusOpen)
    {
      case white:
        setStatusOpen(StatusOpen.green);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean e2()
  {
    boolean wasEventProcessed = false;
    
    StatusOpenGreen aStatusOpenGreen = statusOpenGreen;
    switch (aStatusOpenGreen)
    {
      case greenStatus:
        exitStatusOpenGreen();
        setStatus(Status.Open);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean check()
  {
    boolean wasEventProcessed = false;
    
    StatusOpenGreenGreenStatus aStatusOpenGreenGreenStatus = statusOpenGreenGreenStatus;
    switch (aStatusOpenGreenGreenStatus)
    {
      case greenStatusOn:
        exitStatusOpenGreen();
        setStatusOpen(StatusOpen.white);
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
      case Open:
        exitOpen();
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
        if (statusOpen == StatusOpen.Null) { setStatusOpen(StatusOpen.white); }
        break;
    }
  }

  private void exitStatusOpen()
  {
    switch(statusOpen)
    {
      case green:
        exitOpen();
        break;
    }
  }

  private void setStatusOpen(StatusOpen aStatusOpen)
  {
    statusOpen = aStatusOpen;
    if (status != Status.Open && aStatusOpen != StatusOpen.Null) { setStatus(Status.Open); }

    // entry actions and do activities
    switch(statusOpen)
    {
      case white:
        // line 259 "TestHarnessStateMachine.ump"
        addLog("White entry");
        break;
      case green:
        if (statusOpenGreen == StatusOpenGreen.Null) { setStatusOpenGreen(StatusOpenGreen.greenStatus); }
        break;
    }
  }

  private void exitStatusOpenGreen()
  {
    switch(statusOpenGreen)
    {
      case greenStatus:
        exitOpen();
        break;
    }
  }

  private void setStatusOpenGreen(StatusOpenGreen aStatusOpenGreen)
  {
    statusOpenGreen = aStatusOpenGreen;
    if (statusOpen != StatusOpen.green && aStatusOpenGreen != StatusOpenGreen.Null) { setStatusOpen(StatusOpen.green); }

    // entry actions and do activities
    switch(statusOpenGreen)
    {
      case greenStatus:
        if (statusOpenGreenGreenStatus == StatusOpenGreenGreenStatus.Null) { setStatusOpenGreenGreenStatus(StatusOpenGreenGreenStatus.greenStatusOn); }
        break;
    }
  }

  private void setStatusOpenGreenGreenStatus(StatusOpenGreenGreenStatus aStatusOpenGreenGreenStatus)
  {
    statusOpenGreenGreenStatus = aStatusOpenGreenGreenStatus;
    if (statusOpenGreen != StatusOpenGreen.greenStatus && aStatusOpenGreenGreenStatus != StatusOpenGreenGreenStatus.Null) { setStatusOpenGreen(StatusOpenGreen.greenStatus); }

    // entry actions and do activities
    switch(statusOpenGreenGreenStatus)
    {
      case greenStatusOn:
        // line 265 "TestHarnessStateMachine.ump"
        addLog("GreenStatusOn Entry");
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