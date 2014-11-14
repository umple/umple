/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 53 "Insurance.ump"
// line 85 "Insurance.ump"
public class Building extends InsuredProperty
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Building Attributes
  private String address;
  private String floorArea;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Building(String aYearBuilt, PropertyInsurancePolicy aPropertyInsurancePolicy, String aAddress, String aFloorArea)
  {
    super(aYearBuilt, aPropertyInsurancePolicy);
    address = aAddress;
    floorArea = aFloorArea;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setFloorArea(String aFloorArea)
  {
    boolean wasSet = false;
    floorArea = aFloorArea;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public String getFloorArea()
  {
    return floorArea;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "," +
            "floorArea" + ":" + getFloorArea()+ "]"
     + outputString;
  }
}