/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

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

    switch (status)
    {
      case Open:
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

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case Open:
        addLog("Open Entry");
        new DoActivityThread(this,"doActivityStatusOpen");
        break;
      case Closed:
        addLog("Closed Entry");
        break;
    }
  }

  private void doActivityStatusOpen() throws InterruptedException
  {
    Thread.sleep(400);
        addLog("Do Activity On Open");
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
      try
      {
        if ("doActivityStatusOpen".equals(doActivityMethodName))
        {
          controller.doActivityStatusOpen();
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void delete()
  {}

}