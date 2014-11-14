/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

// line 81 "../../ElectionSystem.ump"
// line 150 "../../ElectionSystem.ump"
public class ElectoralDistrict
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectoralDistrict Associations
  private List<Voter> voters;
  private List<Position> positions;
  private List<ElectoralDistrict> subDistrict;
  private ElectoralDistrict electoralDistrict;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ElectoralDistrict()
  {
    voters = new ArrayList<Voter>();
    positions = new ArrayList<Position>();
    subDistrict = new ArrayList<ElectoralDistrict>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public Position getPosition(int index)
  {
    Position aPosition = positions.get(index);
    return aPosition;
  }

  public List<Position> getPositions()
  {
    List<Position> newPositions = Collections.unmodifiableList(positions);
    return newPositions;
  }

  public int numberOfPositions()
  {
    int number = positions.size();
    return number;
  }

  public boolean hasPositions()
  {
    boolean has = positions.size() > 0;
    return has;
  }

  public int indexOfPosition(Position aPosition)
  {
    int index = positions.indexOf(aPosition);
    return index;
  }

  public ElectoralDistrict getSubDistrict(int index)
  {
    ElectoralDistrict aSubDistrict = subDistrict.get(index);
    return aSubDistrict;
  }

  public List<ElectoralDistrict> getSubDistrict()
  {
    List<ElectoralDistrict> newSubDistrict = Collections.unmodifiableList(subDistrict);
    return newSubDistrict;
  }

  public int numberOfSubDistrict()
  {
    int number = subDistrict.size();
    return number;
  }

  public boolean hasSubDistrict()
  {
    boolean has = subDistrict.size() > 0;
    return has;
  }

  public int indexOfSubDistrict(ElectoralDistrict aSubDistrict)
  {
    int index = subDistrict.indexOf(aSubDistrict);
    return index;
  }

  public ElectoralDistrict getElectoralDistrict()
  {
    return electoralDistrict;
  }

  public boolean hasElectoralDistrict()
  {
    boolean has = electoralDistrict != null;
    return has;
  }

  public static int minimumNumberOfVoters()
  {
    return 0;
  }

  public Voter addVoter(String aName, String aAddress, PollInElection aPollInElection)
  {
    return new Voter(aName, aAddress, aPollInElection, this);
  }

  public boolean addVoter(Voter aVoter)
  {
    boolean wasAdded = false;
    if (voters.contains(aVoter)) { return false; }
    ElectoralDistrict existingElectoralDistrict = aVoter.getElectoralDistrict();
    boolean isNewElectoralDistrict = existingElectoralDistrict != null && !this.equals(existingElectoralDistrict);
    if (isNewElectoralDistrict)
    {
      aVoter.setElectoralDistrict(this);
    }
    else
    {
      voters.add(aVoter);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVoter(Voter aVoter)
  {
    boolean wasRemoved = false;
    //Unable to remove aVoter, as it must always have a electoralDistrict
    if (!this.equals(aVoter.getElectoralDistrict()))
    {
      voters.remove(aVoter);
      wasRemoved = true;
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

  public static int minimumNumberOfPositions()
  {
    return 0;
  }

  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    if (positions.contains(aPosition)) { return false; }
    ElectoralDistrict existingElectoralDistrict = aPosition.getElectoralDistrict();
    if (existingElectoralDistrict == null)
    {
      aPosition.setElectoralDistrict(this);
    }
    else if (!this.equals(existingElectoralDistrict))
    {
      existingElectoralDistrict.removePosition(aPosition);
      addPosition(aPosition);
    }
    else
    {
      positions.add(aPosition);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePosition(Position aPosition)
  {
    boolean wasRemoved = false;
    if (positions.contains(aPosition))
    {
      positions.remove(aPosition);
      aPosition.setElectoralDistrict(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPositionAt(Position aPosition, int index)
  {  
    boolean wasAdded = false;
    if(addPosition(aPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPositions()) { index = numberOfPositions() - 1; }
      positions.remove(aPosition);
      positions.add(index, aPosition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePositionAt(Position aPosition, int index)
  {
    boolean wasAdded = false;
    if(positions.contains(aPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPositions()) { index = numberOfPositions() - 1; }
      positions.remove(aPosition);
      positions.add(index, aPosition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPositionAt(aPosition, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSubDistrict()
  {
    return 0;
  }

  public boolean addSubDistrict(ElectoralDistrict aSubDistrict)
  {
    boolean wasAdded = false;
    if (subDistrict.contains(aSubDistrict)) { return false; }
    ElectoralDistrict existingElectoralDistrict = aSubDistrict.getElectoralDistrict();
    if (existingElectoralDistrict == null)
    {
      aSubDistrict.setElectoralDistrict(this);
    }
    else if (!this.equals(existingElectoralDistrict))
    {
      existingElectoralDistrict.removeSubDistrict(aSubDistrict);
      addSubDistrict(aSubDistrict);
    }
    else
    {
      subDistrict.add(aSubDistrict);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubDistrict(ElectoralDistrict aSubDistrict)
  {
    boolean wasRemoved = false;
    if (subDistrict.contains(aSubDistrict))
    {
      subDistrict.remove(aSubDistrict);
      aSubDistrict.setElectoralDistrict(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubDistrictAt(ElectoralDistrict aSubDistrict, int index)
  {  
    boolean wasAdded = false;
    if(addSubDistrict(aSubDistrict))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubDistrict()) { index = numberOfSubDistrict() - 1; }
      subDistrict.remove(aSubDistrict);
      subDistrict.add(index, aSubDistrict);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubDistrictAt(ElectoralDistrict aSubDistrict, int index)
  {
    boolean wasAdded = false;
    if(subDistrict.contains(aSubDistrict))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubDistrict()) { index = numberOfSubDistrict() - 1; }
      subDistrict.remove(aSubDistrict);
      subDistrict.add(index, aSubDistrict);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubDistrictAt(aSubDistrict, index);
    }
    return wasAdded;
  }

  public boolean setElectoralDistrict(ElectoralDistrict aElectoralDistrict)
  {
    boolean wasSet = false;
    ElectoralDistrict existingElectoralDistrict = electoralDistrict;
    electoralDistrict = aElectoralDistrict;
    if (existingElectoralDistrict != null && !existingElectoralDistrict.equals(aElectoralDistrict))
    {
      existingElectoralDistrict.removeSubDistrict(this);
    }
    if (aElectoralDistrict != null)
    {
      aElectoralDistrict.addSubDistrict(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=voters.size(); i > 0; i--)
    {
      Voter aVoter = voters.get(i - 1);
      aVoter.delete();
    }
    while( !positions.isEmpty() )
    {
      positions.get(0).setElectoralDistrict(null);
    }
    while( !subDistrict.isEmpty() )
    {
      subDistrict.get(0).setElectoralDistrict(null);
    }
    if (electoralDistrict != null)
    {
      ElectoralDistrict placeholderElectoralDistrict = electoralDistrict;
      this.electoralDistrict = null;
      placeholderElectoralDistrict.removeSubDistrict(this);
    }
  }

}