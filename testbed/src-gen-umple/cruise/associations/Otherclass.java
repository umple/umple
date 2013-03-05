/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 630 "../../../src/TestHarnessAssociations.ump"
public class Otherclass
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Otherclass Attributes
  private String name;

  //Helper Variables
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Otherclass(String aName)
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}