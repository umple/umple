/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 6 "CanalSystem.ump"
// line 74 "CanalSystem.ump"
public class CanalNetwork
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CanalNetwork Attributes
  private String name;

  //CanalNetwork Associations
  private List<CanalNetwork> subNetwork;
  private List<Craft> activeVessels;
  private List<SegEnd> segEnds;
  private CanalNetwork canalNetwork;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CanalNetwork(String aName)
  {
    name = aName;
    subNetwork = new ArrayList<CanalNetwork>();
    activeVessels = new ArrayList<Craft>();
    segEnds = new ArrayList<SegEnd>();
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

  public String getName()
  {
    return name;
  }

  public CanalNetwork getSubNetwork(int index)
  {
    CanalNetwork aSubNetwork = subNetwork.get(index);
    return aSubNetwork;
  }

  public List<CanalNetwork> getSubNetwork()
  {
    List<CanalNetwork> newSubNetwork = Collections.unmodifiableList(subNetwork);
    return newSubNetwork;
  }

  public int numberOfSubNetwork()
  {
    int number = subNetwork.size();
    return number;
  }

  public boolean hasSubNetwork()
  {
    boolean has = subNetwork.size() > 0;
    return has;
  }

  public int indexOfSubNetwork(CanalNetwork aSubNetwork)
  {
    int index = subNetwork.indexOf(aSubNetwork);
    return index;
  }

  public Craft getActiveVessel(int index)
  {
    Craft aActiveVessel = activeVessels.get(index);
    return aActiveVessel;
  }

  public List<Craft> getActiveVessels()
  {
    List<Craft> newActiveVessels = Collections.unmodifiableList(activeVessels);
    return newActiveVessels;
  }

  public int numberOfActiveVessels()
  {
    int number = activeVessels.size();
    return number;
  }

  public boolean hasActiveVessels()
  {
    boolean has = activeVessels.size() > 0;
    return has;
  }

  public int indexOfActiveVessel(Craft aActiveVessel)
  {
    int index = activeVessels.indexOf(aActiveVessel);
    return index;
  }

  public SegEnd getSegEnd(int index)
  {
    SegEnd aSegEnd = segEnds.get(index);
    return aSegEnd;
  }

  public List<SegEnd> getSegEnds()
  {
    List<SegEnd> newSegEnds = Collections.unmodifiableList(segEnds);
    return newSegEnds;
  }

  public int numberOfSegEnds()
  {
    int number = segEnds.size();
    return number;
  }

  public boolean hasSegEnds()
  {
    boolean has = segEnds.size() > 0;
    return has;
  }

  public int indexOfSegEnd(SegEnd aSegEnd)
  {
    int index = segEnds.indexOf(aSegEnd);
    return index;
  }

  public CanalNetwork getCanalNetwork()
  {
    return canalNetwork;
  }

  public boolean hasCanalNetwork()
  {
    boolean has = canalNetwork != null;
    return has;
  }

  public static int minimumNumberOfSubNetwork()
  {
    return 0;
  }

  public boolean addSubNetwork(CanalNetwork aSubNetwork)
  {
    boolean wasAdded = false;
    if (subNetwork.contains(aSubNetwork)) { return false; }
    CanalNetwork existingCanalNetwork = aSubNetwork.getCanalNetwork();
    if (existingCanalNetwork == null)
    {
      aSubNetwork.setCanalNetwork(this);
    }
    else if (!this.equals(existingCanalNetwork))
    {
      existingCanalNetwork.removeSubNetwork(aSubNetwork);
      addSubNetwork(aSubNetwork);
    }
    else
    {
      subNetwork.add(aSubNetwork);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubNetwork(CanalNetwork aSubNetwork)
  {
    boolean wasRemoved = false;
    if (subNetwork.contains(aSubNetwork))
    {
      subNetwork.remove(aSubNetwork);
      aSubNetwork.setCanalNetwork(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubNetworkAt(CanalNetwork aSubNetwork, int index)
  {  
    boolean wasAdded = false;
    if(addSubNetwork(aSubNetwork))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubNetwork()) { index = numberOfSubNetwork() - 1; }
      subNetwork.remove(aSubNetwork);
      subNetwork.add(index, aSubNetwork);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubNetworkAt(CanalNetwork aSubNetwork, int index)
  {
    boolean wasAdded = false;
    if(subNetwork.contains(aSubNetwork))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubNetwork()) { index = numberOfSubNetwork() - 1; }
      subNetwork.remove(aSubNetwork);
      subNetwork.add(index, aSubNetwork);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubNetworkAt(aSubNetwork, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfActiveVessels()
  {
    return 0;
  }

  public boolean addActiveVessel(Craft aActiveVessel)
  {
    boolean wasAdded = false;
    if (activeVessels.contains(aActiveVessel)) { return false; }
    CanalNetwork existingCanalNetwork = aActiveVessel.getCanalNetwork();
    if (existingCanalNetwork == null)
    {
      aActiveVessel.setCanalNetwork(this);
    }
    else if (!this.equals(existingCanalNetwork))
    {
      existingCanalNetwork.removeActiveVessel(aActiveVessel);
      addActiveVessel(aActiveVessel);
    }
    else
    {
      activeVessels.add(aActiveVessel);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeActiveVessel(Craft aActiveVessel)
  {
    boolean wasRemoved = false;
    if (activeVessels.contains(aActiveVessel))
    {
      activeVessels.remove(aActiveVessel);
      aActiveVessel.setCanalNetwork(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addActiveVesselAt(Craft aActiveVessel, int index)
  {  
    boolean wasAdded = false;
    if(addActiveVessel(aActiveVessel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActiveVessels()) { index = numberOfActiveVessels() - 1; }
      activeVessels.remove(aActiveVessel);
      activeVessels.add(index, aActiveVessel);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveActiveVesselAt(Craft aActiveVessel, int index)
  {
    boolean wasAdded = false;
    if(activeVessels.contains(aActiveVessel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActiveVessels()) { index = numberOfActiveVessels() - 1; }
      activeVessels.remove(aActiveVessel);
      activeVessels.add(index, aActiveVessel);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addActiveVesselAt(aActiveVessel, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSegEnds()
  {
    return 0;
  }

  public boolean addSegEnd(SegEnd aSegEnd)
  {
    boolean wasAdded = false;
    if (segEnds.contains(aSegEnd)) { return false; }
    segEnds.add(aSegEnd);
    if (aSegEnd.indexOfCanalNetwork(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSegEnd.addCanalNetwork(this);
      if (!wasAdded)
      {
        segEnds.remove(aSegEnd);
      }
    }
    return wasAdded;
  }

  public boolean removeSegEnd(SegEnd aSegEnd)
  {
    boolean wasRemoved = false;
    if (!segEnds.contains(aSegEnd))
    {
      return wasRemoved;
    }

    int oldIndex = segEnds.indexOf(aSegEnd);
    segEnds.remove(oldIndex);
    if (aSegEnd.indexOfCanalNetwork(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSegEnd.removeCanalNetwork(this);
      if (!wasRemoved)
      {
        segEnds.add(oldIndex,aSegEnd);
      }
    }
    return wasRemoved;
  }

  public boolean addSegEndAt(SegEnd aSegEnd, int index)
  {  
    boolean wasAdded = false;
    if(addSegEnd(aSegEnd))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSegEnds()) { index = numberOfSegEnds() - 1; }
      segEnds.remove(aSegEnd);
      segEnds.add(index, aSegEnd);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSegEndAt(SegEnd aSegEnd, int index)
  {
    boolean wasAdded = false;
    if(segEnds.contains(aSegEnd))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSegEnds()) { index = numberOfSegEnds() - 1; }
      segEnds.remove(aSegEnd);
      segEnds.add(index, aSegEnd);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSegEndAt(aSegEnd, index);
    }
    return wasAdded;
  }

  public boolean setCanalNetwork(CanalNetwork aCanalNetwork)
  {
    boolean wasSet = false;
    CanalNetwork existingCanalNetwork = canalNetwork;
    canalNetwork = aCanalNetwork;
    if (existingCanalNetwork != null && !existingCanalNetwork.equals(aCanalNetwork))
    {
      existingCanalNetwork.removeSubNetwork(this);
    }
    if (aCanalNetwork != null)
    {
      aCanalNetwork.addSubNetwork(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !subNetwork.isEmpty() )
    {
      subNetwork.get(0).setCanalNetwork(null);
    }
    while( !activeVessels.isEmpty() )
    {
      activeVessels.get(0).setCanalNetwork(null);
    }
    ArrayList<SegEnd> copyOfSegEnds = new ArrayList<SegEnd>(segEnds);
    segEnds.clear();
    for(SegEnd aSegEnd : copyOfSegEnds)
    {
      aSegEnd.removeCanalNetwork(this);
    }
    if (canalNetwork != null)
    {
      CanalNetwork placeholderCanalNetwork = canalNetwork;
      this.canalNetwork = null;
      placeholderCanalNetwork.removeSubNetwork(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}