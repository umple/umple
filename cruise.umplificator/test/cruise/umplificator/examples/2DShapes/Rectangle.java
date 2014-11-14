/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 42 "2DShapes.ump"
public class Rectangle extends SimplePolygon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Rectangle Attributes
  private String height;
  private String width;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Rectangle(String aCenter, String aOrientation, String aHeight, String aWidth)
  {
    super(aCenter, aOrientation);
    height = aHeight;
    width = aWidth;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHeight(String aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setWidth(String aWidth)
  {
    boolean wasSet = false;
    width = aWidth;
    wasSet = true;
    return wasSet;
  }

  public String getHeight()
  {
    return height;
  }

  public String getWidth()
  {
    return width;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "height" + ":" + getHeight()+ "," +
            "width" + ":" + getWidth()+ "]"
     + outputString;
  }
}