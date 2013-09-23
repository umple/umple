/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;

/**
 * A boolean condition that is checked when an event method is called
 * If the result is true the transition may be taken
 * @umplesource StateMachine.ump 184
 */
// line 184 "../../../../src/StateMachine.ump"
public class Guard
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Guard Attributes
  private Position position;
  private Position endPosition;
  private String condition;
  private CodeBlock codeblock;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCondition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={193},file={"StateMachine.ump"},javaline={44},length={1})
  public Guard(String aCondition)
  {
    cachedHashCode = -1;
    canSetCondition = true;
    condition = aCondition;
    codeblock = null;
    // line 193 "../../../../src/StateMachine.ump"
    codeblock = aCondition!=null ? new CodeBlock(aCondition) : new CodeBlock();
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

  public boolean setEndPosition(Position aEndPosition)
  {
    boolean wasSet = false;
    endPosition = aEndPosition;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={194},file={"StateMachine.ump"},javaline={72},length={2})
  public boolean setCondition(String aCondition)
  {
    boolean wasSet = false;
    // line 194 "../../../../src/StateMachine.ump"
    codeblock.setCode(aCondition);
    if (!canSetCondition) { return false; }
    condition = aCondition;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={201},file={"StateMachine.ump"},javaline={85},length={5})
  public boolean setCodeblock(CodeBlock aCodeblock)
  {
    boolean wasSet = false;
    codeblock = aCodeblock;
    wasSet = true;
    // line 201 "../../../../src/StateMachine.ump"
    if(condition!=null){
      	  condition+= aCodeblock.getCode();
      	}
      	else
      	  condition = aCodeblock.getCode();
    return wasSet;
  }

  public Position getPosition()
  {
    return position;
  }

  public Position getEndPosition()
  {
    return endPosition;
  }

  @umplesourcefile(line={195},file={"StateMachine.ump"},javaline={107},length={3})
  public String getCondition()
  {
    String aCondition = condition;
    // line 195 "../../../../src/StateMachine.ump"
    if (codeblock.getCode()!=null)
      	  return codeblock.getCode();
      	  else
    return aCondition;
  }

  /**
   * target language code
   */
  public CodeBlock getCodeblock()
  {
    return codeblock;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Guard compareTo = (Guard)obj;
  
    if (condition == null && compareTo.condition != null)
    {
      return false;
    }
    else if (condition != null && !condition.equals(compareTo.condition))
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
    if (condition != null)
    {
      cachedHashCode = cachedHashCode * 23 + condition.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCondition = false;
    return cachedHashCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={209},file={"StateMachine.ump"},javaline={166},length={8})
  public void setCondition(String lang, String code){
    if(condition!=null){
  	  condition+= lang+code;
  	}
  	else 
  	  condition = lang+code;
  	codeblock.setCode(lang,code);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "condition" + ":" + getCondition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endPosition" + "=" + (getEndPosition() != null ? !getEndPosition().equals(this)  ? getEndPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + (getCodeblock() != null ? !getCodeblock().equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}