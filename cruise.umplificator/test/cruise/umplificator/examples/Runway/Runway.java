/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "Runway.ump"
public class Runway
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Runway Attributes
  private boolean noPlaneOnRunway;
  private boolean inspectionSuccess;

  //Runway State Machines
  enum RunwayStateMachine { Open, Closed }
  enum RunwayStateMachineOpen { Null, Free, Occupied }
  enum RunwayStateMachineClosed { Null, Emergency, ReadyToOpen, Restoration }
  enum RunwayStateMachineClosedRestoration_1 { Null, Restoration_1 }
  enum RunwayStateMachineClosedRestoration_1Restoration_1 { Null, Repair, InspectRepairs }
  enum RunwayStateMachineClosedRestoration_2 { Null, Restoration_2 }
  enum RunwayStateMachineClosedRestoration_2Restoration_2 { Null, Maintenance }
  private RunwayStateMachine runwayStateMachine;
  private RunwayStateMachineOpen runwayStateMachineOpen;
  private RunwayStateMachineClosed runwayStateMachineClosed;
  private RunwayStateMachineClosedRestoration_1 runwayStateMachineClosedRestoration_1;
  private RunwayStateMachineClosedRestoration_1Restoration_1 runwayStateMachineClosedRestoration_1Restoration_1;
  private RunwayStateMachineClosedRestoration_2 runwayStateMachineClosedRestoration_2;
  private RunwayStateMachineClosedRestoration_2Restoration_2 runwayStateMachineClosedRestoration_2Restoration_2;

  //Runway Do Activity Threads
  Thread doActivityRunwayStateMachineClosedRestoration_2Restoration_2MaintenanceThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Runway()
  {
    noPlaneOnRunway = false;
    inspectionSuccess = false;
    setRunwayStateMachineOpen(RunwayStateMachineOpen.Null);
    setRunwayStateMachineClosed(RunwayStateMachineClosed.Null);
    setRunwayStateMachineClosedRestoration_1(RunwayStateMachineClosedRestoration_1.Null);
    setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.Null);
    setRunwayStateMachineClosedRestoration_2(RunwayStateMachineClosedRestoration_2.Null);
    setRunwayStateMachineClosedRestoration_2Restoration_2(RunwayStateMachineClosedRestoration_2Restoration_2.Null);
    setRunwayStateMachine(RunwayStateMachine.Open);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNoPlaneOnRunway(boolean aNoPlaneOnRunway)
  {
    boolean wasSet = false;
    noPlaneOnRunway = aNoPlaneOnRunway;
    wasSet = true;
    return wasSet;
  }

  public boolean setInspectionSuccess(boolean aInspectionSuccess)
  {
    boolean wasSet = false;
    inspectionSuccess = aInspectionSuccess;
    wasSet = true;
    return wasSet;
  }

  public boolean getNoPlaneOnRunway()
  {
    return noPlaneOnRunway;
  }

  public boolean getInspectionSuccess()
  {
    return inspectionSuccess;
  }

  public boolean isNoPlaneOnRunway()
  {
    return noPlaneOnRunway;
  }

  public boolean isInspectionSuccess()
  {
    return inspectionSuccess;
  }

  public String getRunwayStateMachineFullName()
  {
    String answer = runwayStateMachine.toString();
    if (runwayStateMachineOpen != RunwayStateMachineOpen.Null) { answer += "." + runwayStateMachineOpen.toString(); }
    if (runwayStateMachineClosed != RunwayStateMachineClosed.Null) { answer += "." + runwayStateMachineClosed.toString(); }
    if (runwayStateMachineClosedRestoration_1 != RunwayStateMachineClosedRestoration_1.Null) { answer += "." + runwayStateMachineClosedRestoration_1.toString(); }
    if (runwayStateMachineClosedRestoration_1Restoration_1 != RunwayStateMachineClosedRestoration_1Restoration_1.Null) { answer += "." + runwayStateMachineClosedRestoration_1Restoration_1.toString(); }
    if (runwayStateMachineClosedRestoration_2 != RunwayStateMachineClosedRestoration_2.Null) { answer += "." + runwayStateMachineClosedRestoration_2.toString(); }
    if (runwayStateMachineClosedRestoration_2Restoration_2 != RunwayStateMachineClosedRestoration_2Restoration_2.Null) { answer += "." + runwayStateMachineClosedRestoration_2Restoration_2.toString(); }
    if (runwayStateMachineClosedRestoration_1Restoration_1 != RunwayStateMachineClosedRestoration_1Restoration_1.Null) { answer += "." + runwayStateMachineClosedRestoration_1Restoration_1.toString(); }
    if (runwayStateMachineClosedRestoration_2Restoration_2 != RunwayStateMachineClosedRestoration_2Restoration_2.Null) { answer += "." + runwayStateMachineClosedRestoration_2Restoration_2.toString(); }
    return answer;
  }

  public RunwayStateMachine getRunwayStateMachine()
  {
    return runwayStateMachine;
  }

  public RunwayStateMachineOpen getRunwayStateMachineOpen()
  {
    return runwayStateMachineOpen;
  }

  public RunwayStateMachineClosed getRunwayStateMachineClosed()
  {
    return runwayStateMachineClosed;
  }

  public RunwayStateMachineClosedRestoration_1 getRunwayStateMachineClosedRestoration_1()
  {
    return runwayStateMachineClosedRestoration_1;
  }

  public RunwayStateMachineClosedRestoration_1Restoration_1 getRunwayStateMachineClosedRestoration_1Restoration_1()
  {
    return runwayStateMachineClosedRestoration_1Restoration_1;
  }

  public RunwayStateMachineClosedRestoration_2 getRunwayStateMachineClosedRestoration_2()
  {
    return runwayStateMachineClosedRestoration_2;
  }

  public RunwayStateMachineClosedRestoration_2Restoration_2 getRunwayStateMachineClosedRestoration_2Restoration_2()
  {
    return runwayStateMachineClosedRestoration_2Restoration_2;
  }

  public boolean alarm()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachine aRunwayStateMachine = runwayStateMachine;
    switch (aRunwayStateMachine)
    {
      case Open:
        exitRunwayStateMachine();
        setRunwayStateMachineClosed(RunwayStateMachineClosed.Emergency);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterOpen()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Null:
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Free);
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
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Free:
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Null);
        wasEventProcessed = true;
        break;
      case Occupied:
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean planeLanding()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Free:
        exitRunwayStateMachineOpen();
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Occupied);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean planeTakingOff()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Free:
        exitRunwayStateMachineOpen();
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Occupied);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean repair()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Free:
        exitRunwayStateMachineOpen();
        setRunwayStateMachineClosed(RunwayStateMachineClosed.Restoration);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean planeTakesOff()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Occupied:
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Free);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean landingComplete()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineOpen aRunwayStateMachineOpen = runwayStateMachineOpen;
    switch (aRunwayStateMachineOpen)
    {
      case Occupied:
        setRunwayStateMachineOpen(RunwayStateMachineOpen.Free);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterClosed()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineClosed aRunwayStateMachineClosed = runwayStateMachineClosed;
    RunwayStateMachineClosedRestoration_1 aRunwayStateMachineClosedRestoration_1 = runwayStateMachineClosedRestoration_1;
    RunwayStateMachineClosedRestoration_1Restoration_1 aRunwayStateMachineClosedRestoration_1Restoration_1 = runwayStateMachineClosedRestoration_1Restoration_1;
    RunwayStateMachineClosedRestoration_2 aRunwayStateMachineClosedRestoration_2 = runwayStateMachineClosedRestoration_2;
    RunwayStateMachineClosedRestoration_2Restoration_2 aRunwayStateMachineClosedRestoration_2Restoration_2 = runwayStateMachineClosedRestoration_2Restoration_2;
    switch (aRunwayStateMachineClosed)
    {
      case Null:
        setRunwayStateMachineClosed(RunwayStateMachineClosed.Emergency);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_1)
    {
      case Null:
        setRunwayStateMachineClosedRestoration_1(RunwayStateMachineClosedRestoration_1.Restoration_1);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_1Restoration_1)
    {
      case Null:
        setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.Repair);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_2)
    {
      case Null:
        setRunwayStateMachineClosedRestoration_2(RunwayStateMachineClosedRestoration_2.Restoration_2);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_2Restoration_2)
    {
      case Null:
        setRunwayStateMachineClosedRestoration_2Restoration_2(RunwayStateMachineClosedRestoration_2Restoration_2.Maintenance);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitClosed()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineClosed aRunwayStateMachineClosed = runwayStateMachineClosed;
    RunwayStateMachineClosedRestoration_1 aRunwayStateMachineClosedRestoration_1 = runwayStateMachineClosedRestoration_1;
    RunwayStateMachineClosedRestoration_1Restoration_1 aRunwayStateMachineClosedRestoration_1Restoration_1 = runwayStateMachineClosedRestoration_1Restoration_1;
    RunwayStateMachineClosedRestoration_2 aRunwayStateMachineClosedRestoration_2 = runwayStateMachineClosedRestoration_2;
    RunwayStateMachineClosedRestoration_2Restoration_2 aRunwayStateMachineClosedRestoration_2Restoration_2 = runwayStateMachineClosedRestoration_2Restoration_2;
    switch (aRunwayStateMachineClosed)
    {
      case Emergency:
        setRunwayStateMachineClosed(RunwayStateMachineClosed.Null);
        wasEventProcessed = true;
        break;
      case ReadyToOpen:
        setRunwayStateMachineClosed(RunwayStateMachineClosed.Null);
        wasEventProcessed = true;
        break;
      case Restoration:
        setRunwayStateMachineClosed(RunwayStateMachineClosed.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_1)
    {
      case Restoration_1:
        setRunwayStateMachineClosedRestoration_1(RunwayStateMachineClosedRestoration_1.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_1Restoration_1)
    {
      case Repair:
        setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.Null);
        wasEventProcessed = true;
        break;
      case InspectRepairs:
        setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_2)
    {
      case Restoration_2:
        setRunwayStateMachineClosedRestoration_2(RunwayStateMachineClosedRestoration_2.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aRunwayStateMachineClosedRestoration_2Restoration_2)
    {
      case Maintenance:
        setRunwayStateMachineClosedRestoration_2Restoration_2(RunwayStateMachineClosedRestoration_2Restoration_2.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean emergencyOver()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineClosed aRunwayStateMachineClosed = runwayStateMachineClosed;
    switch (aRunwayStateMachineClosed)
    {
      case Emergency:
        setRunwayStateMachineClosed(RunwayStateMachineClosed.ReadyToOpen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean open()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineClosed aRunwayStateMachineClosed = runwayStateMachineClosed;
    switch (aRunwayStateMachineClosed)
    {
      case ReadyToOpen:
        if (getNoPlaneOnRunway())
        {
          exitRunwayStateMachine();
          setRunwayStateMachine(RunwayStateMachine.Open);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean repairCompleted()
  {
    boolean wasEventProcessed = false;
    
    RunwayStateMachineClosedRestoration_1Restoration_1 aRunwayStateMachineClosedRestoration_1Restoration_1 = runwayStateMachineClosedRestoration_1Restoration_1;
    switch (aRunwayStateMachineClosedRestoration_1Restoration_1)
    {
      case Repair:
        setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.InspectRepairs);
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
    
    RunwayStateMachineClosedRestoration_1Restoration_1 aRunwayStateMachineClosedRestoration_1Restoration_1 = runwayStateMachineClosedRestoration_1Restoration_1;
    switch (aRunwayStateMachineClosedRestoration_1Restoration_1)
    {
      case InspectRepairs:
        if (getInspectionSuccess())
        {
          exitRunwayStateMachineClosedRestoration_1();
          setRunwayStateMachineClosed(RunwayStateMachineClosed.ReadyToOpen);
          wasEventProcessed = true;
          break;
        }
        if (!getInspectionSuccess())
        {
          setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.Repair);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitRunwayStateMachine()
  {
    switch(runwayStateMachine)
    {
      case Open:
        exitOpen();
        break;
      case Closed:
        exitClosed();
        break;
    }
  }

  private void setRunwayStateMachine(RunwayStateMachine aRunwayStateMachine)
  {
    runwayStateMachine = aRunwayStateMachine;

    // entry actions and do activities
    switch(runwayStateMachine)
    {
      case Open:
        if (runwayStateMachineOpen == RunwayStateMachineOpen.Null) { setRunwayStateMachineOpen(RunwayStateMachineOpen.Free); }
        break;
      case Closed:
        // line 28 "Runway.ump"
        closeRunway();
        if (runwayStateMachineClosed == RunwayStateMachineClosed.Null) { setRunwayStateMachineClosed(RunwayStateMachineClosed.Emergency); }
        break;
    }
  }

  private void exitRunwayStateMachineOpen()
  {
    switch(runwayStateMachineOpen)
    {
      case Free:
        // line 15 "Runway.ump"
        turnOffGreenLight();
        break;
    }
  }

  private void setRunwayStateMachineOpen(RunwayStateMachineOpen aRunwayStateMachineOpen)
  {
    runwayStateMachineOpen = aRunwayStateMachineOpen;
    if (runwayStateMachine != RunwayStateMachine.Open && aRunwayStateMachineOpen != RunwayStateMachineOpen.Null) { setRunwayStateMachine(RunwayStateMachine.Open); }

    // entry actions and do activities
    switch(runwayStateMachineOpen)
    {
      case Free:
        // line 14 "Runway.ump"
        turnOnGreenLight();
        break;
    }
  }

  private void exitRunwayStateMachineClosed()
  {
    switch(runwayStateMachineClosed)
    {
      case Restoration:
        exitClosed();
        break;
    }
  }

  private void setRunwayStateMachineClosed(RunwayStateMachineClosed aRunwayStateMachineClosed)
  {
    runwayStateMachineClosed = aRunwayStateMachineClosed;
    if (runwayStateMachine != RunwayStateMachine.Closed && aRunwayStateMachineClosed != RunwayStateMachineClosed.Null) { setRunwayStateMachine(RunwayStateMachine.Closed); }

    // entry actions and do activities
    switch(runwayStateMachineClosed)
    {
      case Restoration:
        if (runwayStateMachineClosedRestoration_1 == RunwayStateMachineClosedRestoration_1.Null) { setRunwayStateMachineClosedRestoration_1(RunwayStateMachineClosedRestoration_1.Restoration_1); }
        if (runwayStateMachineClosedRestoration_2 == RunwayStateMachineClosedRestoration_2.Null) { setRunwayStateMachineClosedRestoration_2(RunwayStateMachineClosedRestoration_2.Restoration_2); }
        break;
    }
  }

  private void exitRunwayStateMachineClosedRestoration_1()
  {
    switch(runwayStateMachineClosedRestoration_1)
    {
      case Restoration_1:
        exitClosed();
        break;
    }
  }

  private void setRunwayStateMachineClosedRestoration_1(RunwayStateMachineClosedRestoration_1 aRunwayStateMachineClosedRestoration_1)
  {
    runwayStateMachineClosedRestoration_1 = aRunwayStateMachineClosedRestoration_1;
    if (runwayStateMachineClosed != RunwayStateMachineClosed.Restoration && aRunwayStateMachineClosedRestoration_1 != RunwayStateMachineClosedRestoration_1.Null) { setRunwayStateMachineClosed(RunwayStateMachineClosed.Restoration); }

    // entry actions and do activities
    switch(runwayStateMachineClosedRestoration_1)
    {
      case Restoration_1:
        if (runwayStateMachineClosedRestoration_1Restoration_1 == RunwayStateMachineClosedRestoration_1Restoration_1.Null) { setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1.Repair); }
        break;
    }
  }

  private void setRunwayStateMachineClosedRestoration_1Restoration_1(RunwayStateMachineClosedRestoration_1Restoration_1 aRunwayStateMachineClosedRestoration_1Restoration_1)
  {
    runwayStateMachineClosedRestoration_1Restoration_1 = aRunwayStateMachineClosedRestoration_1Restoration_1;
    if (runwayStateMachineClosedRestoration_1 != RunwayStateMachineClosedRestoration_1.Restoration_1 && aRunwayStateMachineClosedRestoration_1Restoration_1 != RunwayStateMachineClosedRestoration_1Restoration_1.Null) { setRunwayStateMachineClosedRestoration_1(RunwayStateMachineClosedRestoration_1.Restoration_1); }
  }

  private void exitRunwayStateMachineClosedRestoration_2()
  {
    switch(runwayStateMachineClosedRestoration_2)
    {
      case Restoration_2:
        exitClosed();
        break;
    }
  }

  private void setRunwayStateMachineClosedRestoration_2(RunwayStateMachineClosedRestoration_2 aRunwayStateMachineClosedRestoration_2)
  {
    runwayStateMachineClosedRestoration_2 = aRunwayStateMachineClosedRestoration_2;
    if (runwayStateMachineClosed != RunwayStateMachineClosed.Restoration && aRunwayStateMachineClosedRestoration_2 != RunwayStateMachineClosedRestoration_2.Null) { setRunwayStateMachineClosed(RunwayStateMachineClosed.Restoration); }

    // entry actions and do activities
    switch(runwayStateMachineClosedRestoration_2)
    {
      case Restoration_2:
        if (runwayStateMachineClosedRestoration_2Restoration_2 == RunwayStateMachineClosedRestoration_2Restoration_2.Null) { setRunwayStateMachineClosedRestoration_2Restoration_2(RunwayStateMachineClosedRestoration_2Restoration_2.Maintenance); }
        break;
    }
  }

  private void exitRunwayStateMachineClosedRestoration_2Restoration_2()
  {
    switch(runwayStateMachineClosedRestoration_2Restoration_2)
    {
      case Maintenance:
        if (doActivityRunwayStateMachineClosedRestoration_2Restoration_2MaintenanceThread != null) { doActivityRunwayStateMachineClosedRestoration_2Restoration_2MaintenanceThread.interrupt(); }
        break;
    }
  }

  private void setRunwayStateMachineClosedRestoration_2Restoration_2(RunwayStateMachineClosedRestoration_2Restoration_2 aRunwayStateMachineClosedRestoration_2Restoration_2)
  {
    runwayStateMachineClosedRestoration_2Restoration_2 = aRunwayStateMachineClosedRestoration_2Restoration_2;
    if (runwayStateMachineClosedRestoration_2 != RunwayStateMachineClosedRestoration_2.Restoration_2 && aRunwayStateMachineClosedRestoration_2Restoration_2 != RunwayStateMachineClosedRestoration_2Restoration_2.Null) { setRunwayStateMachineClosedRestoration_2(RunwayStateMachineClosedRestoration_2.Restoration_2); }

    // entry actions and do activities
    switch(runwayStateMachineClosedRestoration_2Restoration_2)
    {
      case Maintenance:
        doActivityRunwayStateMachineClosedRestoration_2Restoration_2MaintenanceThread = new DoActivityThread(this,"doActivityRunwayStateMachineClosedRestoration_2Restoration_2Maintenance");
        break;
    }
  }

  private void doActivityRunwayStateMachineClosedRestoration_2Restoration_2Maintenance()
  {
    try
    {
      performMaintenanceWork();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    Runway controller;
    String doActivityMethodName;
    
    public DoActivityThread(Runway aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityRunwayStateMachineClosedRestoration_2Restoration_2Maintenance".equals(doActivityMethodName))
      {
        controller.doActivityRunwayStateMachineClosedRestoration_2Restoration_2Maintenance();
      }
    }
  }

  public void delete()
  {}

  // line 58 "Runway.ump"
  public void closeRunway(){
    
  }

  // line 59 "Runway.ump"
  public void turnOffGreenLight(){
    
  }

  // line 60 "Runway.ump"
  public void turnOnGreenLight(){
    
  }

  // line 61 "Runway.ump"
  public void performMaintenanceWork(){
    
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "noPlaneOnRunway" + ":" + getNoPlaneOnRunway()+ "," +
            "inspectionSuccess" + ":" + getInspectionSuccess()+ "]"
     + outputString;
  }
}