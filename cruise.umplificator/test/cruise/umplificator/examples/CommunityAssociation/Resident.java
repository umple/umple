/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 14 "CommunityAssociation.ump"
// line 78 "CommunityAssociation.ump"
public class Resident
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Resident Attributes
  private String name;
  private boolean under18;
  private String emailAddress;
  private String telephoneNumber;
  private String executivePosition;

  //Resident Associations
  private CommunityResidence communityResidence;
  private List<Booking> bookings;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Resident(String aName, boolean aUnder18, String aEmailAddress, String aTelephoneNumber, String aExecutivePosition, CommunityResidence aCommunityResidence)
  {
    name = aName;
    under18 = aUnder18;
    emailAddress = aEmailAddress;
    telephoneNumber = aTelephoneNumber;
    executivePosition = aExecutivePosition;
    boolean didAddCommunityResidence = setCommunityResidence(aCommunityResidence);
    if (!didAddCommunityResidence)
    {
      throw new RuntimeException("Unable to create resident due to communityResidence");
    }
    bookings = new ArrayList<Booking>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setUnder18(boolean aUnder18)
  {
    boolean wasSet = false;
    under18 = aUnder18;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmailAddress(String aEmailAddress)
  {
    boolean wasSet = false;
    emailAddress = aEmailAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelephoneNumber(String aTelephoneNumber)
  {
    boolean wasSet = false;
    telephoneNumber = aTelephoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setExecutivePosition(String aExecutivePosition)
  {
    boolean wasSet = false;
    executivePosition = aExecutivePosition;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public boolean getUnder18()
  {
    return under18;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public String getTelephoneNumber()
  {
    return telephoneNumber;
  }

  public String getExecutivePosition()
  {
    return executivePosition;
  }

  public boolean isUnder18()
  {
    return under18;
  }

  public CommunityResidence getCommunityResidence()
  {
    return communityResidence;
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

  public boolean setCommunityResidence(CommunityResidence aCommunityResidence)
  {
    boolean wasSet = false;
    if (aCommunityResidence == null)
    {
      return wasSet;
    }

    CommunityResidence existingCommunityResidence = communityResidence;
    communityResidence = aCommunityResidence;
    if (existingCommunityResidence != null && !existingCommunityResidence.equals(aCommunityResidence))
    {
      existingCommunityResidence.removeResident(this);
    }
    communityResidence.addResident(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfBookings()
  {
    return 0;
  }

  public boolean addBooking(Booking aBooking)
  {
    boolean wasAdded = false;
    if (bookings.contains(aBooking)) { return false; }
    Resident existingResident = aBooking.getResident();
    if (existingResident == null)
    {
      aBooking.setResident(this);
    }
    else if (!this.equals(existingResident))
    {
      existingResident.removeBooking(aBooking);
      addBooking(aBooking);
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
    if (bookings.contains(aBooking))
    {
      bookings.remove(aBooking);
      aBooking.setResident(null);
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
    CommunityResidence placeholderCommunityResidence = communityResidence;
    this.communityResidence = null;
    placeholderCommunityResidence.removeResident(this);
    while( !bookings.isEmpty() )
    {
      bookings.get(0).setResident(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "under18" + ":" + getUnder18()+ "," +
            "emailAddress" + ":" + getEmailAddress()+ "," +
            "telephoneNumber" + ":" + getTelephoneNumber()+ "," +
            "executivePosition" + ":" + getExecutivePosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "communityResidence = "+(getCommunityResidence()!=null?Integer.toHexString(System.identityHashCode(getCommunityResidence())):"null")
     + outputString;
  }
}