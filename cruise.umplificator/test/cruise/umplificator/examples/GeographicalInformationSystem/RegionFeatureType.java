/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 50 "GeographicalInformationSystem.ump"
// line 83 "GeographicalInformationSystem.ump"
public class RegionFeatureType extends CurveFeatureType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegionFeatureType Associations
  private Bitmap fillPattern;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegionFeatureType(String aDescription, String aColour, String aThickness, String aDashLength, String aGapLength)
  {
    super(aDescription, aColour, aThickness, aDashLength, aGapLength);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Bitmap getFillPattern()
  {
    return fillPattern;
  }

  public boolean hasFillPattern()
  {
    boolean has = fillPattern != null;
    return has;
  }

  public boolean setFillPattern(Bitmap aNewFillPattern)
  {
    boolean wasSet = false;
    if (fillPattern != null && !fillPattern.equals(aNewFillPattern) && equals(fillPattern.getRegionFeatureType()))
    {
      //Unable to setFillPattern, as existing fillPattern would become an orphan
      return wasSet;
    }

    fillPattern = aNewFillPattern;
    RegionFeatureType anOldRegionFeatureType = aNewFillPattern != null ? aNewFillPattern.getRegionFeatureType() : null;

    if (!this.equals(anOldRegionFeatureType))
    {
      if (anOldRegionFeatureType != null)
      {
        anOldRegionFeatureType.fillPattern = null;
      }
      if (fillPattern != null)
      {
        fillPattern.setRegionFeatureType(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Bitmap existingFillPattern = fillPattern;
    fillPattern = null;
    if (existingFillPattern != null)
    {
      existingFillPattern.delete();
    }
    super.delete();
  }

}