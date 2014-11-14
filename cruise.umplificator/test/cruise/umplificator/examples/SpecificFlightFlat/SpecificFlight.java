/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 5 "SpecificFlightFlat.ump"
public class SpecificFlight
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecificFlight Attributes
  private boolean finished;
  private boolean empty;

  //SpecificFlight State Machines
  enum State { planned, planeAssigned, waitingForNextLeg, boarding, closedAtGate, underway, disembarking, completed, cancelled }
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecificFlight(boolean aFinished, boolean aEmpty)
  {
    finished = aFinished;
    empty = aEmpty;
    setState(State.planned);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFinished(boolean aFinished)
  {
    boolean wasSet = false;
    finished = aFinished;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmpty(boolean aEmpty)
  {
    boolean wasSet = false;
    empty = aEmpty;
    wasSet = true;
    return wasSet;
  }

  public boolean getFinished()
  {
    return finished;
  }

  public boolean getEmpty()
  {
    return empty;
  }

  public boolean isFinished()
  {
    return finished;
  }

  public boolean isEmpty()
  {
    return empty;
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

  public boolean assignPlane()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case planned:
        setState(State.planeAssigned);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean cancel()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case planned:
        setState(State.cancelled);
        wasEventProcessed = true;
        break;
      case planeAssigned:
        setState(State.cancelled);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean readyForPassengers()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case planeAssigned:
        setState(State.boarding);
        wasEventProcessed = true;
        break;
      case waitingForNextLeg:
        setState(State.boarding);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean changePlane()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case planeAssigned:
        setState(State.planned);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean evacuate()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case waitingForNextLeg:
        setState(State.disembarking);
        wasEventProcessed = true;
        break;
      case boarding:
        setState(State.disembarking);
        wasEventProcessed = true;
        break;
      case closedAtGate:
        setState(State.disembarking);
        wasEventProcessed = true;
        break;
      case underway:
        setState(State.disembarking);
        wasEventProcessed = true;
        break;
      case disembarking:
        setState(State.disembarking);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean boardingComplete()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case boarding:
        setState(State.closedAtGate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean permissionToDepart()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case closedAtGate:
        setState(State.underway);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean arriveAtGate()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case underway:
        setState(State.disembarking);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean passengersOut()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case disembarking:
        if (!getEmpty())
        {
          setState(State.waitingForNextLeg);
          wasEventProcessed = true;
          break;
        }
        if (getFinished()&&getEmpty())
        {
          setState(State.completed);
          wasEventProcessed = true;
          break;
        }
        if (!getFinished()&&getEmpty())
        {
          setState(State.planeAssigned);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "finished" + ":" + getFinished()+ "," +
            "empty" + ":" + getEmpty()+ "]"
     + outputString;
  }
}