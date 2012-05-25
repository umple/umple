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

  //Poll Associations
  private Election election;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdPoll;
  private boolean canSetElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Poll(int aIdPoll, String aName, String aDescription, Election aElection)
  {
    cachedHashCode = -1;
    canSetIdPoll = true;
    canSetElection = true;
    idPoll = aIdPoll;
    name = aName;
    description = aDescription;
    if (!setElection(aElection))
    {
      throw new RuntimeException("Unable to create Poll due to aElection");
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

  public Election getElection()
  {
    return election;
  }

  public boolean setElection(Election newElection)
  {
    boolean wasSet = false;
    if (!canSetElection) { return false; }
    if (newElection != null)
    {
      election = newElection;
      wasSet = true;
    }
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

    if (election == null && compareTo.election != null)
    {
      return false;
    }
    else if (election != null && !election.equals(compareTo.election))
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

    if (election != null)
    {
      cachedHashCode = cachedHashCode * 23 + election.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetIdPoll = false;
    canSetElection = false;
    return cachedHashCode;
  }

  public void delete()
  {
    election = null;
  }

}