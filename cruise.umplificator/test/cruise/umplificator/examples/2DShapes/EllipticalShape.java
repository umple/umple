/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Abstract
 */
// line 20 "2DShapes.ump"
public class EllipticalShape extends Shape2D
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EllipticalShape Attributes
  private String semiMajorAxis;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EllipticalShape(String aCenter, String aSemiMajorAxis)
  {
    super(aCenter);
    semiMajorAxis = aSemiMajorAxis;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSemiMajorAxis(String aSemiMajorAxis)
  {
    boolean wasSet = false;
    semiMajorAxis = aSemiMajorAxis;
    wasSet = true;
    return wasSet;
  }

  public String getSemiMajorAxis()
  {
    return semiMajorAxis;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "semiMajorAxis" + ":" + getSemiMajorAxis()+ "]"
     + outputString;
  }
}