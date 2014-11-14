/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package routesAndLocations;
import java.util.*;

/**
 * A RoadSegment represents a section of road on which a vehicle can drive.
 * The ends of each segment have been modeled using RoadNodes.
 * Note that distance can be calculated from the speed limit, and locations
 */
// line 105 "../../RoutesAndLocations.ump"
// line 150 "../../RoutesAndLocations.ump"
public class RoadSegment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoadSegment Attributes
  private int speedLimit;
  private int currentReportedSpeed;
  private int lanes;
  private int streetNumberAtStart;
  private int streetNumberAtEnd;

  //RoadSegment Associations
  private List<RoadSegment> inverseSegments;
  private RoadNode end;
  private RoadNode start;
  private List<NamedRoad> namedRoads;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoadSegment(int aSpeedLimit, int aCurrentReportedSpeed, int aLanes, int aStreetNumberAtStart, int aStreetNumberAtEnd)
  {
    speedLimit = aSpeedLimit;
    currentReportedSpeed = aCurrentReportedSpeed;
    lanes = aLanes;
    streetNumberAtStart = aStreetNumberAtStart;
    streetNumberAtEnd = aStreetNumberAtEnd;
    inverseSegments = new ArrayList<RoadSegment>();
    namedRoads = new ArrayList<NamedRoad>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSpeedLimit(int aSpeedLimit)
  {
    boolean wasSet = false;
    speedLimit = aSpeedLimit;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentReportedSpeed(int aCurrentReportedSpeed)
  {
    boolean wasSet = false;
    currentReportedSpeed = aCurrentReportedSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setLanes(int aLanes)
  {
    boolean wasSet = false;
    lanes = aLanes;
    wasSet = true;
    return wasSet;
  }

  public boolean setStreetNumberAtStart(int aStreetNumberAtStart)
  {
    boolean wasSet = false;
    streetNumberAtStart = aStreetNumberAtStart;
    wasSet = true;
    return wasSet;
  }

  public boolean setStreetNumberAtEnd(int aStreetNumberAtEnd)
  {
    boolean wasSet = false;
    streetNumberAtEnd = aStreetNumberAtEnd;
    wasSet = true;
    return wasSet;
  }

  public int getSpeedLimit()
  {
    return speedLimit;
  }

  /**
   * Indicator of real-time congestion; 0=blocked
   */
  public int getCurrentReportedSpeed()
  {
    return currentReportedSpeed;
  }

  public int getLanes()
  {
    return lanes;
  }

  /**
   * The following are used to determine addresses
   */
  public int getStreetNumberAtStart()
  {
    return streetNumberAtStart;
  }

  public int getStreetNumberAtEnd()
  {
    return streetNumberAtEnd;
  }

  public RoadSegment getInverseSegment(int index)
  {
    RoadSegment aInverseSegment = inverseSegments.get(index);
    return aInverseSegment;
  }

  public List<RoadSegment> getInverseSegments()
  {
    List<RoadSegment> newInverseSegments = Collections.unmodifiableList(inverseSegments);
    return newInverseSegments;
  }

  public int numberOfInverseSegments()
  {
    int number = inverseSegments.size();
    return number;
  }

  public boolean hasInverseSegments()
  {
    boolean has = inverseSegments.size() > 0;
    return has;
  }

  public int indexOfInverseSegment(RoadSegment aInverseSegment)
  {
    int index = inverseSegments.indexOf(aInverseSegment);
    return index;
  }

  public RoadNode getEnd()
  {
    return end;
  }

  public boolean hasEnd()
  {
    boolean has = end != null;
    return has;
  }

  public RoadNode getStart()
  {
    return start;
  }

  public boolean hasStart()
  {
    boolean has = start != null;
    return has;
  }

  public NamedRoad getNamedRoad(int index)
  {
    NamedRoad aNamedRoad = namedRoads.get(index);
    return aNamedRoad;
  }

  public List<NamedRoad> getNamedRoads()
  {
    List<NamedRoad> newNamedRoads = Collections.unmodifiableList(namedRoads);
    return newNamedRoads;
  }

  public int numberOfNamedRoads()
  {
    int number = namedRoads.size();
    return number;
  }

  public boolean hasNamedRoads()
  {
    boolean has = namedRoads.size() > 0;
    return has;
  }

  public int indexOfNamedRoad(NamedRoad aNamedRoad)
  {
    int index = namedRoads.indexOf(aNamedRoad);
    return index;
  }

  public static int minimumNumberOfInverseSegments()
  {
    return 0;
  }

  public boolean addInverseSegment(RoadSegment aInverseSegment)
  {
    boolean wasAdded = false;
    if (inverseSegments.contains(aInverseSegment)) { return false; }
    inverseSegments.add(aInverseSegment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInverseSegment(RoadSegment aInverseSegment)
  {
    boolean wasRemoved = false;
    if (inverseSegments.contains(aInverseSegment))
    {
      inverseSegments.remove(aInverseSegment);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInverseSegmentAt(RoadSegment aInverseSegment, int index)
  {  
    boolean wasAdded = false;
    if(addInverseSegment(aInverseSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInverseSegments()) { index = numberOfInverseSegments() - 1; }
      inverseSegments.remove(aInverseSegment);
      inverseSegments.add(index, aInverseSegment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInverseSegmentAt(RoadSegment aInverseSegment, int index)
  {
    boolean wasAdded = false;
    if(inverseSegments.contains(aInverseSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInverseSegments()) { index = numberOfInverseSegments() - 1; }
      inverseSegments.remove(aInverseSegment);
      inverseSegments.add(index, aInverseSegment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInverseSegmentAt(aInverseSegment, index);
    }
    return wasAdded;
  }

  public boolean setEnd(RoadNode aEnd)
  {
    boolean wasSet = false;
    RoadNode existingEnd = end;
    end = aEnd;
    if (existingEnd != null && !existingEnd.equals(aEnd))
    {
      existingEnd.removeIncomingRoad(this);
    }
    if (aEnd != null)
    {
      aEnd.addIncomingRoad(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStart(RoadNode aStart)
  {
    boolean wasSet = false;
    RoadNode existingStart = start;
    start = aStart;
    if (existingStart != null && !existingStart.equals(aStart))
    {
      existingStart.removeOutgoingRoad(this);
    }
    if (aStart != null)
    {
      aStart.addOutgoingRoad(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfNamedRoads()
  {
    return 0;
  }

  public boolean addNamedRoad(NamedRoad aNamedRoad)
  {
    boolean wasAdded = false;
    if (namedRoads.contains(aNamedRoad)) { return false; }
    namedRoads.add(aNamedRoad);
    if (aNamedRoad.indexOfSegment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aNamedRoad.addSegment(this);
      if (!wasAdded)
      {
        namedRoads.remove(aNamedRoad);
      }
    }
    return wasAdded;
  }

  public boolean removeNamedRoad(NamedRoad aNamedRoad)
  {
    boolean wasRemoved = false;
    if (!namedRoads.contains(aNamedRoad))
    {
      return wasRemoved;
    }

    int oldIndex = namedRoads.indexOf(aNamedRoad);
    namedRoads.remove(oldIndex);
    if (aNamedRoad.indexOfSegment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aNamedRoad.removeSegment(this);
      if (!wasRemoved)
      {
        namedRoads.add(oldIndex,aNamedRoad);
      }
    }
    return wasRemoved;
  }

  public boolean addNamedRoadAt(NamedRoad aNamedRoad, int index)
  {  
    boolean wasAdded = false;
    if(addNamedRoad(aNamedRoad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNamedRoads()) { index = numberOfNamedRoads() - 1; }
      namedRoads.remove(aNamedRoad);
      namedRoads.add(index, aNamedRoad);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNamedRoadAt(NamedRoad aNamedRoad, int index)
  {
    boolean wasAdded = false;
    if(namedRoads.contains(aNamedRoad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNamedRoads()) { index = numberOfNamedRoads() - 1; }
      namedRoads.remove(aNamedRoad);
      namedRoads.add(index, aNamedRoad);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addNamedRoadAt(aNamedRoad, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    inverseSegments.clear();
    if (end != null)
    {
      RoadNode placeholderEnd = end;
      this.end = null;
      placeholderEnd.removeIncomingRoad(this);
    }
    if (start != null)
    {
      RoadNode placeholderStart = start;
      this.start = null;
      placeholderStart.removeOutgoingRoad(this);
    }
    ArrayList<NamedRoad> copyOfNamedRoads = new ArrayList<NamedRoad>(namedRoads);
    namedRoads.clear();
    for(NamedRoad aNamedRoad : copyOfNamedRoads)
    {
      if (aNamedRoad.numberOfSegments() <= NamedRoad.minimumNumberOfSegments())
      {
        aNamedRoad.delete();
      }
      else
      {
        aNamedRoad.removeSegment(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "speedLimit" + ":" + getSpeedLimit()+ "," +
            "currentReportedSpeed" + ":" + getCurrentReportedSpeed()+ "," +
            "lanes" + ":" + getLanes()+ "," +
            "streetNumberAtStart" + ":" + getStreetNumberAtStart()+ "," +
            "streetNumberAtEnd" + ":" + getStreetNumberAtEnd()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "end = "+(getEnd()!=null?Integer.toHexString(System.identityHashCode(getEnd())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "start = "+(getStart()!=null?Integer.toHexString(System.identityHashCode(getStart())):"null")
     + outputString;
  }
}