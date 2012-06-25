/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;
import java.sql.Date;
import java.util.*;

/**
 * represents an election
 */
public class Election
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Election Attributes
  private int idElection;
  private String name;
  private String description;
  private Date date;

  //Election Associations
  private List<Poll> polls;
  private List<ElectionForPosition> electionForPositions;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Election(int aIdElection, String aName, String aDescription, Date aDate)
  {
    cachedHashCode = -1;
    canSetIdElection = true;
    idElection = aIdElection;
    name = aName;
    description = aDescription;
    date = aDate;
    polls = new ArrayList<Poll>();
    electionForPositions = new ArrayList<ElectionForPosition>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdElection(int aIdElection)
  {
    boolean wasSet = false;
    if (!canSetIdElection) { return false; }
    idElection = aIdElection;
    wasSet = true;
    return wasSet;
  }

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

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public int getIdElection()
  {
    return idElection;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public Date getDate()
  {
    return date;
  }

  public Poll getPoll(int index)
  {
    Poll aPoll = polls.get(index);
    return aPoll;
  }

  public List<Poll> getPolls()
  {
    List<Poll> newPolls = Collections.unmodifiableList(polls);
    return newPolls;
  }

  public int numberOfPolls()
  {
    int number = polls.size();
    return number;
  }

  public boolean hasPolls()
  {
    boolean has = polls.size() > 0;
    return has;
  }

  public int indexOfPoll(Poll aPoll)
  {
    int index = polls.indexOf(aPoll);
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

  public static int minimumNumberOfPolls()
  {
    return 0;
  }

  public Poll addPoll(int aIdPoll, int aNumber, String aName, String aDescription)
  {
    return new Poll(aIdPoll, aNumber, aName, aDescription, this);
  }

  public boolean addPoll(Poll aPoll)
  {
    boolean wasAdded = false;
    if (polls.contains(aPoll)) { return false; }
    Election existingElection = aPoll.getElection();
    boolean isNewElection = existingElection != null && !this.equals(existingElection);
    if (isNewElection)
    {
      aPoll.setElection(this);
    }
    else
    {
      polls.add(aPoll);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePoll(Poll aPoll)
  {
    boolean wasRemoved = false;
    //Unable to remove aPoll, as it must always have a election
    if (!this.equals(aPoll.getElection()))
    {
      polls.remove(aPoll);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfElectionForPositions()
  {
    return 0;
  }

  public ElectionForPosition addElectionForPosition(int aIdElectionForPosition, Position aPosition)
  {
    return new ElectionForPosition(aIdElectionForPosition, this, aPosition);
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

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Election compareTo = (Election)obj;
  
    if (idElection != compareTo.idElection)
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
    cachedHashCode = cachedHashCode * 23 + idElection;

    canSetIdElection = false;
    return cachedHashCode;
  }

  public void delete()
  {
    for(int i=polls.size(); i > 0; i--)
    {
      Poll aPoll = polls.get(i - 1);
      aPoll.delete();
    }
    for(int i=electionForPositions.size(); i > 0; i--)
    {
      ElectionForPosition aElectionForPosition = electionForPositions.get(i - 1);
      aElectionForPosition.delete();
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String toString() {
    return name;
  }
}