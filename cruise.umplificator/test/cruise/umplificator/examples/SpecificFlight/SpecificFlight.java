/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "SpecificFlight.ump"
public class SpecificFlight
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecificFlight Attributes
  private boolean finished;
  private boolean empty;

  //SpecificFlight State Machines
  enum State { planned, planeAssigned, activeWithPassengers, completed, cancelled }
  enum StateActiveWithPassengers { Null, waitingForNextLeg, boarding, closedAtGate, underway, disembarking }
  private State state;
  private StateActiveWithPassengers stateActiveWithPassengers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecificFlight(boolean aFinished, boolean aEmpty)
  {
    finished = aFinished;
    empty = aEmpty;
    setStateActiveWithPassengers(StateActiveWithPassengers.Null);
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
    if (stateActiveWithPassengers != StateActiveWithPassengers.Null) { answer += "." + stateActiveWithPassengers.toString(); }
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public StateActiveWithPassengers getStateActiveWithPassengers()
  {
    return stateActiveWithPassengers;
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
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aState)
    {
      case planeAssigned:
        setStateActiveWithPassengers(StateActiveWithPassengers.boarding);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStateActiveWithPassengers)
    {
      case waitingForNextLeg:
        setStateActiveWithPassengers(StateActiveWithPassengers.boarding);
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
      case activeWithPassengers:
        setStateActiveWithPassengers(StateActiveWithPassengers.disembarking);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterActiveWithPassengers()
  {
    boolean wasEventProcessed = false;
    
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aStateActiveWithPassengers)
    {
      case Null:
        setStateActiveWithPassengers(StateActiveWithPassengers.waitingForNextLeg);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitActiveWithPassengers()
  {
    boolean wasEventProcessed = false;
    
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aStateActiveWithPassengers)
    {
      case waitingForNextLeg:
        setStateActiveWithPassengers(StateActiveWithPassengers.Null);
        wasEventProcessed = true;
        break;
      case boarding:
        setStateActiveWithPassengers(StateActiveWithPassengers.Null);
        wasEventProcessed = true;
        break;
      case closedAtGate:
        setStateActiveWithPassengers(StateActiveWithPassengers.Null);
        wasEventProcessed = true;
        break;
      case underway:
        setStateActiveWithPassengers(StateActiveWithPassengers.Null);
        wasEventProcessed = true;
        break;
      case disembarking:
        setStateActiveWithPassengers(StateActiveWithPassengers.Null);
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
    
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aStateActiveWithPassengers)
    {
      case boarding:
        setStateActiveWithPassengers(StateActiveWithPassengers.closedAtGate);
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
    
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aStateActiveWithPassengers)
    {
      case closedAtGate:
        setStateActiveWithPassengers(StateActiveWithPassengers.underway);
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
    
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aStateActiveWithPassengers)
    {
      case underway:
        setStateActiveWithPassengers(StateActiveWithPassengers.disembarking);
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
    
    StateActiveWithPassengers aStateActiveWithPassengers = stateActiveWithPassengers;
    switch (aStateActiveWithPassengers)
    {
      case disembarking:
        if (!getEmpty())
        {
          setStateActiveWithPassengers(StateActiveWithPassengers.waitingForNextLeg);
          wasEventProcessed = true;
          break;
        }
        if (getFinished()&&getEmpty())
        {
          exitState();
          setState(State.completed);
          wasEventProcessed = true;
          break;
        }
        if (!getFinished()&&getEmpty())
        {
          exitState();
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

  private void exitState()
  {
    switch(state)
    {
      case activeWithPassengers:
        exitActiveWithPassengers();
        break;
    }
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case activeWithPassengers:
        if (stateActiveWithPassengers == StateActiveWithPassengers.Null) { setStateActiveWithPassengers(StateActiveWithPassengers.waitingForNextLeg); }
        break;
    }
  }

  private void setStateActiveWithPassengers(StateActiveWithPassengers aStateActiveWithPassengers)
  {
    stateActiveWithPassengers = aStateActiveWithPassengers;
    if (state != State.activeWithPassengers && aStateActiveWithPassengers != StateActiveWithPassengers.Null) { setState(State.activeWithPassengers); }
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