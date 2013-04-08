/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * The Precondition object (special Constraint) related to Umple Classes
 * @umplesource Umple.ump 259
 */
// line 259 "../../../../src/Umple.ump"
public class Precondition extends Constraint
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Precondition Associations
  private Method method;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Precondition(Method aMethod)
  {
    super();
    if (!setMethod(aMethod))
    {
      throw new RuntimeException("Unable to create Precondition due to aMethod");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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