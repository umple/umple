/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;

// line 3 "../AfghanRainDesign.ump"
// line 202 "../AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    details = aDetails;
    boolean didAddVillage = setVillage(aVillage);
    if (!didAddVillage)
    {
      throw new RuntimeException("Unable to create watershed due to village");
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

  public Village getVillage()
  {
    return village;
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
      existingVillage.removeWatershed(this);
    }
    village.addWatershed(this);
    wasSet = true;
    return wasSet;
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
    Village placeholderVillage = village;
    this.village = null;
    placeholderVillage.removeWatershed(this);
  }

}