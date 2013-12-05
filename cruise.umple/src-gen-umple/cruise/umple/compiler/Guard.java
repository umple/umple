/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;
import java.util.*;

/**
 * A boolean condition that is checked when an event method is called
 * If the result is true the transition may be taken
 * @umplesource StateMachine.ump 183
 * @umplesource StateMachine_Code.ump 483
 */
// line 183 "../../../../src/StateMachine.ump"
// line 483 "../../../../src/StateMachine_Code.ump"
public class Guard extends Constraint
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Guard Attributes
  private Position position;
  private Position endPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Guard()
  {
    super();
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

  public Position getPosition()
  {
    return position;
  }

  public Position getEndPosition()
  {
    return endPosition;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={486},file={"StateMachine_Code.ump"},javaline={75},length={3})
  public String getCondition(CodeTranslator gen){
    return gen.translate(":Open",this);
  }

  @umplesourcefile(line={490},file={"StateMachine_Code.ump"},javaline={80},length={3})
  public String getCondition(){
    return (new JavaGenerator()).translate(":Plain",this);
  }

}