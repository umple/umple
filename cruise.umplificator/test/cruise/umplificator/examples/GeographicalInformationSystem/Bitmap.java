/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 46 "GeographicalInformationSystem.ump"
// line 73 "GeographicalInformationSystem.ump"
public class Bitmap
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bitmap Attributes
  private String bits;

  //Bitmap Associations
  private RegionFeatureType regionFeatureType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bitmap(String aBits, RegionFeatureType aRegionFeatureType)
  {
    bits = aBits;
    boolean didAddRegionFeatureType = setRegionFeatureType(aRegionFeatureType);
    if (!didAddRegionFeatureType)
    {
      throw new RuntimeException("Unable to create fillPattern due to regionFeatureType");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBits(String aBits)
  {
    boolean wasSet = false;
    bits = aBits;
    wasSet = true;
    return wasSet;
  }

  public String getBits()
  {
    return bits;
  }

  public RegionFeatureType getRegionFeatureType()
  {
    return regionFeatureType;
  }

  public boolean setRegionFeatureType(RegionFeatureType aNewRegionFeatureType)
  {
    boolean wasSet = false;
    if (aNewRegionFeatureType == null)
    {
      //Unable to setRegionFeatureType to null, as fillPattern must always be associated to a regionFeatureType
      return wasSet;
    }
    
    Bitmap existingFillPattern = aNewRegionFeatureType.getFillPattern();
    if (existingFillPattern != null && !equals(existingFillPattern))
    {
      //Unable to setRegionFeatureType, the current regionFeatureType already has a fillPattern, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    RegionFeatureType anOldRegionFeatureType = regionFeatureType;
    regionFeatureType = aNewRegionFeatureType;
    regionFeatureType.setFillPattern(this);

    if (anOldRegionFeatureType != null)
    {
      anOldRegionFeatureType.setFillPattern(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    RegionFeatureType existingRegionFeatureType = regionFeatureType;
    regionFeatureType = null;
    if (existingRegionFeatureType != null)
    {
      existingRegionFeatureType.setFillPattern(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "bits" + ":" + getBits()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "regionFeatureType = "+(getRegionFeatureType()!=null?Integer.toHexString(System.identityHashCode(getRegionFeatureType())):"null")
     + outputString;
  }
}