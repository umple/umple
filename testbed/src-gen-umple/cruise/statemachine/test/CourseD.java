/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 9 "../../../../src/TestHarnessStateMachine.ump"
public class CourseD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseD State Machines
  enum Status { Open, Closed }
  private Status status;

  //Helper Variables
  private TimedEventHandler timeoutOpenToClosedHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseD()
  {
    setStatus(Status.Open);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean timeoutOpenToClosed()
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
        stopTimeoutOpenToClosedHandler();
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
        startTimeoutOpenToClosedHandler();
        break;
    }
  }

  private void startTimeoutOpenToClosedHandler()
  {
    timeoutOpenToClosedHandler = new TimedEventHandler(this,"timeoutOpenToClosed",1);
  }

  private void stopTimeoutOpenToClosedHandler()
  {
    timeoutOpenToClosedHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private CourseD controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(CourseD aController, String aTimeoutMethodName, double aHowLongInSeconds)
    {
      controller = aController;
      timeoutMethodName = aTimeoutMethodName;
      howLongInSeconds = aHowLongInSeconds;
      timer = new Timer();
      timer.schedule(this, (long)howLongInSeconds*1000);
    }
    
    public void stop()
    {
      timer.cancel();
    }
    
    public void run ()
    {
      if ("timeoutOpenToClosed".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutOpenToClosed();
        if (shouldRestart)
        {
          controller.startTimeoutOpenToClosedHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}

}