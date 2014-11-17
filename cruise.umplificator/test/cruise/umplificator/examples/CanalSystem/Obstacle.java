/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 41 "CanalSystem.ump"
// line 112 "CanalSystem.ump"
public class Obstacle extends SegEnd
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Obstacle Associations
  private List<Craft> upStreamQueue;
  private List<Craft> downStreamQueue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Obstacle(String aName, GPSCoord aLocation)
  {
    super(aName, aLocation);
    upStreamQueue = new ArrayList<Craft>();
    downStreamQueue = new ArrayList<Craft>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Craft getUpStreamQueue(int index)
  {
    Craft aUpStreamQueue = upStreamQueue.get(index);
    return aUpStreamQueue;
  }

  public List<Craft> getUpStreamQueue()
  {
    List<Craft> newUpStreamQueue = Collections.unmodifiableList(upStreamQueue);
    return newUpStreamQueue;
  }

  public int numberOfUpStreamQueue()
  {
    int number = upStreamQueue.size();
    return number;
  }

  public boolean hasUpStreamQueue()
  {
    boolean has = upStreamQueue.size() > 0;
    return has;
  }

  public int indexOfUpStreamQueue(Craft aUpStreamQueue)
  {
    int index = upStreamQueue.indexOf(aUpStreamQueue);
    return index;
  }

  public Craft getDownStreamQueue(int index)
  {
    Craft aDownStreamQueue = downStreamQueue.get(index);
    return aDownStreamQueue;
  }

  public List<Craft> getDownStreamQueue()
  {
    List<Craft> newDownStreamQueue = Collections.unmodifiableList(downStreamQueue);
    return newDownStreamQueue;
  }

  public int numberOfDownStreamQueue()
  {
    int number = downStreamQueue.size();
    return number;
  }

  public boolean hasDownStreamQueue()
  {
    boolean has = downStreamQueue.size() > 0;
    return has;
  }

  public int indexOfDownStreamQueue(Craft aDownStreamQueue)
  {
    int index = downStreamQueue.indexOf(aDownStreamQueue);
    return index;
  }

  public static int minimumNumberOfUpStreamQueue()
  {
    return 0;
  }

  public boolean addUpStreamQueue(Craft aUpStreamQueue)
  {
    boolean wasAdded = false;
    if (upStreamQueue.contains(aUpStreamQueue)) { return false; }
    if (upStreamQueue.contains(aUpStreamQueue)) { return false; }
    if (upStreamQueue.contains(aUpStreamQueue)) { return false; }
    Obstacle existingDownstreamObstacle = aUpStreamQueue.getDownstreamObstacle();
    if (existingDownstreamObstacle == null)
    {
      aUpStreamQueue.setDownstreamObstacle(this);
    }
    else if (!this.equals(existingDownstreamObstacle))
    {
      existingDownstreamObstacle.removeUpStreamQueue(aUpStreamQueue);
      addUpStreamQueue(aUpStreamQueue);
    }
    else
    {
      upStreamQueue.add(aUpStreamQueue);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUpStreamQueue(Craft aUpStreamQueue)
  {
    boolean wasRemoved = false;
    if (upStreamQueue.contains(aUpStreamQueue))
    {
      upStreamQueue.remove(aUpStreamQueue);
      aUpStreamQueue.setDownstreamObstacle(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addUpStreamQueueAt(Craft aUpStreamQueue, int index)
  {  
    boolean wasAdded = false;
    if(addUpStreamQueue(aUpStreamQueue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpStreamQueue()) { index = numberOfUpStreamQueue() - 1; }
      upStreamQueue.remove(aUpStreamQueue);
      upStreamQueue.add(index, aUpStreamQueue);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUpStreamQueueAt(Craft aUpStreamQueue, int index)
  {
    boolean wasAdded = false;
    if(upStreamQueue.contains(aUpStreamQueue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpStreamQueue()) { index = numberOfUpStreamQueue() - 1; }
      upStreamQueue.remove(aUpStreamQueue);
      upStreamQueue.add(index, aUpStreamQueue);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUpStreamQueueAt(aUpStreamQueue, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDownStreamQueue()
  {
    return 0;
  }

  public boolean addDownStreamQueue(Craft aDownStreamQueue)
  {
    boolean wasAdded = false;
    if (downStreamQueue.contains(aDownStreamQueue)) { return false; }
    if (downStreamQueue.contains(aDownStreamQueue)) { return false; }
    if (downStreamQueue.contains(aDownStreamQueue)) { return false; }
    Obstacle existingUpstreamObstacle = aDownStreamQueue.getUpstreamObstacle();
    if (existingUpstreamObstacle == null)
    {
      aDownStreamQueue.setUpstreamObstacle(this);
    }
    else if (!this.equals(existingUpstreamObstacle))
    {
      existingUpstreamObstacle.removeDownStreamQueue(aDownStreamQueue);
      addDownStreamQueue(aDownStreamQueue);
    }
    else
    {
      downStreamQueue.add(aDownStreamQueue);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDownStreamQueue(Craft aDownStreamQueue)
  {
    boolean wasRemoved = false;
    if (downStreamQueue.contains(aDownStreamQueue))
    {
      downStreamQueue.remove(aDownStreamQueue);
      aDownStreamQueue.setUpstreamObstacle(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDownStreamQueueAt(Craft aDownStreamQueue, int index)
  {  
    boolean wasAdded = false;
    if(addDownStreamQueue(aDownStreamQueue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDownStreamQueue()) { index = numberOfDownStreamQueue() - 1; }
      downStreamQueue.remove(aDownStreamQueue);
      downStreamQueue.add(index, aDownStreamQueue);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDownStreamQueueAt(Craft aDownStreamQueue, int index)
  {
    boolean wasAdded = false;
    if(downStreamQueue.contains(aDownStreamQueue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDownStreamQueue()) { index = numberOfDownStreamQueue() - 1; }
      downStreamQueue.remove(aDownStreamQueue);
      downStreamQueue.add(index, aDownStreamQueue);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDownStreamQueueAt(aDownStreamQueue, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !upStreamQueue.isEmpty() )
    {
      upStreamQueue.get(0).setDownstreamObstacle(null);
    }
    while( !downStreamQueue.isEmpty() )
    {
      downStreamQueue.get(0).setUpstreamObstacle(null);
    }
    super.delete();
  }

}