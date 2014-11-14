/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

/**
 * We need candidature class since a candidate can run for different
 * positions and for the smae positions at subsequent elections
 */
// line 41 "../../ElectionSystem.ump"
// line 108 "../../ElectionSystem.ump"
public class Candidature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidature Attributes
  private boolean isIncumbent;

  //Candidature Associations
  private ElectionForPosition electionForPosition;
  private Candidate candidate;
  private List<Voter> voters;
  private List<VotesInPoll> votesInPolls;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Candidature(ElectionForPosition aElectionForPosition, Candidate aCandidate)
  {
    isIncumbent = false;
    boolean didAddElectionForPosition = setElectionForPosition(aElectionForPosition);
    if (!didAddElectionForPosition)
    {
      throw new RuntimeException("Unable to create candidature due to electionForPosition");
    }
    boolean didAddCandidate = setCandidate(aCandidate);
    if (!didAddCandidate)
    {
      throw new RuntimeException("Unable to create candidature due to candidate");
    }
    voters = new ArrayList<Voter>();
    votesInPolls = new ArrayList<VotesInPoll>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ElectionForPosition getElectionForPosition()
  {
    return electionForPosition;
  }

  public Candidate getCandidate()
  {
    return candidate;
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

  public boolean setElectionForPosition(ElectionForPosition aElectionForPosition)
  {
    boolean wasSet = false;
    if (aElectionForPosition == null)
    {
      return wasSet;
    }

    ElectionForPosition existingElectionForPosition = electionForPosition;
    electionForPosition = aElectionForPosition;
    if (existingElectionForPosition != null && !existingElectionForPosition.equals(aElectionForPosition))
    {
      existingElectionForPosition.removeCandidature(this);
    }
    electionForPosition.addCandidature(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setCandidate(Candidate aCandidate)
  {
    boolean wasSet = false;
    if (aCandidate == null)
    {
      return wasSet;
    }

    Candidate existingCandidate = candidate;
    candidate = aCandidate;
    if (existingCandidate != null && !existingCandidate.equals(aCandidate))
    {
      existingCandidate.removeCandidature(this);
    }
    candidate.addCandidature(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfVoters()
  {
    return 0;
  }

  public boolean addVoter(Voter aVoter)
  {
    boolean wasAdded = false;
    if (voters.contains(aVoter)) { return false; }
    voters.add(aVoter);
    if (aVoter.indexOfCandidature(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aVoter.addCandidature(this);
      if (!wasAdded)
      {
        voters.remove(aVoter);
      }
    }
    return wasAdded;
  }

  public boolean removeVoter(Voter aVoter)
  {
    boolean wasRemoved = false;
    if (!voters.contains(aVoter))
    {
      return wasRemoved;
    }

    int oldIndex = voters.indexOf(aVoter);
    voters.remove(oldIndex);
    if (aVoter.indexOfCandidature(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aVoter.removeCandidature(this);
      if (!wasRemoved)
      {
        voters.add(oldIndex,aVoter);
      }
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

  public static int minimumNumberOfVotesInPolls()
  {
    return 0;
  }

  public VotesInPoll addVotesInPoll(int aNumVotes, PollInElection aPollInElection)
  {
    return new VotesInPoll(aNumVotes, this, aPollInElection);
  }

  public boolean addVotesInPoll(VotesInPoll aVotesInPoll)
  {
    boolean wasAdded = false;
    if (votesInPolls.contains(aVotesInPoll)) { return false; }
    Candidature existingCandidature = aVotesInPoll.getCandidature();
    boolean isNewCandidature = existingCandidature != null && !this.equals(existingCandidature);
    if (isNewCandidature)
    {
      aVotesInPoll.setCandidature(this);
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
    //Unable to remove aVotesInPoll, as it must always have a candidature
    if (!this.equals(aVotesInPoll.getCandidature()))
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
    ElectionForPosition placeholderElectionForPosition = electionForPosition;
    this.electionForPosition = null;
    placeholderElectionForPosition.removeCandidature(this);
    Candidate placeholderCandidate = candidate;
    this.candidate = null;
    placeholderCandidate.removeCandidature(this);
    ArrayList<Voter> copyOfVoters = new ArrayList<Voter>(voters);
    voters.clear();
    for(Voter aVoter : copyOfVoters)
    {
      aVoter.removeCandidature(this);
    }
    for(int i=votesInPolls.size(); i > 0; i--)
    {
      VotesInPoll aVotesInPoll = votesInPolls.get(i - 1);
      aVotesInPoll.delete();
    }
  }

  // line 46 "../../ElectionSystem.ump"
   public void markAsIncumbent(){
    isIncumbent = true;
  }

  // line 51 "../../ElectionSystem.ump"
   public String toString(){
    return isIncumbent ? "Incumbent" : "Candidature";
  }

}