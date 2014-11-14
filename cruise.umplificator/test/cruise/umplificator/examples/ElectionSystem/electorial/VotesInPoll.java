/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;

// line 69 "../ElectionSystem.ump"
// line 119 "../ElectionSystem.ump"
public class VotesInPoll
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VotesInPoll Attributes
  private int numVotes;

  //VotesInPoll Associations
  private Candidature candidature;
  private PollInElection pollInElection;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCandidature;
  private boolean canSetPollInElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VotesInPoll(int aNumVotes, Candidature aCandidature, PollInElection aPollInElection)
  {
    cachedHashCode = -1;
    canSetCandidature = true;
    canSetPollInElection = true;
    numVotes = aNumVotes;
    boolean didAddCandidature = setCandidature(aCandidature);
    if (!didAddCandidature)
    {
      throw new RuntimeException("Unable to create votesInPoll due to candidature");
    }
    boolean didAddPollInElection = setPollInElection(aPollInElection);
    if (!didAddPollInElection)
    {
      throw new RuntimeException("Unable to create votesInPoll due to pollInElection");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumVotes(int aNumVotes)
  {
    boolean wasSet = false;
    numVotes = aNumVotes;
    wasSet = true;
    return wasSet;
  }

  public int getNumVotes()
  {
    return numVotes;
  }

  public Candidature getCandidature()
  {
    return candidature;
  }

  public PollInElection getPollInElection()
  {
    return pollInElection;
  }

  public boolean setCandidature(Candidature aCandidature)
  {
    boolean wasSet = false;
    if (!canSetCandidature) { return false; }
    if (aCandidature == null)
    {
      return wasSet;
    }

    Candidature existingCandidature = candidature;
    candidature = aCandidature;
    if (existingCandidature != null && !existingCandidature.equals(aCandidature))
    {
      existingCandidature.removeVotesInPoll(this);
    }
    if (!candidature.addVotesInPoll(this))
    {
      candidature = existingCandidature;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setPollInElection(PollInElection aPollInElection)
  {
    boolean wasSet = false;
    if (!canSetPollInElection) { return false; }
    if (aPollInElection == null)
    {
      return wasSet;
    }

    PollInElection existingPollInElection = pollInElection;
    pollInElection = aPollInElection;
    if (existingPollInElection != null && !existingPollInElection.equals(aPollInElection))
    {
      existingPollInElection.removeVotesInPoll(this);
    }
    if (!pollInElection.addVotesInPoll(this))
    {
      pollInElection = existingPollInElection;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    VotesInPoll compareTo = (VotesInPoll)obj;
  
    if (candidature == null && compareTo.candidature != null)
    {
      return false;
    }
    else if (candidature != null && !candidature.equals(compareTo.candidature))
    {
      return false;
    }

    if (pollInElection == null && compareTo.pollInElection != null)
    {
      return false;
    }
    else if (pollInElection != null && !pollInElection.equals(compareTo.pollInElection))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (candidature != null)
    {
      cachedHashCode = cachedHashCode * 23 + candidature.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (pollInElection != null)
    {
      cachedHashCode = cachedHashCode * 23 + pollInElection.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCandidature = false;
    canSetPollInElection = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Candidature placeholderCandidature = candidature;
    this.candidature = null;
    placeholderCandidature.removeVotesInPoll(this);
    PollInElection placeholderPollInElection = pollInElection;
    this.pollInElection = null;
    placeholderPollInElection.removeVotesInPoll(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numVotes" + ":" + getNumVotes()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "candidature = "+(getCandidature()!=null?Integer.toHexString(System.identityHashCode(getCandidature())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "pollInElection = "+(getPollInElection()!=null?Integer.toHexString(System.identityHashCode(getPollInElection())):"null")
     + outputString;
  }
}