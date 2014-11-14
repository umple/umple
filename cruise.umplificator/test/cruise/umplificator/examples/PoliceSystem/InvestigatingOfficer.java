/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 55 "PoliceSystem.ump"
// line 124 "PoliceSystem.ump"
public class InvestigatingOfficer extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InvestigatingOfficer Associations
  private List<CrimeOccurrence> crimeOccurrences;
  private Jurisdiction jurisdiction;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InvestigatingOfficer(String aName, String aPhone, String aSex, String aAddress, String aAge, Jurisdiction aJurisdiction)
  {
    super(aName, aPhone, aSex, aAddress, aAge);
    crimeOccurrences = new ArrayList<CrimeOccurrence>();
    boolean didAddJurisdiction = setJurisdiction(aJurisdiction);
    if (!didAddJurisdiction)
    {
      throw new RuntimeException("Unable to create investigatingOfficer due to jurisdiction");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public Jurisdiction getJurisdiction()
  {
    return jurisdiction;
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
    if (aCrimeOccurrence.indexOfInvestigatingOfficer(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrimeOccurrence.addInvestigatingOfficer(this);
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
    if (aCrimeOccurrence.indexOfInvestigatingOfficer(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrimeOccurrence.removeInvestigatingOfficer(this);
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

  public boolean setJurisdiction(Jurisdiction aJurisdiction)
  {
    boolean wasSet = false;
    if (aJurisdiction == null)
    {
      return wasSet;
    }

    Jurisdiction existingJurisdiction = jurisdiction;
    jurisdiction = aJurisdiction;
    if (existingJurisdiction != null && !existingJurisdiction.equals(aJurisdiction))
    {
      existingJurisdiction.removeInvestigatingOfficer(this);
    }
    jurisdiction.addInvestigatingOfficer(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<CrimeOccurrence> copyOfCrimeOccurrences = new ArrayList<CrimeOccurrence>(crimeOccurrences);
    crimeOccurrences.clear();
    for(CrimeOccurrence aCrimeOccurrence : copyOfCrimeOccurrences)
    {
      aCrimeOccurrence.removeInvestigatingOfficer(this);
    }
    Jurisdiction placeholderJurisdiction = jurisdiction;
    this.jurisdiction = null;
    placeholderJurisdiction.removeInvestigatingOfficer(this);
    super.delete();
  }

}