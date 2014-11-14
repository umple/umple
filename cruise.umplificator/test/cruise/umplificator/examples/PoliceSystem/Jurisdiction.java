/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 50 "PoliceSystem.ump"
// line 102 "PoliceSystem.ump"
public class Jurisdiction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Jurisdiction Attributes
  private String name;
  private String phone;
  private String address;

  //Jurisdiction Associations
  private List<InvestigatingOfficer> investigatingOfficers;
  private List<CrimeOccurrence> crimeOccurrences;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Jurisdiction(String aName, String aPhone, String aAddress)
  {
    name = aName;
    phone = aPhone;
    address = aAddress;
    investigatingOfficers = new ArrayList<InvestigatingOfficer>();
    crimeOccurrences = new ArrayList<CrimeOccurrence>();
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

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
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

  public String getPhone()
  {
    return phone;
  }

  public String getAddress()
  {
    return address;
  }

  public InvestigatingOfficer getInvestigatingOfficer(int index)
  {
    InvestigatingOfficer aInvestigatingOfficer = investigatingOfficers.get(index);
    return aInvestigatingOfficer;
  }

  public List<InvestigatingOfficer> getInvestigatingOfficers()
  {
    List<InvestigatingOfficer> newInvestigatingOfficers = Collections.unmodifiableList(investigatingOfficers);
    return newInvestigatingOfficers;
  }

  public int numberOfInvestigatingOfficers()
  {
    int number = investigatingOfficers.size();
    return number;
  }

  public boolean hasInvestigatingOfficers()
  {
    boolean has = investigatingOfficers.size() > 0;
    return has;
  }

  public int indexOfInvestigatingOfficer(InvestigatingOfficer aInvestigatingOfficer)
  {
    int index = investigatingOfficers.indexOf(aInvestigatingOfficer);
    return index;
  }

  public CrimeOccurrence getCrimeOccurrence(int index)
  {
    CrimeOccurrence aCrimeOccurrence = crimeOccurrences.get(index);
    return aCrimeOccurrence;
  }

  public List<CrimeOccurrence> getCrimeOccurrences()
  {
    List<CrimeOccurrence> newCrimeOccurrences = Collections.unmodifiableList(crimeOccurrences);
    return newCrimeOccurrences;
  }

  public int numberOfCrimeOccurrences()
  {
    int number = crimeOccurrences.size();
    return number;
  }

  public boolean hasCrimeOccurrences()
  {
    boolean has = crimeOccurrences.size() > 0;
    return has;
  }

  public int indexOfCrimeOccurrence(CrimeOccurrence aCrimeOccurrence)
  {
    int index = crimeOccurrences.indexOf(aCrimeOccurrence);
    return index;
  }

  public static int minimumNumberOfInvestigatingOfficers()
  {
    return 0;
  }

  public InvestigatingOfficer addInvestigatingOfficer(String aName, String aPhone, String aSex, String aAddress, String aAge)
  {
    return new InvestigatingOfficer(aName, aPhone, aSex, aAddress, aAge, this);
  }

  public boolean addInvestigatingOfficer(InvestigatingOfficer aInvestigatingOfficer)
  {
    boolean wasAdded = false;
    if (investigatingOfficers.contains(aInvestigatingOfficer)) { return false; }
    Jurisdiction existingJurisdiction = aInvestigatingOfficer.getJurisdiction();
    boolean isNewJurisdiction = existingJurisdiction != null && !this.equals(existingJurisdiction);
    if (isNewJurisdiction)
    {
      aInvestigatingOfficer.setJurisdiction(this);
    }
    else
    {
      investigatingOfficers.add(aInvestigatingOfficer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInvestigatingOfficer(InvestigatingOfficer aInvestigatingOfficer)
  {
    boolean wasRemoved = false;
    //Unable to remove aInvestigatingOfficer, as it must always have a jurisdiction
    if (!this.equals(aInvestigatingOfficer.getJurisdiction()))
    {
      investigatingOfficers.remove(aInvestigatingOfficer);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInvestigatingOfficerAt(InvestigatingOfficer aInvestigatingOfficer, int index)
  {  
    boolean wasAdded = false;
    if(addInvestigatingOfficer(aInvestigatingOfficer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvestigatingOfficers()) { index = numberOfInvestigatingOfficers() - 1; }
      investigatingOfficers.remove(aInvestigatingOfficer);
      investigatingOfficers.add(index, aInvestigatingOfficer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInvestigatingOfficerAt(InvestigatingOfficer aInvestigatingOfficer, int index)
  {
    boolean wasAdded = false;
    if(investigatingOfficers.contains(aInvestigatingOfficer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvestigatingOfficers()) { index = numberOfInvestigatingOfficers() - 1; }
      investigatingOfficers.remove(aInvestigatingOfficer);
      investigatingOfficers.add(index, aInvestigatingOfficer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInvestigatingOfficerAt(aInvestigatingOfficer, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfCrimeOccurrences()
  {
    return 0;
  }

  public boolean addCrimeOccurrence(CrimeOccurrence aCrimeOccurrence)
  {
    boolean wasAdded = false;
    if (crimeOccurrences.contains(aCrimeOccurrence)) { return false; }
    crimeOccurrences.add(aCrimeOccurrence);
    if (aCrimeOccurrence.indexOfJurisdiction(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrimeOccurrence.addJurisdiction(this);
      if (!wasAdded)
      {
        crimeOccurrences.remove(aCrimeOccurrence);
      }
    }
    return wasAdded;
  }

  public boolean removeCrimeOccurrence(CrimeOccurrence aCrimeOccurrence)
  {
    boolean wasRemoved = false;
    if (!crimeOccurrences.contains(aCrimeOccurrence))
    {
      return wasRemoved;
    }

    int oldIndex = crimeOccurrences.indexOf(aCrimeOccurrence);
    crimeOccurrences.remove(oldIndex);
    if (aCrimeOccurrence.indexOfJurisdiction(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrimeOccurrence.removeJurisdiction(this);
      if (!wasRemoved)
      {
        crimeOccurrences.add(oldIndex,aCrimeOccurrence);
      }
    }
    return wasRemoved;
  }

  public boolean addCrimeOccurrenceAt(CrimeOccurrence aCrimeOccurrence, int index)
  {  
    boolean wasAdded = false;
    if(addCrimeOccurrence(aCrimeOccurrence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCrimeOccurrences()) { index = numberOfCrimeOccurrences() - 1; }
      crimeOccurrences.remove(aCrimeOccurrence);
      crimeOccurrences.add(index, aCrimeOccurrence);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCrimeOccurrenceAt(CrimeOccurrence aCrimeOccurrence, int index)
  {
    boolean wasAdded = false;
    if(crimeOccurrences.contains(aCrimeOccurrence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCrimeOccurrences()) { index = numberOfCrimeOccurrences() - 1; }
      crimeOccurrences.remove(aCrimeOccurrence);
      crimeOccurrences.add(index, aCrimeOccurrence);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCrimeOccurrenceAt(aCrimeOccurrence, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=investigatingOfficers.size(); i > 0; i--)
    {
      InvestigatingOfficer aInvestigatingOfficer = investigatingOfficers.get(i - 1);
      aInvestigatingOfficer.delete();
    }
    ArrayList<CrimeOccurrence> copyOfCrimeOccurrences = new ArrayList<CrimeOccurrence>(crimeOccurrences);
    crimeOccurrences.clear();
    for(CrimeOccurrence aCrimeOccurrence : copyOfCrimeOccurrences)
    {
      aCrimeOccurrence.removeJurisdiction(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "address" + ":" + getAddress()+ "]"
     + outputString;
  }
}