/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 84 "Accommodations.ump"
// line 111 "Accommodations.ump"
public class Guest
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Guest Attributes
  private String id;
  private String first_name;
  private String last_name;
  private Date date_of_birth;
  private String other_guest_details;

  //Guest Associations
  private Gender gender;
  private List<UnitBooking> unitBookings;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Guest(String aId, String aFirst_name, String aLast_name, Date aDate_of_birth, String aOther_guest_details, Gender aGender)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    first_name = aFirst_name;
    last_name = aLast_name;
    date_of_birth = aDate_of_birth;
    other_guest_details = aOther_guest_details;
    if (!setGender(aGender))
    {
      throw new RuntimeException("Unable to create Guest due to aGender");
    }
    unitBookings = new ArrayList<UnitBooking>();
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

  public boolean setFirst_name(String aFirst_name)
  {
    boolean wasSet = false;
    first_name = aFirst_name;
    wasSet = true;
    return wasSet;
  }

  public boolean setLast_name(String aLast_name)
  {
    boolean wasSet = false;
    last_name = aLast_name;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate_of_birth(Date aDate_of_birth)
  {
    boolean wasSet = false;
    date_of_birth = aDate_of_birth;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_guest_details(String aOther_guest_details)
  {
    boolean wasSet = false;
    other_guest_details = aOther_guest_details;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getFirst_name()
  {
    return first_name;
  }

  public String getLast_name()
  {
    return last_name;
  }

  public Date getDate_of_birth()
  {
    return date_of_birth;
  }

  public String getOther_guest_details()
  {
    return other_guest_details;
  }

  public Gender getGender()
  {
    return gender;
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

  public boolean setGender(Gender aNewGender)
  {
    boolean wasSet = false;
    if (aNewGender != null)
    {
      gender = aNewGender;
      wasSet = true;
    }
    return wasSet;
  }

  public static int minimumNumberOfUnitBookings()
  {
    return 0;
  }

  public boolean addUnitBooking(UnitBooking aUnitBooking)
  {
    boolean wasAdded = false;
    if (unitBookings.contains(aUnitBooking)) { return false; }
    Guest existingGuest = aUnitBooking.getGuest();
    if (existingGuest == null)
    {
      aUnitBooking.setGuest(this);
    }
    else if (!this.equals(existingGuest))
    {
      existingGuest.removeUnitBooking(aUnitBooking);
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
      aUnitBooking.setGuest(null);
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

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Guest compareTo = (Guest)obj;
  
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
    gender = null;
    while( !unitBookings.isEmpty() )
    {
      unitBookings.get(0).setGuest(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "first_name" + ":" + getFirst_name()+ "," +
            "last_name" + ":" + getLast_name()+ "," +
            "other_guest_details" + ":" + getOther_guest_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date_of_birth" + "=" + (getDate_of_birth() != null ? !getDate_of_birth().equals(this)  ? getDate_of_birth().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "gender = "+(getGender()!=null?Integer.toHexString(System.identityHashCode(getGender())):"null")
     + outputString;
  }
}