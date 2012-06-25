/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;

public class Candidature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidature Attributes
  private int idCandidature;

  //Candidature Associations
  private Candidate candidate;
  private ElectionForPosition electionForPosition;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdCandidature;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Candidature(int aIdCandidature, Candidate aCandidate, ElectionForPosition aElectionForPosition)
  {
    cachedHashCode = -1;
    canSetIdCandidature = true;
    idCandidature = aIdCandidature;
    boolean didAddCandidate = setCandidate(aCandidate);
    if (!didAddCandidate)
    {
      throw new RuntimeException("Unable to create candidature due to candidate");
    }
    boolean didAddElectionForPosition = setElectionForPosition(aElectionForPosition);
    if (!didAddElectionForPosition)
    {
      throw new RuntimeException("Unable to create candidature due to electionForPosition");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdCandidature(int aIdCandidature)
  {
    boolean wasSet = false;
    if (!canSetIdCandidature) { return false; }
    idCandidature = aIdCandidature;
    wasSet = true;
    return wasSet;
  }

  public int getIdCandidature()
  {
    return idCandidature;
  }

  public Candidate getCandidate()
  {
    return candidate;
  }

  public ElectionForPosition getElectionForPosition()
  {
    return electionForPosition;
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

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Candidature compareTo = (Candidature)obj;
  
    if (idCandidature != compareTo.idCandidature)
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
    cachedHashCode = cachedHashCode * 23 + idCandidature;

    canSetIdCandidature = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Candidate placeholderCandidate = candidate;
    this.candidate = null;
    placeholderCandidate.removeCandidature(this);
    ElectionForPosition placeholderElectionForPosition = electionForPosition;
    this.electionForPosition = null;
    placeholderElectionForPosition.removeCandidature(this);
  }

}