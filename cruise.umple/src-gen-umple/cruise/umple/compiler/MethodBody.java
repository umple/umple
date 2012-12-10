/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;

/**
 * The contents of a method, such as the code within it.
 */
// line 139 "../../../../src/Umple.ump"
public class MethodBody
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MethodBody Attributes
  private String extraCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MethodBody(String aExtraCode)
  {
    extraCode = aExtraCode;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setExtraCode(String aExtraCode)
  {
    boolean wasSet = false;
    extraCode = aExtraCode;
    wasSet = true;
    return wasSet;
  }

  /**
   * The code within the method body.
   */
  public String getExtraCode()
  {
    return extraCode;
  }

  public void delete()
  {}

}