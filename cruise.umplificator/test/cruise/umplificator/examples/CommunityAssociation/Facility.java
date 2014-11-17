/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 6 "CommunityAssociation.ump"
// line 72 "CommunityAssociation.ump"
public class Facility
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Facility Attributes
  private String id;
  private String type;
  private String openPeriod;

  //Facility Associations
  private List<Booking> booked;
  private CommunityAssociation communityAssociation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Facility(String aId, String aType, String aOpenPeriod, CommunityAssociation aCommunityAssociation)
  {
    id = aId;
    type = aType;
    openPeriod = aOpenPeriod;
    booked = new ArrayList<Booking>();
    boolean didAddCommunityAssociation = setCommunityAssociation(aCommunityAssociation);
    if (!didAddCommunityAssociation)
    {
      throw new RuntimeException("Unable to create facility due to communityAssociation");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setOpenPeriod(String aOpenPeriod)
  {
    boolean wasSet = false;
    openPeriod = aOpenPeriod;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getType()
  {
    return type;
  }

  public String getOpenPeriod()
  {
    return openPeriod;
  }

  public Booking getBooked(int index)
  {
    Booking aBooked = booked.get(index);
    return aBooked;
  }

  public List<Booking> getBooked()
  {
    List<Booking> newBooked = Collections.unmodifiableList(booked);
    return newBooked;
  }

  public int numberOfBooked()
  {
    int number = booked.size();
    return number;
  }

  public boolean hasBooked()
  {
    boolean has = booked.size() > 0;
    return has;
  }

  public int indexOfBooked(Booking aBooked)
  {
    int index = booked.indexOf(aBooked);
    return index;
  }

  public CommunityAssociation getCommunityAssociation()
  {
    return communityAssociation;
  }

  public static int minimumNumberOfBooked()
  {
    return 0;
  }

  public Booking addBooked(Date aDate, Time aStartTime, Time aEndTime, float aFeePaid, boolean aIsReservedForFCFS)
  {
    return new Booking(aDate, aStartTime, aEndTime, aFeePaid, aIsReservedForFCFS, this);
  }

  public boolean addBooked(Booking aBooked)
  {
    boolean wasAdded = false;
    if (booked.contains(aBooked)) { return false; }
    if (booked.contains(aBooked)) { return false; }
    if (booked.contains(aBooked)) { return false; }
    Facility existingFacility = aBooked.getFacility();
    boolean isNewFacility = existingFacility != null && !this.equals(existingFacility);
    if (isNewFacility)
    {
      aBooked.setFacility(this);
    }
    else
    {
      booked.add(aBooked);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBooked(Booking aBooked)
  {
    boolean wasRemoved = false;
    //Unable to remove aBooked, as it must always have a facility
    if (!this.equals(aBooked.getFacility()))
    {
      booked.remove(aBooked);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBookedAt(Booking aBooked, int index)
  {  
    boolean wasAdded = false;
    if(addBooked(aBooked))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBooked()) { index = numberOfBooked() - 1; }
      booked.remove(aBooked);
      booked.add(index, aBooked);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBookedAt(Booking aBooked, int index)
  {
    boolean wasAdded = false;
    if(booked.contains(aBooked))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBooked()) { index = numberOfBooked() - 1; }
      booked.remove(aBooked);
      booked.add(index, aBooked);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBookedAt(aBooked, index);
    }
    return wasAdded;
  }

  public boolean setCommunityAssociation(CommunityAssociation aCommunityAssociation)
  {
    boolean wasSet = false;
    if (aCommunityAssociation == null)
    {
      return wasSet;
    }

    CommunityAssociation existingCommunityAssociation = communityAssociation;
    communityAssociation = aCommunityAssociation;
    if (existingCommunityAssociation != null && !existingCommunityAssociation.equals(aCommunityAssociation))
    {
      existingCommunityAssociation.removeFacility(this);
    }
    communityAssociation.addFacility(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=booked.size(); i > 0; i--)
    {
      Booking aBooked = booked.get(i - 1);
      aBooked.delete();
    }
    CommunityAssociation placeholderCommunityAssociation = communityAssociation;
    this.communityAssociation = null;
    placeholderCommunityAssociation.removeFacility(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "type" + ":" + getType()+ "," +
            "openPeriod" + ":" + getOpenPeriod()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "communityAssociation = "+(getCommunityAssociation()!=null?Integer.toHexString(System.identityHashCode(getCommunityAssociation())):"null")
     + outputString;
  }
}