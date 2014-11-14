/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

/**
 * Eg. Mayor, Councilor. AKA seats
 * A position can have different elections for it at different times, eg. once every four years.
 */
// line 34 "../../ElectionSystem.ump"
// line 125 "../../ElectionSystem.ump"
public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private String description;

  //Position Associations
  private List<ElectionForPosition> electionForPositions;
  private ElectedBody electedBody;
  private ElectoralDistrict electoralDistrict;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(String aDescription, ElectedBody aElectedBody)
  {
    description = aDescription;
    electionForPositions = new ArrayList<ElectionForPosition>();
    boolean didAddElectedBody = setElectedBody(aElectedBody);
    if (!didAddElectedBody)
    {
      throw new RuntimeException("Unable to create position due to electedBody");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
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

  public ElectedBody getElectedBody()
  {
    return electedBody;
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

  public static int minimumNumberOfElectionForPositions()
  {
    return 0;
  }

  public ElectionForPosition addElectionForPosition(Election aElection)
  {
    return new ElectionForPosition(aElection, this);
  }

  public boolean addElectionForPosition(ElectionForPosition aElectionForPosition)
  {
    boolean wasAdded = false;
    if (electionForPositions.contains(aElectionForPosition)) { return false; }
    Position existingPosition = aElectionForPosition.getPosition();
    boolean isNewPosition = existingPosition != null && !this.equals(existingPosition);
    if (isNewPosition)
    {
      aElectionForPosition.setPosition(this);
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
    //Unable to remove aElectionForPosition, as it must always have a position
    if (!this.equals(aElectionForPosition.getPosition()))
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

  public boolean setElectedBody(ElectedBody aElectedBody)
  {
    boolean wasSet = false;
    if (aElectedBody == null)
    {
      return wasSet;
    }

    ElectedBody existingElectedBody = electedBody;
    electedBody = aElectedBody;
    if (existingElectedBody != null && !existingElectedBody.equals(aElectedBody))
    {
      existingElectedBody.removePosition(this);
    }
    electedBody.addPosition(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setElectoralDistrict(ElectoralDistrict aElectoralDistrict)
  {
    boolean wasSet = false;
    ElectoralDistrict existingElectoralDistrict = electoralDistrict;
    electoralDistrict = aElectoralDistrict;
    if (existingElectoralDistrict != null && !existingElectoralDistrict.equals(aElectoralDistrict))
    {
      existingElectoralDistrict.removePosition(this);
    }
    if (aElectoralDistrict != null)
    {
      aElectoralDistrict.addPosition(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=electionForPositions.size(); i > 0; i--)
    {
      ElectionForPosition aElectionForPosition = electionForPositions.get(i - 1);
      aElectionForPosition.delete();
    }
    ElectedBody placeholderElectedBody = electedBody;
    this.electedBody = null;
    placeholderElectedBody.removePosition(this);
    if (electoralDistrict != null)
    {
      ElectoralDistrict placeholderElectoralDistrict = electoralDistrict;
      this.electoralDistrict = null;
      placeholderElectoralDistrict.removePosition(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "electedBody = "+(getElectedBody()!=null?Integer.toHexString(System.identityHashCode(getElectedBody())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "electoralDistrict = "+(getElectoralDistrict()!=null?Integer.toHexString(System.identityHashCode(getElectoralDistrict())):"null")
     + outputString;
  }
}