/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 4 "Elevator_State_Machine.ump"
public class Elevator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Elevator Attributes
  private int timer;

  //Elevator State Machines
  enum Elevator_state_machine { Idle, PrepareUp, PrepareDown, InMotion, OnFloor }
  enum Elevator_state_machinePrepareUp { Null, DoorClosingMovingUp }
  enum Elevator_state_machinePrepareDown { Null, DoorClosingMovingDown }
  enum Elevator_state_machineInMotion { Null, Moving, Stopping }
  enum Elevator_state_machineOnFloor { Null, DoorOpening, AtFloor, DoorClosing, CheckingNextDestination }
  private Elevator_state_machine elevator_state_machine;
  private Elevator_state_machinePrepareUp elevator_state_machinePrepareUp;
  private Elevator_state_machinePrepareDown elevator_state_machinePrepareDown;
  private Elevator_state_machineInMotion elevator_state_machineInMotion;
  private Elevator_state_machineOnFloor elevator_state_machineOnFloor;

  //Helper Variables
  private TimedEventHandler timeoutAtFloorToDoorClosingHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Elevator()
  {
    timer = 100;
    setElevator_state_machinePrepareUp(Elevator_state_machinePrepareUp.Null);
    setElevator_state_machinePrepareDown(Elevator_state_machinePrepareDown.Null);
    setElevator_state_machineInMotion(Elevator_state_machineInMotion.Null);
    setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.Null);
    setElevator_state_machine(Elevator_state_machine.Idle);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimer(int aTimer)
  {
    boolean wasSet = false;
    timer = aTimer;
    wasSet = true;
    return wasSet;
  }

  public int getTimer()
  {
    return timer;
  }

  public String getElevator_state_machineFullName()
  {
    String answer = elevator_state_machine.toString();
    if (elevator_state_machinePrepareUp != Elevator_state_machinePrepareUp.Null) { answer += "." + elevator_state_machinePrepareUp.toString(); }
    if (elevator_state_machinePrepareDown != Elevator_state_machinePrepareDown.Null) { answer += "." + elevator_state_machinePrepareDown.toString(); }
    if (elevator_state_machineInMotion != Elevator_state_machineInMotion.Null) { answer += "." + elevator_state_machineInMotion.toString(); }
    if (elevator_state_machineOnFloor != Elevator_state_machineOnFloor.Null) { answer += "." + elevator_state_machineOnFloor.toString(); }
    return answer;
  }

  public Elevator_state_machine getElevator_state_machine()
  {
    return elevator_state_machine;
  }

  public Elevator_state_machinePrepareUp getElevator_state_machinePrepareUp()
  {
    return elevator_state_machinePrepareUp;
  }

  public Elevator_state_machinePrepareDown getElevator_state_machinePrepareDown()
  {
    return elevator_state_machinePrepareDown;
  }

  public Elevator_state_machineInMotion getElevator_state_machineInMotion()
  {
    return elevator_state_machineInMotion;
  }

  public Elevator_state_machineOnFloor getElevator_state_machineOnFloor()
  {
    return elevator_state_machineOnFloor;
  }

  public boolean upRequest()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machine aElevator_state_machine = elevator_state_machine;
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machine)
    {
      case Idle:
        setElevator_state_machine(Elevator_state_machine.PrepareUp);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aElevator_state_machineOnFloor)
    {
      case CheckingNextDestination:
        exitElevator_state_machine();
        setElevator_state_machine(Elevator_state_machine.PrepareUp);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean downRequest()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machine aElevator_state_machine = elevator_state_machine;
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machine)
    {
      case Idle:
        setElevator_state_machine(Elevator_state_machine.PrepareDown);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aElevator_state_machineOnFloor)
    {
      case CheckingNextDestination:
        exitElevator_state_machine();
        setElevator_state_machine(Elevator_state_machine.PrepareDown);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean started()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machine aElevator_state_machine = elevator_state_machine;
    switch (aElevator_state_machine)
    {
      case PrepareUp:
        exitElevator_state_machine();
        setElevator_state_machineInMotion(Elevator_state_machineInMotion.Moving);
        wasEventProcessed = true;
        break;
      case PrepareDown:
        exitElevator_state_machine();
        setElevator_state_machineInMotion(Elevator_state_machineInMotion.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterPrepareUp()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machinePrepareUp aElevator_state_machinePrepareUp = elevator_state_machinePrepareUp;
    switch (aElevator_state_machinePrepareUp)
    {
      case Null:
        setElevator_state_machinePrepareUp(Elevator_state_machinePrepareUp.DoorClosingMovingUp);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitPrepareUp()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machinePrepareUp aElevator_state_machinePrepareUp = elevator_state_machinePrepareUp;
    switch (aElevator_state_machinePrepareUp)
    {
      case DoorClosingMovingUp:
        setElevator_state_machinePrepareUp(Elevator_state_machinePrepareUp.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean doorClosed()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machinePrepareUp aElevator_state_machinePrepareUp = elevator_state_machinePrepareUp;
    Elevator_state_machinePrepareDown aElevator_state_machinePrepareDown = elevator_state_machinePrepareDown;
    switch (aElevator_state_machinePrepareUp)
    {
      case DoorClosingMovingUp:
        exitElevator_state_machine();
        // line 13 "Elevator_State_Machine.ump"
        goUp();
        setElevator_state_machine(Elevator_state_machine.InMotion);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aElevator_state_machinePrepareDown)
    {
      case DoorClosingMovingDown:
        exitElevator_state_machine();
        // line 19 "Elevator_State_Machine.ump"
        goDown();
        setElevator_state_machine(Elevator_state_machine.InMotion);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterPrepareDown()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machinePrepareDown aElevator_state_machinePrepareDown = elevator_state_machinePrepareDown;
    switch (aElevator_state_machinePrepareDown)
    {
      case Null:
        setElevator_state_machinePrepareDown(Elevator_state_machinePrepareDown.DoorClosingMovingDown);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitPrepareDown()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machinePrepareDown aElevator_state_machinePrepareDown = elevator_state_machinePrepareDown;
    switch (aElevator_state_machinePrepareDown)
    {
      case DoorClosingMovingDown:
        setElevator_state_machinePrepareDown(Elevator_state_machinePrepareDown.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterInMotion()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineInMotion aElevator_state_machineInMotion = elevator_state_machineInMotion;
    switch (aElevator_state_machineInMotion)
    {
      case Null:
        setElevator_state_machineInMotion(Elevator_state_machineInMotion.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitInMotion()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineInMotion aElevator_state_machineInMotion = elevator_state_machineInMotion;
    switch (aElevator_state_machineInMotion)
    {
      case Moving:
        setElevator_state_machineInMotion(Elevator_state_machineInMotion.Null);
        wasEventProcessed = true;
        break;
      case Stopping:
        setElevator_state_machineInMotion(Elevator_state_machineInMotion.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean approachingFloor()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineInMotion aElevator_state_machineInMotion = elevator_state_machineInMotion;
    switch (aElevator_state_machineInMotion)
    {
      case Moving:
        if (floorRequested())
        {
          setElevator_state_machineInMotion(Elevator_state_machineInMotion.Moving);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean approachedFloor()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineInMotion aElevator_state_machineInMotion = elevator_state_machineInMotion;
    switch (aElevator_state_machineInMotion)
    {
      case Moving:
        if (floorRequested())
        {
        // line 27 "Elevator_State_Machine.ump"
          stop();
          setElevator_state_machineInMotion(Elevator_state_machineInMotion.Stopping);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean stopped()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineInMotion aElevator_state_machineInMotion = elevator_state_machineInMotion;
    switch (aElevator_state_machineInMotion)
    {
      case Stopping:
        exitElevator_state_machine();
        // line 30 "Elevator_State_Machine.ump"
        openDoor();
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorOpening);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterOnFloor()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case Null:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorOpening);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitOnFloor()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case DoorOpening:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.Null);
        wasEventProcessed = true;
        break;
      case AtFloor:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.Null);
        wasEventProcessed = true;
        break;
      case DoorClosing:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.Null);
        wasEventProcessed = true;
        break;
      case CheckingNextDestination:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean doorOpened()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case DoorOpening:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.AtFloor);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutAtFloorToDoorClosing()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case AtFloor:
        if (obstruction())
        {
          exitElevator_state_machineOnFloor();
          setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorClosing);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean doorClosingRequest()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case AtFloor:
        exitElevator_state_machineOnFloor();
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorClosing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean doorCLosed()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case DoorClosing:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.CheckingNextDestination);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean obstruction()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case DoorClosing:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorOpening);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean doorOpeningRequest()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case DoorClosing:
        setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorOpening);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean noRequest()
  {
    boolean wasEventProcessed = false;
    
    Elevator_state_machineOnFloor aElevator_state_machineOnFloor = elevator_state_machineOnFloor;
    switch (aElevator_state_machineOnFloor)
    {
      case CheckingNextDestination:
        exitElevator_state_machine();
        setElevator_state_machine(Elevator_state_machine.Idle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitElevator_state_machine()
  {
    switch(elevator_state_machine)
    {
      case PrepareUp:
        exitPrepareUp();
        break;
      case PrepareDown:
        exitPrepareDown();
        break;
      case InMotion:
        exitInMotion();
        break;
      case OnFloor:
        exitOnFloor();
        break;
    }
  }

  private void setElevator_state_machine(Elevator_state_machine aElevator_state_machine)
  {
    elevator_state_machine = aElevator_state_machine;

    // entry actions and do activities
    switch(elevator_state_machine)
    {
      case PrepareUp:
        if (elevator_state_machinePrepareUp == Elevator_state_machinePrepareUp.Null) { setElevator_state_machinePrepareUp(Elevator_state_machinePrepareUp.DoorClosingMovingUp); }
        break;
      case PrepareDown:
        if (elevator_state_machinePrepareDown == Elevator_state_machinePrepareDown.Null) { setElevator_state_machinePrepareDown(Elevator_state_machinePrepareDown.DoorClosingMovingDown); }
        break;
      case InMotion:
        if (elevator_state_machineInMotion == Elevator_state_machineInMotion.Null) { setElevator_state_machineInMotion(Elevator_state_machineInMotion.Moving); }
        break;
      case OnFloor:
        if (elevator_state_machineOnFloor == Elevator_state_machineOnFloor.Null) { setElevator_state_machineOnFloor(Elevator_state_machineOnFloor.DoorOpening); }
        break;
    }
  }

  private void setElevator_state_machinePrepareUp(Elevator_state_machinePrepareUp aElevator_state_machinePrepareUp)
  {
    elevator_state_machinePrepareUp = aElevator_state_machinePrepareUp;
    if (elevator_state_machine != Elevator_state_machine.PrepareUp && aElevator_state_machinePrepareUp != Elevator_state_machinePrepareUp.Null) { setElevator_state_machine(Elevator_state_machine.PrepareUp); }
  }

  private void setElevator_state_machinePrepareDown(Elevator_state_machinePrepareDown aElevator_state_machinePrepareDown)
  {
    elevator_state_machinePrepareDown = aElevator_state_machinePrepareDown;
    if (elevator_state_machine != Elevator_state_machine.PrepareDown && aElevator_state_machinePrepareDown != Elevator_state_machinePrepareDown.Null) { setElevator_state_machine(Elevator_state_machine.PrepareDown); }
  }

  private void setElevator_state_machineInMotion(Elevator_state_machineInMotion aElevator_state_machineInMotion)
  {
    elevator_state_machineInMotion = aElevator_state_machineInMotion;
    if (elevator_state_machine != Elevator_state_machine.InMotion && aElevator_state_machineInMotion != Elevator_state_machineInMotion.Null) { setElevator_state_machine(Elevator_state_machine.InMotion); }
  }

  private void exitElevator_state_machineOnFloor()
  {
    switch(elevator_state_machineOnFloor)
    {
      case AtFloor:
        stopTimeoutAtFloorToDoorClosingHandler();
        break;
    }
  }

  private void setElevator_state_machineOnFloor(Elevator_state_machineOnFloor aElevator_state_machineOnFloor)
  {
    elevator_state_machineOnFloor = aElevator_state_machineOnFloor;
    if (elevator_state_machine != Elevator_state_machine.OnFloor && aElevator_state_machineOnFloor != Elevator_state_machineOnFloor.Null) { setElevator_state_machine(Elevator_state_machine.OnFloor); }

    // entry actions and do activities
    switch(elevator_state_machineOnFloor)
    {
      case AtFloor:
        startTimeoutAtFloorToDoorClosingHandler();
        break;
    }
  }

  private void startTimeoutAtFloorToDoorClosingHandler()
  {
    timeoutAtFloorToDoorClosingHandler = new TimedEventHandler(this,"timeoutAtFloorToDoorClosing",timer);
  }

  private void stopTimeoutAtFloorToDoorClosingHandler()
  {
    timeoutAtFloorToDoorClosingHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private Elevator controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(Elevator aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutAtFloorToDoorClosing".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutAtFloorToDoorClosing();
        if (shouldRestart)
        {
          controller.startTimeoutAtFloorToDoorClosingHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}

  // line 55 "Elevator_State_Machine.ump"
  public void goUp(){
    
  }

  // line 56 "Elevator_State_Machine.ump"
  public void goDown(){
    
  }

  // line 57 "Elevator_State_Machine.ump"
  public void stop(){
    
  }

  // line 58 "Elevator_State_Machine.ump"
  public void openDoor(){
    
  }

  // line 59 "Elevator_State_Machine.ump"
  public Boolean floorRequested(){
    return false;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "timer" + ":" + getTimer()+ "]"
     + outputString;
  }
}