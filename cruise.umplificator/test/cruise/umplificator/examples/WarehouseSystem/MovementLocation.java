/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 5 "WarehouseSystem.ump"
// line 155 "WarehouseSystem.ump"
public class MovementLocation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MovementLocation Associations
  private List<RwbmMovement> toMovement;
  private List<RwbmMovement> fromMovement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MovementLocation()
  {
    toMovement = new ArrayList<RwbmMovement>();
    fromMovement = new ArrayList<RwbmMovement>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public RwbmMovement getToMovement(int index)
  {
    RwbmMovement aToMovement = toMovement.get(index);
    return aToMovement;
  }

  public List<RwbmMovement> getToMovement()
  {
    List<RwbmMovement> newToMovement = Collections.unmodifiableList(toMovement);
    return newToMovement;
  }

  public int numberOfToMovement()
  {
    int number = toMovement.size();
    return number;
  }

  public boolean hasToMovement()
  {
    boolean has = toMovement.size() > 0;
    return has;
  }

  public int indexOfToMovement(RwbmMovement aToMovement)
  {
    int index = toMovement.indexOf(aToMovement);
    return index;
  }

  public RwbmMovement getFromMovement(int index)
  {
    RwbmMovement aFromMovement = fromMovement.get(index);
    return aFromMovement;
  }

  public List<RwbmMovement> getFromMovement()
  {
    List<RwbmMovement> newFromMovement = Collections.unmodifiableList(fromMovement);
    return newFromMovement;
  }

  public int numberOfFromMovement()
  {
    int number = fromMovement.size();
    return number;
  }

  public boolean hasFromMovement()
  {
    boolean has = fromMovement.size() > 0;
    return has;
  }

  public int indexOfFromMovement(RwbmMovement aFromMovement)
  {
    int index = fromMovement.indexOf(aFromMovement);
    return index;
  }

  public static int minimumNumberOfToMovement()
  {
    return 0;
  }

  public RwbmMovement addToMovement(double aStartTime, double aEndTime, MovementLocation aFrom, BoxOrPallet aMovedBox)
  {
    return new RwbmMovement(aStartTime, aEndTime, this, aFrom, aMovedBox);
  }

  public boolean addToMovement(RwbmMovement aToMovement)
  {
    boolean wasAdded = false;
    if (toMovement.contains(aToMovement)) { return false; }
    if (toMovement.contains(aToMovement)) { return false; }
    if (toMovement.contains(aToMovement)) { return false; }
    MovementLocation existingTo = aToMovement.getTo();
    boolean isNewTo = existingTo != null && !this.equals(existingTo);
    if (isNewTo)
    {
      aToMovement.setTo(this);
    }
    else
    {
      toMovement.add(aToMovement);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeToMovement(RwbmMovement aToMovement)
  {
    boolean wasRemoved = false;
    //Unable to remove aToMovement, as it must always have a to
    if (!this.equals(aToMovement.getTo()))
    {
      toMovement.remove(aToMovement);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addToMovementAt(RwbmMovement aToMovement, int index)
  {  
    boolean wasAdded = false;
    if(addToMovement(aToMovement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToMovement()) { index = numberOfToMovement() - 1; }
      toMovement.remove(aToMovement);
      toMovement.add(index, aToMovement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveToMovementAt(RwbmMovement aToMovement, int index)
  {
    boolean wasAdded = false;
    if(toMovement.contains(aToMovement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToMovement()) { index = numberOfToMovement() - 1; }
      toMovement.remove(aToMovement);
      toMovement.add(index, aToMovement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addToMovementAt(aToMovement, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfFromMovement()
  {
    return 0;
  }

  public RwbmMovement addFromMovement(double aStartTime, double aEndTime, MovementLocation aTo, BoxOrPallet aMovedBox)
  {
    return new RwbmMovement(aStartTime, aEndTime, aTo, this, aMovedBox);
  }

  public boolean addFromMovement(RwbmMovement aFromMovement)
  {
    boolean wasAdded = false;
    if (fromMovement.contains(aFromMovement)) { return false; }
    if (fromMovement.contains(aFromMovement)) { return false; }
    if (fromMovement.contains(aFromMovement)) { return false; }
    MovementLocation existingFrom = aFromMovement.getFrom();
    boolean isNewFrom = existingFrom != null && !this.equals(existingFrom);
    if (isNewFrom)
    {
      aFromMovement.setFrom(this);
    }
    else
    {
      fromMovement.add(aFromMovement);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFromMovement(RwbmMovement aFromMovement)
  {
    boolean wasRemoved = false;
    //Unable to remove aFromMovement, as it must always have a from
    if (!this.equals(aFromMovement.getFrom()))
    {
      fromMovement.remove(aFromMovement);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFromMovementAt(RwbmMovement aFromMovement, int index)
  {  
    boolean wasAdded = false;
    if(addFromMovement(aFromMovement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFromMovement()) { index = numberOfFromMovement() - 1; }
      fromMovement.remove(aFromMovement);
      fromMovement.add(index, aFromMovement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFromMovementAt(RwbmMovement aFromMovement, int index)
  {
    boolean wasAdded = false;
    if(fromMovement.contains(aFromMovement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFromMovement()) { index = numberOfFromMovement() - 1; }
      fromMovement.remove(aFromMovement);
      fromMovement.add(index, aFromMovement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFromMovementAt(aFromMovement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=toMovement.size(); i > 0; i--)
    {
      RwbmMovement aToMovement = toMovement.get(i - 1);
      aToMovement.delete();
    }
    for(int i=fromMovement.size(); i > 0; i--)
    {
      RwbmMovement aFromMovement = fromMovement.get(i - 1);
      aFromMovement.delete();
    }
  }

}