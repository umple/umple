/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 43 "DMMExtensionCTF.ump"
// line 105 "DMMExtensionCTF.ump"
public class TracePattern
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TracePattern Attributes
  private String description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TracePattern(String aDescription)
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