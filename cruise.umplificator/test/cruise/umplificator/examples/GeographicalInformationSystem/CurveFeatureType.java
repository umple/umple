/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 43 "GeographicalInformationSystem.ump"
// line 62 "GeographicalInformationSystem.ump"
public class CurveFeatureType extends FeatureType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CurveFeatureType Attributes
  private String colour;
  private String thickness;
  private String dashLength;
  private String gapLength;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CurveFeatureType(String aDescription, String aColour, String aThickness, String aDashLength, String aGapLength)
  {
    super(aDescription);
    colour = aColour;
    thickness = aThickness;
    dashLength = aDashLength;
    gapLength = aGapLength;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
    wasSet = true;
    return wasSet;
  }

  public boolean setThickness(String aThickness)
  {
    boolean wasSet = false;
    thickness = aThickness;
    wasSet = true;
    return wasSet;
  }

  public boolean setDashLength(String aDashLength)
  {
    boolean wasSet = false;
    dashLength = aDashLength;
    wasSet = true;
    return wasSet;
  }

  public boolean setGapLength(String aGapLength)
  {
    boolean wasSet = false;
    gapLength = aGapLength;
    wasSet = true;
    return wasSet;
  }

  public String getColour()
  {
    return colour;
  }

  public String getThickness()
  {
    return thickness;
  }

  public String getDashLength()
  {
    return dashLength;
  }

  public String getGapLength()
  {
    return gapLength;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "colour" + ":" + getColour()+ "," +
            "thickness" + ":" + getThickness()+ "," +
            "dashLength" + ":" + getDashLength()+ "," +
            "gapLength" + ":" + getGapLength()+ "]"
     + outputString;
  }
}