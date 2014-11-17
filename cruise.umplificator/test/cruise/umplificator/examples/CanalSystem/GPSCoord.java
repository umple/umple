/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 69 "CanalSystem.ump"
// line 149 "CanalSystem.ump"
public class GPSCoord
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GPSCoord Attributes
  private float lattitide;
  private float longitude;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GPSCoord(float aLattitide, float aLongitude)
  {
    lattitide = aLattitide;
    longitude = aLongitude;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLattitide(float aLattitide)
  {
    boolean wasSet = false;
    lattitide = aLattitide;
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

  public float getLattitide()
  {
    return lattitide;
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
            "lattitide" + ":" + getLattitide()+ "," +
            "longitude" + ":" + getLongitude()+ "]"
     + outputString;
  }
}