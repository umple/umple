/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

/**
 * Some code to execute for an extended period while in a state
 * This code is found after they keyword 'do' in Umple
 * The code is executed in a separate threat, and can be terminated by
 * an outgoing transition. Upon completion of the activity, any
 * autotransition will be taken
 * @umplesource StateMachine.ump 61
 */
// line 61 "../../../../src/StateMachine.ump"
public class Activity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Activity Attributes
  private Position position;
  private String activityCode;
  private CodeBlock codeblock;

  //Activity Associations
  private Event onCompletionEvent;
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Activity(String aActivityCode, State aState)
  {
    activityCode = aActivityCode;
    codeblock = null;
    boolean didAddState = setState(aState);
    if (!didAddState)
    {
      throw new RuntimeException("Unable to create activity due to state");
    }
    // line 72 "../../../../src/StateMachine.ump"
    codeblock = aActivityCode!=null ? new CodeBlock(aActivityCode) : new CodeBlock();
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
    // line 73 "../../../../src/StateMachine.ump"
    codeblock.setCode(aActivityCode);
    activityCode = aActivityCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setCodeblock(CodeBlock aCodeblock)
  {
    boolean wasSet = false;
    codeblock = aCodeblock;
    wasSet = true;
    // line 80 "../../../../src/StateMachine.ump"
    if(activityCode!=null){
      	  activityCode+= aCodeblock.getCode();
      	}
      	else
      	  activityCode = aCodeblock.getCode();
    return wasSet;
  }

  public Position getPosition()
  {
    return position;
  }

  public String getActivityCode()
  {
    String aActivityCode = activityCode;
    // line 74 "../../../../src/StateMachine.ump"
    if (codeblock.getCode()!=null)
      	  return codeblock.getCode();
      	  else
    return aActivityCode;
  }

  public CodeBlock getCodeblock()
  {
    return codeblock;
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

  // line 87 "../../../../src/StateMachine.ump"
  public void setActivityCode(String lang, String code){
    if(activityCode!=null){
  	  activityCode+= lang+code;
  	}
  	else
  	  activityCode = lang+code;
  	codeblock.setCode(lang,code);
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "activityCode" + ":" + getActivityCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "state" + "=" + getPosition() != null ? !getPosition() .equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "onCompletionEvent" + "=" + getCodeblock() != null ? !getCodeblock() .equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + getOnCompletionEvent() != null ? !getOnCompletionEvent() .equals(this)  ? getOnCompletionEvent().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + getState() != null ? !getState() .equals(this)  ? getState().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}