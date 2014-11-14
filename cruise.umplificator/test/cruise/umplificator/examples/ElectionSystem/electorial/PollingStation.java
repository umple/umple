/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

// line 7 "../../ElectionSystem.ump"
// line 96 "../../ElectionSystem.ump"
public class PollingStation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PollingStation Attributes
  private int number;
  private String address;

  //PollingStation Associations
  private List<PollInElection> pollInElections;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PollingStation(int aNumber, String aAddress)
  {
    number = aNumber;
    address = aAddress;
    pollInElections = new ArrayList<PollInElection>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public String getAddress()
  {
    return address;
  }

  public PollInElection getPollInElection(int index)
  {
    PollInElection aPollInElection = pollInElections.get(index);
    return aPollInElection;
  }

  public List<PollInElection> getPollInElections()
  {
    List<PollInElection> newPollInElections = Collections.unmodifiableList(pollInElections);
    return newPollInElections;
  }

  public int numberOfPollInElections()
  {
    int number = pollInElections.size();
    return number;
  }

  public boolean hasPollInElections()
  {
    boolean has = pollInElections.size() > 0;
    return has;
  }

  public int indexOfPollInElection(PollInElection aPollInElection)
  {
    int index = pollInElections.indexOf(aPollInElection);
    return index;
  }

  public static int minimumNumberOfPollInElections()
  {
    return 0;
  }

  public PollInElection addPollInElection(int aNumber, Election aElection)
  {
    return new PollInElection(aNumber, this, aElection);
  }

  public boolean addPollInElection(PollInElection aPollInElection)
  {
    boolean wasAdded = false;
    if (pollInElections.contains(aPollInElection)) { return false; }
    PollingStation existingPollingStation = aPollInElection.getPollingStation();
    boolean isNewPollingStation = existingPollingStation != null && !this.equals(existingPollingStation);
    if (isNewPollingStation)
    {
      aPollInElection.setPollingStation(this);
    }
    else
    {
      pollInElections.add(aPollInElection);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePollInElection(PollInElection aPollInElection)
  {
    boolean wasRemoved = false;
    //Unable to remove aPollInElection, as it must always have a pollingStation
    if (!this.equals(aPollInElection.getPollingStation()))
    {
      pollInElections.remove(aPollInElection);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPollInElectionAt(PollInElection aPollInElection, int index)
  {  
    boolean wasAdded = false;
    if(addPollInElection(aPollInElection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPollInElections()) { index = numberOfPollInElections() - 1; }
      pollInElections.remove(aPollInElection);
      pollInElections.add(index, aPollInElection);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePollInElectionAt(PollInElection aPollInElection, int index)
  {
    boolean wasAdded = false;
    if(pollInElections.contains(aPollInElection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPollInElections()) { index = numberOfPollInElections() - 1; }
      pollInElections.remove(aPollInElection);
      pollInElections.add(index, aPollInElection);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPollInElectionAt(aPollInElection, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=pollInElections.size(); i > 0; i--)
    {
      PollInElection aPollInElection = pollInElections.get(i - 1);
      aPollInElection.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "address" + ":" + getAddress()+ "]"
     + outputString;
  }
}