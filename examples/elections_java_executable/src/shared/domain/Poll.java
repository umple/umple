/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;

public class Poll
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Poll Attributes
  private int idPoll;
  private String name;
  private String description;
  private String status;

  //Poll Associations
  private Election election;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdPoll;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Poll(int aIdPoll, String aName, String aDescription, Election aElection)
  {
    cachedHashCode = -1;
    canSetIdPoll = true;
    idPoll = aIdPoll;
    name = aName;
    description = aDescription;
    status = "planned";
    boolean didAddElection = setElection(aElection);
    if (!didAddElection)
    {
      throw new RuntimeException("Unable to create poll due to election");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdPoll(int aIdPoll)
  {
    boolean wasSet = false;
    if (!canSetIdPoll) { return false; }
    idPoll = aIdPoll;
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

  public boolean setStatus(String aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    return wasSet;
  }

  public int getIdPoll()
  {
    return idPoll;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public String getStatus()
  {
    return status;
  }

  public Election getElection()
  {
    return election;
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
      existingElection.removePoll(this);
    }
    election.addPoll(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Poll compareTo = (Poll)obj;
  
    if (idPoll != compareTo.idPoll)
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
    cachedHashCode = cachedHashCode * 23 + idPoll;

    canSetIdPoll = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Election placeholderElection = election;
    this.election = null;
    placeholderElection.removePoll(this);
  }

}