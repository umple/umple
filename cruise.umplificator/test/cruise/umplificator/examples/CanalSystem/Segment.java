/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 18 "CanalSystem.ump"
// line 86 "CanalSystem.ump"
public class Segment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Segment Attributes
  private float waterLevel;

  //Segment Associations
  private List<SegEnd> segEnds;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Segment(float aWaterLevel)
  {
    waterLevel = aWaterLevel;
    segEnds = new ArrayList<SegEnd>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWaterLevel(float aWaterLevel)
  {
    boolean wasSet = false;
    waterLevel = aWaterLevel;
    wasSet = true;
    return wasSet;
  }

  /**
   * m above sea level
   */
  public float getWaterLevel()
  {
    return waterLevel;
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

  public boolean isNumberOfSegEndsValid()
  {
    boolean isValid = numberOfSegEnds() >= minimumNumberOfSegEnds() && numberOfSegEnds() <= maximumNumberOfSegEnds();
    return isValid;
  }

  public static int requiredNumberOfSegEnds()
  {
    return 2;
  }

  public static int minimumNumberOfSegEnds()
  {
    return 2;
  }

  public static int maximumNumberOfSegEnds()
  {
    return 2;
  }

  public boolean addSegEnd(SegEnd aSegEnd)
  {
    boolean wasAdded = false;
    if (segEnds.contains(aSegEnd)) { return false; }
    if (segEnds.contains(aSegEnd)) { return false; }
    if (numberOfSegEnds() >= maximumNumberOfSegEnds())
    {
      return wasAdded;
    }

    segEnds.add(aSegEnd);
    if (aSegEnd.indexOfSegment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSegEnd.addSegment(this);
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

    if (numberOfSegEnds() <= minimumNumberOfSegEnds())
    {
      return wasRemoved;
    }

    int oldIndex = segEnds.indexOf(aSegEnd);
    segEnds.remove(oldIndex);
    if (aSegEnd.indexOfSegment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSegEnd.removeSegment(this);
      if (!wasRemoved)
      {
        segEnds.add(oldIndex,aSegEnd);
      }
    }
    return wasRemoved;
  }

  public boolean setSegEnds(SegEnd... newSegEnds)
  {
    boolean wasSet = false;
    ArrayList<SegEnd> verifiedSegEnds = new ArrayList<SegEnd>();
    for (SegEnd aSegEnd : newSegEnds)
    {
      if (verifiedSegEnds.contains(aSegEnd))
      {
        continue;
      }
      verifiedSegEnds.add(aSegEnd);
    }

    if (verifiedSegEnds.size() != newSegEnds.length || verifiedSegEnds.size() < minimumNumberOfSegEnds() || verifiedSegEnds.size() > maximumNumberOfSegEnds())
    {
      return wasSet;
    }

    ArrayList<SegEnd> oldSegEnds = new ArrayList<SegEnd>(segEnds);
    segEnds.clear();
    for (SegEnd aNewSegEnd : verifiedSegEnds)
    {
      segEnds.add(aNewSegEnd);
      if (oldSegEnds.contains(aNewSegEnd))
      {
        oldSegEnds.remove(aNewSegEnd);
      }
      else
      {
        aNewSegEnd.addSegment(this);
      }
    }

    for (SegEnd anOldSegEnd : oldSegEnds)
    {
      anOldSegEnd.removeSegment(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<SegEnd> copyOfSegEnds = new ArrayList<SegEnd>(segEnds);
    segEnds.clear();
    for(SegEnd aSegEnd : copyOfSegEnds)
    {
      if (aSegEnd.numberOfSegments() <= SegEnd.minimumNumberOfSegments())
      {
        aSegEnd.delete();
      }
      else
      {
        aSegEnd.removeSegment(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "waterLevel" + ":" + getWaterLevel()+ "]"
     + outputString;
  }
}