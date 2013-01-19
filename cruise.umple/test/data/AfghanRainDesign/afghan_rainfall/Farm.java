/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;

// line 79 "../AfghanRainDesign.ump"
// line 180 "../AfghanRainDesign.ump"
public class Farm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Farm Attributes
  private String id;
  private String farm_details;

  //Farm Associations
  private Village village;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Farm(String aId, String aFarm_details)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    farm_details = aFarm_details;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setFarm_details(String aFarm_details)
  {
    boolean wasSet = false;
    farm_details = aFarm_details;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getFarm_details()
  {
    return farm_details;
  }

  public Village getVillage()
  {
    return village;
  }

  public boolean setVillage(Village newVillage)
  {
    boolean wasSet = false;
    village = newVillage;
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Farm compareTo = (Farm)obj;
  
    if (id == null && compareTo.id != null)
    {
      return false;
    }
    else if (id != null && !id.equals(compareTo.id))
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
    if (id != null)
    {
      cachedHashCode = cachedHashCode * 23 + id.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    village = null;
  }

}