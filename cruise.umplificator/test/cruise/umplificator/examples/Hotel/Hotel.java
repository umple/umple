/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 14 "Hotel.ump"
// line 96 "Hotel.ump"
public class Hotel
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hotel Attributes
  private String name;
  private String address;

  //Hotel Associations
  private List<RentableSpace> rentableSpaces;
  private HotelCompany hotelCompany;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Hotel(String aName, String aAddress, HotelCompany aHotelCompany)
  {
    name = aName;
    address = aAddress;
    rentableSpaces = new ArrayList<RentableSpace>();
    boolean didAddHotelCompany = setHotelCompany(aHotelCompany);
    if (!didAddHotelCompany)
    {
      throw new RuntimeException("Unable to create own due to hotelCompany");
    }
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
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

  public HotelCompany getHotelCompany()
  {
    return hotelCompany;
  }

  public static int minimumNumberOfRentableSpaces()
  {
    return 0;
  }

  public RentableSpace addRentableSpace(String aCostPerDay, String aFloorArea, Suite aSuite)
  {
    return new RentableSpace(aCostPerDay, aFloorArea, this, aSuite);
  }

  public boolean addRentableSpace(RentableSpace aRentableSpace)
  {
    boolean wasAdded = false;
    if (rentableSpaces.contains(aRentableSpace)) { return false; }
    Hotel existingHotel = aRentableSpace.getHotel();
    boolean isNewHotel = existingHotel != null && !this.equals(existingHotel);
    if (isNewHotel)
    {
      aRentableSpace.setHotel(this);
    }
    else
    {
      rentableSpaces.add(aRentableSpace);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRentableSpace(RentableSpace aRentableSpace)
  {
    boolean wasRemoved = false;
    //Unable to remove aRentableSpace, as it must always have a hotel
    if (!this.equals(aRentableSpace.getHotel()))
    {
      rentableSpaces.remove(aRentableSpace);
      wasRemoved = true;
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

  public boolean setHotelCompany(HotelCompany aHotelCompany)
  {
    boolean wasSet = false;
    if (aHotelCompany == null)
    {
      return wasSet;
    }

    HotelCompany existingHotelCompany = hotelCompany;
    hotelCompany = aHotelCompany;
    if (existingHotelCompany != null && !existingHotelCompany.equals(aHotelCompany))
    {
      existingHotelCompany.removeOwn(this);
    }
    hotelCompany.addOwn(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=rentableSpaces.size(); i > 0; i--)
    {
      RentableSpace aRentableSpace = rentableSpaces.get(i - 1);
      aRentableSpace.delete();
    }
    HotelCompany placeholderHotelCompany = hotelCompany;
    this.hotelCompany = null;
    placeholderHotelCompany.removeOwn(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hotelCompany = "+(getHotelCompany()!=null?Integer.toHexString(System.identityHashCode(getHotelCompany())):"null")
     + outputString;
  }
}