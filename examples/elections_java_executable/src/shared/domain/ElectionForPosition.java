/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;

public class ElectionForPosition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionForPosition Attributes
  private int idElectionForPosition;

  //ElectionForPosition Associations
  private Election election;
  private Position position;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdElectionForPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ElectionForPosition(int aIdElectionForPosition, Election aElection, Position aPosition)
  {
    cachedHashCode = -1;
    canSetIdElectionForPosition = true;
    idElectionForPosition = aIdElectionForPosition;
    boolean didAddElection = setElection(aElection);
    if (!didAddElection)
    {
      throw new RuntimeException("Unable to create electionForPosition due to election");
    }
    boolean didAddPosition = setPosition(aPosition);
    if (!didAddPosition)
    {
      throw new RuntimeException("Unable to create electionForPosition due to position");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdElectionForPosition(int aIdElectionForPosition)
  {
    boolean wasSet = false;
    if (!canSetIdElectionForPosition) { return false; }
    idElectionForPosition = aIdElectionForPosition;
    wasSet = true;
    return wasSet;
  }

  public int getIdElectionForPosition()
  {
    return idElectionForPosition;
  }

  public Election getElection()
  {
    return election;
  }

  public Position getPosition()
  {
    return position;
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
      existingElection.removeElectionForPosition(this);
    }
    election.addElectionForPosition(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    if (aPosition == null)
    {
      return wasSet;
    }

    Position existingPosition = position;
    position = aPosition;
    if (existingPosition != null && !existingPosition.equals(aPosition))
    {
      existingPosition.removeElectionForPosition(this);
    }
    position.addElectionForPosition(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    ElectionForPosition compareTo = (ElectionForPosition)obj;
  
    if (idElectionForPosition != compareTo.idElectionForPosition)
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
    cachedHashCode = cachedHashCode * 23 + idElectionForPosition;

    canSetIdElectionForPosition = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Election placeholderElection = election;
    this.election = null;
    placeholderElection.removeElectionForPosition(this);
    Position placeholderPosition = position;
    this.position = null;
    placeholderPosition.removeElectionForPosition(this);
  }

}