/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 7 "DigitalWatchFlat.ump"
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
  enum Sm { time, date, paused, running, lapRunning, lapPaused, bothOff, chimeOn, bothOn, alarmOn, alarmTime, alarmHour, alarmMinute, second, minute, hour, month, day, year }
  private Sm sm;

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
    setSm(Sm.time);
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
    return answer;
  }

  public Sm getSm()
  {
    return sm;
  }

  public boolean s1()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case time:
        setSm(Sm.date);
        wasEventProcessed = true;
        break;
      case paused:
        setSm(Sm.running);
        wasEventProcessed = true;
        break;
      case running:
        setSm(Sm.paused);
        wasEventProcessed = true;
        break;
      case lapRunning:
        setSm(Sm.lapPaused);
        wasEventProcessed = true;
        break;
      case lapPaused:
        setSm(Sm.lapRunning);
        wasEventProcessed = true;
        break;
      case bothOff:
        setSm(Sm.chimeOn);
        wasEventProcessed = true;
        break;
      case chimeOn:
        setSm(Sm.bothOn);
        wasEventProcessed = true;
        break;
      case bothOn:
        setSm(Sm.alarmOn);
        wasEventProcessed = true;
        break;
      case alarmOn:
        setSm(Sm.bothOff);
        wasEventProcessed = true;
        break;
      case alarmTime:
        setSm(Sm.alarmMinute);
        wasEventProcessed = true;
        break;
      case alarmHour:
        setSm(Sm.alarmMinute);
        wasEventProcessed = true;
        break;
      case alarmMinute:
        setSm(Sm.alarmHour);
        wasEventProcessed = true;
        break;
      case second:
        setSm(Sm.minute);
        wasEventProcessed = true;
        break;
      case minute:
        setSm(Sm.hour);
        wasEventProcessed = true;
        break;
      case hour:
        setSm(Sm.month);
        wasEventProcessed = true;
        break;
      case month:
        setSm(Sm.day);
        wasEventProcessed = true;
        break;
      case day:
        setSm(Sm.year);
        wasEventProcessed = true;
        break;
      case year:
        setSm(Sm.second);
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
    
    Sm aSm = sm;
    switch (aSm)
    {
      case time:
        setSm(Sm.bothOff);
        wasEventProcessed = true;
        break;
      case paused:
        // line 25 "DigitalWatchFlat.ump"
        zero();
        setSm(Sm.paused);
        wasEventProcessed = true;
        break;
      case running:
        setSm(Sm.lapRunning);
        wasEventProcessed = true;
        break;
      case lapRunning:
        setSm(Sm.running);
        wasEventProcessed = true;
        break;
      case lapPaused:
        setSm(Sm.paused);
        wasEventProcessed = true;
        break;
      case alarmTime:
        // line 66 "DigitalWatchFlat.ump"
        alarmHour++;
        setSm(Sm.alarmHour);
        wasEventProcessed = true;
        break;
      case alarmHour:
        // line 71 "DigitalWatchFlat.ump"
        alarmHour++;
        setSm(Sm.alarmHour);
        wasEventProcessed = true;
        break;
      case alarmMinute:
        // line 76 "DigitalWatchFlat.ump"
        alarmMinute++;
        setSm(Sm.alarmMinute);
        wasEventProcessed = true;
        break;
      case second:
        // line 83 "DigitalWatchFlat.ump"
        secondzero();
        setSm(Sm.second);
        wasEventProcessed = true;
        break;
      case minute:
        // line 88 "DigitalWatchFlat.ump"
        minute++;
        setSm(Sm.minute);
        wasEventProcessed = true;
        break;
      case hour:
        // line 93 "DigitalWatchFlat.ump"
        hour++;
        setSm(Sm.hour);
        wasEventProcessed = true;
        break;
      case month:
        // line 98 "DigitalWatchFlat.ump"
        month++;
        setSm(Sm.month);
        wasEventProcessed = true;
        break;
      case day:
        // line 103 "DigitalWatchFlat.ump"
        day++;
        setSm(Sm.day);
        wasEventProcessed = true;
        break;
      case year:
        // line 108 "DigitalWatchFlat.ump"
        year++;
        setSm(Sm.year);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean s3()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case time:
        setSm(Sm.paused);
        wasEventProcessed = true;
        break;
      case paused:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case running:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case lapRunning:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case lapPaused:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case alarmTime:
        setSm(Sm.second);
        wasEventProcessed = true;
        break;
      case alarmHour:
        setSm(Sm.second);
        wasEventProcessed = true;
        break;
      case alarmMinute:
        setSm(Sm.second);
        wasEventProcessed = true;
        break;
      case second:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case minute:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case hour:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case month:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case day:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case year:
        setSm(Sm.time);
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
    
    Sm aSm = sm;
    switch (aSm)
    {
      case time:
        setSm(Sm.alarmTime);
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
    
    Sm aSm = sm;
    switch (aSm)
    {
      case date:
        setSm(Sm.time);
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
      case bothOff:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case chimeOn:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case bothOn:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      case alarmOn:
        setSm(Sm.time);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setSm(Sm aSm)
  {
    sm = aSm;
  }

  public void delete()
  {}

  // line 123 "DigitalWatchFlat.ump"
  public void secondzero(){
    setSecond(0);
  }

  // line 126 "DigitalWatchFlat.ump"
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