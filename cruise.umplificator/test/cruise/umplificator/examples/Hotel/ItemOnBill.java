/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 20 "Hotel.ump"
// line 91 "Hotel.ump"
public class ItemOnBill
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ItemOnBill Attributes
  private String description;
  private String charge;

  //ItemOnBill Associations
  private Booking booking;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ItemOnBill(String aDescription, String aCharge, Booking aBooking)
  {
    description = aDescription;
    charge = aCharge;
    boolean didAddBooking = setBooking(aBooking);
    if (!didAddBooking)
    {
      throw new RuntimeException("Unable to create itemOnBill due to booking");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setCharge(String aCharge)
  {
    boolean wasSet = false;
    charge = aCharge;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public String getCharge()
  {
    return charge;
  }

  public Booking getBooking()
  {
    return booking;
  }

  public boolean setBooking(Booking aBooking)
  {
    boolean wasSet = false;
    if (aBooking == null)
    {
      return wasSet;
    }

    Booking existingBooking = booking;
    booking = aBooking;
    if (existingBooking != null && !existingBooking.equals(aBooking))
    {
      existingBooking.removeItemOnBill(this);
    }
    booking.addItemOnBill(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Booking placeholderBooking = booking;
    this.booking = null;
    placeholderBooking.removeItemOnBill(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "charge" + ":" + getCharge()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "booking = "+(getBooking()!=null?Integer.toHexString(System.identityHashCode(getBooking())):"null")
     + outputString;
  }
}