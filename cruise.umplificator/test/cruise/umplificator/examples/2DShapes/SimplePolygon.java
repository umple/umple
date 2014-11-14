/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 34 "2DShapes.ump"
public class SimplePolygon extends Polygon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SimplePolygon Attributes
  private String orientation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SimplePolygon(String aCenter, String aOrientation)
  {
    super(aCenter);
    orientation = aOrientation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrientation(String aOrientation)
  {
    boolean wasSet = false;
    orientation = aOrientation;
    wasSet = true;
    return wasSet;
  }

  public String getOrientation()
  {
    return orientation;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "orientation" + ":" + getOrientation()+ "]"
     + outputString;
  }
}