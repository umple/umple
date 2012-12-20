/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

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
    id = aId;
    details = aDetails;
    boolean didAddVillage = setVillage(aVillage);
    if (!didAddVillage)
    {
      throw new RuntimeException("Unable to create agriculturalZone due to village");
    }
    cachedHashCode = -1;
    canSetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    if (!canSetId)
    {
      return false;
    }
    id = aId;
    return true;
  }

  public boolean setDetails(String aDetails)
  {
    details = aDetails;
    return true;
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
    district = newDistrict;
    return true;
  }

  public boolean setVillage(Village aVillage)
  {
    if (aVillage == null)
    {
      return false;
    }
    
    Village existingVillage = village;
    village = aVillage;
    if (existingVillage != null && !existingVillage.equals(aVillage))
    {
      existingVillage.removeAgriculturalZone(this);
    }
    village.addAgriculturalZone(this);
    return true;
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
    village.removeAgriculturalZone(this);
  }

}