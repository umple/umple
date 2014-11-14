/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 111 "AfghanRainDesign.ump"
// line 195 "AfghanRainDesign.ump"
public class AgriculturalZone
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AgriculturalZone Attributes
  private int id;
  private String details;

  //AgriculturalZone Associations
  private District district;
  private Village village;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AgriculturalZone(int aId, String aDetails, Village aVillage)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    details = aDetails;
    boolean didAddVillage = setVillage(aVillage);
    if (!didAddVillage)
    {
      throw new RuntimeException("Unable to create agriculturalZone due to village");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDetails(String aDetails)
  {
    boolean wasSet = false;
    details = aDetails;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getDetails()
  {
    return details;
  }

  public District getDistrict()
  {
    return district;
  }

  public boolean hasDistrict()
  {
    boolean has = district != null;
    return has;
  }

  public Village getVillage()
  {
    return village;
  }

  public boolean setDistrict(District aNewDistrict)
  {
    boolean wasSet = false;
    district = aNewDistrict;
    wasSet = true;
    return wasSet;
  }

  public boolean setVillage(Village aVillage)
  {
    boolean wasSet = false;
    if (aVillage == null)
    {
      return wasSet;
    }

    Village existingVillage = village;
    village = aVillage;
    if (existingVillage != null && !existingVillage.equals(aVillage))
    {
      existingVillage.removeAgriculturalZone(this);
    }
    village.addAgriculturalZone(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    AgriculturalZone compareTo = (AgriculturalZone)obj;
  
    if (id != compareTo.id)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + id;

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    district = null;
    Village placeholderVillage = village;
    this.village = null;
    placeholderVillage.removeAgriculturalZone(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "details" + ":" + getDetails()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "district = "+(getDistrict()!=null?Integer.toHexString(System.identityHashCode(getDistrict())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "village = "+(getVillage()!=null?Integer.toHexString(System.identityHashCode(getVillage())):"null")
     + outputString;
  }
}