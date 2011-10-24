/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.957 modeling language!*/

package cruise.umple.compiler;

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

  public String getExtraCode()
  {
    return extraCode;
  }

  public void delete()
  {}

}