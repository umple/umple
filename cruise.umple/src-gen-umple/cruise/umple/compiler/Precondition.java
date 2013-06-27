/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * The Precondition object (special Constraint) related to Umple Classes
 * @umplesource Umple.ump 260
 */
// line 260 "../../../../src/Umple.ump"
public class Precondition extends Constraint
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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