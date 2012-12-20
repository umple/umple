/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;
import java.util.*;

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
  private List<Candidature> candidatures;

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
    candidatures = new ArrayList<Candidature>();
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

  public Candidature getCandidature(int index)
  {
    Candidature aCandidature = candidatures.get(index);
    return aCandidature;
  }

  public List<Candidature> getCandidatures()
  {
    List<Candidature> newCandidatures = Collections.unmodifiableList(candidatures);
    return newCandidatures;
  }

  public int numberOfCandidatures()
  {
    int number = candidatures.size();
    return number;
  }

  public boolean hasCandidatures()
  {
    boolean has = candidatures.size() > 0;
    return has;
  }

  public int indexOfCandidature(Candidature aCandidature)
  {
    int index = candidatures.indexOf(aCandidature);
    return index;
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

  public static int minimumNumberOfCandidatures()
  {
    return 0;
  }

  public Candidature addCandidature(int aIdCandidature, Candidate aCandidate)
  {
    return new Candidature(aIdCandidature, aCandidate, this);
  }

  public boolean addCandidature(Candidature aCandidature)
  {
    boolean wasAdded = false;
    if (candidatures.contains(aCandidature)) { return false; }
    ElectionForPosition existingElectionForPosition = aCandidature.getElectionForPosition();
    boolean isNewElectionForPosition = existingElectionForPosition != null && !this.equals(existingElectionForPosition);
    if (isNewElectionForPosition)
    {
      aCandidature.setElectionForPosition(this);
    }
    else
    {
      candidatures.add(aCandidature);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCandidature(Candidature aCandidature)
  {
    boolean wasRemoved = false;
    //Unable to remove aCandidature, as it must always have a electionForPosition
    if (!this.equals(aCandidature.getElectionForPosition()))
    {
      candidatures.remove(aCandidature);
      wasRemoved = true;
    }
    return wasRemoved;
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
    for(int i=candidatures.size(); i > 0; i--)
    {
      Candidature aCandidature = candidatures.get(i - 1);
      aCandidature.delete();
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String toString() {
    return position.getName();
  }
}