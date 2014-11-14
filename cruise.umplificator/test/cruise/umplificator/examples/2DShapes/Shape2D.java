/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 16 "2DShapes.ump"
public class Shape2D
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shape2D Attributes
  private String center;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shape2D(String aCenter)
  {
    center = aCenter;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCenter(String aCenter)
  {
    boolean wasSet = false;
    center = aCenter;
    wasSet = true;
    return wasSet;
  }

  public String getCenter()
  {
    return center;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "center" + ":" + getCenter()+ "]"
     + outputString;
  }
}