/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.util.*;

// line 122 "AccessControl2.ump"
// line 195 "AccessControl2.ump"
public class ACSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ACSystem Attributes
  private int doorTime;

  //ACSystem State Machines
  enum AccessControlSystemSM { waitingForCardEntry, validatingAccessCode, unLock, opened }
  private AccessControlSystemSM accessControlSystemSM;

  //ACSystem Associations
  private List<User> mayUse;
  private AccessZone exiting;
  private AccessZone enteriing;

  //Helper Variables
  private TimedEventHandler timeoutunLockTowaitingForCardEntryHandler;
  private TimedEventHandler timeoutopenedTowaitingForCardEntryHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ACSystem(AccessZone aExiting, AccessZone aEnteriing, User... allMayUse)
  {
    doorTime = 10;
    mayUse = new ArrayList<User>();
    boolean didAddMayUse = setMayUse(allMayUse);
    if (!didAddMayUse)
    {
      throw new RuntimeException("Unable to create ACSystem, must have at least 1 mayUse");
    }
    if (aExiting == null || aExiting.getExitControls() != null)
    {
      throw new RuntimeException("Unable to create ACSystem due to aExiting");
    }
    exiting = aExiting;
    if (aEnteriing == null || aEnteriing.getEntryControls() != null)
    {
      throw new RuntimeException("Unable to create ACSystem due to aEnteriing");
    }
    enteriing = aEnteriing;
    setAccessControlSystemSM(AccessControlSystemSM.waitingForCardEntry);
  }

  public ACSystem(Authorizer aHasKnowledgeForExiting, ACSystem aEntryControlsForExiting, Authorizer aHasKnowledgeForEnteriing, ACSystem aExitControlsForEnteriing, User... allMayUse)
  {
    doorTime = 10;
    mayUse = new ArrayList<User>();
    boolean didAddMayUse = setMayUse(allMayUse);
    if (!didAddMayUse)
    {
      throw new RuntimeException("Unable to create ACSystem, must have at least 1 mayUse");
    }
    exiting = new AccessZone(aHasKnowledgeForExiting, this, aEntryControlsForExiting);
    enteriing = new AccessZone(aHasKnowledgeForEnteriing, aExitControlsForEnteriing, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDoorTime(int aDoorTime)
  {
    boolean wasSet = false;
    doorTime = aDoorTime;
    wasSet = true;
    return wasSet;
  }

  public int getDoorTime()
  {
    return doorTime;
  }

  public String getAccessControlSystemSMFullName()
  {
    String answer = accessControlSystemSM.toString();
    return answer;
  }

  public AccessControlSystemSM getAccessControlSystemSM()
  {
    return accessControlSystemSM;
  }

  public boolean cardIn()
  {
    boolean wasEventProcessed = false;
    
    AccessControlSystemSM aAccessControlSystemSM = accessControlSystemSM;
    switch (aAccessControlSystemSM)
    {
      case waitingForCardEntry:
        setAccessControlSystemSM(AccessControlSystemSM.validatingAccessCode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pin()
  {
    boolean wasEventProcessed = false;
    
    AccessControlSystemSM aAccessControlSystemSM = accessControlSystemSM;
    switch (aAccessControlSystemSM)
    {
      case validatingAccessCode:
        if (getEnteriings().getHasKnowledge().getIsValid())
        {
        // line 134 "AccessControl2.ump"
          enteriing.getHasKnowledge().ok(); setDoorTimer(1000); getMayUse(0).cardOut(); enteriing.getDoor(0).unLock();
          setAccessControlSystemSM(AccessControlSystemSM.unLock);
          wasEventProcessed = true;
          break;
        }
        if (getEnteriings().getHasKnowledge().getIsValid())
        {
        // line 135 "AccessControl2.ump"
          enteriing.getHasKnowledge().nOk(); getMayUse(0).cardOut();
          setAccessControlSystemSM(AccessControlSystemSM.waitingForCardEntry);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean opened()
  {
    boolean wasEventProcessed = false;
    
    AccessControlSystemSM aAccessControlSystemSM = accessControlSystemSM;
    switch (aAccessControlSystemSM)
    {
      case unLock:
        exitAccessControlSystemSM();
        // line 138 "AccessControl2.ump"
        reSetDoorTimer(1000);
        setAccessControlSystemSM(AccessControlSystemSM.opened);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutunLockTowaitingForCardEntry()
  {
    boolean wasEventProcessed = false;
    
    AccessControlSystemSM aAccessControlSystemSM = accessControlSystemSM;
    switch (aAccessControlSystemSM)
    {
      case unLock:
        exitAccessControlSystemSM();
        // line 139 "AccessControl2.ump"
        exiting.getDoor(0).lock();
        setAccessControlSystemSM(AccessControlSystemSM.waitingForCardEntry);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean closed()
  {
    boolean wasEventProcessed = false;
    
    AccessControlSystemSM aAccessControlSystemSM = accessControlSystemSM;
    switch (aAccessControlSystemSM)
    {
      case opened:
        exitAccessControlSystemSM();
        // line 142 "AccessControl2.ump"
        exiting.getDoor(0).lock(); reSetDoorTimer(1000);
        setAccessControlSystemSM(AccessControlSystemSM.waitingForCardEntry);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutopenedTowaitingForCardEntry()
  {
    boolean wasEventProcessed = false;
    
    AccessControlSystemSM aAccessControlSystemSM = accessControlSystemSM;
    switch (aAccessControlSystemSM)
    {
      case opened:
        exitAccessControlSystemSM();
        // line 143 "AccessControl2.ump"
        exiting.getHasKnowledge().error();
        setAccessControlSystemSM(AccessControlSystemSM.waitingForCardEntry);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitAccessControlSystemSM()
  {
    switch(accessControlSystemSM)
    {
      case unLock:
        stopTimeoutunLockTowaitingForCardEntryHandler();
        break;
      case opened:
        stopTimeoutopenedTowaitingForCardEntryHandler();
        break;
    }
  }

  private void setAccessControlSystemSM(AccessControlSystemSM aAccessControlSystemSM)
  {
    accessControlSystemSM = aAccessControlSystemSM;

    // entry actions and do activities
    switch(accessControlSystemSM)
    {
      case unLock:
        startTimeoutunLockTowaitingForCardEntryHandler();
        break;
      case opened:
        startTimeoutopenedTowaitingForCardEntryHandler();
        break;
    }
  }

  public User getMayUse(int index)
  {
    User aMayUse = mayUse.get(index);
    return aMayUse;
  }

  public List<User> getMayUse()
  {
    List<User> newMayUse = Collections.unmodifiableList(mayUse);
    return newMayUse;
  }

  public int numberOfMayUse()
  {
    int number = mayUse.size();
    return number;
  }

  public boolean hasMayUse()
  {
    boolean has = mayUse.size() > 0;
    return has;
  }

  public int indexOfMayUse(User aMayUse)
  {
    int index = mayUse.indexOf(aMayUse);
    return index;
  }

  public AccessZone getExiting()
  {
    return exiting;
  }

  public AccessZone getEnteriing()
  {
    return enteriing;
  }

  public static int minimumNumberOfMayUse()
  {
    return 1;
  }

  public boolean addMayUse(User aMayUse)
  {
    boolean wasAdded = false;
    if (mayUse.contains(aMayUse)) { return false; }
    ACSystem existingMayAcceptAndValidate = aMayUse.getMayAcceptAndValidate();
    if (existingMayAcceptAndValidate != null && existingMayAcceptAndValidate.numberOfMayUse() <= minimumNumberOfMayUse())
    {
      return wasAdded;
    }
    else if (existingMayAcceptAndValidate != null)
    {
      existingMayAcceptAndValidate.mayUse.remove(aMayUse);
    }
    mayUse.add(aMayUse);
    setMayAcceptAndValidate(aMayUse,this);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMayUse(User aMayUse)
  {
    boolean wasRemoved = false;
    if (mayUse.contains(aMayUse) && numberOfMayUse() > minimumNumberOfMayUse())
    {
      mayUse.remove(aMayUse);
      setMayAcceptAndValidate(aMayUse,null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setMayUse(User... newMayUse)
  {
    boolean wasSet = false;
    if (newMayUse.length < minimumNumberOfMayUse())
    {
      return wasSet;
    }

    ArrayList<User> checkNewMayUse = new ArrayList<User>();
    HashMap<ACSystem,Integer> mayAcceptAndValidateToNewMayUse = new HashMap<ACSystem,Integer>();
    for (User aMayUse : newMayUse)
    {
      if (checkNewMayUse.contains(aMayUse))
      {
        return wasSet;
      }
      else if (aMayUse.getMayAcceptAndValidate() != null && !this.equals(aMayUse.getMayAcceptAndValidate()))
      {
        ACSystem existingMayAcceptAndValidate = aMayUse.getMayAcceptAndValidate();
        if (!mayAcceptAndValidateToNewMayUse.containsKey(existingMayAcceptAndValidate))
        {
          mayAcceptAndValidateToNewMayUse.put(existingMayAcceptAndValidate, new Integer(existingMayAcceptAndValidate.numberOfMayUse()));
        }
        Integer currentCount = mayAcceptAndValidateToNewMayUse.get(existingMayAcceptAndValidate);
        int nextCount = currentCount - 1;
        if (nextCount < 1)
        {
          return wasSet;
        }
        mayAcceptAndValidateToNewMayUse.put(existingMayAcceptAndValidate, new Integer(nextCount));
      }
      checkNewMayUse.add(aMayUse);
    }

    mayUse.removeAll(checkNewMayUse);

    for (User orphan : mayUse)
    {
      setMayAcceptAndValidate(orphan, null);
    }
    mayUse.clear();
    for (User aMayUse : newMayUse)
    {
      if (aMayUse.getMayAcceptAndValidate() != null)
      {
        aMayUse.getMayAcceptAndValidate().mayUse.remove(aMayUse);
      }
      setMayAcceptAndValidate(aMayUse, this);
      mayUse.add(aMayUse);
    }
    wasSet = true;
    return wasSet;
  }

  private void setMayAcceptAndValidate(User aMayUse, ACSystem aMayAcceptAndValidate)
  {
    try
    {
      java.lang.reflect.Field mentorField = aMayUse.getClass().getDeclaredField("mayAcceptAndValidate");
      mentorField.setAccessible(true);
      mentorField.set(aMayUse, aMayAcceptAndValidate);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aMayAcceptAndValidate to aMayUse", e);
    }
  }

  public boolean addMayUseAt(User aMayUse, int index)
  {  
    boolean wasAdded = false;
    if(addMayUse(aMayUse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayUse()) { index = numberOfMayUse() - 1; }
      mayUse.remove(aMayUse);
      mayUse.add(index, aMayUse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMayUseAt(User aMayUse, int index)
  {
    boolean wasAdded = false;
    if(mayUse.contains(aMayUse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayUse()) { index = numberOfMayUse() - 1; }
      mayUse.remove(aMayUse);
      mayUse.add(index, aMayUse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMayUseAt(aMayUse, index);
    }
    return wasAdded;
  }

  private void startTimeoutunLockTowaitingForCardEntryHandler()
  {
    timeoutunLockTowaitingForCardEntryHandler = new TimedEventHandler(this,"timeoutunLockTowaitingForCardEntry",doorTime);
  }

  private void stopTimeoutunLockTowaitingForCardEntryHandler()
  {
    timeoutunLockTowaitingForCardEntryHandler.stop();
  }

  private void startTimeoutopenedTowaitingForCardEntryHandler()
  {
    timeoutopenedTowaitingForCardEntryHandler = new TimedEventHandler(this,"timeoutopenedTowaitingForCardEntry",doorTime);
  }

  private void stopTimeoutopenedTowaitingForCardEntryHandler()
  {
    timeoutopenedTowaitingForCardEntryHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private ACSystem controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(ACSystem aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutunLockTowaitingForCardEntry".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutunLockTowaitingForCardEntry();
        if (shouldRestart)
        {
          controller.startTimeoutunLockTowaitingForCardEntryHandler();
        }
        return;
      }
      if ("timeoutopenedTowaitingForCardEntry".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutopenedTowaitingForCardEntry();
        if (shouldRestart)
        {
          controller.startTimeoutopenedTowaitingForCardEntryHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {
    for(User aMayUse : mayUse)
    {
      setMayAcceptAndValidate(aMayUse,null);
    }
    mayUse.clear();
    AccessZone existingExiting = exiting;
    exiting = null;
    if (existingExiting != null)
    {
      existingExiting.delete();
    }
    AccessZone existingEnteriing = enteriing;
    enteriing = null;
    if (existingEnteriing != null)
    {
      existingEnteriing.delete();
    }
  }

  // line 148 "AccessControl2.ump"
   public void setDoorTimer(Integer time){
    time=doorTime;
  }

  // line 152 "AccessControl2.ump"
   public Integer doorTimeout(){
    return getDoorTime();
  }

  // line 156 "AccessControl2.ump"
   public void reSetDoorTimer(Integer time){
    setDoorTimer(doorTime);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "doorTime" + ":" + getDoorTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "exiting = "+(getExiting()!=null?Integer.toHexString(System.identityHashCode(getExiting())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "enteriing = "+(getEnteriing()!=null?Integer.toHexString(System.identityHashCode(getEnteriing())):"null")
     + outputString;
  }
}