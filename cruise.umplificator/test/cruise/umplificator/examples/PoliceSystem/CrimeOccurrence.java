/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 16 "PoliceSystem.ump"
// line 86 "PoliceSystem.ump"
public class CrimeOccurrence
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CrimeOccurrence Attributes
  private String location;
  private String date;
  private String time;
  private String description;

  //CrimeOccurrence Associations
  private List<ChargeOccurrence> chargeOccurrences;
  private List<Suspect> suspects;
  private List<Witness> witnesses;
  private List<Victim> victims;
  private List<InvestigatingOfficer> investigatingOfficers;
  private List<Jurisdiction> jurisdictions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CrimeOccurrence(String aLocation, String aDate, String aTime, String aDescription)
  {
    location = aLocation;
    date = aDate;
    time = aTime;
    description = aDescription;
    chargeOccurrences = new ArrayList<ChargeOccurrence>();
    suspects = new ArrayList<Suspect>();
    witnesses = new ArrayList<Witness>();
    victims = new ArrayList<Victim>();
    investigatingOfficers = new ArrayList<InvestigatingOfficer>();
    jurisdictions = new ArrayList<Jurisdiction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(String aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getLocation()
  {
    return location;
  }

  public String getDate()
  {
    return date;
  }

  public String getTime()
  {
    return time;
  }

  public String getDescription()
  {
    return description;
  }

  public ChargeOccurrence getChargeOccurrence(int index)
  {
    ChargeOccurrence aChargeOccurrence = chargeOccurrences.get(index);
    return aChargeOccurrence;
  }

  public List<ChargeOccurrence> getChargeOccurrences()
  {
    List<ChargeOccurrence> newChargeOccurrences = Collections.unmodifiableList(chargeOccurrences);
    return newChargeOccurrences;
  }

  public int numberOfChargeOccurrences()
  {
    int number = chargeOccurrences.size();
    return number;
  }

  public boolean hasChargeOccurrences()
  {
    boolean has = chargeOccurrences.size() > 0;
    return has;
  }

  public int indexOfChargeOccurrence(ChargeOccurrence aChargeOccurrence)
  {
    int index = chargeOccurrences.indexOf(aChargeOccurrence);
    return index;
  }

  public Suspect getSuspect(int index)
  {
    Suspect aSuspect = suspects.get(index);
    return aSuspect;
  }

  public List<Suspect> getSuspects()
  {
    List<Suspect> newSuspects = Collections.unmodifiableList(suspects);
    return newSuspects;
  }

  public int numberOfSuspects()
  {
    int number = suspects.size();
    return number;
  }

  public boolean hasSuspects()
  {
    boolean has = suspects.size() > 0;
    return has;
  }

  public int indexOfSuspect(Suspect aSuspect)
  {
    int index = suspects.indexOf(aSuspect);
    return index;
  }

  public Witness getWitness(int index)
  {
    Witness aWitness = witnesses.get(index);
    return aWitness;
  }

  public List<Witness> getWitnesses()
  {
    List<Witness> newWitnesses = Collections.unmodifiableList(witnesses);
    return newWitnesses;
  }

  public int numberOfWitnesses()
  {
    int number = witnesses.size();
    return number;
  }

  public boolean hasWitnesses()
  {
    boolean has = witnesses.size() > 0;
    return has;
  }

  public int indexOfWitness(Witness aWitness)
  {
    int index = witnesses.indexOf(aWitness);
    return index;
  }

  public Victim getVictim(int index)
  {
    Victim aVictim = victims.get(index);
    return aVictim;
  }

  public List<Victim> getVictims()
  {
    List<Victim> newVictims = Collections.unmodifiableList(victims);
    return newVictims;
  }

  public int numberOfVictims()
  {
    int number = victims.size();
    return number;
  }

  public boolean hasVictims()
  {
    boolean has = victims.size() > 0;
    return has;
  }

  public int indexOfVictim(Victim aVictim)
  {
    int index = victims.indexOf(aVictim);
    return index;
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

  public Jurisdiction getJurisdiction(int index)
  {
    Jurisdiction aJurisdiction = jurisdictions.get(index);
    return aJurisdiction;
  }

  public List<Jurisdiction> getJurisdictions()
  {
    List<Jurisdiction> newJurisdictions = Collections.unmodifiableList(jurisdictions);
    return newJurisdictions;
  }

  public int numberOfJurisdictions()
  {
    int number = jurisdictions.size();
    return number;
  }

  public boolean hasJurisdictions()
  {
    boolean has = jurisdictions.size() > 0;
    return has;
  }

  public int indexOfJurisdiction(Jurisdiction aJurisdiction)
  {
    int index = jurisdictions.indexOf(aJurisdiction);
    return index;
  }

  public static int minimumNumberOfChargeOccurrences()
  {
    return 0;
  }

  public boolean addChargeOccurrence(ChargeOccurrence aChargeOccurrence)
  {
    boolean wasAdded = false;
    if (chargeOccurrences.contains(aChargeOccurrence)) { return false; }
    chargeOccurrences.add(aChargeOccurrence);
    if (aChargeOccurrence.indexOfCrimeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aChargeOccurrence.addCrimeOccurrence(this);
      if (!wasAdded)
      {
        chargeOccurrences.remove(aChargeOccurrence);
      }
    }
    return wasAdded;
  }

  public boolean removeChargeOccurrence(ChargeOccurrence aChargeOccurrence)
  {
    boolean wasRemoved = false;
    if (!chargeOccurrences.contains(aChargeOccurrence))
    {
      return wasRemoved;
    }

    int oldIndex = chargeOccurrences.indexOf(aChargeOccurrence);
    chargeOccurrences.remove(oldIndex);
    if (aChargeOccurrence.indexOfCrimeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aChargeOccurrence.removeCrimeOccurrence(this);
      if (!wasRemoved)
      {
        chargeOccurrences.add(oldIndex,aChargeOccurrence);
      }
    }
    return wasRemoved;
  }

  public boolean addChargeOccurrenceAt(ChargeOccurrence aChargeOccurrence, int index)
  {  
    boolean wasAdded = false;
    if(addChargeOccurrence(aChargeOccurrence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChargeOccurrences()) { index = numberOfChargeOccurrences() - 1; }
      chargeOccurrences.remove(aChargeOccurrence);
      chargeOccurrences.add(index, aChargeOccurrence);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChargeOccurrenceAt(ChargeOccurrence aChargeOccurrence, int index)
  {
    boolean wasAdded = false;
    if(chargeOccurrences.contains(aChargeOccurrence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChargeOccurrences()) { index = numberOfChargeOccurrences() - 1; }
      chargeOccurrences.remove(aChargeOccurrence);
      chargeOccurrences.add(index, aChargeOccurrence);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChargeOccurrenceAt(aChargeOccurrence, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSuspects()
  {
    return 0;
  }

  public boolean addSuspect(Suspect aSuspect)
  {
    boolean wasAdded = false;
    if (suspects.contains(aSuspect)) { return false; }
    suspects.add(aSuspect);
    if (aSuspect.indexOfCrimeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSuspect.addCrimeOccurrence(this);
      if (!wasAdded)
      {
        suspects.remove(aSuspect);
      }
    }
    return wasAdded;
  }

  public boolean removeSuspect(Suspect aSuspect)
  {
    boolean wasRemoved = false;
    if (!suspects.contains(aSuspect))
    {
      return wasRemoved;
    }

    int oldIndex = suspects.indexOf(aSuspect);
    suspects.remove(oldIndex);
    if (aSuspect.indexOfCrimeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSuspect.removeCrimeOccurrence(this);
      if (!wasRemoved)
      {
        suspects.add(oldIndex,aSuspect);
      }
    }
    return wasRemoved;
  }

  public boolean addSuspectAt(Suspect aSuspect, int index)
  {  
    boolean wasAdded = false;
    if(addSuspect(aSuspect))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuspects()) { index = numberOfSuspects() - 1; }
      suspects.remove(aSuspect);
      suspects.add(index, aSuspect);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSuspectAt(Suspect aSuspect, int index)
  {
    boolean wasAdded = false;
    if(suspects.contains(aSuspect))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuspects()) { index = numberOfSuspects() - 1; }
      suspects.remove(aSuspect);
      suspects.add(index, aSuspect);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSuspectAt(aSuspect, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfWitnesses()
  {
    return 0;
  }

  public boolean addWitness(Witness aWitness)
  {
    boolean wasAdded = false;
    if (witnesses.contains(aWitness)) { return false; }
    witnesses.add(aWitness);
    if (aWitness.indexOfCrimeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aWitness.addCrimeOccurrence(this);
      if (!wasAdded)
      {
        witnesses.remove(aWitness);
      }
    }
    return wasAdded;
  }

  public boolean removeWitness(Witness aWitness)
  {
    boolean wasRemoved = false;
    if (!witnesses.contains(aWitness))
    {
      return wasRemoved;
    }

    int oldIndex = witnesses.indexOf(aWitness);
    witnesses.remove(oldIndex);
    if (aWitness.indexOfCrimeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aWitness.removeCrimeOccurrence(this);
      if (!wasRemoved)
      {
        witnesses.add(oldIndex,aWitness);
      }
    }
    return wasRemoved;
  }

  public boolean addWitnessAt(Witness aWitness, int index)
  {  
    boolean wasAdded = false;
    if(addWitness(aWitness))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWitnesses()) { index = numberOfWitnesses() - 1; }
      witnesses.remove(aWitness);
      witnesses.add(index, aWitness);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWitnessAt(Witness aWitness, int index)
  {
    boolean wasAdded = false;
    if(witnesses.contains(aWitness))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWitnesses()) { index = numberOfWitnesses() - 1; }
      witnesses.remove(aWitness);
      witnesses.add(index, aWitness);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWitnessAt(aWitness, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfVictims()
  {
    return 0;
  }

  public boolean addVictim(Victim aVictim)
  {
    boolean wasAdded = false;
    if (victims.contains(aVictim)) { return false; }
    victims.add(aVictim);
    if (aVictim.indexOfCrimeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aVictim.addCrimeOccurrence(this);
      if (!wasAdded)
      {
        victims.remove(aVictim);
      }
    }
    return wasAdded;
  }

  public boolean removeVictim(Victim aVictim)
  {
    boolean wasRemoved = false;
    if (!victims.contains(aVictim))
    {
      return wasRemoved;
    }

    int oldIndex = victims.indexOf(aVictim);
    victims.remove(oldIndex);
    if (aVictim.indexOfCrimeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aVictim.removeCrimeOccurrence(this);
      if (!wasRemoved)
      {
        victims.add(oldIndex,aVictim);
      }
    }
    return wasRemoved;
  }

  public boolean addVictimAt(Victim aVictim, int index)
  {  
    boolean wasAdded = false;
    if(addVictim(aVictim))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVictims()) { index = numberOfVictims() - 1; }
      victims.remove(aVictim);
      victims.add(index, aVictim);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVictimAt(Victim aVictim, int index)
  {
    boolean wasAdded = false;
    if(victims.contains(aVictim))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVictims()) { index = numberOfVictims() - 1; }
      victims.remove(aVictim);
      victims.add(index, aVictim);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVictimAt(aVictim, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfInvestigatingOfficers()
  {
    return 0;
  }

  public boolean addInvestigatingOfficer(InvestigatingOfficer aInvestigatingOfficer)
  {
    boolean wasAdded = false;
    if (investigatingOfficers.contains(aInvestigatingOfficer)) { return false; }
    investigatingOfficers.add(aInvestigatingOfficer);
    if (aInvestigatingOfficer.indexOfCrimeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aInvestigatingOfficer.addCrimeOccurrence(this);
      if (!wasAdded)
      {
        investigatingOfficers.remove(aInvestigatingOfficer);
      }
    }
    return wasAdded;
  }

  public boolean removeInvestigatingOfficer(InvestigatingOfficer aInvestigatingOfficer)
  {
    boolean wasRemoved = false;
    if (!investigatingOfficers.contains(aInvestigatingOfficer))
    {
      return wasRemoved;
    }

    int oldIndex = investigatingOfficers.indexOf(aInvestigatingOfficer);
    investigatingOfficers.remove(oldIndex);
    if (aInvestigatingOfficer.indexOfCrimeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aInvestigatingOfficer.removeCrimeOccurrence(this);
      if (!wasRemoved)
      {
        investigatingOfficers.add(oldIndex,aInvestigatingOfficer);
      }
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

  public static int minimumNumberOfJurisdictions()
  {
    return 0;
  }

  public boolean addJurisdiction(Jurisdiction aJurisdiction)
  {
    boolean wasAdded = false;
    if (jurisdictions.contains(aJurisdiction)) { return false; }
    jurisdictions.add(aJurisdiction);
    if (aJurisdiction.indexOfCrimeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aJurisdiction.addCrimeOccurrence(this);
      if (!wasAdded)
      {
        jurisdictions.remove(aJurisdiction);
      }
    }
    return wasAdded;
  }

  public boolean removeJurisdiction(Jurisdiction aJurisdiction)
  {
    boolean wasRemoved = false;
    if (!jurisdictions.contains(aJurisdiction))
    {
      return wasRemoved;
    }

    int oldIndex = jurisdictions.indexOf(aJurisdiction);
    jurisdictions.remove(oldIndex);
    if (aJurisdiction.indexOfCrimeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aJurisdiction.removeCrimeOccurrence(this);
      if (!wasRemoved)
      {
        jurisdictions.add(oldIndex,aJurisdiction);
      }
    }
    return wasRemoved;
  }

  public boolean addJurisdictionAt(Jurisdiction aJurisdiction, int index)
  {  
    boolean wasAdded = false;
    if(addJurisdiction(aJurisdiction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJurisdictions()) { index = numberOfJurisdictions() - 1; }
      jurisdictions.remove(aJurisdiction);
      jurisdictions.add(index, aJurisdiction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveJurisdictionAt(Jurisdiction aJurisdiction, int index)
  {
    boolean wasAdded = false;
    if(jurisdictions.contains(aJurisdiction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJurisdictions()) { index = numberOfJurisdictions() - 1; }
      jurisdictions.remove(aJurisdiction);
      jurisdictions.add(index, aJurisdiction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addJurisdictionAt(aJurisdiction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<ChargeOccurrence> copyOfChargeOccurrences = new ArrayList<ChargeOccurrence>(chargeOccurrences);
    chargeOccurrences.clear();
    for(ChargeOccurrence aChargeOccurrence : copyOfChargeOccurrences)
    {
      aChargeOccurrence.removeCrimeOccurrence(this);
    }
    ArrayList<Suspect> copyOfSuspects = new ArrayList<Suspect>(suspects);
    suspects.clear();
    for(Suspect aSuspect : copyOfSuspects)
    {
      aSuspect.removeCrimeOccurrence(this);
    }
    ArrayList<Witness> copyOfWitnesses = new ArrayList<Witness>(witnesses);
    witnesses.clear();
    for(Witness aWitness : copyOfWitnesses)
    {
      aWitness.removeCrimeOccurrence(this);
    }
    ArrayList<Victim> copyOfVictims = new ArrayList<Victim>(victims);
    victims.clear();
    for(Victim aVictim : copyOfVictims)
    {
      aVictim.removeCrimeOccurrence(this);
    }
    ArrayList<InvestigatingOfficer> copyOfInvestigatingOfficers = new ArrayList<InvestigatingOfficer>(investigatingOfficers);
    investigatingOfficers.clear();
    for(InvestigatingOfficer aInvestigatingOfficer : copyOfInvestigatingOfficers)
    {
      aInvestigatingOfficer.removeCrimeOccurrence(this);
    }
    ArrayList<Jurisdiction> copyOfJurisdictions = new ArrayList<Jurisdiction>(jurisdictions);
    jurisdictions.clear();
    for(Jurisdiction aJurisdiction : copyOfJurisdictions)
    {
      aJurisdiction.removeCrimeOccurrence(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "," +
            "date" + ":" + getDate()+ "," +
            "time" + ":" + getTime()+ "," +
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}