/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 43 "Hotel.ump"
// line 63 "Hotel.ump"
public class Event extends Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(String aStartDate, String aEndDate, String aStartTime, String aEndTime, String aBedroomsRequired, String aCreditCardToBill, Person aPerson, String aDescription)
  {
    super(aStartDate, aEndDate, aStartTime, aEndTime, aBedroomsRequired, aCreditCardToBill, aPerson);
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
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}