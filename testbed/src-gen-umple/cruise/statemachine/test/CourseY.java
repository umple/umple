/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 276 "../../../../src/TestHarnessStateMachine.ump"
public class CourseY
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseY Attributes
  private List<String> logs;

  //CourseY State Machines
  enum ActiveStateMachine { activeTopLevelState }
  enum ActiveStateMachineActiveTopLevelState { Null, thread1 }
  private ActiveStateMachine activeStateMachine;
  private ActiveStateMachineActiveTopLevelState activeStateMachineActiveTopLevelState;

  //CourseY Do Activity Threads
  Thread doActivityActiveTopLevelStateThread1Thread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseY()
  {
    logs = new ArrayList<String>();
    setActiveStateMachineActiveTopLevelState(ActiveStateMachineActiveTopLevelState.Null);
    setActiveStateMachine(ActiveStateMachine.activeTopLevelState);
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

  public String getActiveStateMachineFullName()
  {
    String answer = activeStateMachine.toString();
    if (activeStateMachineActiveTopLevelState != ActiveStateMachineActiveTopLevelState.Null) { answer += "." + activeStateMachineActiveTopLevelState.toString(); }
    return answer;
  }

  public ActiveStateMachine getActiveStateMachine()
  {
    return activeStateMachine;
  }

  public ActiveStateMachineActiveTopLevelState getActiveStateMachineActiveTopLevelState()
  {
    return activeStateMachineActiveTopLevelState;
  }

  private boolean enterActiveTopLevelState()
  {
    boolean wasEventProcessed = false;
    
    ActiveStateMachineActiveTopLevelState aActiveStateMachineActiveTopLevelState = activeStateMachineActiveTopLevelState;
    switch (aActiveStateMachineActiveTopLevelState)
    {
      case Null:
        setActiveStateMachineActiveTopLevelState(ActiveStateMachineActiveTopLevelState.thread1);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitActiveTopLevelState()
  {
    boolean wasEventProcessed = false;
    
    ActiveStateMachineActiveTopLevelState aActiveStateMachineActiveTopLevelState = activeStateMachineActiveTopLevelState;
    switch (aActiveStateMachineActiveTopLevelState)
    {
      case thread1:
        setActiveStateMachineActiveTopLevelState(ActiveStateMachineActiveTopLevelState.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitActiveStateMachine()
  {
    switch(activeStateMachine)
    {
      case activeTopLevelState:
        exitActiveTopLevelState();
        break;
    }
  }

  private void setActiveStateMachine(ActiveStateMachine aActiveStateMachine)
  {
    activeStateMachine = aActiveStateMachine;

    // entry actions and do activities
    switch(activeStateMachine)
    {
      case activeTopLevelState:
        if (activeStateMachineActiveTopLevelState == ActiveStateMachineActiveTopLevelState.Null) { setActiveStateMachineActiveTopLevelState(ActiveStateMachineActiveTopLevelState.thread1); }
        break;
    }
  }

  private void exitActiveStateMachineActiveTopLevelState()
  {
    switch(activeStateMachineActiveTopLevelState)
    {
      case thread1:
        if (doActivityActiveTopLevelStateThread1Thread != null) { doActivityActiveTopLevelStateThread1Thread.interrupt(); }
        break;
    }
  }

  private void setActiveStateMachineActiveTopLevelState(ActiveStateMachineActiveTopLevelState aActiveStateMachineActiveTopLevelState)
  {
    activeStateMachineActiveTopLevelState = aActiveStateMachineActiveTopLevelState;
    if (activeStateMachine != ActiveStateMachine.activeTopLevelState && aActiveStateMachineActiveTopLevelState != ActiveStateMachineActiveTopLevelState.Null) { setActiveStateMachine(ActiveStateMachine.activeTopLevelState); }

    // entry actions and do activities
    switch(activeStateMachineActiveTopLevelState)
    {
      case thread1:
        doActivityActiveTopLevelStateThread1Thread = new DoActivityThread(this,"doActivityActiveTopLevelStateThread1");
        break;
    }
  }

  private void doActivityActiveTopLevelStateThread1()
  {
    try
    {
      addLog("Active entry");
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    CourseY controller;
    String doActivityMethodName;
    
    public DoActivityThread(CourseY aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityActiveTopLevelStateThread1".equals(doActivityMethodName))
      {
        controller.doActivityActiveTopLevelStateThread1();
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