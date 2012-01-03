/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

public class CourseC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseC Attributes
  private List<String> logs;

  //CourseC State Machines
  enum Status { Open, Closed }
  private Status status;

  //CourseC Do Activity Threads
  Thread doActivityStatusClosedThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseC()
  {
    logs = new ArrayList<String>();
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
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean flip()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Open:
        setStatus(Status.Closed);
        wasEventProcessed = true;
        break;
      case Closed:
        exitStatus();
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
      case Closed:
        if (doActivityStatusClosedThread != null) { doActivityStatusClosedThread.interrupt(); }
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
        addLog("Open Entry");
        break;
      case Closed:
        addLog("Closed Entry");
        doActivityStatusClosedThread = new DoActivityThread(this,"doActivityStatusClosed");
        break;
    }
  }

  private void doActivityStatusClosed()
  {
    try
    {
      Thread.sleep(400);
        addLog("Do Activity On Closed");
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    CourseC controller;
    String doActivityMethodName;
    
    public DoActivityThread(CourseC aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityStatusClosed".equals(doActivityMethodName))
      {
        controller.doActivityStatusClosed();
      }
    }
  }

  public void delete()
  {}

}