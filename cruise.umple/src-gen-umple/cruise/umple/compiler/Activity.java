/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;

public class Activity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Activity Attributes
  private String activityCode;

  //Activity Associations
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

  public boolean setActivityCode(String aActivityCode)
  {
    boolean wasSet = false;
    activityCode = aActivityCode;
    wasSet = true;
    return wasSet;
  }

  public String getActivityCode()
  {
    return activityCode;
  }

  public State getState()
  {
    return state;
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
    State existingState = state;
    state = null;
    if (existingState != null)
    {
      existingState.setActivity(null);
    }
  }

}