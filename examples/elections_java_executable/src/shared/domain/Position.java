/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;
import java.util.*;

public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int idPosition;
  private String name;
  private String description;

  //Position Associations
  private List<ElectionForPosition> electionForPositions;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aIdPosition, String aName, String aDescription)
  {
    cachedHashCode = -1;
    canSetIdPosition = true;
    idPosition = aIdPosition;
    name = aName;
    description = aDescription;
    electionForPositions = new ArrayList<ElectionForPosition>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdPosition(int aIdPosition)
  {
    boolean wasSet = false;
    if (!canSetIdPosition) { return false; }
    idPosition = aIdPosition;
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

  public int getIdPosition()
  {
    return idPosition;
  }

  public String getName()
  {
    return name;
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

  public static int minimumNumberOfElectionForPositions()
  {
    return 0;
  }

  public ElectionForPosition addElectionForPosition(int aIdElectionForPosition, Election aElection)
  {
    return new ElectionForPosition(aIdElectionForPosition, aElection, this);
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

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Position compareTo = (Position)obj;
  
    if (idPosition != compareTo.idPosition)
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
    cachedHashCode = cachedHashCode * 23 + idPosition;

    canSetIdPosition = false;
    return cachedHashCode;
  }

  public void delete()
  {
    for(int i=electionForPositions.size(); i > 0; i--)
    {
      ElectionForPosition aElectionForPosition = electionForPositions.get(i - 1);
      aElectionForPosition.delete();
    }
  }

}