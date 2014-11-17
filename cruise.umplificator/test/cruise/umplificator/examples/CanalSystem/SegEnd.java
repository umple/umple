/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 13 "CanalSystem.ump"
// line 81 "CanalSystem.ump"
public class SegEnd
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SegEnd Attributes
  private String name;
  private GPSCoord location;

  //SegEnd Associations
  private List<CanalNetwork> canalNetworks;
  private List<Segment> segments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SegEnd(String aName, GPSCoord aLocation)
  {
    name = aName;
    location = aLocation;
    canalNetworks = new ArrayList<CanalNetwork>();
    segments = new ArrayList<Segment>();
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

  public boolean setLocation(GPSCoord aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public GPSCoord getLocation()
  {
    return location;
  }

  public CanalNetwork getCanalNetwork(int index)
  {
    CanalNetwork aCanalNetwork = canalNetworks.get(index);
    return aCanalNetwork;
  }

  public List<CanalNetwork> getCanalNetworks()
  {
    List<CanalNetwork> newCanalNetworks = Collections.unmodifiableList(canalNetworks);
    return newCanalNetworks;
  }

  public int numberOfCanalNetworks()
  {
    int number = canalNetworks.size();
    return number;
  }

  public boolean hasCanalNetworks()
  {
    boolean has = canalNetworks.size() > 0;
    return has;
  }

  public int indexOfCanalNetwork(CanalNetwork aCanalNetwork)
  {
    int index = canalNetworks.indexOf(aCanalNetwork);
    return index;
  }

  public Segment getSegment(int index)
  {
    Segment aSegment = segments.get(index);
    return aSegment;
  }

  public List<Segment> getSegments()
  {
    List<Segment> newSegments = Collections.unmodifiableList(segments);
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

  public int indexOfSegment(Segment aSegment)
  {
    int index = segments.indexOf(aSegment);
    return index;
  }

  public static int minimumNumberOfCanalNetworks()
  {
    return 0;
  }

  public boolean addCanalNetwork(CanalNetwork aCanalNetwork)
  {
    boolean wasAdded = false;
    if (canalNetworks.contains(aCanalNetwork)) { return false; }
    if (canalNetworks.contains(aCanalNetwork)) { return false; }
    if (canalNetworks.contains(aCanalNetwork)) { return false; }
    if (canalNetworks.contains(aCanalNetwork)) { return false; }
    if (canalNetworks.contains(aCanalNetwork)) { return false; }
    canalNetworks.add(aCanalNetwork);
    if (aCanalNetwork.indexOfSegEnd(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCanalNetwork.addSegEnd(this);
      if (!wasAdded)
      {
        canalNetworks.remove(aCanalNetwork);
      }
    }
    return wasAdded;
  }

  public boolean removeCanalNetwork(CanalNetwork aCanalNetwork)
  {
    boolean wasRemoved = false;
    if (!canalNetworks.contains(aCanalNetwork))
    {
      return wasRemoved;
    }

    int oldIndex = canalNetworks.indexOf(aCanalNetwork);
    canalNetworks.remove(oldIndex);
    if (aCanalNetwork.indexOfSegEnd(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCanalNetwork.removeSegEnd(this);
      if (!wasRemoved)
      {
        canalNetworks.add(oldIndex,aCanalNetwork);
      }
    }
    return wasRemoved;
  }

  public boolean addCanalNetworkAt(CanalNetwork aCanalNetwork, int index)
  {  
    boolean wasAdded = false;
    if(addCanalNetwork(aCanalNetwork))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCanalNetworks()) { index = numberOfCanalNetworks() - 1; }
      canalNetworks.remove(aCanalNetwork);
      canalNetworks.add(index, aCanalNetwork);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCanalNetworkAt(CanalNetwork aCanalNetwork, int index)
  {
    boolean wasAdded = false;
    if(canalNetworks.contains(aCanalNetwork))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCanalNetworks()) { index = numberOfCanalNetworks() - 1; }
      canalNetworks.remove(aCanalNetwork);
      canalNetworks.add(index, aCanalNetwork);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCanalNetworkAt(aCanalNetwork, index);
    }
    return wasAdded;
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

  public boolean addSegment(Segment aSegment)
  {
    boolean wasAdded = false;
    if (segments.contains(aSegment)) { return false; }
    if (segments.contains(aSegment)) { return false; }
    if (segments.contains(aSegment)) { return false; }
    if (segments.contains(aSegment)) { return false; }
    if (segments.contains(aSegment)) { return false; }
    segments.add(aSegment);
    if (aSegment.indexOfSegEnd(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSegment.addSegEnd(this);
      if (!wasAdded)
      {
        segments.remove(aSegment);
      }
    }
    return wasAdded;
  }

  public boolean removeSegment(Segment aSegment)
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
    if (aSegment.indexOfSegEnd(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSegment.removeSegEnd(this);
      if (!wasRemoved)
      {
        segments.add(oldIndex,aSegment);
      }
    }
    return wasRemoved;
  }

  public boolean setSegments(Segment... newSegments)
  {
    boolean wasSet = false;
    ArrayList<Segment> verifiedSegments = new ArrayList<Segment>();
    for (Segment aSegment : newSegments)
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

    ArrayList<Segment> oldSegments = new ArrayList<Segment>(segments);
    segments.clear();
    for (Segment aNewSegment : verifiedSegments)
    {
      segments.add(aNewSegment);
      if (oldSegments.contains(aNewSegment))
      {
        oldSegments.remove(aNewSegment);
      }
      else
      {
        aNewSegment.addSegEnd(this);
      }
    }

    for (Segment anOldSegment : oldSegments)
    {
      anOldSegment.removeSegEnd(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addSegmentAt(Segment aSegment, int index)
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

  public boolean addOrMoveSegmentAt(Segment aSegment, int index)
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
    ArrayList<CanalNetwork> copyOfCanalNetworks = new ArrayList<CanalNetwork>(canalNetworks);
    canalNetworks.clear();
    for(CanalNetwork aCanalNetwork : copyOfCanalNetworks)
    {
      aCanalNetwork.removeSegEnd(this);
    }
    ArrayList<Segment> copyOfSegments = new ArrayList<Segment>(segments);
    segments.clear();
    for(Segment aSegment : copyOfSegments)
    {
      if (aSegment.numberOfSegEnds() <= Segment.minimumNumberOfSegEnds())
      {
        aSegment.delete();
      }
      else
      {
        aSegment.removeSegEnd(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}