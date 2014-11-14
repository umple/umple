/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 4 "LibraryLoanStateMachine.ump"
public class Loan
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Loan Attributes
  private int loanStartTime;
  private int deadline;

  //Loan State Machines
  enum State { initial, outstanding, recalled, overdue, returned, lost }
  private State state;

  //Helper Variables
  private TimedEventHandler timeoutoutstandingTooverdueHandler;
  private TimedEventHandler timeoutrecalledTooverdueHandler;
  private TimedEventHandler timeoutoverdueTooverdueHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Loan(int aLoanStartTime)
  {
    loanStartTime = aLoanStartTime;
    deadline = 1209600000;
    setState(State.initial);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLoanStartTime(int aLoanStartTime)
  {
    boolean wasSet = false;
    loanStartTime = aLoanStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDeadline(int aDeadline)
  {
    boolean wasSet = false;
    deadline = aDeadline;
    wasSet = true;
    return wasSet;
  }

  /**
   * Loan due in 14 days; can be extended for 7; fines when late each 2 days
   */

  public int getLoanTime()
  {
    return 1000*60*60*24*14;
  }

  public int getExtensionTime()
  {
    return 1000*60*60*24*7;
  }

  public int getFineIncrementInterval()
  {
    return 1000*60*60*24*2;
  }

  /**
   * Timestamp in ms when the load was initiated
   */
  public int getLoanStartTime()
  {
    return loanStartTime;
  }

  /**
   * Number of ms to the loan becoming due from entry to current state
   * 2 weeks
   */
  public int getDeadline()
  {
    return deadline;
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  private boolean __autotransition11__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case initial:
        setState(State.outstanding);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean extend()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case outstanding:
        // line 27 "LibraryLoanStateMachine.ump"
        deadline = getExtensionTime();
        setState(State.outstanding);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean returnitem()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case outstanding:
        exitState();
        setState(State.returned);
        wasEventProcessed = true;
        break;
      case recalled:
        exitState();
        setState(State.returned);
        wasEventProcessed = true;
        break;
      case overdue:
        exitState();
        setState(State.returned);
        wasEventProcessed = true;
        break;
      case lost:
        // line 54 "LibraryLoanStateMachine.ump"
        refundReplacementCost();
        setState(State.returned);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean recall()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case outstanding:
        exitState();
        // line 29 "LibraryLoanStateMachine.ump"
        sendRecallNotice();
        setState(State.recalled);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutoutstandingTooverdue()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case outstanding:
        exitState();
        setState(State.overdue);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean declareLost()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case outstanding:
        exitState();
        setState(State.lost);
        wasEventProcessed = true;
        break;
      case recalled:
        exitState();
        setState(State.lost);
        wasEventProcessed = true;
        break;
      case overdue:
        exitState();
        setState(State.lost);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutrecalledTooverdue()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case recalled:
        exitState();
        setState(State.overdue);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutoverdueTooverdue()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case overdue:
        setState(State.overdue);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitState()
  {
    switch(state)
    {
      case outstanding:
        stopTimeoutoutstandingTooverdueHandler();
        break;
      case recalled:
        stopTimeoutrecalledTooverdueHandler();
        break;
      case overdue:
        stopTimeoutoverdueTooverdueHandler();
        break;
    }
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case initial:
        // line 19 "LibraryLoanStateMachine.ump"
        deadline = getLoanTime();
        loanStartTime = currentTime();
        __autotransition11__();
        break;
      case outstanding:
        startTimeoutoutstandingTooverdueHandler();
        break;
      case recalled:
        // line 35 "LibraryLoanStateMachine.ump"
        deadline = deadline - (currentTime() - loanStartTime);
        startTimeoutrecalledTooverdueHandler();
        break;
      case overdue:
        // line 41 "LibraryLoanStateMachine.ump"
        assessFine(); sendOverdueNotice();
        startTimeoutoverdueTooverdueHandler();
        break;
      case lost:
        // line 51 "LibraryLoanStateMachine.ump"
        assessReplacementCost();
        break;
    }
  }

  private void startTimeoutoutstandingTooverdueHandler()
  {
    timeoutoutstandingTooverdueHandler = new TimedEventHandler(this,"timeoutoutstandingTooverdue",deadline);
  }

  private void stopTimeoutoutstandingTooverdueHandler()
  {
    timeoutoutstandingTooverdueHandler.stop();
  }

  private void startTimeoutrecalledTooverdueHandler()
  {
    timeoutrecalledTooverdueHandler = new TimedEventHandler(this,"timeoutrecalledTooverdue",deadline);
  }

  private void stopTimeoutrecalledTooverdueHandler()
  {
    timeoutrecalledTooverdueHandler.stop();
  }

  private void startTimeoutoverdueTooverdueHandler()
  {
    timeoutoverdueTooverdueHandler = new TimedEventHandler(this,"timeoutoverdueTooverdue",getFineIncrementInterval());
  }

  private void stopTimeoutoverdueTooverdueHandler()
  {
    timeoutoverdueTooverdueHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private Loan controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(Loan aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutoutstandingTooverdue".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutoutstandingTooverdue();
        if (shouldRestart)
        {
          controller.startTimeoutoutstandingTooverdueHandler();
        }
        return;
      }
      if ("timeoutrecalledTooverdue".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutrecalledTooverdue();
        if (shouldRestart)
        {
          controller.startTimeoutrecalledTooverdueHandler();
        }
        return;
      }
      if ("timeoutoverdueTooverdue".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutoverdueTooverdue();
        if (shouldRestart)
        {
          controller.startTimeoutoverdueTooverdueHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}

  // line 57 "LibraryLoanStateMachine.ump"
  public void refundReplacementCost(){
    
  }

  // line 58 "LibraryLoanStateMachine.ump"
  public void sendRecallNotice(){
    
  }

  // line 59 "LibraryLoanStateMachine.ump"
  public void assessFine(){
    
  }

  // line 60 "LibraryLoanStateMachine.ump"
  public void sendOverdueNotice(){
    
  }

  // line 61 "LibraryLoanStateMachine.ump"
  public void assessReplacementCost(){
    
  }

  // line 62 "LibraryLoanStateMachine.ump"
  public int currentTime(){
    return 1;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "loanTime" + ":" + getLoanTime()+ "," +
            "extensionTime" + ":" + getExtensionTime()+ "," +
            "fineIncrementInterval" + ":" + getFineIncrementInterval()+ "," +
            "loanStartTime" + ":" + getLoanStartTime()+ "," +
            "deadline" + ":" + getDeadline()+ "]"
     + outputString;
  }
}