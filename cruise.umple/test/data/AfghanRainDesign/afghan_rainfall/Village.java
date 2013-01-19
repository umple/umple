/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;
import java.util.*;

/**
 * assocationClass
 */
// line 117 "../AfghanRainDesign.ump"
// line 156 "../AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    name = aName;
    other_village_details = aOther_village_details;
    agriculturalZones = new ArrayList<AgriculturalZone>();
    watersheds = new ArrayList<Watershed>();
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_village_details(String aOther_village_details)
  {
    boolean wasSet = false;
    other_village_details = aOther_village_details;
    wasSet = true;
    return wasSet;
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
    AgriculturalZone aAgriculturalZone = agriculturalZones.get(index);
    return aAgriculturalZone;
  }

  public List<AgriculturalZone> getAgriculturalZones()
  {
    List<AgriculturalZone> newAgriculturalZones = Collections.unmodifiableList(agriculturalZones);
    return newAgriculturalZones;
  }

  public int numberOfAgriculturalZones()
  {
    int number = agriculturalZones.size();
    return number;
  }

  public boolean hasAgriculturalZones()
  {
    boolean has = agriculturalZones.size() > 0;
    return has;
  }

  public int indexOfAgriculturalZone(AgriculturalZone aAgriculturalZone)
  {
    int index = agriculturalZones.indexOf(aAgriculturalZone);
    return index;
  }

  public Watershed getWatershed(int index)
  {
    Watershed aWatershed = watersheds.get(index);
    return aWatershed;
  }

  public List<Watershed> getWatersheds()
  {
    List<Watershed> newWatersheds = Collections.unmodifiableList(watersheds);
    return newWatersheds;
  }

  public int numberOfWatersheds()
  {
    int number = watersheds.size();
    return number;
  }

  public boolean hasWatersheds()
  {
    boolean has = watersheds.size() > 0;
    return has;
  }

  public int indexOfWatershed(Watershed aWatershed)
  {
    int index = watersheds.indexOf(aWatershed);
    return index;
  }

  public static int minimumNumberOfAgriculturalZones()
  {
    return 0;
  }

  public AgriculturalZone addAgriculturalZone(int aId, String aDetails)
  {
    return new AgriculturalZone(aId, aDetails, this);
  }

  public boolean addAgriculturalZone(AgriculturalZone aAgriculturalZone)
  {
    boolean wasAdded = false;
    if (agriculturalZones.contains(aAgriculturalZone)) { return false; }
    Village existingVillage = aAgriculturalZone.getVillage();
    boolean isNewVillage = existingVillage != null && !this.equals(existingVillage);
    if (isNewVillage)
    {
      aAgriculturalZone.setVillage(this);
    }
    else
    {
      agriculturalZones.add(aAgriculturalZone);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAgriculturalZone(AgriculturalZone aAgriculturalZone)
  {
    boolean wasRemoved = false;
    //Unable to remove aAgriculturalZone, as it must always have a village
    if (!this.equals(aAgriculturalZone.getVillage()))
    {
      agriculturalZones.remove(aAgriculturalZone);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAgriculturalZoneAt(AgriculturalZone aAgriculturalZone, int index)
  {  
    boolean wasAdded = false;
    if(addAgriculturalZone(aAgriculturalZone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAgriculturalZones()) { index = numberOfAgriculturalZones() - 1; }
      agriculturalZones.remove(aAgriculturalZone);
      agriculturalZones.add(index, aAgriculturalZone);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAgriculturalZoneAt(AgriculturalZone aAgriculturalZone, int index)
  {
    boolean wasAdded = false;
    if(agriculturalZones.contains(aAgriculturalZone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAgriculturalZones()) { index = numberOfAgriculturalZones() - 1; }
      agriculturalZones.remove(aAgriculturalZone);
      agriculturalZones.add(index, aAgriculturalZone);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAgriculturalZoneAt(aAgriculturalZone, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfWatersheds()
  {
    return 0;
  }

  public Watershed addWatershed(int aId, String aDetails)
  {
    return new Watershed(aId, aDetails, this);
  }

  public boolean addWatershed(Watershed aWatershed)
  {
    boolean wasAdded = false;
    if (watersheds.contains(aWatershed)) { return false; }
    Village existingVillage = aWatershed.getVillage();
    boolean isNewVillage = existingVillage != null && !this.equals(existingVillage);
    if (isNewVillage)
    {
      aWatershed.setVillage(this);
    }
    else
    {
      watersheds.add(aWatershed);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWatershed(Watershed aWatershed)
  {
    boolean wasRemoved = false;
    //Unable to remove aWatershed, as it must always have a village
    if (!this.equals(aWatershed.getVillage()))
    {
      watersheds.remove(aWatershed);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addWatershedAt(Watershed aWatershed, int index)
  {  
    boolean wasAdded = false;
    if(addWatershed(aWatershed))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWatersheds()) { index = numberOfWatersheds() - 1; }
      watersheds.remove(aWatershed);
      watersheds.add(index, aWatershed);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWatershedAt(Watershed aWatershed, int index)
  {
    boolean wasAdded = false;
    if(watersheds.contains(aWatershed))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWatersheds()) { index = numberOfWatersheds() - 1; }
      watersheds.remove(aWatershed);
      watersheds.add(index, aWatershed);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWatershedAt(aWatershed, index);
    }
    return wasAdded;
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
    for(int i=agriculturalZones.size(); i > 0; i--)
    {
      AgriculturalZone aAgriculturalZone = agriculturalZones.get(i - 1);
      aAgriculturalZone.delete();
    }
    for(int i=watersheds.size(); i > 0; i--)
    {
      Watershed aWatershed = watersheds.get(i - 1);
      aWatershed.delete();
    }
  }

}