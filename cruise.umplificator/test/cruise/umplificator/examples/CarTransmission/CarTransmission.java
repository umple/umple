/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 8 "CarTransmission.ump"
public class CarTransmission
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CarTransmission Attributes
  private boolean driveSelected;

  //CarTransmission State Machines
  enum State { neutral, reverse, drive }
  enum StateDrive { Null, first, second, third }
  private State state;
  private StateDrive stateDrive;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CarTransmission(boolean aDriveSelected)
  {
    driveSelected = aDriveSelected;
    setStateDrive(StateDrive.Null);
    setState(State.neutral);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDriveSelected(boolean aDriveSelected)
  {
    boolean wasSet = false;
    driveSelected = aDriveSelected;
    wasSet = true;
    return wasSet;
  }

  public boolean getDriveSelected()
  {
    return driveSelected;
  }

  public boolean isDriveSelected()
  {
    return driveSelected;
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    if (stateDrive != StateDrive.Null) { answer += "." + stateDrive.toString(); }
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public StateDrive getStateDrive()
  {
    return stateDrive;
  }

  public boolean selectReverse()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case neutral:
        setState(State.reverse);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectDrive()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case neutral:
        setState(State.drive);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectFirst()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case neutral:
        setStateDrive(StateDrive.first);
        wasEventProcessed = true;
        break;
      case drive:
        setStateDrive(StateDrive.first);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectSecond()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case neutral:
        setStateDrive(StateDrive.second);
        wasEventProcessed = true;
        break;
      case drive:
        setStateDrive(StateDrive.second);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectNeutral()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case reverse:
        setState(State.neutral);
        wasEventProcessed = true;
        break;
      case drive:
        exitState();
        setState(State.neutral);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterDrive()
  {
    boolean wasEventProcessed = false;
    
    StateDrive aStateDrive = stateDrive;
    switch (aStateDrive)
    {
      case Null:
        setStateDrive(StateDrive.first);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitDrive()
  {
    boolean wasEventProcessed = false;
    
    StateDrive aStateDrive = stateDrive;
    switch (aStateDrive)
    {
      case first:
        setStateDrive(StateDrive.Null);
        wasEventProcessed = true;
        break;
      case second:
        setStateDrive(StateDrive.Null);
        wasEventProcessed = true;
        break;
      case third:
        setStateDrive(StateDrive.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean reachSecondSpeed()
  {
    boolean wasEventProcessed = false;
    
    StateDrive aStateDrive = stateDrive;
    switch (aStateDrive)
    {
      case first:
        if (getDriveSelected())
        {
          setStateDrive(StateDrive.second);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean reachThirdSpeed()
  {
    boolean wasEventProcessed = false;
    
    StateDrive aStateDrive = stateDrive;
    switch (aStateDrive)
    {
      case second:
        if (getDriveSelected())
        {
          setStateDrive(StateDrive.third);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean dropBelowSecondSpeed()
  {
    boolean wasEventProcessed = false;
    
    StateDrive aStateDrive = stateDrive;
    switch (aStateDrive)
    {
      case second:
        if (getDriveSelected())
        {
          setStateDrive(StateDrive.first);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean dropBelowThirdSpeed()
  {
    boolean wasEventProcessed = false;
    
    StateDrive aStateDrive = stateDrive;
    switch (aStateDrive)
    {
      case third:
        setStateDrive(StateDrive.second);
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
      case drive:
        exitDrive();
        break;
    }
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case drive:
        if (stateDrive == StateDrive.Null) { setStateDrive(StateDrive.first); }
        break;
    }
  }

  private void setStateDrive(StateDrive aStateDrive)
  {
    stateDrive = aStateDrive;
    if (state != State.drive && aStateDrive != StateDrive.Null) { setState(State.drive); }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "driveSelected" + ":" + getDriveSelected()+ "]"
     + outputString;
  }
}