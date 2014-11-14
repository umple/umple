/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 35 "Hotel.ump"
// line 74 "Hotel.ump"
public class HotelBedroom extends RentableSpace
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HotelBedroom Attributes
  private String roomNumber;
  private String qualityLevel;
  private String isSmoking;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HotelBedroom(String aCostPerDay, String aFloorArea, Hotel aHotel, Suite aSuite, String aRoomNumber, String aQualityLevel, String aIsSmoking)
  {
    super(aCostPerDay, aFloorArea, aHotel, aSuite);
    roomNumber = aRoomNumber;
    qualityLevel = aQualityLevel;
    isSmoking = aIsSmoking;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRoomNumber(String aRoomNumber)
  {
    boolean wasSet = false;
    roomNumber = aRoomNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setQualityLevel(String aQualityLevel)
  {
    boolean wasSet = false;
    qualityLevel = aQualityLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsSmoking(String aIsSmoking)
  {
    boolean wasSet = false;
    isSmoking = aIsSmoking;
    wasSet = true;
    return wasSet;
  }

  public String getRoomNumber()
  {
    return roomNumber;
  }

  public String getQualityLevel()
  {
    return qualityLevel;
  }

  public String getIsSmoking()
  {
    return isSmoking;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "roomNumber" + ":" + getRoomNumber()+ "," +
            "qualityLevel" + ":" + getQualityLevel()+ "," +
            "isSmoking" + ":" + getIsSmoking()+ "]"
     + outputString;
  }
}