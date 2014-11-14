/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

// line 14 "../../ElectionSystem.ump"
// line 131 "../../ElectionSystem.ump"
public class ElectedBody
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectedBody Attributes
  private String description;

  //ElectedBody Associations
  private List<Position> positions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ElectedBody(String aDescription)
  {
    description = aDescription;
    positions = new ArrayList<Position>();
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

  public static int minimumNumberOfPositions()
  {
    return 0;
  }

  public Position addPosition(String aDescription)
  {
    return new Position(aDescription, this);
  }

  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    if (positions.contains(aPosition)) { return false; }
    ElectedBody existingElectedBody = aPosition.getElectedBody();
    boolean isNewElectedBody = existingElectedBody != null && !this.equals(existingElectedBody);
    if (isNewElectedBody)
    {
      aPosition.setElectedBody(this);
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
    //Unable to remove aPosition, as it must always have a electedBody
    if (!this.equals(aPosition.getElectedBody()))
    {
      positions.remove(aPosition);
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

  public void delete()
  {
    for(int i=positions.size(); i > 0; i--)
    {
      Position aPosition = positions.get(i - 1);
      aPosition.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}