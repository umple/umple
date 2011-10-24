/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.957 modeling language!*/

package cruise.umple.compiler;

public class Guard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Guard Attributes
  private String condition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Guard(String aCondition)
  {
    condition = aCondition;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCondition(String aCondition)
  {
    boolean wasSet = false;
    condition = aCondition;
    wasSet = true;
    return wasSet;
  }

  public String getCondition()
  {
    return condition;
  }

  public void delete()
  {}

}