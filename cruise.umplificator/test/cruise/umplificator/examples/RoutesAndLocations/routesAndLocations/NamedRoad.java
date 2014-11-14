/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package routesAndLocations;
import java.util.*;

/**
 * A named road might have the name of a street, the number of
 * a highway, etc. A RoadSegment can have several names because
 * for example, sometimes several numbered highways share a segment
 */
// line 90 "../../RoutesAndLocations.ump"
// line 164 "../../RoutesAndLocations.ump"
public class NamedRoad
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NamedRoad Attributes
  private String name;
  private String direction;

  //NamedRoad Associations
  private List<RoadSegment> segments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NamedRoad(String aName, String aDirection, RoadSegment... allSegments)
  {
    name = aName;
    direction = aDirection;
    segments = new ArrayList<RoadSegment>();
    boolean didAddSegments = setSegments(allSegments);
    if (!didAddSegments)
    {
      throw new RuntimeException("Unable to create NamedRoad, must have at least 1 segments");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDirection(String aDirection)
  {
    boolean wasSet = false;
    direction = aDirection;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  /**
   * Most roads have two directions, e.g. North and South
   */
  public String getDirection()
  {
    return direction;
  }

  public RoadSegment getSegment(int index)
  {
    RoadSegment aSegment = segments.get(index);
    return aSegment;
  }

  /**
   * Listed in order
   */
  public List<RoadSegment> getSegments()
  {
    List<RoadSegment> newSegments = Collections.unmodifiableList(segments);
    return newSegments;
  }

  public int numberOfSegments()
  {
    int number = segments.size();
    return number;
  }

  public boolean hasSegments()
  {
    boolean has = segments.size() > 0;
    return has;
  }

  public int indexOfSegment(RoadSegment aSegment)
  {
    int index = segments.indexOf(aSegment);
    return index;
  }

  public boolean isNumberOfSegmentsValid()
  {
    boolean isValid = numberOfSegments() >= minimumNumberOfSegments();
    return isValid;
  }

  public static int minimumNumberOfSegments()
  {
    return 1;
  }

  public boolean addSegment(RoadSegment aSegment)
  {
    boolean wasAdded = false;
    if (segments.contains(aSegment)) { return false; }
    segments.add(aSegment);
    if (aSegment.indexOfNamedRoad(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSegment.addNamedRoad(this);
      if (!wasAdded)
      {
        segments.remove(aSegment);
      }
    }
    return wasAdded;
  }

  public boolean removeSegment(RoadSegment aSegment)
  {
    boolean wasRemoved = false;
    if (!segments.contains(aSegment))
    {
      return wasRemoved;
    }

    if (numberOfSegments() <= minimumNumberOfSegments())
    {
      return wasRemoved;
    }

    int oldIndex = segments.indexOf(aSegment);
    segments.remove(oldIndex);
    if (aSegment.indexOfNamedRoad(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSegment.removeNamedRoad(this);
      if (!wasRemoved)
      {
        segments.add(oldIndex,aSegment);
      }
    }
    return wasRemoved;
  }

  public boolean setSegments(RoadSegment... newSegments)
  {
    boolean wasSet = false;
    ArrayList<RoadSegment> verifiedSegments = new ArrayList<RoadSegment>();
    for (RoadSegment aSegment : newSegments)
    {
      if (verifiedSegments.contains(aSegment))
      {
        continue;
      }
      verifiedSegments.add(aSegment);
    }

    if (verifiedSegments.size() != newSegments.length || verifiedSegments.size() < minimumNumberOfSegments())
    {
      return wasSet;
    }

    ArrayList<RoadSegment> oldSegments = new ArrayList<RoadSegment>(segments);
    segments.clear();
    for (RoadSegment aNewSegment : verifiedSegments)
    {
      segments.add(aNewSegment);
      if (oldSegments.contains(aNewSegment))
      {
        oldSegments.remove(aNewSegment);
      }
      else
      {
        aNewSegment.addNamedRoad(this);
      }
    }

    for (RoadSegment anOldSegment : oldSegments)
    {
      anOldSegment.removeNamedRoad(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addSegmentAt(RoadSegment aSegment, int index)
  {  
    boolean wasAdded = false;
    if(addSegment(aSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSegments()) { index = numberOfSegments() - 1; }
      segments.remove(aSegment);
      segments.add(index, aSegment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSegmentAt(RoadSegment aSegment, int index)
  {
    boolean wasAdded = false;
    if(segments.contains(aSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSegments()) { index = numberOfSegments() - 1; }
      segments.remove(aSegment);
      segments.add(index, aSegment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSegmentAt(aSegment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<RoadSegment> copyOfSegments = new ArrayList<RoadSegment>(segments);
    segments.clear();
    for(RoadSegment aSegment : copyOfSegments)
    {
      aSegment.removeNamedRoad(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "direction" + ":" + getDirection()+ "]"
     + outputString;
  }
}