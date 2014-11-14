/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 9 "TelephoneSystem.ump"
// line 41 "TelephoneSystem.ump"
public class PhoneCall
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneCall Attributes
  private String isOnHold;
  private String startTime;
  private String duration;

  //PhoneCall Associations
  private TelephoneNumber originator;
  private List<TelephoneNumber> parties;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneCall(String aIsOnHold, String aStartTime, String aDuration, TelephoneNumber aOriginator)
  {
    isOnHold = aIsOnHold;
    startTime = aStartTime;
    duration = aDuration;
    boolean didAddOriginator = setOriginator(aOriginator);
    if (!didAddOriginator)
    {
      throw new RuntimeException("Unable to create call due to originator");
    }
    parties = new ArrayList<TelephoneNumber>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsOnHold(String aIsOnHold)
  {
    boolean wasSet = false;
    isOnHold = aIsOnHold;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(String aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setDuration(String aDuration)
  {
    boolean wasSet = false;
    duration = aDuration;
    wasSet = true;
    return wasSet;
  }

  public String getIsOnHold()
  {
    return isOnHold;
  }

  public String getStartTime()
  {
    return startTime;
  }

  public String getDuration()
  {
    return duration;
  }

  public TelephoneNumber getOriginator()
  {
    return originator;
  }

  public TelephoneNumber getParty(int index)
  {
    TelephoneNumber aParty = parties.get(index);
    return aParty;
  }

  public List<TelephoneNumber> getParties()
  {
    List<TelephoneNumber> newParties = Collections.unmodifiableList(parties);
    return newParties;
  }

  public int numberOfParties()
  {
    int number = parties.size();
    return number;
  }

  public boolean hasParties()
  {
    boolean has = parties.size() > 0;
    return has;
  }

  public int indexOfParty(TelephoneNumber aParty)
  {
    int index = parties.indexOf(aParty);
    return index;
  }

  public boolean setOriginator(TelephoneNumber aOriginator)
  {
    boolean wasSet = false;
    if (aOriginator == null)
    {
      return wasSet;
    }

    TelephoneNumber existingOriginator = originator;
    originator = aOriginator;
    if (existingOriginator != null && !existingOriginator.equals(aOriginator))
    {
      existingOriginator.removeCall(this);
    }
    originator.addCall(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfParties()
  {
    return 0;
  }

  public boolean addParty(TelephoneNumber aParty)
  {
    boolean wasAdded = false;
    if (parties.contains(aParty)) { return false; }
    parties.add(aParty);
    if (aParty.indexOfPhoneCall(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aParty.addPhoneCall(this);
      if (!wasAdded)
      {
        parties.remove(aParty);
      }
    }
    return wasAdded;
  }

  public boolean removeParty(TelephoneNumber aParty)
  {
    boolean wasRemoved = false;
    if (!parties.contains(aParty))
    {
      return wasRemoved;
    }

    int oldIndex = parties.indexOf(aParty);
    parties.remove(oldIndex);
    if (aParty.indexOfPhoneCall(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aParty.removePhoneCall(this);
      if (!wasRemoved)
      {
        parties.add(oldIndex,aParty);
      }
    }
    return wasRemoved;
  }

  public boolean addPartyAt(TelephoneNumber aParty, int index)
  {  
    boolean wasAdded = false;
    if(addParty(aParty))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParties()) { index = numberOfParties() - 1; }
      parties.remove(aParty);
      parties.add(index, aParty);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePartyAt(TelephoneNumber aParty, int index)
  {
    boolean wasAdded = false;
    if(parties.contains(aParty))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParties()) { index = numberOfParties() - 1; }
      parties.remove(aParty);
      parties.add(index, aParty);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPartyAt(aParty, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    TelephoneNumber placeholderOriginator = originator;
    this.originator = null;
    placeholderOriginator.removeCall(this);
    ArrayList<TelephoneNumber> copyOfParties = new ArrayList<TelephoneNumber>(parties);
    parties.clear();
    for(TelephoneNumber aParty : copyOfParties)
    {
      aParty.removePhoneCall(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isOnHold" + ":" + getIsOnHold()+ "," +
            "startTime" + ":" + getStartTime()+ "," +
            "duration" + ":" + getDuration()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "originator = "+(getOriginator()!=null?Integer.toHexString(System.identityHashCode(getOriginator())):"null")
     + outputString;
  }
}