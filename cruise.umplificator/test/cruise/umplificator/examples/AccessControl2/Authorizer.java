/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Authentication: to establish the identity of the user
 * Authorization: to establish the right of a user to enter access zone
 */
// line 65 "AccessControl2.ump"
// line 203 "AccessControl2.ump"
public class Authorizer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Authorizer Attributes
  private boolean isValid;

  //Authorizer State Machines
  enum ValidatingPINSM { validatingPIN, waitingForDigit, waitingForAuthentication, waitingForAuthorization }
  enum ValidatingPINSMWaitingForDigit { Null, waitingDigit }
  private ValidatingPINSM validatingPINSM;
  private ValidatingPINSMWaitingForDigit validatingPINSMWaitingForDigit;

  //Authorizer Associations
  private List<AccessPoint> accessPoints;
  private List<AccessZone> accessZones;

  //Helper Variables
  private TimedEventHandler timeoutwaitingForDigitTowaitingForDigitHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Authorizer(boolean aIsValid)
  {
    isValid = aIsValid;
    accessPoints = new ArrayList<AccessPoint>();
    accessZones = new ArrayList<AccessZone>();
    setValidatingPINSMWaitingForDigit(ValidatingPINSMWaitingForDigit.Null);
    setValidatingPINSM(ValidatingPINSM.validatingPIN);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsValid(boolean aIsValid)
  {
    boolean wasSet = false;
    isValid = aIsValid;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsValid()
  {
    return isValid;
  }

  public boolean isIsValid()
  {
    return isValid;
  }

  public String getValidatingPINSMFullName()
  {
    String answer = validatingPINSM.toString();
    if (validatingPINSMWaitingForDigit != ValidatingPINSMWaitingForDigit.Null) { answer += "." + validatingPINSMWaitingForDigit.toString(); }
    return answer;
  }

  public ValidatingPINSM getValidatingPINSM()
  {
    return validatingPINSM;
  }

  public ValidatingPINSMWaitingForDigit getValidatingPINSMWaitingForDigit()
  {
    return validatingPINSMWaitingForDigit;
  }

  public boolean validatePIN(String cardID,List pin)
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSM aValidatingPINSM = validatingPINSM;
    switch (aValidatingPINSM)
    {
      case validatingPIN:
        setValidatingPINSM(ValidatingPINSM.waitingForDigit);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutwaitingForDigitTowaitingForDigit()
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSM aValidatingPINSM = validatingPINSM;
    switch (aValidatingPINSM)
    {
      case waitingForDigit:
        // line 79 "AccessControl2.ump"
        System.out.println("TIMEOUT");
        setValidatingPINSM(ValidatingPINSM.waitingForDigit);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean authenticate(List PIN)
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSM aValidatingPINSM = validatingPINSM;
    switch (aValidatingPINSM)
    {
      case waitingForAuthentication:
        // line 82 "AccessControl2.ump"
        authorize(PIN);
        setValidatingPINSM(ValidatingPINSM.waitingForAuthorization);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1__()
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSM aValidatingPINSM = validatingPINSM;
    switch (aValidatingPINSM)
    {
      case waitingForAuthorization:
        if (getIsValid())
        {
        // line 85 "AccessControl2.ump"
          ok();
          setValidatingPINSM(ValidatingPINSM.validatingPIN);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition2__()
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSM aValidatingPINSM = validatingPINSM;
    switch (aValidatingPINSM)
    {
      case waitingForAuthorization:
        if (!getIsValid())
        {
        // line 86 "AccessControl2.ump"
          nOk();
          setValidatingPINSM(ValidatingPINSM.validatingPIN);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterWaitingForDigit()
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSMWaitingForDigit aValidatingPINSMWaitingForDigit = validatingPINSMWaitingForDigit;
    switch (aValidatingPINSMWaitingForDigit)
    {
      case Null:
        setValidatingPINSMWaitingForDigit(ValidatingPINSMWaitingForDigit.waitingDigit);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitWaitingForDigit()
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSMWaitingForDigit aValidatingPINSMWaitingForDigit = validatingPINSMWaitingForDigit;
    switch (aValidatingPINSMWaitingForDigit)
    {
      case waitingDigit:
        setValidatingPINSMWaitingForDigit(ValidatingPINSMWaitingForDigit.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean digit(List d)
  {
    boolean wasEventProcessed = false;
    
    ValidatingPINSMWaitingForDigit aValidatingPINSMWaitingForDigit = validatingPINSMWaitingForDigit;
    switch (aValidatingPINSMWaitingForDigit)
    {
      case waitingDigit:
        exitValidatingPINSM();
        // line 77 "AccessControl2.ump"
        authenticate(d);
        setValidatingPINSM(ValidatingPINSM.waitingForAuthentication);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitValidatingPINSM()
  {
    switch(validatingPINSM)
    {
      case waitingForDigit:
        exitWaitingForDigit();
        break;
    }
  }

  private void setValidatingPINSM(ValidatingPINSM aValidatingPINSM)
  {
    validatingPINSM = aValidatingPINSM;

    // entry actions and do activities
    switch(validatingPINSM)
    {
      case waitingForDigit:
        if (validatingPINSMWaitingForDigit == ValidatingPINSMWaitingForDigit.Null) { setValidatingPINSMWaitingForDigit(ValidatingPINSMWaitingForDigit.waitingDigit); }
        break;
      case waitingForAuthorization:
        __autotransition1__();
        __autotransition2__();
        break;
    }
  }

  private void setValidatingPINSMWaitingForDigit(ValidatingPINSMWaitingForDigit aValidatingPINSMWaitingForDigit)
  {
    validatingPINSMWaitingForDigit = aValidatingPINSMWaitingForDigit;
    if (validatingPINSM != ValidatingPINSM.waitingForDigit && aValidatingPINSMWaitingForDigit != ValidatingPINSMWaitingForDigit.Null) { setValidatingPINSM(ValidatingPINSM.waitingForDigit); }
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

  public AccessZone getAccessZone(int index)
  {
    AccessZone aAccessZone = accessZones.get(index);
    return aAccessZone;
  }

  public List<AccessZone> getAccessZones()
  {
    List<AccessZone> newAccessZones = Collections.unmodifiableList(accessZones);
    return newAccessZones;
  }

  public int numberOfAccessZones()
  {
    int number = accessZones.size();
    return number;
  }

  public boolean hasAccessZones()
  {
    boolean has = accessZones.size() > 0;
    return has;
  }

  public int indexOfAccessZone(AccessZone aAccessZone)
  {
    int index = accessZones.indexOf(aAccessZone);
    return index;
  }

  public static int minimumNumberOfAccessPoints()
  {
    return 0;
  }

  public AccessPoint addAccessPoint(Door aDoor)
  {
    return new AccessPoint(aDoor, this);
  }

  public boolean addAccessPoint(AccessPoint aAccessPoint)
  {
    boolean wasAdded = false;
    if (accessPoints.contains(aAccessPoint)) { return false; }
    Authorizer existingControls = aAccessPoint.getControls();
    boolean isNewControls = existingControls != null && !this.equals(existingControls);
    if (isNewControls)
    {
      aAccessPoint.setControls(this);
    }
    else
    {
      accessPoints.add(aAccessPoint);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccessPoint(AccessPoint aAccessPoint)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccessPoint, as it must always have a controls
    if (!this.equals(aAccessPoint.getControls()))
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

  public static int minimumNumberOfAccessZones()
  {
    return 0;
  }

  public AccessZone addAccessZone(ACSystem aExitControls, ACSystem aEntryControls)
  {
    return new AccessZone(this, aExitControls, aEntryControls);
  }

  public boolean addAccessZone(AccessZone aAccessZone)
  {
    boolean wasAdded = false;
    if (accessZones.contains(aAccessZone)) { return false; }
    Authorizer existingHasKnowledge = aAccessZone.getHasKnowledge();
    boolean isNewHasKnowledge = existingHasKnowledge != null && !this.equals(existingHasKnowledge);
    if (isNewHasKnowledge)
    {
      aAccessZone.setHasKnowledge(this);
    }
    else
    {
      accessZones.add(aAccessZone);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccessZone(AccessZone aAccessZone)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccessZone, as it must always have a hasKnowledge
    if (!this.equals(aAccessZone.getHasKnowledge()))
    {
      accessZones.remove(aAccessZone);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccessZoneAt(AccessZone aAccessZone, int index)
  {  
    boolean wasAdded = false;
    if(addAccessZone(aAccessZone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccessZones()) { index = numberOfAccessZones() - 1; }
      accessZones.remove(aAccessZone);
      accessZones.add(index, aAccessZone);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccessZoneAt(AccessZone aAccessZone, int index)
  {
    boolean wasAdded = false;
    if(accessZones.contains(aAccessZone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccessZones()) { index = numberOfAccessZones() - 1; }
      accessZones.remove(aAccessZone);
      accessZones.add(index, aAccessZone);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccessZoneAt(aAccessZone, index);
    }
    return wasAdded;
  }

  private void startTimeoutwaitingForDigitTowaitingForDigitHandler()
  {
    timeoutwaitingForDigitTowaitingForDigitHandler = new TimedEventHandler(this,"timeoutwaitingForDigitTowaitingForDigit",10);
  }

  private void stopTimeoutwaitingForDigitTowaitingForDigitHandler()
  {
    timeoutwaitingForDigitTowaitingForDigitHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private Authorizer controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(Authorizer aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutwaitingForDigitTowaitingForDigit".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutwaitingForDigitTowaitingForDigit();
        if (shouldRestart)
        {
          controller.startTimeoutwaitingForDigitTowaitingForDigitHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {
    for(int i=accessPoints.size(); i > 0; i--)
    {
      AccessPoint aAccessPoint = accessPoints.get(i - 1);
      aAccessPoint.delete();
    }
    for(int i=accessZones.size(); i > 0; i--)
    {
      AccessZone aAccessZone = accessZones.get(i - 1);
      aAccessZone.delete();
    }
  }

  // line 92 "AccessControl2.ump"
   public void ok(){
    System.out.println("PIN is OK");
  }

  // line 95 "AccessControl2.ump"
   public void nOk(){
    System.out.println("PIN is NOK");
  }

  // line 98 "AccessControl2.ump"
   public void error(){
    System.out.println("Error is detected");
  }

  // line 101 "AccessControl2.ump"
   public void authorize(List PIN){
    System.out.println("User carries Card has a valid PIN [" + PIN + "]");
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isValid" + ":" + getIsValid()+ "]"
     + outputString;
  }
}