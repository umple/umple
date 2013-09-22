/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

/**
 * A quickly-executed block of code that is run upon entry or exit from a state
 * @umplesource StateMachine.ump 125
 */
// line 125 "../../../../src/StateMachine.ump"
public class Action
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Action Attributes
  private String actionType;
  private Position position;
  private Position endPosition;
  private String actionCode;
  private boolean isInternal;
  private CodeBlock codeblock;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetActionType;
  private boolean canSetActionCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={136},file={"StateMachine.ump"},javaline={49},length={1})
  public Action(String aActionCode)
  {
    cachedHashCode = -1;
    canSetActionType = true;
    canSetActionCode = true;
    actionType = null;
    actionCode = aActionCode;
    isInternal = false;
    codeblock = null;
    // line 136 "../../../../src/StateMachine.ump"
    codeblock = aActionCode!=null ? new CodeBlock(aActionCode) : new CodeBlock();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setActionType(String aActionType)
  {
    boolean wasSet = false;
    if (!canSetActionType) { return false; }
    actionType = aActionType;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndPosition(Position aEndPosition)
  {
    boolean wasSet = false;
    endPosition = aEndPosition;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={137},file={"StateMachine.ump"},javaline={86},length={2})
  public boolean setActionCode(String aActionCode)
  {
    boolean wasSet = false;
    // line 137 "../../../../src/StateMachine.ump"
    codeblock.setCode(aActionCode);
    if (!canSetActionCode) { return false; }
    actionCode = aActionCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={144},file={"StateMachine.ump"},javaline={107},length={5})
  public boolean setCodeblock(CodeBlock aCodeblock)
  {
    boolean wasSet = false;
    codeblock = aCodeblock;
    wasSet = true;
    // line 144 "../../../../src/StateMachine.ump"
    if(actionCode!=null){
      	  actionCode+= aCodeblock.getCode();
      	}
      	else
      	  actionCode = aCodeblock.getCode();
    return wasSet;
  }

  public String getActionType()
  {
    return actionType;
  }

  public Position getPosition()
  {
    return position;
  }

  public Position getEndPosition()
  {
    return endPosition;
  }

  @umplesourcefile(line={138},file={"StateMachine.ump"},javaline={134},length={3})
  public String getActionCode()
  {
    String aActionCode = actionCode;
    // line 138 "../../../../src/StateMachine.ump"
    if (codeblock.getCode()!=null)
      	  return codeblock.getCode();
      	  else
    return aActionCode;
  }

  /**
   * target language code
   */
  public boolean getIsInternal()
  {
    return isInternal;
  }

  public CodeBlock getCodeblock()
  {
    return codeblock;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Action compareTo = (Action)obj;
  
    if (actionType == null && compareTo.actionType != null)
    {
      return false;
    }
    else if (actionType != null && !actionType.equals(compareTo.actionType))
    {
      return false;
    }

    if (actionCode == null && compareTo.actionCode != null)
    {
      return false;
    }
    else if (actionCode != null && !actionCode.equals(compareTo.actionCode))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (actionType != null)
    {
      cachedHashCode = cachedHashCode * 23 + actionType.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (actionCode != null)
    {
      cachedHashCode = cachedHashCode * 23 + actionCode.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetActionType = false;
    canSetActionCode = false;
    return cachedHashCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={151},file={"StateMachine.ump"},javaline={222},length={8})
  public void setActionCode(String lang, String code){
    if(actionCode!=null){
  	  actionCode+= lang+code;
  	}
  	else 
  	  actionCode = lang+code;
  	codeblock.setCode(lang,code);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "actionCode" + ":" + getActionCode()+ "," +
            "actionType" + ":" + getActionType()+ "," +
            "isInternal" + ":" + getIsInternal()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endPosition" + "=" + (getEndPosition() != null ? !getEndPosition().equals(this)  ? getEndPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + (getCodeblock() != null ? !getCodeblock().equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}