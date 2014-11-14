/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 29 "Hotel.ump"
// line 85 "Hotel.ump"
public class RentableSpace
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RentableSpace Attributes
  private String costPerDay;
  private String floorArea;

  //RentableSpace Associations
  private List<Booking> bookings;
  private Hotel hotel;
  private Suite suite;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RentableSpace(String aCostPerDay, String aFloorArea, Hotel aHotel, Suite aSuite)
  {
    costPerDay = aCostPerDay;
    floorArea = aFloorArea;
    bookings = new ArrayList<Booking>();
    boolean didAddHotel = setHotel(aHotel);
    if (!didAddHotel)
    {
      throw new RuntimeException("Unable to create rentableSpace due to hotel");
    }
    boolean didAddSuite = setSuite(aSuite);
    if (!didAddSuite)
    {
      throw new RuntimeException("Unable to create rentableSpace due to suite");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCostPerDay(String aCostPerDay)
  {
    boolean wasSet = false;
    costPerDay = aCostPerDay;
    wasSet = true;
    return wasSet;
  }

  public boolean setFloorArea(String aFloorArea)
  {
    boolean wasSet = false;
    floorArea = aFloorArea;
    wasSet = true;
    return wasSet;
  }

  public String getCostPerDay()
  {
    return costPerDay;
  }

  public String getFloorArea()
  {
    return floorArea;
  }

  public Booking getBooking(int index)
  {
    Booking aBooking = bookings.get(index);
    return aBooking;
  }

  public List<Booking> getBookings()
  {
    List<Booking> newBookings = Collections.unmodifiableList(bookings);
    return newBookings;
  }

  public int numberOfBookings()
  {
    int number = bookings.size();
    return number;
  }

  public boolean hasBookings()
  {
    boolean has = bookings.size() > 0;
    return has;
  }

  public int indexOfBooking(Booking aBooking)
  {
    int index = bookings.indexOf(aBooking);
    return index;
  }

  public Hotel getHotel()
  {
    return hotel;
  }

  public Suite getSuite()
  {
    return suite;
  }

  public static int minimumNumberOfBookings()
  {
    return 0;
  }

  public boolean addBooking(Booking aBooking)
  {
    boolean wasAdded = false;
    if (bookings.contains(aBooking)) { return false; }
    if (bookings.contains(aBooking)) { return false; }
    if (bookings.contains(aBooking)) { return false; }
    bookings.add(aBooking);
    if (aBooking.indexOfRentableSpace(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBooking.addRentableSpace(this);
      if (!wasAdded)
      {
        bookings.remove(aBooking);
      }
    }
    return wasAdded;
  }

  public boolean removeBooking(Booking aBooking)
  {
    boolean wasRemoved = false;
    if (!bookings.contains(aBooking))
    {
      return wasRemoved;
    }

    int oldIndex = bookings.indexOf(aBooking);
    bookings.remove(oldIndex);
    if (aBooking.indexOfRentableSpace(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBooking.removeRentableSpace(this);
      if (!wasRemoved)
      {
        bookings.add(oldIndex,aBooking);
      }
    }
    return wasRemoved;
  }

  public boolean addBookingAt(Booking aBooking, int index)
  {  
    boolean wasAdded = false;
    if(addBooking(aBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBookings()) { index = numberOfBookings() - 1; }
      bookings.remove(aBooking);
      bookings.add(index, aBooking);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBookingAt(Booking aBooking, int index)
  {
    boolean wasAdded = false;
    if(bookings.contains(aBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBookings()) { index = numberOfBookings() - 1; }
      bookings.remove(aBooking);
      bookings.add(index, aBooking);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBookingAt(aBooking, index);
    }
    return wasAdded;
  }

  public boolean setHotel(Hotel aHotel)
  {
    boolean wasSet = false;
    if (aHotel == null)
    {
      return wasSet;
    }

    Hotel existingHotel = hotel;
    hotel = aHotel;
    if (existingHotel != null && !existingHotel.equals(aHotel))
    {
      existingHotel.removeRentableSpace(this);
    }
    hotel.addRentableSpace(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setSuite(Suite aSuite)
  {
    boolean wasSet = false;
    if (aSuite == null)
    {
      return wasSet;
    }

    Suite existingSuite = suite;
    suite = aSuite;
    if (existingSuite != null && !existingSuite.equals(aSuite))
    {
      existingSuite.removeRentableSpace(this);
    }
    suite.addRentableSpace(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Booking> copyOfBookings = new ArrayList<Booking>(bookings);
    bookings.clear();
    for(Booking aBooking : copyOfBookings)
    {
      aBooking.removeRentableSpace(this);
    }
    Hotel placeholderHotel = hotel;
    this.hotel = null;
    placeholderHotel.removeRentableSpace(this);
    Suite placeholderSuite = suite;
    this.suite = null;
    placeholderSuite.removeRentableSpace(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "costPerDay" + ":" + getCostPerDay()+ "," +
            "floorArea" + ":" + getFloorArea()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hotel = "+(getHotel()!=null?Integer.toHexString(System.identityHashCode(getHotel())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "suite = "+(getSuite()!=null?Integer.toHexString(System.identityHashCode(getSuite())):"null")
     + outputString;
  }
}