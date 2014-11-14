/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 27 "Insurance.ump"
// line 90 "Insurance.ump"
public class Claim
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Claim Attributes
  private String description;
  private String amountClaimed;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Claim(String aDescription, String aAmountClaimed)
  {
    description = aDescription;
    amountClaimed = aAmountClaimed;
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

  public boolean setAmountClaimed(String aAmountClaimed)
  {
    boolean wasSet = false;
    amountClaimed = aAmountClaimed;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public String getAmountClaimed()
  {
    return amountClaimed;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "amountClaimed" + ":" + getAmountClaimed()+ "]"
     + outputString;
  }
}