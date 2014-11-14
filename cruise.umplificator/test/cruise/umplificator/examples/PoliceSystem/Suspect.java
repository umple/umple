/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 26 "PoliceSystem.ump"
// line 118 "PoliceSystem.ump"
public class Suspect extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Suspect Attributes
  private String statement;

  //Suspect Associations
  private List<ChargeOccurrence> chargeOccurrences;
  private List<CrimeOccurrence> crimeOccurrences;
  private List<SuspectDescription> suspectDescriptions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Suspect(String aName, String aPhone, String aSex, String aAddress, String aAge, String aStatement)
  {
    super(aName, aPhone, aSex, aAddress, aAge);
    statement = aStatement;
    chargeOccurrences = new ArrayList<ChargeOccurrence>();
    crimeOccurrences = new ArrayList<CrimeOccurrence>();
    suspectDescriptions = new ArrayList<SuspectDescription>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStatement(String aStatement)
  {
    boolean wasSet = false;
    statement = aStatement;
    wasSet = true;
    return wasSet;
  }

  public String getStatement()
  {
    return statement;
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

  public SuspectDescription getSuspectDescription(int index)
  {
    SuspectDescription aSuspectDescription = suspectDescriptions.get(index);
    return aSuspectDescription;
  }

  public List<SuspectDescription> getSuspectDescriptions()
  {
    List<SuspectDescription> newSuspectDescriptions = Collections.unmodifiableList(suspectDescriptions);
    return newSuspectDescriptions;
  }

  public int numberOfSuspectDescriptions()
  {
    int number = suspectDescriptions.size();
    return number;
  }

  public boolean hasSuspectDescriptions()
  {
    boolean has = suspectDescriptions.size() > 0;
    return has;
  }

  public int indexOfSuspectDescription(SuspectDescription aSuspectDescription)
  {
    int index = suspectDescriptions.indexOf(aSuspectDescription);
    return index;
  }

  public static int minimumNumberOfChargeOccurrences()
  {
    return 0;
  }

  public ChargeOccurrence addChargeOccurrence(String aDateEntered, String aDisposition, String aPenalty, OffenseType aOffenseType)
  {
    return new ChargeOccurrence(aDateEntered, aDisposition, aPenalty, aOffenseType, this);
  }

  public boolean addChargeOccurrence(ChargeOccurrence aChargeOccurrence)
  {
    boolean wasAdded = false;
    if (chargeOccurrences.contains(aChargeOccurrence)) { return false; }
    Suspect existingSuspect = aChargeOccurrence.getSuspect();
    boolean isNewSuspect = existingSuspect != null && !this.equals(existingSuspect);
    if (isNewSuspect)
    {
      aChargeOccurrence.setSuspect(this);
    }
    else
    {
      chargeOccurrences.add(aChargeOccurrence);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeChargeOccurrence(ChargeOccurrence aChargeOccurrence)
  {
    boolean wasRemoved = false;
    //Unable to remove aChargeOccurrence, as it must always have a suspect
    if (!this.equals(aChargeOccurrence.getSuspect()))
    {
      chargeOccurrences.remove(aChargeOccurrence);
      wasRemoved = true;
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

  public static int minimumNumberOfCrimeOccurrences()
  {
    return 0;
  }

  public boolean addCrimeOccurrence(CrimeOccurrence aCrimeOccurrence)
  {
    boolean wasAdded = false;
    if (crimeOccurrences.contains(aCrimeOccurrence)) { return false; }
    crimeOccurrences.add(aCrimeOccurrence);
    if (aCrimeOccurrence.indexOfSuspect(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrimeOccurrence.addSuspect(this);
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
    if (aCrimeOccurrence.indexOfSuspect(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrimeOccurrence.removeSuspect(this);
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

  public static int minimumNumberOfSuspectDescriptions()
  {
    return 0;
  }

  public boolean addSuspectDescription(SuspectDescription aSuspectDescription)
  {
    boolean wasAdded = false;
    if (suspectDescriptions.contains(aSuspectDescription)) { return false; }
    suspectDescriptions.add(aSuspectDescription);
    if (aSuspectDescription.indexOfMatche(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSuspectDescription.addMatche(this);
      if (!wasAdded)
      {
        suspectDescriptions.remove(aSuspectDescription);
      }
    }
    return wasAdded;
  }

  public boolean removeSuspectDescription(SuspectDescription aSuspectDescription)
  {
    boolean wasRemoved = false;
    if (!suspectDescriptions.contains(aSuspectDescription))
    {
      return wasRemoved;
    }

    int oldIndex = suspectDescriptions.indexOf(aSuspectDescription);
    suspectDescriptions.remove(oldIndex);
    if (aSuspectDescription.indexOfMatche(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSuspectDescription.removeMatche(this);
      if (!wasRemoved)
      {
        suspectDescriptions.add(oldIndex,aSuspectDescription);
      }
    }
    return wasRemoved;
  }

  public boolean addSuspectDescriptionAt(SuspectDescription aSuspectDescription, int index)
  {  
    boolean wasAdded = false;
    if(addSuspectDescription(aSuspectDescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuspectDescriptions()) { index = numberOfSuspectDescriptions() - 1; }
      suspectDescriptions.remove(aSuspectDescription);
      suspectDescriptions.add(index, aSuspectDescription);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSuspectDescriptionAt(SuspectDescription aSuspectDescription, int index)
  {
    boolean wasAdded = false;
    if(suspectDescriptions.contains(aSuspectDescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuspectDescriptions()) { index = numberOfSuspectDescriptions() - 1; }
      suspectDescriptions.remove(aSuspectDescription);
      suspectDescriptions.add(index, aSuspectDescription);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSuspectDescriptionAt(aSuspectDescription, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=chargeOccurrences.size(); i > 0; i--)
    {
      ChargeOccurrence aChargeOccurrence = chargeOccurrences.get(i - 1);
      aChargeOccurrence.delete();
    }
    ArrayList<CrimeOccurrence> copyOfCrimeOccurrences = new ArrayList<CrimeOccurrence>(crimeOccurrences);
    crimeOccurrences.clear();
    for(CrimeOccurrence aCrimeOccurrence : copyOfCrimeOccurrences)
    {
      aCrimeOccurrence.removeSuspect(this);
    }
    ArrayList<SuspectDescription> copyOfSuspectDescriptions = new ArrayList<SuspectDescription>(suspectDescriptions);
    suspectDescriptions.clear();
    for(SuspectDescription aSuspectDescription : copyOfSuspectDescriptions)
    {
      aSuspectDescription.removeMatche(this);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "statement" + ":" + getStatement()+ "]"
     + outputString;
  }
}