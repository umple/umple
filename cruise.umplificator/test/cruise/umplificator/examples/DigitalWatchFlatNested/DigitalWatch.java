/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 7 "DigitalWatchNested.ump"
public class DigitalWatch
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DigitalWatch Attributes
  private int day;
  private int month;
  private int year;
  private int hour;
  private int minute;
  private int second;
  private int alarmHour;
  private int alarmMinute;
  private int alarmSecond;
  private int timer;

  //DigitalWatch State Machines
  enum Sm { regular, chronometer, alarmStatus, alarmUpdate }
  enum SmRegular { Null, time, date, update }
  enum SmRegularUpdate { Null, second, minute, hour, month, day, year }
  enum SmChronometer { Null, chronoNormal, lapRunning, lapPaused }
  enum SmChronometerChronoNormal { Null, paused, running }
  enum SmAlarmStatus { Null, bothOff, chimeOn, bothOn, alarmOn }
  enum SmAlarmUpdate { Null, alarmTime, hourMinuteUpdate }
  enum SmAlarmUpdateHourMinuteUpdate { Null, alarmHour, alarmMinute }
  private Sm sm;
  private SmRegular smRegular;
  private SmRegularUpdate smRegularUpdate;
  private SmChronometer smChronometer;
  private SmChronometerChronoNormal smChronometerChronoNormal;
  private SmAlarmStatus smAlarmStatus;
  private SmAlarmUpdate smAlarmUpdate;
  private SmAlarmUpdateHourMinuteUpdate smAlarmUpdateHourMinuteUpdate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DigitalWatch()
  {
    day = 0;
    month = 0;
    year = 2014;
    hour = 0;
    minute = 0;
    second = 0;
    alarmHour = 0;
    alarmMinute = 0;
    alarmSecond = 0;
    timer = 0;
    setSmRegular(SmRegular.Null);
    setSmRegularUpdate(SmRegularUpdate.Null);
    setSmChronometer(SmChronometer.Null);
    setSmChronometerChronoNormal(SmChronometerChronoNormal.Null);
    setSmAlarmStatus(SmAlarmStatus.Null);
    setSmAlarmUpdate(SmAlarmUpdate.Null);
    setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.Null);
    setSm(Sm.regular);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDay(int aDay)
  {
    boolean wasSet = false;
    day = aDay;
    wasSet = true;
    return wasSet;
  }

  public boolean setMonth(int aMonth)
  {
    boolean wasSet = false;
    month = aMonth;
    wasSet = true;
    return wasSet;
  }

  public boolean setYear(int aYear)
  {
    boolean wasSet = false;
    year = aYear;
    wasSet = true;
    return wasSet;
  }

  public boolean setHour(int aHour)
  {
    boolean wasSet = false;
    hour = aHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinute(int aMinute)
  {
    boolean wasSet = false;
    minute = aMinute;
    wasSet = true;
    return wasSet;
  }

  public boolean setSecond(int aSecond)
  {
    boolean wasSet = false;
    second = aSecond;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlarmHour(int aAlarmHour)
  {
    boolean wasSet = false;
    alarmHour = aAlarmHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlarmMinute(int aAlarmMinute)
  {
    boolean wasSet = false;
    alarmMinute = aAlarmMinute;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlarmSecond(int aAlarmSecond)
  {
    boolean wasSet = false;
    alarmSecond = aAlarmSecond;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimer(int aTimer)
  {
    boolean wasSet = false;
    timer = aTimer;
    wasSet = true;
    return wasSet;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getSecond()
  {
    return second;
  }

  public int getAlarmHour()
  {
    return alarmHour;
  }

  public int getAlarmMinute()
  {
    return alarmMinute;
  }

  public int getAlarmSecond()
  {
    return alarmSecond;
  }

  public int getTimer()
  {
    return timer;
  }

  public String getSmFullName()
  {
    String answer = sm.toString();
    if (smRegular != SmRegular.Null) { answer += "." + smRegular.toString(); }
    if (smRegularUpdate != SmRegularUpdate.Null) { answer += "." + smRegularUpdate.toString(); }
    if (smChronometer != SmChronometer.Null) { answer += "." + smChronometer.toString(); }
    if (smChronometerChronoNormal != SmChronometerChronoNormal.Null) { answer += "." + smChronometerChronoNormal.toString(); }
    if (smAlarmStatus != SmAlarmStatus.Null) { answer += "." + smAlarmStatus.toString(); }
    if (smAlarmUpdate != SmAlarmUpdate.Null) { answer += "." + smAlarmUpdate.toString(); }
    if (smAlarmUpdateHourMinuteUpdate != SmAlarmUpdateHourMinuteUpdate.Null) { answer += "." + smAlarmUpdateHourMinuteUpdate.toString(); }
    return answer;
  }

  public Sm getSm()
  {
    return sm;
  }

  public SmRegular getSmRegular()
  {
    return smRegular;
  }

  public SmRegularUpdate getSmRegularUpdate()
  {
    return smRegularUpdate;
  }

  public SmChronometer getSmChronometer()
  {
    return smChronometer;
  }

  public SmChronometerChronoNormal getSmChronometerChronoNormal()
  {
    return smChronometerChronoNormal;
  }

  public SmAlarmStatus getSmAlarmStatus()
  {
    return smAlarmStatus;
  }

  public SmAlarmUpdate getSmAlarmUpdate()
  {
    return smAlarmUpdate;
  }

  public SmAlarmUpdateHourMinuteUpdate getSmAlarmUpdateHourMinuteUpdate()
  {
    return smAlarmUpdateHourMinuteUpdate;
  }

  public boolean s3()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    SmRegular aSmRegular = smRegular;
    switch (aSm)
    {
      case chronometer:
        exitSm();
        setSmRegular(SmRegular.time);
        wasEventProcessed = true;
        break;
      case alarmUpdate:
        exitSm();
        setSmRegularUpdate(SmRegularUpdate.second);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmRegular)
    {
      case time:
        exitSm();
        setSm(Sm.chronometer);
        wasEventProcessed = true;
        break;
      case update:
        exitSmRegular();
        setSmRegular(SmRegular.time);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean notS2()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case alarmStatus:
        exitSm();
        setSmRegular(SmRegular.time);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterRegular()
  {
    boolean wasEventProcessed = false;
    
    SmRegular aSmRegular = smRegular;
    SmRegularUpdate aSmRegularUpdate = smRegularUpdate;
    switch (aSmRegular)
    {
      case Null:
        setSmRegular(SmRegular.time);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmRegularUpdate)
    {
      case Null:
        setSmRegularUpdate(SmRegularUpdate.second);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitRegular()
  {
    boolean wasEventProcessed = false;
    
    SmRegular aSmRegular = smRegular;
    SmRegularUpdate aSmRegularUpdate = smRegularUpdate;
    switch (aSmRegular)
    {
      case time:
        setSmRegular(SmRegular.Null);
        wasEventProcessed = true;
        break;
      case date:
        setSmRegular(SmRegular.Null);
        wasEventProcessed = true;
        break;
      case update:
        setSmRegular(SmRegular.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmRegularUpdate)
    {
      case second:
        setSmRegularUpdate(SmRegularUpdate.Null);
        wasEventProcessed = true;
        break;
      case minute:
        setSmRegularUpdate(SmRegularUpdate.Null);
        wasEventProcessed = true;
        break;
      case hour:
        setSmRegularUpdate(SmRegularUpdate.Null);
        wasEventProcessed = true;
        break;
      case month:
        setSmRegularUpdate(SmRegularUpdate.Null);
        wasEventProcessed = true;
        break;
      case day:
        setSmRegularUpdate(SmRegularUpdate.Null);
        wasEventProcessed = true;
        break;
      case year:
        setSmRegularUpdate(SmRegularUpdate.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean s1()
  {
    boolean wasEventProcessed = false;
    
    SmRegular aSmRegular = smRegular;
    SmRegularUpdate aSmRegularUpdate = smRegularUpdate;
    SmChronometer aSmChronometer = smChronometer;
    SmChronometerChronoNormal aSmChronometerChronoNormal = smChronometerChronoNormal;
    SmAlarmStatus aSmAlarmStatus = smAlarmStatus;
    SmAlarmUpdate aSmAlarmUpdate = smAlarmUpdate;
    SmAlarmUpdateHourMinuteUpdate aSmAlarmUpdateHourMinuteUpdate = smAlarmUpdateHourMinuteUpdate;
    switch (aSmRegular)
    {
      case time:
        setSmRegular(SmRegular.date);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmRegularUpdate)
    {
      case second:
        setSmRegularUpdate(SmRegularUpdate.minute);
        wasEventProcessed = true;
        break;
      case minute:
        setSmRegularUpdate(SmRegularUpdate.hour);
        wasEventProcessed = true;
        break;
      case hour:
        setSmRegularUpdate(SmRegularUpdate.month);
        wasEventProcessed = true;
        break;
      case month:
        setSmRegularUpdate(SmRegularUpdate.day);
        wasEventProcessed = true;
        break;
      case day:
        setSmRegularUpdate(SmRegularUpdate.year);
        wasEventProcessed = true;
        break;
      case year:
        setSmRegularUpdate(SmRegularUpdate.second);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmChronometer)
    {
      case lapRunning:
        setSmChronometer(SmChronometer.lapPaused);
        wasEventProcessed = true;
        break;
      case lapPaused:
        setSmChronometer(SmChronometer.lapRunning);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmChronometerChronoNormal)
    {
      case paused:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.running);
        wasEventProcessed = true;
        break;
      case running:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmStatus)
    {
      case bothOff:
        setSmAlarmStatus(SmAlarmStatus.chimeOn);
        wasEventProcessed = true;
        break;
      case chimeOn:
        setSmAlarmStatus(SmAlarmStatus.bothOn);
        wasEventProcessed = true;
        break;
      case bothOn:
        setSmAlarmStatus(SmAlarmStatus.alarmOn);
        wasEventProcessed = true;
        break;
      case alarmOn:
        setSmAlarmStatus(SmAlarmStatus.bothOff);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmUpdate)
    {
      case alarmTime:
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmMinute);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmUpdateHourMinuteUpdate)
    {
      case alarmHour:
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmMinute);
        wasEventProcessed = true;
        break;
      case alarmMinute:
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmHour);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean s2()
  {
    boolean wasEventProcessed = false;
    
    SmRegular aSmRegular = smRegular;
    SmRegularUpdate aSmRegularUpdate = smRegularUpdate;
    SmChronometer aSmChronometer = smChronometer;
    SmChronometerChronoNormal aSmChronometerChronoNormal = smChronometerChronoNormal;
    SmAlarmUpdate aSmAlarmUpdate = smAlarmUpdate;
    SmAlarmUpdateHourMinuteUpdate aSmAlarmUpdateHourMinuteUpdate = smAlarmUpdateHourMinuteUpdate;
    switch (aSmRegular)
    {
      case time:
        exitSm();
        setSm(Sm.alarmStatus);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmRegularUpdate)
    {
      case second:
        // line 28 "DigitalWatchNested.ump"
        secondzero();
        setSmRegularUpdate(SmRegularUpdate.second);
        wasEventProcessed = true;
        break;
      case minute:
        // line 32 "DigitalWatchNested.ump"
        minute++;
        setSmRegularUpdate(SmRegularUpdate.minute);
        wasEventProcessed = true;
        break;
      case hour:
        // line 36 "DigitalWatchNested.ump"
        hour++;
        setSmRegularUpdate(SmRegularUpdate.hour);
        wasEventProcessed = true;
        break;
      case month:
        // line 40 "DigitalWatchNested.ump"
        month++;
        setSmRegularUpdate(SmRegularUpdate.month);
        wasEventProcessed = true;
        break;
      case day:
        // line 44 "DigitalWatchNested.ump"
        day++;
        setSmRegularUpdate(SmRegularUpdate.day);
        wasEventProcessed = true;
        break;
      case year:
        // line 48 "DigitalWatchNested.ump"
        year++;
        setSmRegularUpdate(SmRegularUpdate.year);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmChronometer)
    {
      case lapRunning:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.running);
        wasEventProcessed = true;
        break;
      case lapPaused:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmChronometerChronoNormal)
    {
      case paused:
        // line 59 "DigitalWatchNested.ump"
        zero();
        setSmChronometerChronoNormal(SmChronometerChronoNormal.paused);
        wasEventProcessed = true;
        break;
      case running:
        exitSmChronometer();
        setSmChronometer(SmChronometer.lapRunning);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmUpdate)
    {
      case alarmTime:
        // line 98 "DigitalWatchNested.ump"
        alarmHour++;
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmHour);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmUpdateHourMinuteUpdate)
    {
      case alarmHour:
        // line 103 "DigitalWatchNested.ump"
        alarmHour++;
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmHour);
        wasEventProcessed = true;
        break;
      case alarmMinute:
        // line 107 "DigitalWatchNested.ump"
        alarmMinute++;
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmMinute);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean s3during2Secs()
  {
    boolean wasEventProcessed = false;
    
    SmRegular aSmRegular = smRegular;
    switch (aSmRegular)
    {
      case time:
        exitSm();
        setSmAlarmUpdate(SmAlarmUpdate.alarmTime);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean notS1()
  {
    boolean wasEventProcessed = false;
    
    SmRegular aSmRegular = smRegular;
    switch (aSmRegular)
    {
      case date:
        setSmRegular(SmRegular.time);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterChronometer()
  {
    boolean wasEventProcessed = false;
    
    SmChronometer aSmChronometer = smChronometer;
    SmChronometerChronoNormal aSmChronometerChronoNormal = smChronometerChronoNormal;
    switch (aSmChronometer)
    {
      case Null:
        setSmChronometer(SmChronometer.chronoNormal);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmChronometerChronoNormal)
    {
      case Null:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitChronometer()
  {
    boolean wasEventProcessed = false;
    
    SmChronometer aSmChronometer = smChronometer;
    SmChronometerChronoNormal aSmChronometerChronoNormal = smChronometerChronoNormal;
    switch (aSmChronometer)
    {
      case chronoNormal:
        setSmChronometer(SmChronometer.Null);
        wasEventProcessed = true;
        break;
      case lapRunning:
        setSmChronometer(SmChronometer.Null);
        wasEventProcessed = true;
        break;
      case lapPaused:
        setSmChronometer(SmChronometer.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmChronometerChronoNormal)
    {
      case paused:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.Null);
        wasEventProcessed = true;
        break;
      case running:
        setSmChronometerChronoNormal(SmChronometerChronoNormal.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterAlarmStatus()
  {
    boolean wasEventProcessed = false;
    
    SmAlarmStatus aSmAlarmStatus = smAlarmStatus;
    switch (aSmAlarmStatus)
    {
      case Null:
        setSmAlarmStatus(SmAlarmStatus.bothOff);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitAlarmStatus()
  {
    boolean wasEventProcessed = false;
    
    SmAlarmStatus aSmAlarmStatus = smAlarmStatus;
    switch (aSmAlarmStatus)
    {
      case bothOff:
        setSmAlarmStatus(SmAlarmStatus.Null);
        wasEventProcessed = true;
        break;
      case chimeOn:
        setSmAlarmStatus(SmAlarmStatus.Null);
        wasEventProcessed = true;
        break;
      case bothOn:
        setSmAlarmStatus(SmAlarmStatus.Null);
        wasEventProcessed = true;
        break;
      case alarmOn:
        setSmAlarmStatus(SmAlarmStatus.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterAlarmUpdate()
  {
    boolean wasEventProcessed = false;
    
    SmAlarmUpdate aSmAlarmUpdate = smAlarmUpdate;
    SmAlarmUpdateHourMinuteUpdate aSmAlarmUpdateHourMinuteUpdate = smAlarmUpdateHourMinuteUpdate;
    switch (aSmAlarmUpdate)
    {
      case Null:
        setSmAlarmUpdate(SmAlarmUpdate.alarmTime);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmUpdateHourMinuteUpdate)
    {
      case Null:
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmHour);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitAlarmUpdate()
  {
    boolean wasEventProcessed = false;
    
    SmAlarmUpdate aSmAlarmUpdate = smAlarmUpdate;
    SmAlarmUpdateHourMinuteUpdate aSmAlarmUpdateHourMinuteUpdate = smAlarmUpdateHourMinuteUpdate;
    switch (aSmAlarmUpdate)
    {
      case alarmTime:
        setSmAlarmUpdate(SmAlarmUpdate.Null);
        wasEventProcessed = true;
        break;
      case hourMinuteUpdate:
        setSmAlarmUpdate(SmAlarmUpdate.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSmAlarmUpdateHourMinuteUpdate)
    {
      case alarmHour:
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.Null);
        wasEventProcessed = true;
        break;
      case alarmMinute:
        setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitSm()
  {
    switch(sm)
    {
      case regular:
        exitRegular();
        break;
      case chronometer:
        exitChronometer();
        break;
      case alarmStatus:
        exitAlarmStatus();
        break;
      case alarmUpdate:
        exitAlarmUpdate();
        break;
    }
  }

  private void setSm(Sm aSm)
  {
    sm = aSm;

    // entry actions and do activities
    switch(sm)
    {
      case regular:
        if (smRegular == SmRegular.Null) { setSmRegular(SmRegular.time); }
        break;
      case chronometer:
        if (smChronometer == SmChronometer.Null) { setSmChronometer(SmChronometer.chronoNormal); }
        break;
      case alarmStatus:
        if (smAlarmStatus == SmAlarmStatus.Null) { setSmAlarmStatus(SmAlarmStatus.bothOff); }
        break;
      case alarmUpdate:
        if (smAlarmUpdate == SmAlarmUpdate.Null) { setSmAlarmUpdate(SmAlarmUpdate.alarmTime); }
        break;
    }
  }

  private void exitSmRegular()
  {
    switch(smRegular)
    {
      case update:
        exitRegular();
        break;
    }
  }

  private void setSmRegular(SmRegular aSmRegular)
  {
    smRegular = aSmRegular;
    if (sm != Sm.regular && aSmRegular != SmRegular.Null) { setSm(Sm.regular); }

    // entry actions and do activities
    switch(smRegular)
    {
      case update:
        if (smRegularUpdate == SmRegularUpdate.Null) { setSmRegularUpdate(SmRegularUpdate.second); }
        break;
    }
  }

  private void setSmRegularUpdate(SmRegularUpdate aSmRegularUpdate)
  {
    smRegularUpdate = aSmRegularUpdate;
    if (smRegular != SmRegular.update && aSmRegularUpdate != SmRegularUpdate.Null) { setSmRegular(SmRegular.update); }
  }

  private void exitSmChronometer()
  {
    switch(smChronometer)
    {
      case chronoNormal:
        exitChronometer();
        break;
    }
  }

  private void setSmChronometer(SmChronometer aSmChronometer)
  {
    smChronometer = aSmChronometer;
    if (sm != Sm.chronometer && aSmChronometer != SmChronometer.Null) { setSm(Sm.chronometer); }

    // entry actions and do activities
    switch(smChronometer)
    {
      case chronoNormal:
        if (smChronometerChronoNormal == SmChronometerChronoNormal.Null) { setSmChronometerChronoNormal(SmChronometerChronoNormal.paused); }
        break;
    }
  }

  private void setSmChronometerChronoNormal(SmChronometerChronoNormal aSmChronometerChronoNormal)
  {
    smChronometerChronoNormal = aSmChronometerChronoNormal;
    if (smChronometer != SmChronometer.chronoNormal && aSmChronometerChronoNormal != SmChronometerChronoNormal.Null) { setSmChronometer(SmChronometer.chronoNormal); }
  }

  private void setSmAlarmStatus(SmAlarmStatus aSmAlarmStatus)
  {
    smAlarmStatus = aSmAlarmStatus;
    if (sm != Sm.alarmStatus && aSmAlarmStatus != SmAlarmStatus.Null) { setSm(Sm.alarmStatus); }
  }

  private void exitSmAlarmUpdate()
  {
    switch(smAlarmUpdate)
    {
      case hourMinuteUpdate:
        exitAlarmUpdate();
        break;
    }
  }

  private void setSmAlarmUpdate(SmAlarmUpdate aSmAlarmUpdate)
  {
    smAlarmUpdate = aSmAlarmUpdate;
    if (sm != Sm.alarmUpdate && aSmAlarmUpdate != SmAlarmUpdate.Null) { setSm(Sm.alarmUpdate); }

    // entry actions and do activities
    switch(smAlarmUpdate)
    {
      case hourMinuteUpdate:
        if (smAlarmUpdateHourMinuteUpdate == SmAlarmUpdateHourMinuteUpdate.Null) { setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate.alarmHour); }
        break;
    }
  }

  private void setSmAlarmUpdateHourMinuteUpdate(SmAlarmUpdateHourMinuteUpdate aSmAlarmUpdateHourMinuteUpdate)
  {
    smAlarmUpdateHourMinuteUpdate = aSmAlarmUpdateHourMinuteUpdate;
    if (smAlarmUpdate != SmAlarmUpdate.hourMinuteUpdate && aSmAlarmUpdateHourMinuteUpdate != SmAlarmUpdateHourMinuteUpdate.Null) { setSmAlarmUpdate(SmAlarmUpdate.hourMinuteUpdate); }
  }

  public void delete()
  {}

  // line 123 "DigitalWatchNested.ump"
  public void secondzero(){
    setSecond(0);
  }

  // line 126 "DigitalWatchNested.ump"
  public void zero(){
    setTimer(0);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "day" + ":" + getDay()+ "," +
            "month" + ":" + getMonth()+ "," +
            "year" + ":" + getYear()+ "," +
            "hour" + ":" + getHour()+ "," +
            "minute" + ":" + getMinute()+ "," +
            "second" + ":" + getSecond()+ "," +
            "alarmHour" + ":" + getAlarmHour()+ "," +
            "alarmMinute" + ":" + getAlarmMinute()+ "," +
            "alarmSecond" + ":" + getAlarmSecond()+ "," +
            "timer" + ":" + getTimer()+ "]"
     + outputString;
  }
}