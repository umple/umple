/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;

// line 107 "../AfghanRainDesign.ump"
// line 191 "../AfghanRainDesign.ump"
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

  public Village getVillage()
  {
    return village;
  }

  public boolean setDistrict(District newDistrict)
  {
    boolean wasSet = false;
    district = newDistrict;
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

}