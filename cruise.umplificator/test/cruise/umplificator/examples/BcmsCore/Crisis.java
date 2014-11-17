/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Time;
import java.util.*;

/**
 * A crisis is what is being managed by the
 * Crisis Management System
 * 
 */
// line 39 "BcmsCore.ump"
// line 112 "BcmsCore.ump"
public class Crisis
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Crisis Attributes
  private String identifier;
  private Location gpsLocation;
  private Time initialReportedTime;
  private String description;

  //Crisis State Machines
  enum Status { active, closed }
  private Status status;

  //Crisis Associations
  private List<Vehicle> assignedFireVehicles;
  private List<Vehicle> assignedPoliceVehicles;
  private Route proposedFireRoute;
  private Route proposedPoliceRoute;
  private List<Route> disagreedRoutes;
  private List<RoadSegment> blockedOrCongestedSegments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Crisis(String aIdentifier, Location aGpsLocation, Time aInitialReportedTime, String aDescription)
  {
    identifier = aIdentifier;
    gpsLocation = aGpsLocation;
    initialReportedTime = aInitialReportedTime;
    description = aDescription;
    assignedFireVehicles = new ArrayList<Vehicle>();
    assignedPoliceVehicles = new ArrayList<Vehicle>();
    disagreedRoutes = new ArrayList<Route>();
    blockedOrCongestedSegments = new ArrayList<RoadSegment>();
    setStatus(Status.active);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdentifier(String aIdentifier)
  {
    boolean wasSet = false;
    identifier = aIdentifier;
    wasSet = true;
    return wasSet;
  }

  public boolean setGpsLocation(Location aGpsLocation)
  {
    boolean wasSet = false;
    gpsLocation = aGpsLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setInitialReportedTime(Time aInitialReportedTime)
  {
    boolean wasSet = false;
    initialReportedTime = aInitialReportedTime;
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

  public String getIdentifier()
  {
    return identifier;
  }

  public Location getGpsLocation()
  {
    return gpsLocation;
  }

  public Time getInitialReportedTime()
  {
    return initialReportedTime;
  }

  public String getDescription()
  {
    return description;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean setStatus(Status aStatus)
  {
    status = aStatus;
    return true;
  }

  public Vehicle getAssignedFireVehicle(int index)
  {
    Vehicle aAssignedFireVehicle = assignedFireVehicles.get(index);
    return aAssignedFireVehicle;
  }

  public List<Vehicle> getAssignedFireVehicles()
  {
    List<Vehicle> newAssignedFireVehicles = Collections.unmodifiableList(assignedFireVehicles);
    return newAssignedFireVehicles;
  }

  public int numberOfAssignedFireVehicles()
  {
    int number = assignedFireVehicles.size();
    return number;
  }

  public boolean hasAssignedFireVehicles()
  {
    boolean has = assignedFireVehicles.size() > 0;
    return has;
  }

  public int indexOfAssignedFireVehicle(Vehicle aAssignedFireVehicle)
  {
    int index = assignedFireVehicles.indexOf(aAssignedFireVehicle);
    return index;
  }

  public Vehicle getAssignedPoliceVehicle(int index)
  {
    Vehicle aAssignedPoliceVehicle = assignedPoliceVehicles.get(index);
    return aAssignedPoliceVehicle;
  }

  public List<Vehicle> getAssignedPoliceVehicles()
  {
    List<Vehicle> newAssignedPoliceVehicles = Collections.unmodifiableList(assignedPoliceVehicles);
    return newAssignedPoliceVehicles;
  }

  public int numberOfAssignedPoliceVehicles()
  {
    int number = assignedPoliceVehicles.size();
    return number;
  }

  public boolean hasAssignedPoliceVehicles()
  {
    boolean has = assignedPoliceVehicles.size() > 0;
    return has;
  }

  public int indexOfAssignedPoliceVehicle(Vehicle aAssignedPoliceVehicle)
  {
    int index = assignedPoliceVehicles.indexOf(aAssignedPoliceVehicle);
    return index;
  }

  public Route getProposedFireRoute()
  {
    return proposedFireRoute;
  }

  public boolean hasProposedFireRoute()
  {
    boolean has = proposedFireRoute != null;
    return has;
  }

  public Route getProposedPoliceRoute()
  {
    return proposedPoliceRoute;
  }

  public boolean hasProposedPoliceRoute()
  {
    boolean has = proposedPoliceRoute != null;
    return has;
  }

  public Route getDisagreedRoute(int index)
  {
    Route aDisagreedRoute = disagreedRoutes.get(index);
    return aDisagreedRoute;
  }

  public List<Route> getDisagreedRoutes()
  {
    List<Route> newDisagreedRoutes = Collections.unmodifiableList(disagreedRoutes);
    return newDisagreedRoutes;
  }

  public int numberOfDisagreedRoutes()
  {
    int number = disagreedRoutes.size();
    return number;
  }

  public boolean hasDisagreedRoutes()
  {
    boolean has = disagreedRoutes.size() > 0;
    return has;
  }

  public int indexOfDisagreedRoute(Route aDisagreedRoute)
  {
    int index = disagreedRoutes.indexOf(aDisagreedRoute);
    return index;
  }

  public RoadSegment getBlockedOrCongestedSegment(int index)
  {
    RoadSegment aBlockedOrCongestedSegment = blockedOrCongestedSegments.get(index);
    return aBlockedOrCongestedSegment;
  }

  public List<RoadSegment> getBlockedOrCongestedSegments()
  {
    List<RoadSegment> newBlockedOrCongestedSegments = Collections.unmodifiableList(blockedOrCongestedSegments);
    return newBlockedOrCongestedSegments;
  }

  public int numberOfBlockedOrCongestedSegments()
  {
    int number = blockedOrCongestedSegments.size();
    return number;
  }

  public boolean hasBlockedOrCongestedSegments()
  {
    boolean has = blockedOrCongestedSegments.size() > 0;
    return has;
  }

  public int indexOfBlockedOrCongestedSegment(RoadSegment aBlockedOrCongestedSegment)
  {
    int index = blockedOrCongestedSegments.indexOf(aBlockedOrCongestedSegment);
    return index;
  }

  public static int minimumNumberOfAssignedFireVehicles()
  {
    return 0;
  }

  public boolean addAssignedFireVehicle(Vehicle aAssignedFireVehicle)
  {
    boolean wasAdded = false;
    if (assignedFireVehicles.contains(aAssignedFireVehicle)) { return false; }
    assignedFireVehicles.add(aAssignedFireVehicle);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssignedFireVehicle(Vehicle aAssignedFireVehicle)
  {
    boolean wasRemoved = false;
    if (assignedFireVehicles.contains(aAssignedFireVehicle))
    {
      assignedFireVehicles.remove(aAssignedFireVehicle);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAssignedFireVehicleAt(Vehicle aAssignedFireVehicle, int index)
  {  
    boolean wasAdded = false;
    if(addAssignedFireVehicle(aAssignedFireVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedFireVehicles()) { index = numberOfAssignedFireVehicles() - 1; }
      assignedFireVehicles.remove(aAssignedFireVehicle);
      assignedFireVehicles.add(index, aAssignedFireVehicle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignedFireVehicleAt(Vehicle aAssignedFireVehicle, int index)
  {
    boolean wasAdded = false;
    if(assignedFireVehicles.contains(aAssignedFireVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedFireVehicles()) { index = numberOfAssignedFireVehicles() - 1; }
      assignedFireVehicles.remove(aAssignedFireVehicle);
      assignedFireVehicles.add(index, aAssignedFireVehicle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignedFireVehicleAt(aAssignedFireVehicle, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAssignedPoliceVehicles()
  {
    return 0;
  }

  public boolean addAssignedPoliceVehicle(Vehicle aAssignedPoliceVehicle)
  {
    boolean wasAdded = false;
    if (assignedPoliceVehicles.contains(aAssignedPoliceVehicle)) { return false; }
    assignedPoliceVehicles.add(aAssignedPoliceVehicle);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssignedPoliceVehicle(Vehicle aAssignedPoliceVehicle)
  {
    boolean wasRemoved = false;
    if (assignedPoliceVehicles.contains(aAssignedPoliceVehicle))
    {
      assignedPoliceVehicles.remove(aAssignedPoliceVehicle);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAssignedPoliceVehicleAt(Vehicle aAssignedPoliceVehicle, int index)
  {  
    boolean wasAdded = false;
    if(addAssignedPoliceVehicle(aAssignedPoliceVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedPoliceVehicles()) { index = numberOfAssignedPoliceVehicles() - 1; }
      assignedPoliceVehicles.remove(aAssignedPoliceVehicle);
      assignedPoliceVehicles.add(index, aAssignedPoliceVehicle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignedPoliceVehicleAt(Vehicle aAssignedPoliceVehicle, int index)
  {
    boolean wasAdded = false;
    if(assignedPoliceVehicles.contains(aAssignedPoliceVehicle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedPoliceVehicles()) { index = numberOfAssignedPoliceVehicles() - 1; }
      assignedPoliceVehicles.remove(aAssignedPoliceVehicle);
      assignedPoliceVehicles.add(index, aAssignedPoliceVehicle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignedPoliceVehicleAt(aAssignedPoliceVehicle, index);
    }
    return wasAdded;
  }

  public boolean setProposedFireRoute(Route aNewProposedFireRoute)
  {
    boolean wasSet = false;
    proposedFireRoute = aNewProposedFireRoute;
    wasSet = true;
    return wasSet;
  }

  public boolean setProposedPoliceRoute(Route aNewProposedPoliceRoute)
  {
    boolean wasSet = false;
    proposedPoliceRoute = aNewProposedPoliceRoute;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDisagreedRoutes()
  {
    return 0;
  }

  public boolean addDisagreedRoute(Route aDisagreedRoute)
  {
    boolean wasAdded = false;
    if (disagreedRoutes.contains(aDisagreedRoute)) { return false; }
    disagreedRoutes.add(aDisagreedRoute);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDisagreedRoute(Route aDisagreedRoute)
  {
    boolean wasRemoved = false;
    if (disagreedRoutes.contains(aDisagreedRoute))
    {
      disagreedRoutes.remove(aDisagreedRoute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDisagreedRouteAt(Route aDisagreedRoute, int index)
  {  
    boolean wasAdded = false;
    if(addDisagreedRoute(aDisagreedRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDisagreedRoutes()) { index = numberOfDisagreedRoutes() - 1; }
      disagreedRoutes.remove(aDisagreedRoute);
      disagreedRoutes.add(index, aDisagreedRoute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDisagreedRouteAt(Route aDisagreedRoute, int index)
  {
    boolean wasAdded = false;
    if(disagreedRoutes.contains(aDisagreedRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDisagreedRoutes()) { index = numberOfDisagreedRoutes() - 1; }
      disagreedRoutes.remove(aDisagreedRoute);
      disagreedRoutes.add(index, aDisagreedRoute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDisagreedRouteAt(aDisagreedRoute, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfBlockedOrCongestedSegments()
  {
    return 0;
  }

  public boolean addBlockedOrCongestedSegment(RoadSegment aBlockedOrCongestedSegment)
  {
    boolean wasAdded = false;
    if (blockedOrCongestedSegments.contains(aBlockedOrCongestedSegment)) { return false; }
    blockedOrCongestedSegments.add(aBlockedOrCongestedSegment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBlockedOrCongestedSegment(RoadSegment aBlockedOrCongestedSegment)
  {
    boolean wasRemoved = false;
    if (blockedOrCongestedSegments.contains(aBlockedOrCongestedSegment))
    {
      blockedOrCongestedSegments.remove(aBlockedOrCongestedSegment);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBlockedOrCongestedSegmentAt(RoadSegment aBlockedOrCongestedSegment, int index)
  {  
    boolean wasAdded = false;
    if(addBlockedOrCongestedSegment(aBlockedOrCongestedSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBlockedOrCongestedSegments()) { index = numberOfBlockedOrCongestedSegments() - 1; }
      blockedOrCongestedSegments.remove(aBlockedOrCongestedSegment);
      blockedOrCongestedSegments.add(index, aBlockedOrCongestedSegment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBlockedOrCongestedSegmentAt(RoadSegment aBlockedOrCongestedSegment, int index)
  {
    boolean wasAdded = false;
    if(blockedOrCongestedSegments.contains(aBlockedOrCongestedSegment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBlockedOrCongestedSegments()) { index = numberOfBlockedOrCongestedSegments() - 1; }
      blockedOrCongestedSegments.remove(aBlockedOrCongestedSegment);
      blockedOrCongestedSegments.add(index, aBlockedOrCongestedSegment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBlockedOrCongestedSegmentAt(aBlockedOrCongestedSegment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    assignedFireVehicles.clear();
    assignedPoliceVehicles.clear();
    proposedFireRoute = null;
    proposedPoliceRoute = null;
    disagreedRoutes.clear();
    blockedOrCongestedSegments.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "identifier" + ":" + getIdentifier()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "gpsLocation" + "=" + (getGpsLocation() != null ? !getGpsLocation().equals(this)  ? getGpsLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "initialReportedTime" + "=" + (getInitialReportedTime() != null ? !getInitialReportedTime().equals(this)  ? getInitialReportedTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "proposedFireRoute = "+(getProposedFireRoute()!=null?Integer.toHexString(System.identityHashCode(getProposedFireRoute())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "proposedPoliceRoute = "+(getProposedPoliceRoute()!=null?Integer.toHexString(System.identityHashCode(getProposedPoliceRoute())):"null")
     + outputString;
  }
}