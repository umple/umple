/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 55 "CanalSystem.ump"
// line 131 "CanalSystem.ump"
public class Craft
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Craft Attributes
  private GPSCoord location;

  //Craft Associations
  private CanalNetwork canalNetwork;
  private Obstacle downstreamObstacle;
  private Obstacle upstreamObstacle;
  private Trip trip;
  private Transponder transponder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Craft()
  {
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocation(GPSCoord aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public GPSCoord getLocation()
  {
    return location;
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

  public Obstacle getDownstreamObstacle()
  {
    return downstreamObstacle;
  }

  public boolean hasDownstreamObstacle()
  {
    boolean has = downstreamObstacle != null;
    return has;
  }

  public Obstacle getUpstreamObstacle()
  {
    return upstreamObstacle;
  }

  public boolean hasUpstreamObstacle()
  {
    boolean has = upstreamObstacle != null;
    return has;
  }

  public Trip getTrip()
  {
    return trip;
  }

  public boolean hasTrip()
  {
    boolean has = trip != null;
    return has;
  }

  public Transponder getTransponder()
  {
    return transponder;
  }

  public boolean hasTransponder()
  {
    boolean has = transponder != null;
    return has;
  }

  public boolean setCanalNetwork(CanalNetwork aCanalNetwork)
  {
    boolean wasSet = false;
    CanalNetwork existingCanalNetwork = canalNetwork;
    canalNetwork = aCanalNetwork;
    if (existingCanalNetwork != null && !existingCanalNetwork.equals(aCanalNetwork))
    {
      existingCanalNetwork.removeActiveVessel(this);
    }
    if (aCanalNetwork != null)
    {
      aCanalNetwork.addActiveVessel(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setDownstreamObstacle(Obstacle aDownstreamObstacle)
  {
    boolean wasSet = false;
    Obstacle existingDownstreamObstacle = downstreamObstacle;
    downstreamObstacle = aDownstreamObstacle;
    if (existingDownstreamObstacle != null && !existingDownstreamObstacle.equals(aDownstreamObstacle))
    {
      existingDownstreamObstacle.removeUpStreamQueue(this);
    }
    if (aDownstreamObstacle != null)
    {
      aDownstreamObstacle.addUpStreamQueue(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setUpstreamObstacle(Obstacle aUpstreamObstacle)
  {
    boolean wasSet = false;
    Obstacle existingUpstreamObstacle = upstreamObstacle;
    upstreamObstacle = aUpstreamObstacle;
    if (existingUpstreamObstacle != null && !existingUpstreamObstacle.equals(aUpstreamObstacle))
    {
      existingUpstreamObstacle.removeDownStreamQueue(this);
    }
    if (aUpstreamObstacle != null)
    {
      aUpstreamObstacle.addDownStreamQueue(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTrip(Trip aNewTrip)
  {
    boolean wasSet = false;
    if (trip != null && !trip.equals(aNewTrip) && equals(trip.getCraft()))
    {
      //Unable to setTrip, as existing trip would become an orphan
      return wasSet;
    }

    trip = aNewTrip;
    Craft anOldCraft = aNewTrip != null ? aNewTrip.getCraft() : null;

    if (!this.equals(anOldCraft))
    {
      if (anOldCraft != null)
      {
        anOldCraft.trip = null;
      }
      if (trip != null)
      {
        trip.setCraft(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTransponder(Transponder aNewTransponder)
  {
    boolean wasSet = false;
    if (aNewTransponder == null)
    {
      Transponder existingTransponder = transponder;
      transponder = null;
      
      if (existingTransponder != null && existingTransponder.getCraft() != null)
      {
        existingTransponder.setCraft(null);
      }
      wasSet = true;
      return wasSet;
    }

    Transponder currentTransponder = getTransponder();
    if (currentTransponder != null && !currentTransponder.equals(aNewTransponder))
    {
      currentTransponder.setCraft(null);
    }

    transponder = aNewTransponder;
    Craft existingCraft = aNewTransponder.getCraft();

    if (!equals(existingCraft))
    {
      aNewTransponder.setCraft(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (canalNetwork != null)
    {
      CanalNetwork placeholderCanalNetwork = canalNetwork;
      this.canalNetwork = null;
      placeholderCanalNetwork.removeActiveVessel(this);
    }
    if (downstreamObstacle != null)
    {
      Obstacle placeholderDownstreamObstacle = downstreamObstacle;
      this.downstreamObstacle = null;
      placeholderDownstreamObstacle.removeUpStreamQueue(this);
    }
    if (upstreamObstacle != null)
    {
      Obstacle placeholderUpstreamObstacle = upstreamObstacle;
      this.upstreamObstacle = null;
      placeholderUpstreamObstacle.removeDownStreamQueue(this);
    }
    Trip existingTrip = trip;
    trip = null;
    if (existingTrip != null)
    {
      existingTrip.delete();
    }
    if (transponder != null)
    {
      transponder.setCraft(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "canalNetwork = "+(getCanalNetwork()!=null?Integer.toHexString(System.identityHashCode(getCanalNetwork())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "downstreamObstacle = "+(getDownstreamObstacle()!=null?Integer.toHexString(System.identityHashCode(getDownstreamObstacle())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "upstreamObstacle = "+(getUpstreamObstacle()!=null?Integer.toHexString(System.identityHashCode(getUpstreamObstacle())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "trip = "+(getTrip()!=null?Integer.toHexString(System.identityHashCode(getTrip())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "transponder = "+(getTransponder()!=null?Integer.toHexString(System.identityHashCode(getTransponder())):"null")
     + outputString;
  }
}