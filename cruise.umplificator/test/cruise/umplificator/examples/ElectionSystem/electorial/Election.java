/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.sql.Date;
import java.util.*;

/**
 * Different elections may have different sets of polls
 */
// line 21 "../../ElectionSystem.ump"
// line 137 "../../ElectionSystem.ump"
public class Election
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Election Attributes
  private Date date;

  //Election Associations
  private List<PollInElection> pollInElections;
  private List<ElectionForPosition> electionForPositions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Election(Date aDate)
  {
    date = aDate;
    pollInElections = new ArrayList<PollInElection>();
    electionForPositions = new ArrayList<ElectionForPosition>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
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

  public ElectionForPosition getElectionForPosition(int index)
  {
    ElectionForPosition aElectionForPosition = electionForPositions.get(index);
    return aElectionForPosition;
  }

  public List<ElectionForPosition> getElectionForPositions()
  {
    List<ElectionForPosition> newElectionForPositions = Collections.unmodifiableList(electionForPositions);
    return newElectionForPositions;
  }

  public int numberOfElectionForPositions()
  {
    int number = electionForPositions.size();
    return number;
  }

  public boolean hasElectionForPositions()
  {
    boolean has = electionForPositions.size() > 0;
    return has;
  }

  public int indexOfElectionForPosition(ElectionForPosition aElectionForPosition)
  {
    int index = electionForPositions.indexOf(aElectionForPosition);
    return index;
  }

  public static int minimumNumberOfPollInElections()
  {
    return 0;
  }

  public PollInElection addPollInElection(int aNumber, PollingStation aPollingStation)
  {
    return new PollInElection(aNumber, aPollingStation, this);
  }

  public boolean addPollInElection(PollInElection aPollInElection)
  {
    boolean wasAdded = false;
    if (pollInElections.contains(aPollInElection)) { return false; }
    Election existingElection = aPollInElection.getElection();
    boolean isNewElection = existingElection != null && !this.equals(existingElection);
    if (isNewElection)
    {
      aPollInElection.setElection(this);
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
    //Unable to remove aPollInElection, as it must always have a election
    if (!this.equals(aPollInElection.getElection()))
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

  public static int minimumNumberOfElectionForPositions()
  {
    return 0;
  }

  public ElectionForPosition addElectionForPosition(Position aPosition)
  {
    return new ElectionForPosition(this, aPosition);
  }

  public boolean addElectionForPosition(ElectionForPosition aElectionForPosition)
  {
    boolean wasAdded = false;
    if (electionForPositions.contains(aElectionForPosition)) { return false; }
    Election existingElection = aElectionForPosition.getElection();
    boolean isNewElection = existingElection != null && !this.equals(existingElection);
    if (isNewElection)
    {
      aElectionForPosition.setElection(this);
    }
    else
    {
      electionForPositions.add(aElectionForPosition);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeElectionForPosition(ElectionForPosition aElectionForPosition)
  {
    boolean wasRemoved = false;
    //Unable to remove aElectionForPosition, as it must always have a election
    if (!this.equals(aElectionForPosition.getElection()))
    {
      electionForPositions.remove(aElectionForPosition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addElectionForPositionAt(ElectionForPosition aElectionForPosition, int index)
  {  
    boolean wasAdded = false;
    if(addElectionForPosition(aElectionForPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElectionForPositions()) { index = numberOfElectionForPositions() - 1; }
      electionForPositions.remove(aElectionForPosition);
      electionForPositions.add(index, aElectionForPosition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveElectionForPositionAt(ElectionForPosition aElectionForPosition, int index)
  {
    boolean wasAdded = false;
    if(electionForPositions.contains(aElectionForPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElectionForPositions()) { index = numberOfElectionForPositions() - 1; }
      electionForPositions.remove(aElectionForPosition);
      electionForPositions.add(index, aElectionForPosition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addElectionForPositionAt(aElectionForPosition, index);
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
    for(int i=electionForPositions.size(); i > 0; i--)
    {
      ElectionForPosition aElectionForPosition = electionForPositions.get(i - 1);
      aElectionForPosition.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}