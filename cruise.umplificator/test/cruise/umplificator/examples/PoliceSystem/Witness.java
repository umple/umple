/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 32 "PoliceSystem.ump"
// line 113 "PoliceSystem.ump"
public class Witness extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Witness Attributes
  private String statement;

  //Witness Associations
  private List<CrimeOccurrence> crimeOccurrences;
  private List<SuspectDescription> suspectDescriptions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Witness(String aName, String aPhone, String aSex, String aAddress, String aAge, String aStatement)
  {
    super(aName, aPhone, aSex, aAddress, aAge);
    statement = aStatement;
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

  public static int minimumNumberOfCrimeOccurrences()
  {
    return 0;
  }

  public boolean addCrimeOccurrence(CrimeOccurrence aCrimeOccurrence)
  {
    boolean wasAdded = false;
    if (crimeOccurrences.contains(aCrimeOccurrence)) { return false; }
    crimeOccurrences.add(aCrimeOccurrence);
    if (aCrimeOccurrence.indexOfWitness(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrimeOccurrence.addWitness(this);
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
    if (aCrimeOccurrence.indexOfWitness(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrimeOccurrence.removeWitness(this);
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

  public SuspectDescription addSuspectDescription(String aHeight, String aWeight, String aBuild, String aColour, String aHairCharacteristics, String aFacialCharacteristics, String aOtherDetails)
  {
    return new SuspectDescription(aHeight, aWeight, aBuild, aColour, aHairCharacteristics, aFacialCharacteristics, aOtherDetails, this);
  }

  public boolean addSuspectDescription(SuspectDescription aSuspectDescription)
  {
    boolean wasAdded = false;
    if (suspectDescriptions.contains(aSuspectDescription)) { return false; }
    Witness existingDescribedBy = aSuspectDescription.getDescribedBy();
    boolean isNewDescribedBy = existingDescribedBy != null && !this.equals(existingDescribedBy);
    if (isNewDescribedBy)
    {
      aSuspectDescription.setDescribedBy(this);
    }
    else
    {
      suspectDescriptions.add(aSuspectDescription);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSuspectDescription(SuspectDescription aSuspectDescription)
  {
    boolean wasRemoved = false;
    //Unable to remove aSuspectDescription, as it must always have a describedBy
    if (!this.equals(aSuspectDescription.getDescribedBy()))
    {
      suspectDescriptions.remove(aSuspectDescription);
      wasRemoved = true;
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
    ArrayList<CrimeOccurrence> copyOfCrimeOccurrences = new ArrayList<CrimeOccurrence>(crimeOccurrences);
    crimeOccurrences.clear();
    for(CrimeOccurrence aCrimeOccurrence : copyOfCrimeOccurrences)
    {
      aCrimeOccurrence.removeWitness(this);
    }
    for(int i=suspectDescriptions.size(); i > 0; i--)
    {
      SuspectDescription aSuspectDescription = suspectDescriptions.get(i - 1);
      aSuspectDescription.delete();
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