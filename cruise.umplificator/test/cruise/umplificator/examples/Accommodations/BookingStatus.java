/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 62 "Accommodations.ump"
// line 148 "Accommodations.ump"
public class BookingStatus
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BookingStatus Attributes
  private String code;

  //BookingStatus State Machines
  enum Description { Confirmed, Provisional }
  private Description description;

  //BookingStatus Associations
  private List<UnitBooking> unitBookings;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BookingStatus(String aCode)
  {
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    unitBookings = new ArrayList<UnitBooking>();
    setDescription(Description.Confirmed);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    if (!canSetCode) { return false; }
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public String getDescriptionFullName()
  {
    String answer = description.toString();
    return answer;
  }

  public Description getDescription()
  {
    return description;
  }

  public boolean setDescription(Description aDescription)
  {
    description = aDescription;
    return true;
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

  public static int minimumNumberOfUnitBookings()
  {
    return 0;
  }

  public boolean addUnitBooking(UnitBooking aUnitBooking)
  {
    boolean wasAdded = false;
    if (unitBookings.contains(aUnitBooking)) { return false; }
    BookingStatus existingBookingStatus = aUnitBooking.getBookingStatus();
    if (existingBookingStatus == null)
    {
      aUnitBooking.setBookingStatus(this);
    }
    else if (!this.equals(existingBookingStatus))
    {
      existingBookingStatus.removeUnitBooking(aUnitBooking);
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
      aUnitBooking.setBookingStatus(null);
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

    BookingStatus compareTo = (BookingStatus)obj;
  
    if (code == null && compareTo.code != null)
    {
      return false;
    }
    else if (code != null && !code.equals(compareTo.code))
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
    if (code != null)
    {
      cachedHashCode = cachedHashCode * 23 + code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCode = false;
    return cachedHashCode;
  }

  public void delete()
  {
    while( !unitBookings.isEmpty() )
    {
      unitBookings.get(0).setBookingStatus(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "]"
     + outputString;
  }
}