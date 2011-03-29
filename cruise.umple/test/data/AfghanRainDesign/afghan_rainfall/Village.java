/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;
import java.util.*;

public class Village
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Village Attributes
  private int id;
  private String name;
  private String other_village_details;

  //Village Associations
  private List<AgriculturalZone> agriculturalZones;
  private List<Watershed> watersheds;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Village(int aId, String aName, String aOther_village_details)
  {
    id = aId;
    name = aName;
    other_village_details = aOther_village_details;
    agriculturalZones = new ArrayList<AgriculturalZone>();
    watersheds = new ArrayList<Watershed>();
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

  public boolean setName(String aName)
  {
    name = aName;
    return true;
  }

  public boolean setOther_village_details(String aOther_village_details)
  {
    other_village_details = aOther_village_details;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getOther_village_details()
  {
    return other_village_details;
  }

  public AgriculturalZone getAgriculturalZone(int index)
  {
    return agriculturalZones.get(index);
  }

  public List<AgriculturalZone> getAgriculturalZones()
  {
    return Collections.unmodifiableList(agriculturalZones);
  }

  public int numberOfAgriculturalZones()
  {
    return agriculturalZones.size();
  }

  public boolean hasAgriculturalZones()
  {
    return agriculturalZones.size() > 0;
  }

  public int indexOfAgriculturalZone(AgriculturalZone aAgriculturalZone)
  {
    return agriculturalZones.indexOf(aAgriculturalZone);
  }

  public Watershed getWatershed(int index)
  {
    return watersheds.get(index);
  }

  public List<Watershed> getWatersheds()
  {
    return Collections.unmodifiableList(watersheds);
  }

  public int numberOfWatersheds()
  {
    return watersheds.size();
  }

  public boolean hasWatersheds()
  {
    return watersheds.size() > 0;
  }

  public int indexOfWatershed(Watershed aWatershed)
  {
    return watersheds.indexOf(aWatershed);
  }

  public AgriculturalZone addAgriculturalZone(int aId, String aDetails)
  {
    return new AgriculturalZone(aId, aDetails, this);
  }

  public boolean addAgriculturalZone(AgriculturalZone aAgriculturalZone)
  {
    if (agriculturalZones.contains(aAgriculturalZone))
    {
      return false;
    }

    Village existingVillage = aAgriculturalZone.getVillage();
    boolean isNewVillage = existingVillage != null && !existingVillage.equals(this);
    if (isNewVillage)
    {
      aAgriculturalZone.setVillage(this);
    }
    else
    {
      agriculturalZones.add(aAgriculturalZone);
    }
    return true;
  }

  public boolean removeAgriculturalZone(AgriculturalZone aAgriculturalZone)
  {
    //Unable to remove aAgriculturalZone, as it must always have a village
    if (aAgriculturalZone.getVillage().equals(this))
    {
      return false;
    }
    else
    {
      agriculturalZones.remove(aAgriculturalZone);
      return true;
    }
  }

  public Watershed addWatershed(int aId, String aDetails)
  {
    return new Watershed(aId, aDetails, this);
  }

  public boolean addWatershed(Watershed aWatershed)
  {
    if (watersheds.contains(aWatershed))
    {
      return false;
    }

    Village existingVillage = aWatershed.getVillage();
    boolean isNewVillage = existingVillage != null && !existingVillage.equals(this);
    if (isNewVillage)
    {
      aWatershed.setVillage(this);
    }
    else
    {
      watersheds.add(aWatershed);
    }
    return true;
  }

  public boolean removeWatershed(Watershed aWatershed)
  {
    //Unable to remove aWatershed, as it must always have a village
    if (aWatershed.getVillage().equals(this))
    {
      return false;
    }
    else
    {
      watersheds.remove(aWatershed);
      return true;
    }
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Village compareTo = (Village)obj;
  
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
    for(AgriculturalZone aAgriculturalZone : agriculturalZones)
    {
      aAgriculturalZone.delete();
    }
    for(Watershed aWatershed : watersheds)
    {
      aWatershed.delete();
    }
  }

}