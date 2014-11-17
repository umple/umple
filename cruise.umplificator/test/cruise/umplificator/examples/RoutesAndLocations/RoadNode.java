/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * RoadNodes are places where RoadSegments connect. A node with just one incoming
 * and one outgoing is used to handle changes in direction, e.g. as a road turns
 * a corner, changes in speed limit, changes in number of lanes, and other factors.
 * When there is more than one outgoing or incoming, the node represents points
 * where traffic flow can split and join.
 * A crossroads is one type. Entry into a roundabout would be another,
 * Highway merges and exits are other kinds as are parking lots and entries
 * into or out of fire stations..
 * 
 * RoadSegments leaving the city lead to no RoadNode
 * RoadSegments entering the city come from no RoadNode
 */
// line 60 "RoutesAndLocations.ump"
// line 156 "RoutesAndLocations.ump"
public class RoadNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoadNode Attributes
  private int id;

  //RoadNode Associations
  private Location nodeLocation;
  private List<RoadSegment> incomingRoads;
  private List<RoadSegment> outgoingRoads;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoadNode(int aId, Location aNodeLocation)
  {
    id = aId;
    if (!setNodeLocation(aNodeLocation))
    {
      throw new RuntimeException("Unable to create RoadNode due to aNodeLocation");
    }
    incomingRoads = new ArrayList<RoadSegment>();
    outgoingRoads = new ArrayList<RoadSegment>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public Location getNodeLocation()
  {
    return nodeLocation;
  }

  public RoadSegment getIncomingRoad(int index)
  {
    RoadSegment aIncomingRoad = incomingRoads.get(index);
    return aIncomingRoad;
  }

  public List<RoadSegment> getIncomingRoads()
  {
    List<RoadSegment> newIncomingRoads = Collections.unmodifiableList(incomingRoads);
    return newIncomingRoads;
  }

  public int numberOfIncomingRoads()
  {
    int number = incomingRoads.size();
    return number;
  }

  public boolean hasIncomingRoads()
  {
    boolean has = incomingRoads.size() > 0;
    return has;
  }

  public int indexOfIncomingRoad(RoadSegment aIncomingRoad)
  {
    int index = incomingRoads.indexOf(aIncomingRoad);
    return index;
  }

  public RoadSegment getOutgoingRoad(int index)
  {
    RoadSegment aOutgoingRoad = outgoingRoads.get(index);
    return aOutgoingRoad;
  }

  public List<RoadSegment> getOutgoingRoads()
  {
    List<RoadSegment> newOutgoingRoads = Collections.unmodifiableList(outgoingRoads);
    return newOutgoingRoads;
  }

  public int numberOfOutgoingRoads()
  {
    int number = outgoingRoads.size();
    return number;
  }

  public boolean hasOutgoingRoads()
  {
    boolean has = outgoingRoads.size() > 0;
    return has;
  }

  public int indexOfOutgoingRoad(RoadSegment aOutgoingRoad)
  {
    int index = outgoingRoads.indexOf(aOutgoingRoad);
    return index;
  }

  public boolean setNodeLocation(Location aNewNodeLocation)
  {
    boolean wasSet = false;
    if (aNewNodeLocation != null)
    {
      nodeLocation = aNewNodeLocation;
      wasSet = true;
    }
    return wasSet;
  }

  public static int minimumNumberOfIncomingRoads()
  {
    return 0;
  }

  public boolean addIncomingRoad(RoadSegment aIncomingRoad)
  {
    boolean wasAdded = false;
    if (incomingRoads.contains(aIncomingRoad)) { return false; }
    if (incomingRoads.contains(aIncomingRoad)) { return false; }
    RoadNode existingEnd = aIncomingRoad.getEnd();
    if (existingEnd == null)
    {
      aIncomingRoad.setEnd(this);
    }
    else if (!this.equals(existingEnd))
    {
      existingEnd.removeIncomingRoad(aIncomingRoad);
      addIncomingRoad(aIncomingRoad);
    }
    else
    {
      incomingRoads.add(aIncomingRoad);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIncomingRoad(RoadSegment aIncomingRoad)
  {
    boolean wasRemoved = false;
    if (incomingRoads.contains(aIncomingRoad))
    {
      incomingRoads.remove(aIncomingRoad);
      aIncomingRoad.setEnd(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIncomingRoadAt(RoadSegment aIncomingRoad, int index)
  {  
    boolean wasAdded = false;
    if(addIncomingRoad(aIncomingRoad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIncomingRoads()) { index = numberOfIncomingRoads() - 1; }
      incomingRoads.remove(aIncomingRoad);
      incomingRoads.add(index, aIncomingRoad);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIncomingRoadAt(RoadSegment aIncomingRoad, int index)
  {
    boolean wasAdded = false;
    if(incomingRoads.contains(aIncomingRoad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIncomingRoads()) { index = numberOfIncomingRoads() - 1; }
      incomingRoads.remove(aIncomingRoad);
      incomingRoads.add(index, aIncomingRoad);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIncomingRoadAt(aIncomingRoad, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfOutgoingRoads()
  {
    return 0;
  }

  public boolean addOutgoingRoad(RoadSegment aOutgoingRoad)
  {
    boolean wasAdded = false;
    if (outgoingRoads.contains(aOutgoingRoad)) { return false; }
    if (outgoingRoads.contains(aOutgoingRoad)) { return false; }
    RoadNode existingStart = aOutgoingRoad.getStart();
    if (existingStart == null)
    {
      aOutgoingRoad.setStart(this);
    }
    else if (!this.equals(existingStart))
    {
      existingStart.removeOutgoingRoad(aOutgoingRoad);
      addOutgoingRoad(aOutgoingRoad);
    }
    else
    {
      outgoingRoads.add(aOutgoingRoad);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOutgoingRoad(RoadSegment aOutgoingRoad)
  {
    boolean wasRemoved = false;
    if (outgoingRoads.contains(aOutgoingRoad))
    {
      outgoingRoads.remove(aOutgoingRoad);
      aOutgoingRoad.setStart(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOutgoingRoadAt(RoadSegment aOutgoingRoad, int index)
  {  
    boolean wasAdded = false;
    if(addOutgoingRoad(aOutgoingRoad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOutgoingRoads()) { index = numberOfOutgoingRoads() - 1; }
      outgoingRoads.remove(aOutgoingRoad);
      outgoingRoads.add(index, aOutgoingRoad);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOutgoingRoadAt(RoadSegment aOutgoingRoad, int index)
  {
    boolean wasAdded = false;
    if(outgoingRoads.contains(aOutgoingRoad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOutgoingRoads()) { index = numberOfOutgoingRoads() - 1; }
      outgoingRoads.remove(aOutgoingRoad);
      outgoingRoads.add(index, aOutgoingRoad);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOutgoingRoadAt(aOutgoingRoad, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    nodeLocation = null;
    while( !incomingRoads.isEmpty() )
    {
      incomingRoads.get(0).setEnd(null);
    }
    while( !outgoingRoads.isEmpty() )
    {
      outgoingRoads.get(0).setStart(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "nodeLocation = "+(getNodeLocation()!=null?Integer.toHexString(System.identityHashCode(getNodeLocation())):"null")
     + outputString;
  }
}