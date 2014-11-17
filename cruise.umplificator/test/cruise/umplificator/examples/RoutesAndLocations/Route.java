/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * A route is a plan to get from one location to another
 * It is built by algorithms that traverse the nodes and arcs of the map
 * taking into account speed, congestion, etc.
 */
// line 123 "RoutesAndLocations.ump"
// line 144 "RoutesAndLocations.ump"
public class Route
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Route Attributes
  private int estimatedTime;

  //Route Associations
  private List<RoadSegment> roadSegments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Route(int aEstimatedTime, RoadSegment... allRoadSegments)
  {
    estimatedTime = aEstimatedTime;
    roadSegments = new ArrayList<RoadSegment>();
    boolean didAddRoadSegments = setRoadSegments(allRoadSegments);
    if (!didAddRoadSegments)
    {
      throw new RuntimeException("Unable to create Route, must have at least 1 roadSegments");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEstimatedTime(int aEstimatedTime)
  {
    boolean wasSet = false;
    estimatedTime = aEstimatedTime;
    wasSet = true;
    return wasSet;
  }

  /**
   * Time seconds at current flow speeds
   */
  public int getEstimatedTime()
  {
    return estimatedTime;
  }

  public RoadSegment getRoadSegment(int index)
  {
    RoadSegment aRoadSegment = roadSegments.get(index);
    return aRoadSegment;
  }

  /**
   * Ordered list of segments
   */
  public List<RoadSegment> getRoadSegments()
  {
    List<RoadSegment> newRoadSegments = Collections.unmodifiableList(roadSegments);
    return newRoadSegments;
  }

  public int numberOfRoadSegments()
  {
    int number = roadSegments.size();
    return number;
  }

  public boolean hasRoadSegments()
  {
    boolean has = roadSegments.size() > 0;
    return has;
  }

  public int indexOfRoadSegment(RoadSegment aRoadSegment)
  {
    int index = roadSegments.indexOf(aRoadSegment);
    return index;
  }

  public static int minimumNumberOfRoadSegments()
  {
    return 1;
  }

  public boolean addRoadSegment(RoadSegment aRoadSegment)
  {
    boolean wasAdded = false;
    if (roadSegments.contains(aRoadSegment)) { return false; }
    roadSegments.add(aRoadSegment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoadSegment(RoadSegment aRoadSegment)
  {
    boolean wasRemoved = false;
    if (!roadSegments.contains(aRoadSegment))
    {
      return wasRemoved;
    }

    if (numberOfRoadSegments() <= minimumNumberOfRoadSegments())
    {
      return wasRemoved;
    }

    roadSegments.remove(aRoadSegment);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean setRoadSegments(RoadSegment... newRoadSegments)
  {
    boolean wasSet = false;
    ArrayList<RoadSegment> verifiedRoadSegments = new ArrayList<RoadSegment>();
    for (RoadSegment aRoadSegment : newRoadSegments)
    {
      if (verifiedRoadSegments.contains(aRoadSegment))
      {
        continue;
      }
      verifiedRoadSegments.add(aRoadSegment);
    }

    if (verifiedRoadSegments.size() != newRoadSegments.length || verifiedRoadSegments.size() < minimumNumberOfRoadSegments())
    {
      return wasSet;
    }

    roadSegments.clear();
    roadSegments.addAll(verifiedRoadSegments);
    wasSet = true;
    return wasSet;
  }

  public boolean addRoadSegmentAt(RoadSegment aRoadSegment, int index)
  {  
    boolean wasAdded = false;
    if(addRoadSegment(aRoadSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoadSegments()) { index = numberOfRoadSegments() - 1; }
      roadSegments.remove(aRoadSegment);
      roadSegments.add(index, aRoadSegment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoadSegmentAt(RoadSegment aRoadSegment, int index)
  {
    boolean wasAdded = false;
    if(roadSegments.contains(aRoadSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoadSegments()) { index = numberOfRoadSegments() - 1; }
      roadSegments.remove(aRoadSegment);
      roadSegments.add(index, aRoadSegment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoadSegmentAt(aRoadSegment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    roadSegments.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "estimatedTime" + ":" + getEstimatedTime()+ "]"
     + outputString;
  }
}