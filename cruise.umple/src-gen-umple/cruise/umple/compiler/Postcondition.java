/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * The Postcondition object (special Constraint) related to Umple Classes
 * @umplesource Umple.ump 276
 */
// line 276 "../../../../src/Umple.ump"
public class Postcondition extends Constraint
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Postcondition Attributes
  private Position position;

  //Postcondition Associations
  private Method method;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Postcondition(Method aMethod)
  {
    super();
    if (!setMethod(aMethod))
    {
      throw new RuntimeException("Unable to create Postcondition due to aMethod");
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

  public Position getPosition()
  {
    return position;
  }

  public Method getMethod()
  {
    return method;
  }

  public boolean setMethod(Method aNewMethod)
  {
    boolean wasSet = false;
    if (aNewMethod != null)
    {
      method = aNewMethod;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    method = null;
    super.delete();
  }

}