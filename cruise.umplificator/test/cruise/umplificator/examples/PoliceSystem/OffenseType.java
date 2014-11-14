/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 11 "PoliceSystem.ump"
// line 75 "PoliceSystem.ump"
public class OffenseType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OffenseType Attributes
  private String name;
  private String description;
  private String act;
  private String section;
  private String maxPenalty;

  //OffenseType Associations
  private List<ChargeOccurrence> chargeOccurrences;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OffenseType(String aName, String aDescription, String aAct, String aSection, String aMaxPenalty)
  {
    name = aName;
    description = aDescription;
    act = aAct;
    section = aSection;
    maxPenalty = aMaxPenalty;
    chargeOccurrences = new ArrayList<ChargeOccurrence>();
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

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setAct(String aAct)
  {
    boolean wasSet = false;
    act = aAct;
    wasSet = true;
    return wasSet;
  }

  public boolean setSection(String aSection)
  {
    boolean wasSet = false;
    section = aSection;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaxPenalty(String aMaxPenalty)
  {
    boolean wasSet = false;
    maxPenalty = aMaxPenalty;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public String getAct()
  {
    return act;
  }

  public String getSection()
  {
    return section;
  }

  public String getMaxPenalty()
  {
    return maxPenalty;
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

  public static int minimumNumberOfChargeOccurrences()
  {
    return 0;
  }

  public ChargeOccurrence addChargeOccurrence(String aDateEntered, String aDisposition, String aPenalty, Suspect aSuspect)
  {
    return new ChargeOccurrence(aDateEntered, aDisposition, aPenalty, this, aSuspect);
  }

  public boolean addChargeOccurrence(ChargeOccurrence aChargeOccurrence)
  {
    boolean wasAdded = false;
    if (chargeOccurrences.contains(aChargeOccurrence)) { return false; }
    OffenseType existingOffenseType = aChargeOccurrence.getOffenseType();
    boolean isNewOffenseType = existingOffenseType != null && !this.equals(existingOffenseType);
    if (isNewOffenseType)
    {
      aChargeOccurrence.setOffenseType(this);
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
    //Unable to remove aChargeOccurrence, as it must always have a offenseType
    if (!this.equals(aChargeOccurrence.getOffenseType()))
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

  public void delete()
  {
    for(int i=chargeOccurrences.size(); i > 0; i--)
    {
      ChargeOccurrence aChargeOccurrence = chargeOccurrences.get(i - 1);
      aChargeOccurrence.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "description" + ":" + getDescription()+ "," +
            "act" + ":" + getAct()+ "," +
            "section" + ":" + getSection()+ "," +
            "maxPenalty" + ":" + getMaxPenalty()+ "]"
     + outputString;
  }
}