/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 9 "PoliceSystem.ump"
// line 97 "PoliceSystem.ump"
public class ChargeOccurrence
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ChargeOccurrence Attributes
  private String dateEntered;
  private String disposition;
  private String penalty;

  //ChargeOccurrence Associations
  private OffenseType offenseType;
  private List<CrimeOccurrence> crimeOccurrences;
  private Suspect suspect;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ChargeOccurrence(String aDateEntered, String aDisposition, String aPenalty, OffenseType aOffenseType, Suspect aSuspect)
  {
    dateEntered = aDateEntered;
    disposition = aDisposition;
    penalty = aPenalty;
    boolean didAddOffenseType = setOffenseType(aOffenseType);
    if (!didAddOffenseType)
    {
      throw new RuntimeException("Unable to create chargeOccurrence due to offenseType");
    }
    crimeOccurrences = new ArrayList<CrimeOccurrence>();
    boolean didAddSuspect = setSuspect(aSuspect);
    if (!didAddSuspect)
    {
      throw new RuntimeException("Unable to create chargeOccurrence due to suspect");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateEntered(String aDateEntered)
  {
    boolean wasSet = false;
    dateEntered = aDateEntered;
    wasSet = true;
    return wasSet;
  }

  public boolean setDisposition(String aDisposition)
  {
    boolean wasSet = false;
    disposition = aDisposition;
    wasSet = true;
    return wasSet;
  }

  public boolean setPenalty(String aPenalty)
  {
    boolean wasSet = false;
    penalty = aPenalty;
    wasSet = true;
    return wasSet;
  }

  public String getDateEntered()
  {
    return dateEntered;
  }

  public String getDisposition()
  {
    return disposition;
  }

  public String getPenalty()
  {
    return penalty;
  }

  public OffenseType getOffenseType()
  {
    return offenseType;
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

  public Suspect getSuspect()
  {
    return suspect;
  }

  public boolean setOffenseType(OffenseType aOffenseType)
  {
    boolean wasSet = false;
    if (aOffenseType == null)
    {
      return wasSet;
    }

    OffenseType existingOffenseType = offenseType;
    offenseType = aOffenseType;
    if (existingOffenseType != null && !existingOffenseType.equals(aOffenseType))
    {
      existingOffenseType.removeChargeOccurrence(this);
    }
    offenseType.addChargeOccurrence(this);
    wasSet = true;
    return wasSet;
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
    if (aCrimeOccurrence.indexOfChargeOccurrence(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrimeOccurrence.addChargeOccurrence(this);
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
    if (aCrimeOccurrence.indexOfChargeOccurrence(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrimeOccurrence.removeChargeOccurrence(this);
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

  public boolean setSuspect(Suspect aSuspect)
  {
    boolean wasSet = false;
    if (aSuspect == null)
    {
      return wasSet;
    }

    Suspect existingSuspect = suspect;
    suspect = aSuspect;
    if (existingSuspect != null && !existingSuspect.equals(aSuspect))
    {
      existingSuspect.removeChargeOccurrence(this);
    }
    suspect.addChargeOccurrence(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    OffenseType placeholderOffenseType = offenseType;
    this.offenseType = null;
    placeholderOffenseType.removeChargeOccurrence(this);
    ArrayList<CrimeOccurrence> copyOfCrimeOccurrences = new ArrayList<CrimeOccurrence>(crimeOccurrences);
    crimeOccurrences.clear();
    for(CrimeOccurrence aCrimeOccurrence : copyOfCrimeOccurrences)
    {
      aCrimeOccurrence.removeChargeOccurrence(this);
    }
    Suspect placeholderSuspect = suspect;
    this.suspect = null;
    placeholderSuspect.removeChargeOccurrence(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "dateEntered" + ":" + getDateEntered()+ "," +
            "disposition" + ":" + getDisposition()+ "," +
            "penalty" + ":" + getPenalty()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "offenseType = "+(getOffenseType()!=null?Integer.toHexString(System.identityHashCode(getOffenseType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "suspect = "+(getSuspect()!=null?Integer.toHexString(System.identityHashCode(getSuspect())):"null")
     + outputString;
  }
}