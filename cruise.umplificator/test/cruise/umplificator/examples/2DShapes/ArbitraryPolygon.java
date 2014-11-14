/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 38 "2DShapes.ump"
public class ArbitraryPolygon extends Polygon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ArbitraryPolygon Attributes
  private String points;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ArbitraryPolygon(String aCenter, String aPoints)
  {
    super(aCenter);
    points = aPoints;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPoints(String aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
    wasSet = true;
    return wasSet;
  }

  public String getPoints()
  {
    return points;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "points" + ":" + getPoints()+ "]"
     + outputString;
  }
}