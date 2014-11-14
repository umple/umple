/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 40 "Pizza.ump"
// line 97 "Pizza.ump"
public class ToppingType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ToppingType Attributes
  private String description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ToppingType(String aDescription)
  {
    description = aDescription;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}