/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 214 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseW
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseW Attributes
  private List<String> logs;

  //CourseW State Machines
  enum Status { Open }
  enum StatusOpen { Null, statusOpen }
  private Status status;
  private StatusOpen statusOpen;

  //CourseW Do Activity Threads
  Thread doActivityStatusOpenStatusOpenThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseW()
  {
    logs = new ArrayList<String>();
    setStatusOpen(StatusOpen.Null);
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

  private boolean enterOpen()
  {
    boolean wasEventProcessed = false;
    
    StatusOpen aStatusOpen = statusOpen;
    switch (aStatusOpen)
    {
      case Null:
        setStatusOpen(StatusOpen.statusOpen);
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
    switch (aStatusOpen)
    {
      case statusOpen:
        setStatusOpen(StatusOpen.Null);
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
        if (statusOpen == StatusOpen.Null) { setStatusOpen(StatusOpen.statusOpen); }
        break;
    }
  }

  private void exitStatusOpen()
  {
    switch(statusOpen)
    {
      case statusOpen:
        if (doActivityStatusOpenStatusOpenThread != null) { doActivityStatusOpenStatusOpenThread.interrupt(); }
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
      case statusOpen:
        doActivityStatusOpenStatusOpenThread = new DoActivityThread(this,"doActivityStatusOpenStatusOpen");
        break;
    }
  }

  @umplesourcefile(line={221},file={"TestHarnessStateMachineJava.ump"},javaline={193},length={1})
  private void doActivityStatusOpenStatusOpen()
  {
    try
    {
      addLog("DoActivity in nested state");
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    CourseW controller;
    String doActivityMethodName;
    
    public DoActivityThread(CourseW aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityStatusOpenStatusOpen".equals(doActivityMethodName))
      {
        controller.doActivityStatusOpenStatusOpen();
      }
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