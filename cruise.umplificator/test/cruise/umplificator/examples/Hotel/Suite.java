/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 39 "Hotel.ump"
// line 79 "Hotel.ump"
public class Suite
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Suite Associations
  private List<RentableSpace> rentableSpaces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Suite()
  {
    rentableSpaces = new ArrayList<RentableSpace>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public static int minimumNumberOfRentableSpaces()
  {
    return 0;
  }

  public RentableSpace addRentableSpace(String aCostPerDay, String aFloorArea, Hotel aHotel)
  {
    return new RentableSpace(aCostPerDay, aFloorArea, aHotel, this);
  }

  public boolean addRentableSpace(RentableSpace aRentableSpace)
  {
    boolean wasAdded = false;
    if (rentableSpaces.contains(aRentableSpace)) { return false; }
    Suite existingSuite = aRentableSpace.getSuite();
    boolean isNewSuite = existingSuite != null && !this.equals(existingSuite);
    if (isNewSuite)
    {
      aRentableSpace.setSuite(this);
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
    //Unable to remove aRentableSpace, as it must always have a suite
    if (!this.equals(aRentableSpace.getSuite()))
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

  public void delete()
  {
    for(int i=rentableSpaces.size(); i > 0; i--)
    {
      RentableSpace aRentableSpace = rentableSpaces.get(i - 1);
      aRentableSpace.delete();
    }
  }

}