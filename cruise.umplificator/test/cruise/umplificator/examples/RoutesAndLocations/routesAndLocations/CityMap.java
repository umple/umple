/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package routesAndLocations;
import java.util.*;

// line 23 "../../RoutesAndLocations.ump"
// line 180 "../../RoutesAndLocations.ump"
public class CityMap
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static CityMap theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CityMap Associations
  private List<Landmark> fireStn;
  private List<Landmark> policeStn;
  private List<Landmark> otherLm;
  private List<NamedRoad> namedRoads;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private CityMap()
  {
    fireStn = new ArrayList<Landmark>();
    policeStn = new ArrayList<Landmark>();
    otherLm = new ArrayList<Landmark>();
    namedRoads = new ArrayList<NamedRoad>();
  }

  public static CityMap getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new CityMap();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Landmark getFireStn(int index)
  {
    Landmark aFireStn = fireStn.get(index);
    return aFireStn;
  }

  public List<Landmark> getFireStn()
  {
    List<Landmark> newFireStn = Collections.unmodifiableList(fireStn);
    return newFireStn;
  }

  public int numberOfFireStn()
  {
    int number = fireStn.size();
    return number;
  }

  public boolean hasFireStn()
  {
    boolean has = fireStn.size() > 0;
    return has;
  }

  public int indexOfFireStn(Landmark aFireStn)
  {
    int index = fireStn.indexOf(aFireStn);
    return index;
  }

  public Landmark getPoliceStn(int index)
  {
    Landmark aPoliceStn = policeStn.get(index);
    return aPoliceStn;
  }

  public List<Landmark> getPoliceStn()
  {
    List<Landmark> newPoliceStn = Collections.unmodifiableList(policeStn);
    return newPoliceStn;
  }

  public int numberOfPoliceStn()
  {
    int number = policeStn.size();
    return number;
  }

  public boolean hasPoliceStn()
  {
    boolean has = policeStn.size() > 0;
    return has;
  }

  public int indexOfPoliceStn(Landmark aPoliceStn)
  {
    int index = policeStn.indexOf(aPoliceStn);
    return index;
  }

  public Landmark getOtherLm(int index)
  {
    Landmark aOtherLm = otherLm.get(index);
    return aOtherLm;
  }

  public List<Landmark> getOtherLm()
  {
    List<Landmark> newOtherLm = Collections.unmodifiableList(otherLm);
    return newOtherLm;
  }

  public int numberOfOtherLm()
  {
    int number = otherLm.size();
    return number;
  }

  public boolean hasOtherLm()
  {
    boolean has = otherLm.size() > 0;
    return has;
  }

  public int indexOfOtherLm(Landmark aOtherLm)
  {
    int index = otherLm.indexOf(aOtherLm);
    return index;
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

  public static int minimumNumberOfFireStn()
  {
    return 0;
  }

  public boolean addFireStn(Landmark aFireStn)
  {
    boolean wasAdded = false;
    if (fireStn.contains(aFireStn)) { return false; }
    fireStn.add(aFireStn);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFireStn(Landmark aFireStn)
  {
    boolean wasRemoved = false;
    if (fireStn.contains(aFireStn))
    {
      fireStn.remove(aFireStn);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFireStnAt(Landmark aFireStn, int index)
  {  
    boolean wasAdded = false;
    if(addFireStn(aFireStn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFireStn()) { index = numberOfFireStn() - 1; }
      fireStn.remove(aFireStn);
      fireStn.add(index, aFireStn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFireStnAt(Landmark aFireStn, int index)
  {
    boolean wasAdded = false;
    if(fireStn.contains(aFireStn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFireStn()) { index = numberOfFireStn() - 1; }
      fireStn.remove(aFireStn);
      fireStn.add(index, aFireStn);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFireStnAt(aFireStn, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPoliceStn()
  {
    return 0;
  }

  public boolean addPoliceStn(Landmark aPoliceStn)
  {
    boolean wasAdded = false;
    if (policeStn.contains(aPoliceStn)) { return false; }
    policeStn.add(aPoliceStn);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePoliceStn(Landmark aPoliceStn)
  {
    boolean wasRemoved = false;
    if (policeStn.contains(aPoliceStn))
    {
      policeStn.remove(aPoliceStn);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPoliceStnAt(Landmark aPoliceStn, int index)
  {  
    boolean wasAdded = false;
    if(addPoliceStn(aPoliceStn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPoliceStn()) { index = numberOfPoliceStn() - 1; }
      policeStn.remove(aPoliceStn);
      policeStn.add(index, aPoliceStn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePoliceStnAt(Landmark aPoliceStn, int index)
  {
    boolean wasAdded = false;
    if(policeStn.contains(aPoliceStn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPoliceStn()) { index = numberOfPoliceStn() - 1; }
      policeStn.remove(aPoliceStn);
      policeStn.add(index, aPoliceStn);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPoliceStnAt(aPoliceStn, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfOtherLm()
  {
    return 0;
  }

  public boolean addOtherLm(Landmark aOtherLm)
  {
    boolean wasAdded = false;
    if (otherLm.contains(aOtherLm)) { return false; }
    otherLm.add(aOtherLm);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOtherLm(Landmark aOtherLm)
  {
    boolean wasRemoved = false;
    if (otherLm.contains(aOtherLm))
    {
      otherLm.remove(aOtherLm);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOtherLmAt(Landmark aOtherLm, int index)
  {  
    boolean wasAdded = false;
    if(addOtherLm(aOtherLm))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOtherLm()) { index = numberOfOtherLm() - 1; }
      otherLm.remove(aOtherLm);
      otherLm.add(index, aOtherLm);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOtherLmAt(Landmark aOtherLm, int index)
  {
    boolean wasAdded = false;
    if(otherLm.contains(aOtherLm))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOtherLm()) { index = numberOfOtherLm() - 1; }
      otherLm.remove(aOtherLm);
      otherLm.add(index, aOtherLm);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOtherLmAt(aOtherLm, index);
    }
    return wasAdded;
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
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeNamedRoad(NamedRoad aNamedRoad)
  {
    boolean wasRemoved = false;
    if (namedRoads.contains(aNamedRoad))
    {
      namedRoads.remove(aNamedRoad);
      wasRemoved = true;
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
    fireStn.clear();
    policeStn.clear();
    otherLm.clear();
    namedRoads.clear();
  }

}