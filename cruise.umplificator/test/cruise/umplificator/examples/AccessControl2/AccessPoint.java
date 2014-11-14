/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.util.*;

/**
 * Access Point: each direction of passage through a door is considered as an access point.
 */
// line 39 "AccessControl2.ump"
// line 208 "AccessControl2.ump"
public class AccessPoint
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AccessPoint Attributes
  private String cardIdentification;

  //AccessPoint State Machines
  enum AccessPointSm { waitingCardID, waitingPIN }
  private AccessPointSm accessPointSm;

  //AccessPoint Associations
  private Door door;
  private List<AccessPoint> accessPoints;
  private List<User> mayEnterThrough;
  private Authorizer controls;

  //Helper Variables
  private TimedEventHandler timeoutwaitingPINTowaitingCardIDHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AccessPoint(Door aDoor, Authorizer aControls)
  {
    cardIdentification = null;
    if (aDoor == null || aDoor.getControls() != null)
    {
      throw new RuntimeException("Unable to create AccessPoint due to aDoor");
    }
    door = aDoor;
    accessPoints = new ArrayList<AccessPoint>();
    mayEnterThrough = new ArrayList<User>();
    boolean didAddControls = setControls(aControls);
    if (!didAddControls)
    {
      throw new RuntimeException("Unable to create accessPoint due to controls");
    }
    setAccessPointSm(AccessPointSm.waitingCardID);
  }

  public AccessPoint(AccessZone aAccessedThroughForDoor, Authorizer aControls)
  {
    cardIdentification = null;
    door = new Door(this, aAccessedThroughForDoor);
    accessPoints = new ArrayList<AccessPoint>();
    mayEnterThrough = new ArrayList<User>();
    boolean didAddControls = setControls(aControls);
    if (!didAddControls)
    {
      throw new RuntimeException("Unable to create accessPoint due to controls");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCardIdentification(String aCardIdentification)
  {
    boolean wasSet = false;
    cardIdentification = aCardIdentification;
    wasSet = true;
    return wasSet;
  }

  public String getCardIdentification()
  {
    return cardIdentification;
  }

  public String getAccessPointSmFullName()
  {
    String answer = accessPointSm.toString();
    return answer;
  }

  public AccessPointSm getAccessPointSm()
  {
    return accessPointSm;
  }

  public boolean cardId(String cardID)
  {
    boolean wasEventProcessed = false;
    
    AccessPointSm aAccessPointSm = accessPointSm;
    switch (aAccessPointSm)
    {
      case waitingCardID:
        // line 47 "AccessControl2.ump"
        setCardIdentification(cardID); if(hasMayEnterThrough()){ for(User user: getMayEnterThrough()){ if(user.getCard().getCardId().toString()==getCardIdentification()){ user.insertCard(cardID);}}}
        setAccessPointSm(AccessPointSm.waitingPIN);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pin(int no1,int no2,int no3,int no4)
  {
    boolean wasEventProcessed = false;
    
    AccessPointSm aAccessPointSm = accessPointSm;
    switch (aAccessPointSm)
    {
      case waitingCardID:
        setAccessPointSm(AccessPointSm.waitingCardID);
        wasEventProcessed = true;
        break;
      case waitingPIN:
        // line 51 "AccessControl2.ump"
        if(hasMayEnterThrough()){ for(User user: getMayEnterThrough()){ if(user.getCard().getCardId().toString()==getCardIdentification()){ user.enterPIN(no1, no2, no3, no4);  if (user.getCard().hasPin() || user.getCard().numberOfPin() <=4) { controls.ok(); List pinList = Arrays.asList(user.getCard().getPin()); controls.validatePIN(user.getCard().getCardId().toString(),pinList ); controls.setIsValid(true);} else{controls.nOk(); controls.setIsValid(false);}}}}
        setAccessPointSm(AccessPointSm.waitingPIN);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutwaitingPINTowaitingCardID()
  {
    boolean wasEventProcessed = false;
    
    AccessPointSm aAccessPointSm = accessPointSm;
    switch (aAccessPointSm)
    {
      case waitingPIN:
        exitAccessPointSm();
        setAccessPointSm(AccessPointSm.waitingCardID);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitAccessPointSm()
  {
    switch(accessPointSm)
    {
      case waitingPIN:
        stopTimeoutwaitingPINTowaitingCardIDHandler();
        break;
    }
  }

  private void setAccessPointSm(AccessPointSm aAccessPointSm)
  {
    accessPointSm = aAccessPointSm;

    // entry actions and do activities
    switch(accessPointSm)
    {
      case waitingPIN:
        startTimeoutwaitingPINTowaitingCardIDHandler();
        break;
    }
  }

  public Door getDoor()
  {
    return door;
  }

  public AccessPoint getAccessPoint(int index)
  {
    AccessPoint aAccessPoint = accessPoints.get(index);
    return aAccessPoint;
  }

  public List<AccessPoint> getAccessPoints()
  {
    List<AccessPoint> newAccessPoints = Collections.unmodifiableList(accessPoints);
    return newAccessPoints;
  }

  public int numberOfAccessPoints()
  {
    int number = accessPoints.size();
    return number;
  }

  public boolean hasAccessPoints()
  {
    boolean has = accessPoints.size() > 0;
    return has;
  }

  public int indexOfAccessPoint(AccessPoint aAccessPoint)
  {
    int index = accessPoints.indexOf(aAccessPoint);
    return index;
  }

  public User getMayEnterThrough(int index)
  {
    User aMayEnterThrough = mayEnterThrough.get(index);
    return aMayEnterThrough;
  }

  public List<User> getMayEnterThrough()
  {
    List<User> newMayEnterThrough = Collections.unmodifiableList(mayEnterThrough);
    return newMayEnterThrough;
  }

  public int numberOfMayEnterThrough()
  {
    int number = mayEnterThrough.size();
    return number;
  }

  public boolean hasMayEnterThrough()
  {
    boolean has = mayEnterThrough.size() > 0;
    return has;
  }

  public int indexOfMayEnterThrough(User aMayEnterThrough)
  {
    int index = mayEnterThrough.indexOf(aMayEnterThrough);
    return index;
  }

  public Authorizer getControls()
  {
    return controls;
  }

  public static int minimumNumberOfAccessPoints()
  {
    return 0;
  }

  public boolean addAccessPoint(AccessPoint aAccessPoint)
  {
    boolean wasAdded = false;
    if (accessPoints.contains(aAccessPoint)) { return false; }
    accessPoints.add(aAccessPoint);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccessPoint(AccessPoint aAccessPoint)
  {
    boolean wasRemoved = false;
    if (accessPoints.contains(aAccessPoint))
    {
      accessPoints.remove(aAccessPoint);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccessPointAt(AccessPoint aAccessPoint, int index)
  {  
    boolean wasAdded = false;
    if(addAccessPoint(aAccessPoint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccessPoints()) { index = numberOfAccessPoints() - 1; }
      accessPoints.remove(aAccessPoint);
      accessPoints.add(index, aAccessPoint);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccessPointAt(AccessPoint aAccessPoint, int index)
  {
    boolean wasAdded = false;
    if(accessPoints.contains(aAccessPoint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccessPoints()) { index = numberOfAccessPoints() - 1; }
      accessPoints.remove(aAccessPoint);
      accessPoints.add(index, aAccessPoint);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccessPointAt(aAccessPoint, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMayEnterThrough()
  {
    return 0;
  }

  public boolean addMayEnterThrough(User aMayEnterThrough)
  {
    boolean wasAdded = false;
    if (mayEnterThrough.contains(aMayEnterThrough)) { return false; }
    mayEnterThrough.add(aMayEnterThrough);
    if (aMayEnterThrough.indexOfAccessPoint(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMayEnterThrough.addAccessPoint(this);
      if (!wasAdded)
      {
        mayEnterThrough.remove(aMayEnterThrough);
      }
    }
    return wasAdded;
  }

  public boolean removeMayEnterThrough(User aMayEnterThrough)
  {
    boolean wasRemoved = false;
    if (!mayEnterThrough.contains(aMayEnterThrough))
    {
      return wasRemoved;
    }

    int oldIndex = mayEnterThrough.indexOf(aMayEnterThrough);
    mayEnterThrough.remove(oldIndex);
    if (aMayEnterThrough.indexOfAccessPoint(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMayEnterThrough.removeAccessPoint(this);
      if (!wasRemoved)
      {
        mayEnterThrough.add(oldIndex,aMayEnterThrough);
      }
    }
    return wasRemoved;
  }

  public boolean addMayEnterThroughAt(User aMayEnterThrough, int index)
  {  
    boolean wasAdded = false;
    if(addMayEnterThrough(aMayEnterThrough))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayEnterThrough()) { index = numberOfMayEnterThrough() - 1; }
      mayEnterThrough.remove(aMayEnterThrough);
      mayEnterThrough.add(index, aMayEnterThrough);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMayEnterThroughAt(User aMayEnterThrough, int index)
  {
    boolean wasAdded = false;
    if(mayEnterThrough.contains(aMayEnterThrough))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayEnterThrough()) { index = numberOfMayEnterThrough() - 1; }
      mayEnterThrough.remove(aMayEnterThrough);
      mayEnterThrough.add(index, aMayEnterThrough);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMayEnterThroughAt(aMayEnterThrough, index);
    }
    return wasAdded;
  }

  public boolean setControls(Authorizer aControls)
  {
    boolean wasSet = false;
    if (aControls == null)
    {
      return wasSet;
    }

    Authorizer existingControls = controls;
    controls = aControls;
    if (existingControls != null && !existingControls.equals(aControls))
    {
      existingControls.removeAccessPoint(this);
    }
    controls.addAccessPoint(this);
    wasSet = true;
    return wasSet;
  }

  private void startTimeoutwaitingPINTowaitingCardIDHandler()
  {
    timeoutwaitingPINTowaitingCardIDHandler = new TimedEventHandler(this,"timeoutwaitingPINTowaitingCardID",5);
  }

  private void stopTimeoutwaitingPINTowaitingCardIDHandler()
  {
    timeoutwaitingPINTowaitingCardIDHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private AccessPoint controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(AccessPoint aController, String aTimeoutMethodName, double aHowLongInSeconds)
    {
      controller = aController;
      timeoutMethodName = aTimeoutMethodName;
      howLongInSeconds = aHowLongInSeconds;
      timer = new Timer();
      timer.schedule(this, (long)howLongInSeconds*1000);
    }
    
    public void stop()
    {
      timer.cancel();
    }
    
    public void run ()
    {
      if ("timeoutwaitingPINTowaitingCardID".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutwaitingPINTowaitingCardID();
        if (shouldRestart)
        {
          controller.startTimeoutwaitingPINTowaitingCardIDHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {
    Door existingDoor = door;
    door = null;
    if (existingDoor != null)
    {
      existingDoor.delete();
    }
    accessPoints.clear();
    ArrayList<User> copyOfMayEnterThrough = new ArrayList<User>(mayEnterThrough);
    mayEnterThrough.clear();
    for(User aMayEnterThrough : copyOfMayEnterThrough)
    {
      aMayEnterThrough.removeAccessPoint(this);
    }
    Authorizer placeholderControls = controls;
    this.controls = null;
    placeholderControls.removeAccessPoint(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "cardIdentification" + ":" + getCardIdentification()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "door = "+(getDoor()!=null?Integer.toHexString(System.identityHashCode(getDoor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "controls = "+(getControls()!=null?Integer.toHexString(System.identityHashCode(getControls())):"null")
     + outputString;
  }
}