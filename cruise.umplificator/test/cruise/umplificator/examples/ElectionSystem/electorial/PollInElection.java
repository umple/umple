/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

// line 63 "../../ElectionSystem.ump"
// line 113 "../../ElectionSystem.ump"
public class PollInElection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PollInElection Attributes
  private int number;

  //PollInElection Associations
  private List<Voter> voters;
  private PollingStation pollingStation;
  private Election election;
  private List<VotesInPoll> votesInPolls;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PollInElection(int aNumber, PollingStation aPollingStation, Election aElection)
  {
    number = aNumber;
    voters = new ArrayList<Voter>();
    boolean didAddPollingStation = setPollingStation(aPollingStation);
    if (!didAddPollingStation)
    {
      throw new RuntimeException("Unable to create pollInElection due to pollingStation");
    }
    boolean didAddElection = setElection(aElection);
    if (!didAddElection)
    {
      throw new RuntimeException("Unable to create pollInElection due to election");
    }
    votesInPolls = new ArrayList<VotesInPoll>();
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

  public int getNumber()
  {
    return number;
  }

  public Voter getVoter(int index)
  {
    Voter aVoter = voters.get(index);
    return aVoter;
  }

  public List<Voter> getVoters()
  {
    List<Voter> newVoters = Collections.unmodifiableList(voters);
    return newVoters;
  }

  public int numberOfVoters()
  {
    int number = voters.size();
    return number;
  }

  public boolean hasVoters()
  {
    boolean has = voters.size() > 0;
    return has;
  }

  public int indexOfVoter(Voter aVoter)
  {
    int index = voters.indexOf(aVoter);
    return index;
  }

  public PollingStation getPollingStation()
  {
    return pollingStation;
  }

  public Election getElection()
  {
    return election;
  }

  public VotesInPoll getVotesInPoll(int index)
  {
    VotesInPoll aVotesInPoll = votesInPolls.get(index);
    return aVotesInPoll;
  }

  public List<VotesInPoll> getVotesInPolls()
  {
    List<VotesInPoll> newVotesInPolls = Collections.unmodifiableList(votesInPolls);
    return newVotesInPolls;
  }

  public int numberOfVotesInPolls()
  {
    int number = votesInPolls.size();
    return number;
  }

  public boolean hasVotesInPolls()
  {
    boolean has = votesInPolls.size() > 0;
    return has;
  }

  public int indexOfVotesInPoll(VotesInPoll aVotesInPoll)
  {
    int index = votesInPolls.indexOf(aVotesInPoll);
    return index;
  }

  public static int minimumNumberOfVoters()
  {
    return 0;
  }

  public Voter addVoter(String aName, String aAddress, ElectoralDistrict aElectoralDistrict)
  {
    return new Voter(aName, aAddress, this, aElectoralDistrict);
  }

  public boolean addVoter(Voter aVoter)
  {
    boolean wasAdded = false;
    if (voters.contains(aVoter)) { return false; }
    PollInElection existingPollInElection = aVoter.getPollInElection();
    boolean isNewPollInElection = existingPollInElection != null && !this.equals(existingPollInElection);
    if (isNewPollInElection)
    {
      aVoter.setPollInElection(this);
    }
    else
    {
      voters.add(aVoter);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVoter(Voter aVoter)
  {
    boolean wasRemoved = false;
    //Unable to remove aVoter, as it must always have a pollInElection
    if (!this.equals(aVoter.getPollInElection()))
    {
      voters.remove(aVoter);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVoterAt(Voter aVoter, int index)
  {  
    boolean wasAdded = false;
    if(addVoter(aVoter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoters()) { index = numberOfVoters() - 1; }
      voters.remove(aVoter);
      voters.add(index, aVoter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoterAt(Voter aVoter, int index)
  {
    boolean wasAdded = false;
    if(voters.contains(aVoter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoters()) { index = numberOfVoters() - 1; }
      voters.remove(aVoter);
      voters.add(index, aVoter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoterAt(aVoter, index);
    }
    return wasAdded;
  }

  public boolean setPollingStation(PollingStation aPollingStation)
  {
    boolean wasSet = false;
    if (aPollingStation == null)
    {
      return wasSet;
    }

    PollingStation existingPollingStation = pollingStation;
    pollingStation = aPollingStation;
    if (existingPollingStation != null && !existingPollingStation.equals(aPollingStation))
    {
      existingPollingStation.removePollInElection(this);
    }
    pollingStation.addPollInElection(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setElection(Election aElection)
  {
    boolean wasSet = false;
    if (aElection == null)
    {
      return wasSet;
    }

    Election existingElection = election;
    election = aElection;
    if (existingElection != null && !existingElection.equals(aElection))
    {
      existingElection.removePollInElection(this);
    }
    election.addPollInElection(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfVotesInPolls()
  {
    return 0;
  }

  public VotesInPoll addVotesInPoll(int aNumVotes, Candidature aCandidature)
  {
    return new VotesInPoll(aNumVotes, aCandidature, this);
  }

  public boolean addVotesInPoll(VotesInPoll aVotesInPoll)
  {
    boolean wasAdded = false;
    if (votesInPolls.contains(aVotesInPoll)) { return false; }
    PollInElection existingPollInElection = aVotesInPoll.getPollInElection();
    boolean isNewPollInElection = existingPollInElection != null && !this.equals(existingPollInElection);
    if (isNewPollInElection)
    {
      aVotesInPoll.setPollInElection(this);
    }
    else
    {
      votesInPolls.add(aVotesInPoll);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVotesInPoll(VotesInPoll aVotesInPoll)
  {
    boolean wasRemoved = false;
    //Unable to remove aVotesInPoll, as it must always have a pollInElection
    if (!this.equals(aVotesInPoll.getPollInElection()))
    {
      votesInPolls.remove(aVotesInPoll);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVotesInPollAt(VotesInPoll aVotesInPoll, int index)
  {  
    boolean wasAdded = false;
    if(addVotesInPoll(aVotesInPoll))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotesInPolls()) { index = numberOfVotesInPolls() - 1; }
      votesInPolls.remove(aVotesInPoll);
      votesInPolls.add(index, aVotesInPoll);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVotesInPollAt(VotesInPoll aVotesInPoll, int index)
  {
    boolean wasAdded = false;
    if(votesInPolls.contains(aVotesInPoll))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotesInPolls()) { index = numberOfVotesInPolls() - 1; }
      votesInPolls.remove(aVotesInPoll);
      votesInPolls.add(index, aVotesInPoll);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVotesInPollAt(aVotesInPoll, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=voters.size(); i > 0; i--)
    {
      Voter aVoter = voters.get(i - 1);
      aVoter.delete();
    }
    PollingStation placeholderPollingStation = pollingStation;
    this.pollingStation = null;
    placeholderPollingStation.removePollInElection(this);
    Election placeholderElection = election;
    this.election = null;
    placeholderElection.removePollInElection(this);
    for(int i=votesInPolls.size(); i > 0; i--)
    {
      VotesInPoll aVotesInPoll = votesInPolls.get(i - 1);
      aVotesInPoll.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pollingStation = "+(getPollingStation()!=null?Integer.toHexString(System.identityHashCode(getPollingStation())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "election = "+(getElection()!=null?Integer.toHexString(System.identityHashCode(getElection())):"null")
     + outputString;
  }
}