/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 23 "CommunityAssociation.ump"
// line 83 "CommunityAssociation.ump"
public class CommunityResidence
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CommunityResidence Attributes
  private String streetAddress;
  private int apartmentNumber;
  private String feePaidToDate;

  //CommunityResidence Associations
  private List<Resident> residents;
  private CommunityAssociation communityAssociation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CommunityResidence(String aStreetAddress, int aApartmentNumber, String aFeePaidToDate, CommunityAssociation aCommunityAssociation)
  {
    streetAddress = aStreetAddress;
    apartmentNumber = aApartmentNumber;
    feePaidToDate = aFeePaidToDate;
    residents = new ArrayList<Resident>();
    boolean didAddCommunityAssociation = setCommunityAssociation(aCommunityAssociation);
    if (!didAddCommunityAssociation)
    {
      throw new RuntimeException("Unable to create communityResidence due to communityAssociation");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStreetAddress(String aStreetAddress)
  {
    boolean wasSet = false;
    streetAddress = aStreetAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setApartmentNumber(int aApartmentNumber)
  {
    boolean wasSet = false;
    apartmentNumber = aApartmentNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setFeePaidToDate(String aFeePaidToDate)
  {
    boolean wasSet = false;
    feePaidToDate = aFeePaidToDate;
    wasSet = true;
    return wasSet;
  }

  public String getStreetAddress()
  {
    return streetAddress;
  }

  public int getApartmentNumber()
  {
    return apartmentNumber;
  }

  public String getFeePaidToDate()
  {
    return feePaidToDate;
  }

  public Resident getResident(int index)
  {
    Resident aResident = residents.get(index);
    return aResident;
  }

  public List<Resident> getResidents()
  {
    List<Resident> newResidents = Collections.unmodifiableList(residents);
    return newResidents;
  }

  public int numberOfResidents()
  {
    int number = residents.size();
    return number;
  }

  public boolean hasResidents()
  {
    boolean has = residents.size() > 0;
    return has;
  }

  public int indexOfResident(Resident aResident)
  {
    int index = residents.indexOf(aResident);
    return index;
  }

  public CommunityAssociation getCommunityAssociation()
  {
    return communityAssociation;
  }

  public static int minimumNumberOfResidents()
  {
    return 0;
  }

  public Resident addResident(String aName, boolean aUnder18, String aEmailAddress, String aTelephoneNumber, String aExecutivePosition)
  {
    return new Resident(aName, aUnder18, aEmailAddress, aTelephoneNumber, aExecutivePosition, this);
  }

  public boolean addResident(Resident aResident)
  {
    boolean wasAdded = false;
    if (residents.contains(aResident)) { return false; }
    CommunityResidence existingCommunityResidence = aResident.getCommunityResidence();
    boolean isNewCommunityResidence = existingCommunityResidence != null && !this.equals(existingCommunityResidence);
    if (isNewCommunityResidence)
    {
      aResident.setCommunityResidence(this);
    }
    else
    {
      residents.add(aResident);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeResident(Resident aResident)
  {
    boolean wasRemoved = false;
    //Unable to remove aResident, as it must always have a communityResidence
    if (!this.equals(aResident.getCommunityResidence()))
    {
      residents.remove(aResident);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addResidentAt(Resident aResident, int index)
  {  
    boolean wasAdded = false;
    if(addResident(aResident))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResidents()) { index = numberOfResidents() - 1; }
      residents.remove(aResident);
      residents.add(index, aResident);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveResidentAt(Resident aResident, int index)
  {
    boolean wasAdded = false;
    if(residents.contains(aResident))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResidents()) { index = numberOfResidents() - 1; }
      residents.remove(aResident);
      residents.add(index, aResident);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addResidentAt(aResident, index);
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
      existingCommunityAssociation.removeCommunityResidence(this);
    }
    communityAssociation.addCommunityResidence(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=residents.size(); i > 0; i--)
    {
      Resident aResident = residents.get(i - 1);
      aResident.delete();
    }
    CommunityAssociation placeholderCommunityAssociation = communityAssociation;
    this.communityAssociation = null;
    placeholderCommunityAssociation.removeCommunityResidence(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "streetAddress" + ":" + getStreetAddress()+ "," +
            "apartmentNumber" + ":" + getApartmentNumber()+ "," +
            "feePaidToDate" + ":" + getFeePaidToDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "communityAssociation = "+(getCommunityAssociation()!=null?Integer.toHexString(System.identityHashCode(getCommunityAssociation())):"null")
     + outputString;
  }
}