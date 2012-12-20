/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

public class Watershed
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Watershed Attributes
  private int id;
  private String details;

  //Watershed Associations
  private Village village;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Watershed(int aId, String aDetails, Village aVillage)
  {
    id = aId;
    details = aDetails;
    boolean didAddVillage = setVillage(aVillage);
    if (!didAddVillage)
    {
      throw new RuntimeException("Unable to create watershed due to village");
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

  public Village getVillage()
  {
    return village;
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
      existingVillage.removeWatershed(this);
    }
    village.addWatershed(this);
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Watershed compareTo = (Watershed)obj;
  
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
    village.removeWatershed(this);
  }

}