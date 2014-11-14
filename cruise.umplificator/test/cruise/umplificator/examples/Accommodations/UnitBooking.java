/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

// line 70 "Accommodations.ump"
// line 124 "Accommodations.ump"
public class UnitBooking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UnitBooking Attributes
  private String id;
  private Date start_date;
  private Date end_date;
  private String other_booking_details;

  //UnitBooking Associations
  private Unit unit;
  private Guest guest;
  private BookingStatus bookingStatus;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UnitBooking(String aId, Date aStart_date, Date aEnd_date, String aOther_booking_details)
  {
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    start_date = aStart_date;
    end_date = aEnd_date;
    other_booking_details = aOther_booking_details;
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

  public boolean setStart_date(Date aStart_date)
  {
    boolean wasSet = false;
    start_date = aStart_date;
    wasSet = true;
    return wasSet;
  }

  public boolean setEnd_date(Date aEnd_date)
  {
    boolean wasSet = false;
    end_date = aEnd_date;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_booking_details(String aOther_booking_details)
  {
    boolean wasSet = false;
    other_booking_details = aOther_booking_details;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public Date getStart_date()
  {
    return start_date;
  }

  public Date getEnd_date()
  {
    return end_date;
  }

  public String getOther_booking_details()
  {
    return other_booking_details;
  }

  public Unit getUnit()
  {
    return unit;
  }

  public boolean hasUnit()
  {
    boolean has = unit != null;
    return has;
  }

  public Guest getGuest()
  {
    return guest;
  }

  public boolean hasGuest()
  {
    boolean has = guest != null;
    return has;
  }

  public BookingStatus getBookingStatus()
  {
    return bookingStatus;
  }

  public boolean hasBookingStatus()
  {
    boolean has = bookingStatus != null;
    return has;
  }

  public boolean setUnit(Unit aUnit)
  {
    boolean wasSet = false;
    Unit existingUnit = unit;
    unit = aUnit;
    if (existingUnit != null && !existingUnit.equals(aUnit))
    {
      existingUnit.removeUnitBooking(this);
    }
    if (aUnit != null)
    {
      aUnit.addUnitBooking(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setGuest(Guest aGuest)
  {
    boolean wasSet = false;
    Guest existingGuest = guest;
    guest = aGuest;
    if (existingGuest != null && !existingGuest.equals(aGuest))
    {
      existingGuest.removeUnitBooking(this);
    }
    if (aGuest != null)
    {
      aGuest.addUnitBooking(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setBookingStatus(BookingStatus aBookingStatus)
  {
    boolean wasSet = false;
    BookingStatus existingBookingStatus = bookingStatus;
    bookingStatus = aBookingStatus;
    if (existingBookingStatus != null && !existingBookingStatus.equals(aBookingStatus))
    {
      existingBookingStatus.removeUnitBooking(this);
    }
    if (aBookingStatus != null)
    {
      aBookingStatus.addUnitBooking(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    UnitBooking compareTo = (UnitBooking)obj;
  
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
    if (unit != null)
    {
      Unit placeholderUnit = unit;
      this.unit = null;
      placeholderUnit.removeUnitBooking(this);
    }
    if (guest != null)
    {
      Guest placeholderGuest = guest;
      this.guest = null;
      placeholderGuest.removeUnitBooking(this);
    }
    if (bookingStatus != null)
    {
      BookingStatus placeholderBookingStatus = bookingStatus;
      this.bookingStatus = null;
      placeholderBookingStatus.removeUnitBooking(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "other_booking_details" + ":" + getOther_booking_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "start_date" + "=" + (getStart_date() != null ? !getStart_date().equals(this)  ? getStart_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "end_date" + "=" + (getEnd_date() != null ? !getEnd_date().equals(this)  ? getEnd_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "unit = "+(getUnit()!=null?Integer.toHexString(System.identityHashCode(getUnit())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "guest = "+(getGuest()!=null?Integer.toHexString(System.identityHashCode(getGuest())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bookingStatus = "+(getBookingStatus()!=null?Integer.toHexString(System.identityHashCode(getBookingStatus())):"null")
     + outputString;
  }
}