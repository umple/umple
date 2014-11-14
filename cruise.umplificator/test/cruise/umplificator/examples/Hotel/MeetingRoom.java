/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 37 "Hotel.ump"
// line 51 "Hotel.ump"
public class MeetingRoom extends RentableSpace
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MeetingRoom Attributes
  private String name;
  private String maxSeatingCapacity;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MeetingRoom(String aCostPerDay, String aFloorArea, Hotel aHotel, Suite aSuite, String aName, String aMaxSeatingCapacity)
  {
    super(aCostPerDay, aFloorArea, aHotel, aSuite);
    name = aName;
    maxSeatingCapacity = aMaxSeatingCapacity;
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

  public boolean setMaxSeatingCapacity(String aMaxSeatingCapacity)
  {
    boolean wasSet = false;
    maxSeatingCapacity = aMaxSeatingCapacity;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getMaxSeatingCapacity()
  {
    return maxSeatingCapacity;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "maxSeatingCapacity" + ":" + getMaxSeatingCapacity()+ "]"
     + outputString;
  }
}