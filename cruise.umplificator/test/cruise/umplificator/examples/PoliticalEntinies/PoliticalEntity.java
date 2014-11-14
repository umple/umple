/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Positioning
 */
// line 9 "PoliticalEntities.ump"
// line 36 "PoliticalEntities.ump"
public class PoliticalEntity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PoliticalEntity Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PoliticalEntity(String aName)
  {
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

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