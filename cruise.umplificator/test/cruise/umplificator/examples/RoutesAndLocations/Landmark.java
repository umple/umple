/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 39 "RoutesAndLocations.ump"
// line 175 "RoutesAndLocations.ump"
public class Landmark extends Location
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Landmark Attributes
  private String description;

  //Landmark State Machines
  enum LandmarkType { fireStation, policeStation, touristDestination, other }
  private LandmarkType landmarkType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Landmark(float aLattitude, float aLongitude, String aDescription)
  {
    super(aLattitude, aLongitude);
    description = aDescription;
    setLandmarkType(LandmarkType.fireStation);
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

  /**
   * Name of landmark (name of fire station, business, address)
   */
  public String getDescription()
  {
    return description;
  }

  public String getLandmarkTypeFullName()
  {
    String answer = landmarkType.toString();
    return answer;
  }

  public LandmarkType getLandmarkType()
  {
    return landmarkType;
  }

  public boolean setLandmarkType(LandmarkType aLandmarkType)
  {
    landmarkType = aLandmarkType;
    return true;
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