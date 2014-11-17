/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 5 "CanalLockStateMachine.ump"
public class Lock
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Lock Attributes
  private boolean boatGoingDown;
  private boolean boatGoingUp;
  private boolean boatBlockingGate;

  //Lock State Machines
  enum LockState { BothDoorsClosedLockFull, OpeningUpperGate, UpperGateOpen, ClosingUpperGate, LoweringWater, BothDoorsClosedLockEmpty, OpeningLowerGate, LowerGateOpen, ClosingLowerGate, RaisingWater }
  private LockState lockState;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Lock()
  {
    boatGoingDown = false;
    boatGoingUp = false;
    boatBlockingGate = false;
    setLockState(LockState.BothDoorsClosedLockFull);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBoatGoingDown(boolean aBoatGoingDown)
  {
    boolean wasSet = false;
    boatGoingDown = aBoatGoingDown;
    wasSet = true;
    return wasSet;
  }

  public boolean setBoatGoingUp(boolean aBoatGoingUp)
  {
    boolean wasSet = false;
    boatGoingUp = aBoatGoingUp;
    wasSet = true;
    return wasSet;
  }

  public boolean setBoatBlockingGate(boolean aBoatBlockingGate)
  {
    boolean wasSet = false;
    boatBlockingGate = aBoatBlockingGate;
    wasSet = true;
    return wasSet;
  }

  public boolean getBoatGoingDown()
  {
    return boatGoingDown;
  }

  public boolean getBoatGoingUp()
  {
    return boatGoingUp;
  }

  public boolean getBoatBlockingGate()
  {
    return boatBlockingGate;
  }

  public boolean isBoatGoingDown()
  {
    return boatGoingDown;
  }

  public boolean isBoatGoingUp()
  {
    return boatGoingUp;
  }

  public boolean isBoatBlockingGate()
  {
    return boatBlockingGate;
  }

  public String getLockStateFullName()
  {
    String answer = lockState.toString();
    return answer;
  }

  public LockState getLockState()
  {
    return lockState;
  }

  public boolean boatRequestsToEnterAndGoDown()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case BothDoorsClosedLockFull:
        setLockState(LockState.OpeningUpperGate);
        wasEventProcessed = true;
        break;
      case BothDoorsClosedLockEmpty:
        setLockState(LockState.RaisingWater);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean boatRequestsToEnterAndGoUp()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case BothDoorsClosedLockFull:
        setLockState(LockState.LoweringWater);
        wasEventProcessed = true;
        break;
      case BothDoorsClosedLockEmpty:
        setLockState(LockState.OpeningLowerGate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean upperGateFullyOpen()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case OpeningUpperGate:
        setLockState(LockState.UpperGateOpen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean boatInLockRequestingToGoDown()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case UpperGateOpen:
        // line 24 "CanalLockStateMachine.ump"
        boatGoingDown = true;
        setLockState(LockState.ClosingUpperGate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean after3minutes()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case UpperGateOpen:
        if (!getBoatBlockingGate())
        {
          setLockState(LockState.ClosingUpperGate);
          wasEventProcessed = true;
          break;
        }
        break;
      case LowerGateOpen:
        if (!getBoatBlockingGate())
        {
          setLockState(LockState.ClosingLowerGate);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean upperGateFullyClosed()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case ClosingUpperGate:
        if (getBoatGoingDown())
        {
          setLockState(LockState.LoweringWater);
          wasEventProcessed = true;
          break;
        }
        if (!getBoatGoingDown())
        {
          setLockState(LockState.BothDoorsClosedLockFull);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean waterLevelMatchesDownStream()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case LoweringWater:
        setLockState(LockState.OpeningLowerGate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean lowerGateFullyOpen()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case OpeningLowerGate:
        setLockState(LockState.LowerGateOpen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean boatInLockRequestingToGoUp()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case LowerGateOpen:
        // line 50 "CanalLockStateMachine.ump"
        boatGoingUp = true;
        setLockState(LockState.ClosingLowerGate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean lowerGateFullyClosed()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case ClosingLowerGate:
        if (getBoatGoingUp())
        {
          setLockState(LockState.RaisingWater);
          wasEventProcessed = true;
          break;
        }
        if (!getBoatGoingUp())
        {
          setLockState(LockState.BothDoorsClosedLockEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean waterLevelMatchesUpStream()
  {
    boolean wasEventProcessed = false;
    
    LockState aLockState = lockState;
    switch (aLockState)
    {
      case RaisingWater:
        setLockState(LockState.OpeningUpperGate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setLockState(LockState aLockState)
  {
    lockState = aLockState;

    // entry actions and do activities
    switch(lockState)
    {
      case UpperGateOpen:
        // line 23 "CanalLockStateMachine.ump"
        boatGoingUp = false;
        break;
      case LowerGateOpen:
        // line 49 "CanalLockStateMachine.ump"
        boatGoingDown = false;
        break;
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "boatGoingDown" + ":" + getBoatGoingDown()+ "," +
            "boatGoingUp" + ":" + getBoatGoingUp()+ "," +
            "boatBlockingGate" + ":" + getBoatBlockingGate()+ "]"
     + outputString;
  }
}