/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 22 "Hotel.ump"
// line 56 "Hotel.ump"
public class Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Booking Attributes
  private String startDate;
  private String endDate;
  private String startTime;
  private String endTime;
  private String bedroomsRequired;
  private String creditCardToBill;

  //Booking Associations
  private List<ItemOnBill> itemOnBills;
  private List<Booking> subsidiaryBooking;
  private Booking booking;
  private List<RentableSpace> rentableSpaces;
  private Person person;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Booking(String aStartDate, String aEndDate, String aStartTime, String aEndTime, String aBedroomsRequired, String aCreditCardToBill, Person aPerson)
  {
    startDate = aStartDate;
    endDate = aEndDate;
    startTime = aStartTime;
    endTime = aEndTime;
    bedroomsRequired = aBedroomsRequired;
    creditCardToBill = aCreditCardToBill;
    itemOnBills = new ArrayList<ItemOnBill>();
    subsidiaryBooking = new ArrayList<Booking>();
    rentableSpaces = new ArrayList<RentableSpace>();
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create booking due to person");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartDate(String aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(String aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(String aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(String aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setBedroomsRequired(String aBedroomsRequired)
  {
    boolean wasSet = false;
    bedroomsRequired = aBedroomsRequired;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditCardToBill(String aCreditCardToBill)
  {
    boolean wasSet = false;
    creditCardToBill = aCreditCardToBill;
    wasSet = true;
    return wasSet;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public String getEndDate()
  {
    return endDate;
  }

  public String getStartTime()
  {
    return startTime;
  }

  public String getEndTime()
  {
    return endTime;
  }

  public String getBedroomsRequired()
  {
    return bedroomsRequired;
  }

  public String getCreditCardToBill()
  {
    return creditCardToBill;
  }

  public ItemOnBill getItemOnBill(int index)
  {
    ItemOnBill aItemOnBill = itemOnBills.get(index);
    return aItemOnBill;
  }

  public List<ItemOnBill> getItemOnBills()
  {
    List<ItemOnBill> newItemOnBills = Collections.unmodifiableList(itemOnBills);
    return newItemOnBills;
  }

  public int numberOfItemOnBills()
  {
    int number = itemOnBills.size();
    return number;
  }

  public boolean hasItemOnBills()
  {
    boolean has = itemOnBills.size() > 0;
    return has;
  }

  public int indexOfItemOnBill(ItemOnBill aItemOnBill)
  {
    int index = itemOnBills.indexOf(aItemOnBill);
    return index;
  }

  public Booking getSubsidiaryBooking(int index)
  {
    Booking aSubsidiaryBooking = subsidiaryBooking.get(index);
    return aSubsidiaryBooking;
  }

  public List<Booking> getSubsidiaryBooking()
  {
    List<Booking> newSubsidiaryBooking = Collections.unmodifiableList(subsidiaryBooking);
    return newSubsidiaryBooking;
  }

  public int numberOfSubsidiaryBooking()
  {
    int number = subsidiaryBooking.size();
    return number;
  }

  public boolean hasSubsidiaryBooking()
  {
    boolean has = subsidiaryBooking.size() > 0;
    return has;
  }

  public int indexOfSubsidiaryBooking(Booking aSubsidiaryBooking)
  {
    int index = subsidiaryBooking.indexOf(aSubsidiaryBooking);
    return index;
  }

  public Booking getBooking()
  {
    return booking;
  }

  public boolean hasBooking()
  {
    boolean has = booking != null;
    return has;
  }

  public RentableSpace getRentableSpace(int index)
  {
    RentableSpace aRentableSpace = rentableSpaces.get(index);
    return aRentableSpace;
  }

  public List<RentableSpace> getRentableSpaces()
  {
    List<RentableSpace> newRentableSpaces = Collections.unmodifiableList(rentableSpaces);
    return newRentableSpaces;
  }

  public int numberOfRentableSpaces()
  {
    int number = rentableSpaces.size();
    return number;
  }

  public boolean hasRentableSpaces()
  {
    boolean has = rentableSpaces.size() > 0;
    return has;
  }

  public int indexOfRentableSpace(RentableSpace aRentableSpace)
  {
    int index = rentableSpaces.indexOf(aRentableSpace);
    return index;
  }

  public Person getPerson()
  {
    return person;
  }

  public static int minimumNumberOfItemOnBills()
  {
    return 0;
  }

  public ItemOnBill addItemOnBill(String aDescription, String aCharge)
  {
    return new ItemOnBill(aDescription, aCharge, this);
  }

  public boolean addItemOnBill(ItemOnBill aItemOnBill)
  {
    boolean wasAdded = false;
    if (itemOnBills.contains(aItemOnBill)) { return false; }
    if (itemOnBills.contains(aItemOnBill)) { return false; }
    Booking existingBooking = aItemOnBill.getBooking();
    boolean isNewBooking = existingBooking != null && !this.equals(existingBooking);
    if (isNewBooking)
    {
      aItemOnBill.setBooking(this);
    }
    else
    {
      itemOnBills.add(aItemOnBill);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItemOnBill(ItemOnBill aItemOnBill)
  {
    boolean wasRemoved = false;
    //Unable to remove aItemOnBill, as it must always have a booking
    if (!this.equals(aItemOnBill.getBooking()))
    {
      itemOnBills.remove(aItemOnBill);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addItemOnBillAt(ItemOnBill aItemOnBill, int index)
  {  
    boolean wasAdded = false;
    if(addItemOnBill(aItemOnBill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemOnBills()) { index = numberOfItemOnBills() - 1; }
      itemOnBills.remove(aItemOnBill);
      itemOnBills.add(index, aItemOnBill);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemOnBillAt(ItemOnBill aItemOnBill, int index)
  {
    boolean wasAdded = false;
    if(itemOnBills.contains(aItemOnBill))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemOnBills()) { index = numberOfItemOnBills() - 1; }
      itemOnBills.remove(aItemOnBill);
      itemOnBills.add(index, aItemOnBill);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemOnBillAt(aItemOnBill, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSubsidiaryBooking()
  {
    return 0;
  }

  public boolean addSubsidiaryBooking(Booking aSubsidiaryBooking)
  {
    boolean wasAdded = false;
    if (subsidiaryBooking.contains(aSubsidiaryBooking)) { return false; }
    if (subsidiaryBooking.contains(aSubsidiaryBooking)) { return false; }
    Booking existingBooking = aSubsidiaryBooking.getBooking();
    if (existingBooking == null)
    {
      aSubsidiaryBooking.setBooking(this);
    }
    else if (!this.equals(existingBooking))
    {
      existingBooking.removeSubsidiaryBooking(aSubsidiaryBooking);
      addSubsidiaryBooking(aSubsidiaryBooking);
    }
    else
    {
      subsidiaryBooking.add(aSubsidiaryBooking);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubsidiaryBooking(Booking aSubsidiaryBooking)
  {
    boolean wasRemoved = false;
    if (subsidiaryBooking.contains(aSubsidiaryBooking))
    {
      subsidiaryBooking.remove(aSubsidiaryBooking);
      aSubsidiaryBooking.setBooking(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubsidiaryBookingAt(Booking aSubsidiaryBooking, int index)
  {  
    boolean wasAdded = false;
    if(addSubsidiaryBooking(aSubsidiaryBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubsidiaryBooking()) { index = numberOfSubsidiaryBooking() - 1; }
      subsidiaryBooking.remove(aSubsidiaryBooking);
      subsidiaryBooking.add(index, aSubsidiaryBooking);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubsidiaryBookingAt(Booking aSubsidiaryBooking, int index)
  {
    boolean wasAdded = false;
    if(subsidiaryBooking.contains(aSubsidiaryBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubsidiaryBooking()) { index = numberOfSubsidiaryBooking() - 1; }
      subsidiaryBooking.remove(aSubsidiaryBooking);
      subsidiaryBooking.add(index, aSubsidiaryBooking);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubsidiaryBookingAt(aSubsidiaryBooking, index);
    }
    return wasAdded;
  }

  public boolean setBooking(Booking aBooking)
  {
    boolean wasSet = false;
    Booking existingBooking = booking;
    booking = aBooking;
    if (existingBooking != null && !existingBooking.equals(aBooking))
    {
      existingBooking.removeSubsidiaryBooking(this);
    }
    if (aBooking != null)
    {
      aBooking.addSubsidiaryBooking(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfRentableSpaces()
  {
    return 0;
  }

  public boolean addRentableSpace(RentableSpace aRentableSpace)
  {
    boolean wasAdded = false;
    if (rentableSpaces.contains(aRentableSpace)) { return false; }
    if (rentableSpaces.contains(aRentableSpace)) { return false; }
    rentableSpaces.add(aRentableSpace);
    if (aRentableSpace.indexOfBooking(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRentableSpace.addBooking(this);
      if (!wasAdded)
      {
        rentableSpaces.remove(aRentableSpace);
      }
    }
    return wasAdded;
  }

  public boolean removeRentableSpace(RentableSpace aRentableSpace)
  {
    boolean wasRemoved = false;
    if (!rentableSpaces.contains(aRentableSpace))
    {
      return wasRemoved;
    }

    int oldIndex = rentableSpaces.indexOf(aRentableSpace);
    rentableSpaces.remove(oldIndex);
    if (aRentableSpace.indexOfBooking(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRentableSpace.removeBooking(this);
      if (!wasRemoved)
      {
        rentableSpaces.add(oldIndex,aRentableSpace);
      }
    }
    return wasRemoved;
  }

  public boolean addRentableSpaceAt(RentableSpace aRentableSpace, int index)
  {  
    boolean wasAdded = false;
    if(addRentableSpace(aRentableSpace))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRentableSpaces()) { index = numberOfRentableSpaces() - 1; }
      rentableSpaces.remove(aRentableSpace);
      rentableSpaces.add(index, aRentableSpace);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRentableSpaceAt(RentableSpace aRentableSpace, int index)
  {
    boolean wasAdded = false;
    if(rentableSpaces.contains(aRentableSpace))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRentableSpaces()) { index = numberOfRentableSpaces() - 1; }
      rentableSpaces.remove(aRentableSpace);
      rentableSpaces.add(index, aRentableSpace);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRentableSpaceAt(aRentableSpace, index);
    }
    return wasAdded;
  }

  public boolean setPerson(Person aPerson)
  {
    boolean wasSet = false;
    if (aPerson == null)
    {
      return wasSet;
    }

    Person existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      existingPerson.removeBooking(this);
    }
    person.addBooking(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=itemOnBills.size(); i > 0; i--)
    {
      ItemOnBill aItemOnBill = itemOnBills.get(i - 1);
      aItemOnBill.delete();
    }
    while( !subsidiaryBooking.isEmpty() )
    {
      subsidiaryBooking.get(0).setBooking(null);
    }
    if (booking != null)
    {
      Booking placeholderBooking = booking;
      this.booking = null;
      placeholderBooking.removeSubsidiaryBooking(this);
    }
    ArrayList<RentableSpace> copyOfRentableSpaces = new ArrayList<RentableSpace>(rentableSpaces);
    rentableSpaces.clear();
    for(RentableSpace aRentableSpace : copyOfRentableSpaces)
    {
      aRentableSpace.removeBooking(this);
    }
    Person placeholderPerson = person;
    this.person = null;
    placeholderPerson.removeBooking(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startDate" + ":" + getStartDate()+ "," +
            "endDate" + ":" + getEndDate()+ "," +
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "," +
            "bedroomsRequired" + ":" + getBedroomsRequired()+ "," +
            "creditCardToBill" + ":" + getCreditCardToBill()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null")
     + outputString;
  }
}