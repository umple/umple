/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package routesAndLocations;

/**
 * A Location describes a place such as an intersection, landmark, bend in a road, etc.
 */
// line 34 "../../RoutesAndLocations.ump"
// line 170 "../../RoutesAndLocations.ump"
public class Location
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Location Attributes
  private float lattitude;
  private float longitude;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Location(float aLattitude, float aLongitude)
  {
    lattitude = aLattitude;
    longitude = aLongitude;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLattitude(float aLattitude)
  {
    boolean wasSet = false;
    lattitude = aLattitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongitude(float aLongitude)
  {
    boolean wasSet = false;
    longitude = aLongitude;
    wasSet = true;
    return wasSet;
  }

  public float getLattitude()
  {
    return lattitude;
  }

  public float getLongitude()
  {
    return longitude;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "lattitude" + ":" + getLattitude()+ "," +
            "longitude" + ":" + getLongitude()+ "]"
     + outputString;
  }
}