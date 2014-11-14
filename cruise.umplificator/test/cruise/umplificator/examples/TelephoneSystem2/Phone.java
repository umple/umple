/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 5 "TelephoneSystem2.ump"
public class Phone
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Phone Attributes
  private boolean permanentMute;
  private boolean callInProgress;

  //Phone State Machines
  enum RingerSound { Off, On }
  private RingerSound ringerSound;
  enum ScreenLight { Off, On, Dimmed }
  private ScreenLight screenLight;
  enum Vibration { Off, On }
  private Vibration vibration;

  //Helper Variables
  private TimedEventHandler timeoutOnToDimmedHandler;
  private TimedEventHandler timeoutDimmedToOffHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Phone()
  {
    permanentMute = false;
    callInProgress = false;
    setRingerSound(RingerSound.Off);
    setScreenLight(ScreenLight.Off);
    setVibration(Vibration.Off);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPermanentMute(boolean aPermanentMute)
  {
    boolean wasSet = false;
    permanentMute = aPermanentMute;
    wasSet = true;
    return wasSet;
  }

  public boolean setCallInProgress(boolean aCallInProgress)
  {
    boolean wasSet = false;
    callInProgress = aCallInProgress;
    wasSet = true;
    return wasSet;
  }

  public boolean getPermanentMute()
  {
    return permanentMute;
  }

  public boolean getCallInProgress()
  {
    return callInProgress;
  }

  public boolean isPermanentMute()
  {
    return permanentMute;
  }

  public boolean isCallInProgress()
  {
    return callInProgress;
  }

  public String getRingerSoundFullName()
  {
    String answer = ringerSound.toString();
    return answer;
  }

  public String getScreenLightFullName()
  {
    String answer = screenLight.toString();
    return answer;
  }

  public String getVibrationFullName()
  {
    String answer = vibration.toString();
    return answer;
  }

  public RingerSound getRingerSound()
  {
    return ringerSound;
  }

  public ScreenLight getScreenLight()
  {
    return screenLight;
  }

  public Vibration getVibration()
  {
    return vibration;
  }

  public boolean callReceived()
  {
    boolean wasEventProcessed = false;
    
    RingerSound aRingerSound = ringerSound;
    ScreenLight aScreenLight = screenLight;
    Vibration aVibration = vibration;
    switch (aRingerSound)
    {
      case Off:
        if (!getPermanentMute())
        {
          setRingerSound(RingerSound.On);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    switch (aScreenLight)
    {
      case Off:
        setScreenLight(ScreenLight.On);
        wasEventProcessed = true;
        break;
      case Dimmed:
        exitScreenLight();
        setScreenLight(ScreenLight.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aVibration)
    {
      case Off:
        setVibration(Vibration.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean silentButton()
  {
    boolean wasEventProcessed = false;
    
    RingerSound aRingerSound = ringerSound;
    switch (aRingerSound)
    {
      case On:
        setRingerSound(RingerSound.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pickUp()
  {
    boolean wasEventProcessed = false;
    
    RingerSound aRingerSound = ringerSound;
    ScreenLight aScreenLight = screenLight;
    Vibration aVibration = vibration;
    switch (aRingerSound)
    {
      case On:
        setRingerSound(RingerSound.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aScreenLight)
    {
      case Off:
        setScreenLight(ScreenLight.On);
        wasEventProcessed = true;
        break;
      case Dimmed:
        exitScreenLight();
        setScreenLight(ScreenLight.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aVibration)
    {
      case On:
        setVibration(Vibration.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean rejectCall()
  {
    boolean wasEventProcessed = false;
    
    RingerSound aRingerSound = ringerSound;
    Vibration aVibration = vibration;
    switch (aRingerSound)
    {
      case On:
        setRingerSound(RingerSound.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aVibration)
    {
      case On:
        setVibration(Vibration.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean unanswered()
  {
    boolean wasEventProcessed = false;
    
    RingerSound aRingerSound = ringerSound;
    Vibration aVibration = vibration;
    switch (aRingerSound)
    {
      case On:
        setRingerSound(RingerSound.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aVibration)
    {
      case On:
        setVibration(Vibration.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean dial()
  {
    boolean wasEventProcessed = false;
    
    ScreenLight aScreenLight = screenLight;
    switch (aScreenLight)
    {
      case Off:
        setScreenLight(ScreenLight.On);
        wasEventProcessed = true;
        break;
      case Dimmed:
        exitScreenLight();
        setScreenLight(ScreenLight.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutOnToDimmed()
  {
    boolean wasEventProcessed = false;
    
    ScreenLight aScreenLight = screenLight;
    switch (aScreenLight)
    {
      case On:
        exitScreenLight();
        setScreenLight(ScreenLight.Dimmed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean hangUp()
  {
    boolean wasEventProcessed = false;
    
    ScreenLight aScreenLight = screenLight;
    switch (aScreenLight)
    {
      case On:
        exitScreenLight();
        setScreenLight(ScreenLight.Off);
        wasEventProcessed = true;
        break;
      case Dimmed:
        exitScreenLight();
        setScreenLight(ScreenLight.Off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutDimmedToOff()
  {
    boolean wasEventProcessed = false;
    
    ScreenLight aScreenLight = screenLight;
    switch (aScreenLight)
    {
      case Dimmed:
        if (!getCallInProgress())
        {
          exitScreenLight();
          setScreenLight(ScreenLight.Off);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setRingerSound(RingerSound aRingerSound)
  {
    ringerSound = aRingerSound;
  }

  private void exitScreenLight()
  {
    switch(screenLight)
    {
      case On:
        stopTimeoutOnToDimmedHandler();
        break;
      case Dimmed:
        stopTimeoutDimmedToOffHandler();
        break;
    }
  }

  private void setScreenLight(ScreenLight aScreenLight)
  {
    screenLight = aScreenLight;

    // entry actions and do activities
    switch(screenLight)
    {
      case On:
        startTimeoutOnToDimmedHandler();
        break;
      case Dimmed:
        startTimeoutDimmedToOffHandler();
        break;
    }
  }

  private void setVibration(Vibration aVibration)
  {
    vibration = aVibration;
  }

  private void startTimeoutOnToDimmedHandler()
  {
    timeoutOnToDimmedHandler = new TimedEventHandler(this,"timeoutOnToDimmed",30000);
  }

  private void stopTimeoutOnToDimmedHandler()
  {
    timeoutOnToDimmedHandler.stop();
  }

  private void startTimeoutDimmedToOffHandler()
  {
    timeoutDimmedToOffHandler = new TimedEventHandler(this,"timeoutDimmedToOff",60000);
  }

  private void stopTimeoutDimmedToOffHandler()
  {
    timeoutDimmedToOffHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private Phone controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(Phone aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutOnToDimmed".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutOnToDimmed();
        if (shouldRestart)
        {
          controller.startTimeoutOnToDimmedHandler();
        }
        return;
      }
      if ("timeoutDimmedToOff".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutDimmedToOff();
        if (shouldRestart)
        {
          controller.startTimeoutDimmedToOffHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "permanentMute" + ":" + getPermanentMute()+ "," +
            "callInProgress" + ":" + getCallInProgress()+ "]"
     + outputString;
  }
}