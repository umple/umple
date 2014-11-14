/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 23 "AirlineExample.ump"
// line 88 "AirlineExample.ump"
public class PassengerRole extends PersonRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PassengerRole Attributes
  private String name;

  //PassengerRole Associations
  private List<Booking> bookings;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PassengerRole(Person aPerson, String aName)
  {
    super(aPerson);
    name = aName;
    bookings = new ArrayList<Booking>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
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

  public static int minimumNumberOfBookings()
  {
    return 0;
  }

  public Booking addBooking(String aSeatNumber, SpecificFlight aSpecificFlight)
  {
    return new Booking(aSeatNumber, aSpecificFlight, this);
  }

  public boolean addBooking(Booking aBooking)
  {
    boolean wasAdded = false;
    if (bookings.contains(aBooking)) { return false; }
    PassengerRole existingPassengerRole = aBooking.getPassengerRole();
    boolean isNewPassengerRole = existingPassengerRole != null && !this.equals(existingPassengerRole);
    if (isNewPassengerRole)
    {
      aBooking.setPassengerRole(this);
    }
    else
    {
      bookings.add(aBooking);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBooking(Booking aBooking)
  {
    boolean wasRemoved = false;
    //Unable to remove aBooking, as it must always have a passengerRole
    if (!this.equals(aBooking.getPassengerRole()))
    {
      bookings.remove(aBooking);
      wasRemoved = true;
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

  public void delete()
  {
    for(int i=bookings.size(); i > 0; i--)
    {
      Booking aBooking = bookings.get(i - 1);
      aBooking.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}