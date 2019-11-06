/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.OptionalOneToMany;
import java.util.*;

// line 8 "../../../OptionalOneToManyMutation_uModel.ump"
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
  private List<TelephoneNumber> originator;
  private List<TelephoneNumber> parties;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneCall(String aIsOnHold, String aStartTime, String aDuration)
  {
    isOnHold = aIsOnHold;
    startTime = aStartTime;
    duration = aDuration;
    originator = new ArrayList<TelephoneNumber>();
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
  /* Code from template association_GetMany */
  public TelephoneNumber getOriginator(int index)
  {
    TelephoneNumber aOriginator = originator.get(index);
    return aOriginator;
  }

  public List<TelephoneNumber> getOriginator()
  {
    List<TelephoneNumber> newOriginator = Collections.unmodifiableList(originator);
    return newOriginator;
  }

  public int numberOfOriginator()
  {
    int number = originator.size();
    return number;
  }

  public boolean hasOriginator()
  {
    boolean has = originator.size() > 0;
    return has;
  }

  public int indexOfOriginator(TelephoneNumber aOriginator)
  {
    int index = originator.indexOf(aOriginator);
    return index;
  }
  /* Code from template association_GetMany */
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOriginator()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public TelephoneNumber addOriginator(String aDigits, PhoneCall aPhoneCall, VoiceMailBox aVoiceMailBox)
  {
    return new TelephoneNumber(aDigits, this, aPhoneCall, aVoiceMailBox);
  }

  public boolean addOriginator(TelephoneNumber aOriginator)
  {
    boolean wasAdded = false;
    PhoneCall existingCall = aOriginator.getCall();
    boolean isNewCall = existingCall != null && !this.equals(existingCall);
    if (isNewCall)
    {
      aOriginator.setCall(this);
    }
    else
    {
      originator.add(aOriginator);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOriginator(TelephoneNumber aOriginator)
  {
    boolean wasRemoved = false;
    //Unable to remove aOriginator, as it must always have a call
    if (!this.equals(aOriginator.getCall()))
    {
      originator.remove(aOriginator);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOriginatorAt(TelephoneNumber aOriginator, int index)
  {  
    boolean wasAdded = false;
    if(addOriginator(aOriginator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOriginator()) { index = numberOfOriginator() - 1; }
      originator.remove(aOriginator);
      originator.add(index, aOriginator);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOriginatorAt(TelephoneNumber aOriginator, int index)
  {
    boolean wasAdded = false;
    if(originator.contains(aOriginator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOriginator()) { index = numberOfOriginator() - 1; }
      originator.remove(aOriginator);
      originator.add(index, aOriginator);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOriginatorAt(aOriginator, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfParties()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public TelephoneNumber addParty(String aDigits, PhoneCall aCall, VoiceMailBox aVoiceMailBox)
  {
    return new TelephoneNumber(aDigits, aCall, this, aVoiceMailBox);
  }

  public boolean addParty(TelephoneNumber aParty)
  {
    boolean wasAdded = false;
    PhoneCall existingPhoneCall = aParty.getPhoneCall();
    boolean isNewPhoneCall = existingPhoneCall != null && !this.equals(existingPhoneCall);
    if (isNewPhoneCall)
    {
      aParty.setPhoneCall(this);
    }
    else
    {
      parties.add(aParty);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParty(TelephoneNumber aParty)
  {
    boolean wasRemoved = false;
    //Unable to remove aParty, as it must always have a phoneCall
    if (!this.equals(aParty.getPhoneCall()))
    {
      parties.remove(aParty);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
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
    for(int i=originator.size(); i > 0; i--)
    {
      TelephoneNumber aOriginator = originator.get(i - 1);
      aOriginator.delete();
    }
    for(int i=parties.size(); i > 0; i--)
    {
      TelephoneNumber aParty = parties.get(i - 1);
      aParty.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "isOnHold" + ":" + getIsOnHold()+ "," +
            "startTime" + ":" + getStartTime()+ "," +
            "duration" + ":" + getDuration()+ "]";
  }
}