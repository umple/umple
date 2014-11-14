/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

// line 28 "../../ElectionSystem.ump"
// line 144 "../../ElectionSystem.ump"
public class ElectionForPosition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionForPosition Associations
  private List<Candidature> candidatures;
  private Election election;
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ElectionForPosition(Election aElection, Position aPosition)
  {
    candidatures = new ArrayList<Candidature>();
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

  public Election getElection()
  {
    return election;
  }

  public Position getPosition()
  {
    return position;
  }

  public static int minimumNumberOfCandidatures()
  {
    return 0;
  }

  public Candidature addCandidature(Candidate aCandidate)
  {
    return new Candidature(this, aCandidate);
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

  public boolean addCandidatureAt(Candidature aCandidature, int index)
  {  
    boolean wasAdded = false;
    if(addCandidature(aCandidature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCandidatures()) { index = numberOfCandidatures() - 1; }
      candidatures.remove(aCandidature);
      candidatures.add(index, aCandidature);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCandidatureAt(Candidature aCandidature, int index)
  {
    boolean wasAdded = false;
    if(candidatures.contains(aCandidature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCandidatures()) { index = numberOfCandidatures() - 1; }
      candidatures.remove(aCandidature);
      candidatures.add(index, aCandidature);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCandidatureAt(aCandidature, index);
    }
    return wasAdded;
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

  public void delete()
  {
    for(int i=candidatures.size(); i > 0; i--)
    {
      Candidature aCandidature = candidatures.get(i - 1);
      aCandidature.delete();
    }
    Election placeholderElection = election;
    this.election = null;
    placeholderElection.removeElectionForPosition(this);
    Position placeholderPosition = position;
    this.position = null;
    placeholderPosition.removeElectionForPosition(this);
  }

}