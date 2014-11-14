/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "TicTacToe.ump"
public class TicTacToe
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TicTacToe State Machines
  enum State { xTurn, oTurn, xWin, oWin, tie }
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TicTacToe()
  {
    setState(State.xTurn);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public boolean xPlays()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case xTurn:
        if (isThreeInARow())
        {
          setState(State.xWin);
          wasEventProcessed = true;
          break;
        }
        if (isThreeInARow()&&spaceAvailable())
        {
          setState(State.oTurn);
          wasEventProcessed = true;
          break;
        }
        if (spaceAvailable())
        {
          setState(State.tie);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean oPlays()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case oTurn:
        if (isThreeInARow())
        {
          setState(State.oWin);
          wasEventProcessed = true;
          break;
        }
        if (isThreeInARow()&&spaceAvailable())
        {
          setState(State.xTurn);
          wasEventProcessed = true;
          break;
        }
        if (spaceAvailable())
        {
          setState(State.tie);
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


  /**
   * The following need to be implemented
   */
  // line 24 "TicTacToe.ump"
  public Boolean isThreeInARow(){
    return false;
  }

  // line 25 "TicTacToe.ump"
  public Boolean spaceAvailable(){
    return true;
  }

}