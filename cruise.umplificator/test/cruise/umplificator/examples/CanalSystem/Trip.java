/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 59 "CanalSystem.ump"
// line 136 "CanalSystem.ump"
public class Trip
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trip Associations
  private List<SegEnd> segEnds;
  private Craft craft;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trip(Craft aCraft, SegEnd... allSegEnds)
  {
    segEnds = new ArrayList<SegEnd>();
    boolean didAddSegEnds = setSegEnds(allSegEnds);
    if (!didAddSegEnds)
    {
      throw new RuntimeException("Unable to create Trip, must have at least 1 segEnds");
    }
    boolean didAddCraft = setCraft(aCraft);
    if (!didAddCraft)
    {
      throw new RuntimeException("Unable to create trip due to craft");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public Craft getCraft()
  {
    return craft;
  }

  public static int minimumNumberOfSegEnds()
  {
    return 1;
  }

  public boolean addSegEnd(SegEnd aSegEnd)
  {
    boolean wasAdded = false;
    if (segEnds.contains(aSegEnd)) { return false; }
    segEnds.add(aSegEnd);
    wasAdded = true;
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

    segEnds.remove(aSegEnd);
    wasRemoved = true;
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

    if (verifiedSegEnds.size() != newSegEnds.length || verifiedSegEnds.size() < minimumNumberOfSegEnds())
    {
      return wasSet;
    }

    segEnds.clear();
    segEnds.addAll(verifiedSegEnds);
    wasSet = true;
    return wasSet;
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

  public boolean setCraft(Craft aNewCraft)
  {
    boolean wasSet = false;
    if (aNewCraft == null)
    {
      //Unable to setCraft to null, as trip must always be associated to a craft
      return wasSet;
    }
    
    Trip existingTrip = aNewCraft.getTrip();
    if (existingTrip != null && !equals(existingTrip))
    {
      //Unable to setCraft, the current craft already has a trip, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Craft anOldCraft = craft;
    craft = aNewCraft;
    craft.setTrip(this);

    if (anOldCraft != null)
    {
      anOldCraft.setTrip(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    segEnds.clear();
    Craft existingCraft = craft;
    craft = null;
    if (existingCraft != null)
    {
      existingCraft.setTrip(null);
    }
  }

}