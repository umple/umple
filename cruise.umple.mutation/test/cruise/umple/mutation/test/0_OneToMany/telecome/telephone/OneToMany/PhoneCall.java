/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.OneToMany;
import java.util.*;

// line 8 "../../../OneToManyMutation_uModel.ump"
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
  private List<TelephoneNumber> parties;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneCall(String aIsOnHold, String aStartTime, String aDuration)
  {
    isOnHold = aIsOnHold;
    startTime = aStartTime;
    duration = aDuration;
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
  public static int minimumNumberOfParties()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addParty(TelephoneNumber aParty)
  {
    boolean wasAdded = false;
    PhoneCall existingPhoneCall = aParty.getPhoneCall();
    if (existingPhoneCall == null)
    {
      aParty.setPhoneCall(this);
    }
    else if (!this.equals(existingPhoneCall))
    {
      existingPhoneCall.removeParty(aParty);
      addParty(aParty);
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
    if (parties.contains(aParty))
    {
      parties.remove(aParty);
      aParty.setPhoneCall(null);
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
    while( !parties.isEmpty() )
    {
      parties.get(0).setPhoneCall(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "isOnHold" + ":" + getIsOnHold()+ "," +
            "startTime" + ":" + getStartTime()+ "," +
            "duration" + ":" + getDuration()+ "]";
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 12 "../../../OneToManyMutation_uModel.ump"
  0..1  * TelephoneNumber originator ;

  
}