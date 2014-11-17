/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 64 "CommunityAssociation.ump"
// line 116 "CommunityAssociation.ump"
public class CommunityAssociation
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static CommunityAssociation theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CommunityAssociation Associations
  private List<CommunityResidence> communityResidences;
  private List<Facility> facilities;
  private List<Event> events;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private CommunityAssociation()
  {
    communityResidences = new ArrayList<CommunityResidence>();
    facilities = new ArrayList<Facility>();
    events = new ArrayList<Event>();
  }

  public static CommunityAssociation getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new CommunityAssociation();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public CommunityResidence getCommunityResidence(int index)
  {
    CommunityResidence aCommunityResidence = communityResidences.get(index);
    return aCommunityResidence;
  }

  public List<CommunityResidence> getCommunityResidences()
  {
    List<CommunityResidence> newCommunityResidences = Collections.unmodifiableList(communityResidences);
    return newCommunityResidences;
  }

  public int numberOfCommunityResidences()
  {
    int number = communityResidences.size();
    return number;
  }

  public boolean hasCommunityResidences()
  {
    boolean has = communityResidences.size() > 0;
    return has;
  }

  public int indexOfCommunityResidence(CommunityResidence aCommunityResidence)
  {
    int index = communityResidences.indexOf(aCommunityResidence);
    return index;
  }

  public Facility getFacility(int index)
  {
    Facility aFacility = facilities.get(index);
    return aFacility;
  }

  public List<Facility> getFacilities()
  {
    List<Facility> newFacilities = Collections.unmodifiableList(facilities);
    return newFacilities;
  }

  public int numberOfFacilities()
  {
    int number = facilities.size();
    return number;
  }

  public boolean hasFacilities()
  {
    boolean has = facilities.size() > 0;
    return has;
  }

  public int indexOfFacility(Facility aFacility)
  {
    int index = facilities.indexOf(aFacility);
    return index;
  }

  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
    return index;
  }

  public static int minimumNumberOfCommunityResidences()
  {
    return 0;
  }

  public CommunityResidence addCommunityResidence(String aStreetAddress, int aApartmentNumber, String aFeePaidToDate)
  {
    return new CommunityResidence(aStreetAddress, aApartmentNumber, aFeePaidToDate, this);
  }

  public boolean addCommunityResidence(CommunityResidence aCommunityResidence)
  {
    boolean wasAdded = false;
    if (communityResidences.contains(aCommunityResidence)) { return false; }
    CommunityAssociation existingCommunityAssociation = aCommunityResidence.getCommunityAssociation();
    boolean isNewCommunityAssociation = existingCommunityAssociation != null && !this.equals(existingCommunityAssociation);
    if (isNewCommunityAssociation)
    {
      aCommunityResidence.setCommunityAssociation(this);
    }
    else
    {
      communityResidences.add(aCommunityResidence);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCommunityResidence(CommunityResidence aCommunityResidence)
  {
    boolean wasRemoved = false;
    //Unable to remove aCommunityResidence, as it must always have a communityAssociation
    if (!this.equals(aCommunityResidence.getCommunityAssociation()))
    {
      communityResidences.remove(aCommunityResidence);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCommunityResidenceAt(CommunityResidence aCommunityResidence, int index)
  {  
    boolean wasAdded = false;
    if(addCommunityResidence(aCommunityResidence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCommunityResidences()) { index = numberOfCommunityResidences() - 1; }
      communityResidences.remove(aCommunityResidence);
      communityResidences.add(index, aCommunityResidence);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCommunityResidenceAt(CommunityResidence aCommunityResidence, int index)
  {
    boolean wasAdded = false;
    if(communityResidences.contains(aCommunityResidence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCommunityResidences()) { index = numberOfCommunityResidences() - 1; }
      communityResidences.remove(aCommunityResidence);
      communityResidences.add(index, aCommunityResidence);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCommunityResidenceAt(aCommunityResidence, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfFacilities()
  {
    return 0;
  }

  public Facility addFacility(String aId, String aType, String aOpenPeriod)
  {
    return new Facility(aId, aType, aOpenPeriod, this);
  }

  public boolean addFacility(Facility aFacility)
  {
    boolean wasAdded = false;
    if (facilities.contains(aFacility)) { return false; }
    CommunityAssociation existingCommunityAssociation = aFacility.getCommunityAssociation();
    boolean isNewCommunityAssociation = existingCommunityAssociation != null && !this.equals(existingCommunityAssociation);
    if (isNewCommunityAssociation)
    {
      aFacility.setCommunityAssociation(this);
    }
    else
    {
      facilities.add(aFacility);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFacility(Facility aFacility)
  {
    boolean wasRemoved = false;
    //Unable to remove aFacility, as it must always have a communityAssociation
    if (!this.equals(aFacility.getCommunityAssociation()))
    {
      facilities.remove(aFacility);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFacilityAt(Facility aFacility, int index)
  {  
    boolean wasAdded = false;
    if(addFacility(aFacility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFacilities()) { index = numberOfFacilities() - 1; }
      facilities.remove(aFacility);
      facilities.add(index, aFacility);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFacilityAt(Facility aFacility, int index)
  {
    boolean wasAdded = false;
    if(facilities.contains(aFacility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFacilities()) { index = numberOfFacilities() - 1; }
      facilities.remove(aFacility);
      facilities.add(index, aFacility);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFacilityAt(aFacility, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfEvents()
  {
    return 0;
  }

  public Event addEvent(Date aDate, Time aTime, float aFee, String aName)
  {
    return new Event(aDate, aTime, aFee, aName, this);
  }

  public boolean addEvent(Event aEvent)
  {
    boolean wasAdded = false;
    if (events.contains(aEvent)) { return false; }
    CommunityAssociation existingCommunityAssociation = aEvent.getCommunityAssociation();
    boolean isNewCommunityAssociation = existingCommunityAssociation != null && !this.equals(existingCommunityAssociation);
    if (isNewCommunityAssociation)
    {
      aEvent.setCommunityAssociation(this);
    }
    else
    {
      events.add(aEvent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEvent(Event aEvent)
  {
    boolean wasRemoved = false;
    //Unable to remove aEvent, as it must always have a communityAssociation
    if (!this.equals(aEvent.getCommunityAssociation()))
    {
      events.remove(aEvent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addEventAt(Event aEvent, int index)
  {  
    boolean wasAdded = false;
    if(addEvent(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEventAt(Event aEvent, int index)
  {
    boolean wasAdded = false;
    if(events.contains(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEventAt(aEvent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=communityResidences.size(); i > 0; i--)
    {
      CommunityResidence aCommunityResidence = communityResidences.get(i - 1);
      aCommunityResidence.delete();
    }
    for(int i=facilities.size(); i > 0; i--)
    {
      Facility aFacility = facilities.get(i - 1);
      aFacility.delete();
    }
    for(int i=events.size(); i > 0; i--)
    {
      Event aEvent = events.get(i - 1);
      aEvent.delete();
    }
  }

}