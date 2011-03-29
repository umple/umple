/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

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
    id = aId;
    farm_details = aFarm_details;
    cachedHashCode = -1;
    canSetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    if (!canSetId)
    {
      return false;
    }
    id = aId;
    return true;
  }

  public boolean setFarm_details(String aFarm_details)
  {
    farm_details = aFarm_details;
    return true;
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
    village = newVillage;
    return true;
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