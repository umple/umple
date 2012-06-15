/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.patterns.test;

public class ClassOtherclass
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOtherclass Attributes
  private String name;

  //Helper Variables
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassOtherclass(String aName)
  {
    name = aName;
    canSetName = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public void delete()
  {}

}