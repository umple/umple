/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 47 "2DShapes.ump"
public class RegularPolygon extends SimplePolygon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegularPolygon Attributes
  private String numPoints;
  private String radius;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegularPolygon(String aCenter, String aOrientation, String aNumPoints, String aRadius)
  {
    super(aCenter, aOrientation);
    numPoints = aNumPoints;
    radius = aRadius;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumPoints(String aNumPoints)
  {
    boolean wasSet = false;
    numPoints = aNumPoints;
    wasSet = true;
    return wasSet;
  }

  public boolean setRadius(String aRadius)
  {
    boolean wasSet = false;
    radius = aRadius;
    wasSet = true;
    return wasSet;
  }

  public String getNumPoints()
  {
    return numPoints;
  }

  public String getRadius()
  {
    return radius;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numPoints" + ":" + getNumPoints()+ "," +
            "radius" + ":" + getRadius()+ "]"
     + outputString;
  }
}