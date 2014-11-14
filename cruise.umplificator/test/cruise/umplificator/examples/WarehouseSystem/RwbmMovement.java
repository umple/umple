/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Note that here we have the choice to use
 * Time or Double, if the customer requires Double due to
 * some interoperability issues with a legacy syste, we can easily
 * accomodate them and use Double instead of Time.
 */
// line 56 "WarehouseSystem.ump"
// line 112 "WarehouseSystem.ump"
public class RwbmMovement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RwbmMovement Attributes
  private double startTime;
  private double endTime;

  //RwbmMovement Associations
  private MovementLocation to;
  private MovementLocation from;
  private BoxOrPallet movedBox;
  private List<Rwbm> rwbms;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RwbmMovement(double aStartTime, double aEndTime, MovementLocation aTo, MovementLocation aFrom, BoxOrPallet aMovedBox)
  {
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddTo = setTo(aTo);
    if (!didAddTo)
    {
      throw new RuntimeException("Unable to create toMovement due to to");
    }
    boolean didAddFrom = setFrom(aFrom);
    if (!didAddFrom)
    {
      throw new RuntimeException("Unable to create fromMovement due to from");
    }
    boolean didAddMovedBox = setMovedBox(aMovedBox);
    if (!didAddMovedBox)
    {
      throw new RuntimeException("Unable to create rwbmMovement due to movedBox");
    }
    rwbms = new ArrayList<Rwbm>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartTime(double aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(double aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public double getStartTime()
  {
    return startTime;
  }

  public double getEndTime()
  {
    return endTime;
  }

  public MovementLocation getTo()
  {
    return to;
  }

  public MovementLocation getFrom()
  {
    return from;
  }

  public BoxOrPallet getMovedBox()
  {
    return movedBox;
  }

  public Rwbm getRwbm(int index)
  {
    Rwbm aRwbm = rwbms.get(index);
    return aRwbm;
  }

  public List<Rwbm> getRwbms()
  {
    List<Rwbm> newRwbms = Collections.unmodifiableList(rwbms);
    return newRwbms;
  }

  public int numberOfRwbms()
  {
    int number = rwbms.size();
    return number;
  }

  public boolean hasRwbms()
  {
    boolean has = rwbms.size() > 0;
    return has;
  }

  public int indexOfRwbm(Rwbm aRwbm)
  {
    int index = rwbms.indexOf(aRwbm);
    return index;
  }

  public boolean setTo(MovementLocation aTo)
  {
    boolean wasSet = false;
    if (aTo == null)
    {
      return wasSet;
    }

    MovementLocation existingTo = to;
    to = aTo;
    if (existingTo != null && !existingTo.equals(aTo))
    {
      existingTo.removeToMovement(this);
    }
    to.addToMovement(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setFrom(MovementLocation aFrom)
  {
    boolean wasSet = false;
    if (aFrom == null)
    {
      return wasSet;
    }

    MovementLocation existingFrom = from;
    from = aFrom;
    if (existingFrom != null && !existingFrom.equals(aFrom))
    {
      existingFrom.removeFromMovement(this);
    }
    from.addFromMovement(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setMovedBox(BoxOrPallet aMovedBox)
  {
    boolean wasSet = false;
    if (aMovedBox == null)
    {
      return wasSet;
    }

    BoxOrPallet existingMovedBox = movedBox;
    movedBox = aMovedBox;
    if (existingMovedBox != null && !existingMovedBox.equals(aMovedBox))
    {
      existingMovedBox.removeRwbmMovement(this);
    }
    movedBox.addRwbmMovement(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfRwbms()
  {
    return 0;
  }

  public Rwbm addRwbm(int aId)
  {
    return new Rwbm(aId, this);
  }

  public boolean addRwbm(Rwbm aRwbm)
  {
    boolean wasAdded = false;
    if (rwbms.contains(aRwbm)) { return false; }
    RwbmMovement existingRwbmMovement = aRwbm.getRwbmMovement();
    boolean isNewRwbmMovement = existingRwbmMovement != null && !this.equals(existingRwbmMovement);
    if (isNewRwbmMovement)
    {
      aRwbm.setRwbmMovement(this);
    }
    else
    {
      rwbms.add(aRwbm);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRwbm(Rwbm aRwbm)
  {
    boolean wasRemoved = false;
    //Unable to remove aRwbm, as it must always have a rwbmMovement
    if (!this.equals(aRwbm.getRwbmMovement()))
    {
      rwbms.remove(aRwbm);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRwbmAt(Rwbm aRwbm, int index)
  {  
    boolean wasAdded = false;
    if(addRwbm(aRwbm))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRwbms()) { index = numberOfRwbms() - 1; }
      rwbms.remove(aRwbm);
      rwbms.add(index, aRwbm);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRwbmAt(Rwbm aRwbm, int index)
  {
    boolean wasAdded = false;
    if(rwbms.contains(aRwbm))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRwbms()) { index = numberOfRwbms() - 1; }
      rwbms.remove(aRwbm);
      rwbms.add(index, aRwbm);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRwbmAt(aRwbm, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    MovementLocation placeholderTo = to;
    this.to = null;
    placeholderTo.removeToMovement(this);
    MovementLocation placeholderFrom = from;
    this.from = null;
    placeholderFrom.removeFromMovement(this);
    BoxOrPallet placeholderMovedBox = movedBox;
    this.movedBox = null;
    placeholderMovedBox.removeRwbmMovement(this);
    for(int i=rwbms.size(); i > 0; i--)
    {
      Rwbm aRwbm = rwbms.get(i - 1);
      aRwbm.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "to = "+(getTo()!=null?Integer.toHexString(System.identityHashCode(getTo())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "from = "+(getFrom()!=null?Integer.toHexString(System.identityHashCode(getFrom())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "movedBox = "+(getMovedBox()!=null?Integer.toHexString(System.identityHashCode(getMovedBox())):"null")
     + outputString;
  }
}