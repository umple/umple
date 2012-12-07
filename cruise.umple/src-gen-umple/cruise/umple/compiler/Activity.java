/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

// line 47 "../../../../src/StateMachine.ump"
public class Activity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Activity Attributes
  private Position position;
  private String activityCode;

  //Activity Associations
  private Event onCompletionEvent;
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Activity(String aActivityCode, State aState)
  {
    activityCode = aActivityCode;
    boolean didAddState = setState(aState);
    if (!didAddState)
    {
      throw new RuntimeException("Unable to create activity due to state");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setActivityCode(String aActivityCode)
  {
    boolean wasSet = false;
    activityCode = aActivityCode;
    wasSet = true;
    return wasSet;
  }

  public Position getPosition()
  {
    return position;
  }

  public String getActivityCode()
  {
    return activityCode;
  }

  public Event getOnCompletionEvent()
  {
    return onCompletionEvent;
  }

  public State getState()
  {
    return state;
  }

  public boolean setOnCompletionEvent(Event newOnCompletionEvent)
  {
    boolean wasSet = false;
    onCompletionEvent = newOnCompletionEvent;
    wasSet = true;
    return wasSet;
  }

  public boolean setState(State newState)
  {
    boolean wasSet = false;
    if (newState == null)
    {
      //Unable to setState to null, as activity must always be associated to a state
      return wasSet;
    }
    
    Activity existingActivity = newState.getActivity();
    if (existingActivity != null && !equals(existingActivity))
    {
      //Unable to setState, the current state already has a activity, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    State oldState = state;
    state = newState;
    state.setActivity(this);

    if (oldState != null)
    {
      oldState.setActivity(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    onCompletionEvent = null;
    State existingState = state;
    state = null;
    if (existingState != null)
    {
      existingState.setActivity(null);
    }
  }

}