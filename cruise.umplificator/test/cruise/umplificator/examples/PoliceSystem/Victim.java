/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 37 "PoliceSystem.ump"
// line 108 "PoliceSystem.ump"
public class Victim extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Victim Attributes
  private String injurySuffered;

  //Victim Associations
  private List<CrimeOccurrence> crimeOccurrences;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Victim(String aName, String aPhone, String aSex, String aAddress, String aAge, String aInjurySuffered)
  {
    super(aName, aPhone, aSex, aAddress, aAge);
    injurySuffered = aInjurySuffered;
    crimeOccurrences = new ArrayList<CrimeOccurrence>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInjurySuffered(String aInjurySuffered)
  {
    boolean wasSet = false;
    injurySuffered = aInjurySuffered;
    wasSet = true;
    return wasSet;
  }

  public String getInjurySuffered()
  {
    return injurySuffered;
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

  public static int minimumNumberOfCrimeOccurrences()
  {
    return 0;
  }

  public boolean addCrimeOccurrence(CrimeOccurrence aCrimeOccurrence)
  {
    boolean wasAdded = false;
    if (crimeOccurrences.contains(aCrimeOccurrence)) { return false; }
    crimeOccurrences.add(aCrimeOccurrence);
    if (aCrimeOccurrence.indexOfVictim(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrimeOccurrence.addVictim(this);
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
    if (aCrimeOccurrence.indexOfVictim(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrimeOccurrence.removeVictim(this);
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
    ArrayList<CrimeOccurrence> copyOfCrimeOccurrences = new ArrayList<CrimeOccurrence>(crimeOccurrences);
    crimeOccurrences.clear();
    for(CrimeOccurrence aCrimeOccurrence : copyOfCrimeOccurrences)
    {
      aCrimeOccurrence.removeVictim(this);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "injurySuffered" + ":" + getInjurySuffered()+ "]"
     + outputString;
  }
}