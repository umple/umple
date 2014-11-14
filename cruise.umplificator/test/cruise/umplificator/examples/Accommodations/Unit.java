/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 32 "Accommodations.ump"
// line 117 "Accommodations.ump"
public class Unit
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Unit Attributes
  private String id;
  private int unit_number;
  private int bedroom_count;
  private int room_count;
  private String other_unit_details;

  //Unit Associations
  private Location location;
  private UnitType type;
  private List<ViewUnitStatus> viewUnitStatuses;
  private List<UnitBooking> unitBookings;
  private List<UnitFacility> unitFacilities;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Unit(String aId, int aUnit_number, int aBedroom_count, int aRoom_count, String aOther_unit_details)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    unit_number = aUnit_number;
    bedroom_count = aBedroom_count;
    room_count = aRoom_count;
    other_unit_details = aOther_unit_details;
    viewUnitStatuses = new ArrayList<ViewUnitStatus>();
    unitBookings = new ArrayList<UnitBooking>();
    unitFacilities = new ArrayList<UnitFacility>();
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

  public boolean setUnit_number(int aUnit_number)
  {
    boolean wasSet = false;
    unit_number = aUnit_number;
    wasSet = true;
    return wasSet;
  }

  public boolean setBedroom_count(int aBedroom_count)
  {
    boolean wasSet = false;
    bedroom_count = aBedroom_count;
    wasSet = true;
    return wasSet;
  }

  public boolean setRoom_count(int aRoom_count)
  {
    boolean wasSet = false;
    room_count = aRoom_count;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_unit_details(String aOther_unit_details)
  {
    boolean wasSet = false;
    other_unit_details = aOther_unit_details;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public int getUnit_number()
  {
    return unit_number;
  }

  public int getBedroom_count()
  {
    return bedroom_count;
  }

  public int getRoom_count()
  {
    return room_count;
  }

  public String getOther_unit_details()
  {
    return other_unit_details;
  }

  public Location getLocation()
  {
    return location;
  }

  public boolean hasLocation()
  {
    boolean has = location != null;
    return has;
  }

  public UnitType getType()
  {
    return type;
  }

  public boolean hasType()
  {
    boolean has = type != null;
    return has;
  }

  public ViewUnitStatus getViewUnitStatus(int index)
  {
    ViewUnitStatus aViewUnitStatus = viewUnitStatuses.get(index);
    return aViewUnitStatus;
  }

  public List<ViewUnitStatus> getViewUnitStatuses()
  {
    List<ViewUnitStatus> newViewUnitStatuses = Collections.unmodifiableList(viewUnitStatuses);
    return newViewUnitStatuses;
  }

  public int numberOfViewUnitStatuses()
  {
    int number = viewUnitStatuses.size();
    return number;
  }

  public boolean hasViewUnitStatuses()
  {
    boolean has = viewUnitStatuses.size() > 0;
    return has;
  }

  public int indexOfViewUnitStatus(ViewUnitStatus aViewUnitStatus)
  {
    int index = viewUnitStatuses.indexOf(aViewUnitStatus);
    return index;
  }

  public UnitBooking getUnitBooking(int index)
  {
    UnitBooking aUnitBooking = unitBookings.get(index);
    return aUnitBooking;
  }

  public List<UnitBooking> getUnitBookings()
  {
    List<UnitBooking> newUnitBookings = Collections.unmodifiableList(unitBookings);
    return newUnitBookings;
  }

  public int numberOfUnitBookings()
  {
    int number = unitBookings.size();
    return number;
  }

  public boolean hasUnitBookings()
  {
    boolean has = unitBookings.size() > 0;
    return has;
  }

  public int indexOfUnitBooking(UnitBooking aUnitBooking)
  {
    int index = unitBookings.indexOf(aUnitBooking);
    return index;
  }

  public UnitFacility getUnitFacility(int index)
  {
    UnitFacility aUnitFacility = unitFacilities.get(index);
    return aUnitFacility;
  }

  public List<UnitFacility> getUnitFacilities()
  {
    List<UnitFacility> newUnitFacilities = Collections.unmodifiableList(unitFacilities);
    return newUnitFacilities;
  }

  public int numberOfUnitFacilities()
  {
    int number = unitFacilities.size();
    return number;
  }

  public boolean hasUnitFacilities()
  {
    boolean has = unitFacilities.size() > 0;
    return has;
  }

  public int indexOfUnitFacility(UnitFacility aUnitFacility)
  {
    int index = unitFacilities.indexOf(aUnitFacility);
    return index;
  }

  public boolean setLocation(Location aNewLocation)
  {
    boolean wasSet = false;
    location = aNewLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(UnitType aNewType)
  {
    boolean wasSet = false;
    type = aNewType;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfViewUnitStatuses()
  {
    return 0;
  }

  public boolean addViewUnitStatus(ViewUnitStatus aViewUnitStatus)
  {
    boolean wasAdded = false;
    if (viewUnitStatuses.contains(aViewUnitStatus)) { return false; }
    Unit existingUnit = aViewUnitStatus.getUnit();
    if (existingUnit == null)
    {
      aViewUnitStatus.setUnit(this);
    }
    else if (!this.equals(existingUnit))
    {
      existingUnit.removeViewUnitStatus(aViewUnitStatus);
      addViewUnitStatus(aViewUnitStatus);
    }
    else
    {
      viewUnitStatuses.add(aViewUnitStatus);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeViewUnitStatus(ViewUnitStatus aViewUnitStatus)
  {
    boolean wasRemoved = false;
    if (viewUnitStatuses.contains(aViewUnitStatus))
    {
      viewUnitStatuses.remove(aViewUnitStatus);
      aViewUnitStatus.setUnit(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addViewUnitStatusAt(ViewUnitStatus aViewUnitStatus, int index)
  {  
    boolean wasAdded = false;
    if(addViewUnitStatus(aViewUnitStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfViewUnitStatuses()) { index = numberOfViewUnitStatuses() - 1; }
      viewUnitStatuses.remove(aViewUnitStatus);
      viewUnitStatuses.add(index, aViewUnitStatus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveViewUnitStatusAt(ViewUnitStatus aViewUnitStatus, int index)
  {
    boolean wasAdded = false;
    if(viewUnitStatuses.contains(aViewUnitStatus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfViewUnitStatuses()) { index = numberOfViewUnitStatuses() - 1; }
      viewUnitStatuses.remove(aViewUnitStatus);
      viewUnitStatuses.add(index, aViewUnitStatus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addViewUnitStatusAt(aViewUnitStatus, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfUnitBookings()
  {
    return 0;
  }

  public boolean addUnitBooking(UnitBooking aUnitBooking)
  {
    boolean wasAdded = false;
    if (unitBookings.contains(aUnitBooking)) { return false; }
    Unit existingUnit = aUnitBooking.getUnit();
    if (existingUnit == null)
    {
      aUnitBooking.setUnit(this);
    }
    else if (!this.equals(existingUnit))
    {
      existingUnit.removeUnitBooking(aUnitBooking);
      addUnitBooking(aUnitBooking);
    }
    else
    {
      unitBookings.add(aUnitBooking);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUnitBooking(UnitBooking aUnitBooking)
  {
    boolean wasRemoved = false;
    if (unitBookings.contains(aUnitBooking))
    {
      unitBookings.remove(aUnitBooking);
      aUnitBooking.setUnit(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addUnitBookingAt(UnitBooking aUnitBooking, int index)
  {  
    boolean wasAdded = false;
    if(addUnitBooking(aUnitBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnitBookings()) { index = numberOfUnitBookings() - 1; }
      unitBookings.remove(aUnitBooking);
      unitBookings.add(index, aUnitBooking);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUnitBookingAt(UnitBooking aUnitBooking, int index)
  {
    boolean wasAdded = false;
    if(unitBookings.contains(aUnitBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnitBookings()) { index = numberOfUnitBookings() - 1; }
      unitBookings.remove(aUnitBooking);
      unitBookings.add(index, aUnitBooking);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUnitBookingAt(aUnitBooking, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfUnitFacilities()
  {
    return 0;
  }

  public boolean addUnitFacility(UnitFacility aUnitFacility)
  {
    boolean wasAdded = false;
    if (unitFacilities.contains(aUnitFacility)) { return false; }
    unitFacilities.add(aUnitFacility);
    if (aUnitFacility.indexOfUnit(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUnitFacility.addUnit(this);
      if (!wasAdded)
      {
        unitFacilities.remove(aUnitFacility);
      }
    }
    return wasAdded;
  }

  public boolean removeUnitFacility(UnitFacility aUnitFacility)
  {
    boolean wasRemoved = false;
    if (!unitFacilities.contains(aUnitFacility))
    {
      return wasRemoved;
    }

    int oldIndex = unitFacilities.indexOf(aUnitFacility);
    unitFacilities.remove(oldIndex);
    if (aUnitFacility.indexOfUnit(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUnitFacility.removeUnit(this);
      if (!wasRemoved)
      {
        unitFacilities.add(oldIndex,aUnitFacility);
      }
    }
    return wasRemoved;
  }

  public boolean addUnitFacilityAt(UnitFacility aUnitFacility, int index)
  {  
    boolean wasAdded = false;
    if(addUnitFacility(aUnitFacility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnitFacilities()) { index = numberOfUnitFacilities() - 1; }
      unitFacilities.remove(aUnitFacility);
      unitFacilities.add(index, aUnitFacility);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUnitFacilityAt(UnitFacility aUnitFacility, int index)
  {
    boolean wasAdded = false;
    if(unitFacilities.contains(aUnitFacility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnitFacilities()) { index = numberOfUnitFacilities() - 1; }
      unitFacilities.remove(aUnitFacility);
      unitFacilities.add(index, aUnitFacility);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUnitFacilityAt(aUnitFacility, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Unit compareTo = (Unit)obj;
  
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
    location = null;
    type = null;
    while( !viewUnitStatuses.isEmpty() )
    {
      viewUnitStatuses.get(0).setUnit(null);
    }
    while( !unitBookings.isEmpty() )
    {
      unitBookings.get(0).setUnit(null);
    }
    ArrayList<UnitFacility> copyOfUnitFacilities = new ArrayList<UnitFacility>(unitFacilities);
    unitFacilities.clear();
    for(UnitFacility aUnitFacility : copyOfUnitFacilities)
    {
      aUnitFacility.removeUnit(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "unit_number" + ":" + getUnit_number()+ "," +
            "bedroom_count" + ":" + getBedroom_count()+ "," +
            "room_count" + ":" + getRoom_count()+ "," +
            "other_unit_details" + ":" + getOther_unit_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location = "+(getLocation()!=null?Integer.toHexString(System.identityHashCode(getLocation())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "type = "+(getType()!=null?Integer.toHexString(System.identityHashCode(getType())):"null")
     + outputString;
  }
}