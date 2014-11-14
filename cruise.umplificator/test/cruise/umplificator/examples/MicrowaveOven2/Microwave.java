/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.lang.Thread;

// line 8 "MicrowaveOven2.ump"
public class Microwave implements Runnable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int TimeIncrementMs = 1000;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Microwave Attributes
  private boolean lightOn;
  private boolean powerTubeOn;
  private boolean isDoorOpened;
  private boolean isButtonPressed;
  private Timer timer;

  //Microwave State Machines
  enum OperatingMicrowaveStateMachine { readyToCook, doorOpen, cooking, cookingInterrupted, cookingComplete, cookingExtended }
  private OperatingMicrowaveStateMachine operatingMicrowaveStateMachine;
  
  //enumeration type of messages accepted by Microwave
  enum MessageType { doorOpened_M, buttonPressed_M, doorClosed_M, timerTimesout_M }
  
  MessageQueue queue;
  Thread removal;

  //Microwave Do Activity Threads
  Thread doActivityOperatingMicrowaveStateMachineCookingThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Microwave()
  {
    lightOn = false;
    powerTubeOn = false;
    isDoorOpened = false;
    isButtonPressed = false;
    timer = new Timer();
    setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.readyToCook);
    queue = new MessageQueue();
    removal=new Thread(this);
    //start the thread of Microwave
    removal.start();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLightOn(boolean aLightOn)
  {
    boolean wasSet = false;
    lightOn = aLightOn;
    wasSet = true;
    return wasSet;
  }

  public boolean setPowerTubeOn(boolean aPowerTubeOn)
  {
    boolean wasSet = false;
    powerTubeOn = aPowerTubeOn;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDoorOpened(boolean aIsDoorOpened)
  {
    boolean wasSet = false;
    isDoorOpened = aIsDoorOpened;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsButtonPressed(boolean aIsButtonPressed)
  {
    boolean wasSet = false;
    isButtonPressed = aIsButtonPressed;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimer(Timer aTimer)
  {
    boolean wasSet = false;
    timer = aTimer;
    wasSet = true;
    return wasSet;
  }

  public boolean getLightOn()
  {
    return lightOn;
  }

  public boolean getPowerTubeOn()
  {
    return powerTubeOn;
  }

  public boolean getIsDoorOpened()
  {
    return isDoorOpened;
  }

  public boolean getIsButtonPressed()
  {
    return isButtonPressed;
  }

  public Timer getTimer()
  {
    return timer;
  }

  public String getOperatingMicrowaveStateMachineFullName()
  {
    String answer = operatingMicrowaveStateMachine.toString();
    return answer;
  }

  public OperatingMicrowaveStateMachine getOperatingMicrowaveStateMachine()
  {
    return operatingMicrowaveStateMachine;
  }

  public boolean _doorOpened()
  {
    boolean wasEventProcessed = false;
    
    OperatingMicrowaveStateMachine aOperatingMicrowaveStateMachine = operatingMicrowaveStateMachine;
    switch (aOperatingMicrowaveStateMachine)
    {
      case readyToCook:
        // line 23 "MicrowaveOven2.ump"
        setIsDoorOpened(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.doorOpen);
        wasEventProcessed = true;
        break;
      case cooking:
        exitOperatingMicrowaveStateMachine();
        // line 47 "MicrowaveOven2.ump"
        setIsDoorOpened(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cookingInterrupted);
        wasEventProcessed = true;
        break;
      case cookingComplete:
        // line 62 "MicrowaveOven2.ump"
        setIsDoorOpened(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.doorOpen);
        wasEventProcessed = true;
        break;
      case cookingExtended:
        // line 73 "MicrowaveOven2.ump"
        setIsDoorOpened(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cookingInterrupted);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _buttonPressed()
  {
    boolean wasEventProcessed = false;
    
    OperatingMicrowaveStateMachine aOperatingMicrowaveStateMachine = operatingMicrowaveStateMachine;
    switch (aOperatingMicrowaveStateMachine)
    {
      case readyToCook:
        // line 24 "MicrowaveOven2.ump"
        setIsButtonPressed(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cooking);
        wasEventProcessed = true;
        break;
      case cooking:
        exitOperatingMicrowaveStateMachine();
        // line 48 "MicrowaveOven2.ump"
        setIsButtonPressed(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cookingExtended);
        wasEventProcessed = true;
        break;
      case cookingComplete:
        // line 63 "MicrowaveOven2.ump"
        setIsButtonPressed(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cooking);
        wasEventProcessed = true;
        break;
      case cookingExtended:
        // line 74 "MicrowaveOven2.ump"
        setIsButtonPressed(true);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cookingExtended);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _doorClosed()
  {
    boolean wasEventProcessed = false;
    
    OperatingMicrowaveStateMachine aOperatingMicrowaveStateMachine = operatingMicrowaveStateMachine;
    switch (aOperatingMicrowaveStateMachine)
    {
      case doorOpen:
        // line 32 "MicrowaveOven2.ump"
        setIsDoorOpened(false);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.readyToCook);
        wasEventProcessed = true;
        break;
      case cookingInterrupted:
        // line 57 "MicrowaveOven2.ump"
        setIsDoorOpened(false);
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.readyToCook);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _timerTimesout()
  {
    boolean wasEventProcessed = false;
    
    OperatingMicrowaveStateMachine aOperatingMicrowaveStateMachine = operatingMicrowaveStateMachine;
    switch (aOperatingMicrowaveStateMachine)
    {
      case cooking:
        exitOperatingMicrowaveStateMachine();
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cookingComplete);
        wasEventProcessed = true;
        break;
      case cookingExtended:
        setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine.cookingComplete);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitOperatingMicrowaveStateMachine()
  {
    switch(operatingMicrowaveStateMachine)
    {
      case cooking:
        if (doActivityOperatingMicrowaveStateMachineCookingThread != null) { doActivityOperatingMicrowaveStateMachineCookingThread.interrupt(); }
        break;
    }
  }

  private void setOperatingMicrowaveStateMachine(OperatingMicrowaveStateMachine aOperatingMicrowaveStateMachine)
  {
    operatingMicrowaveStateMachine = aOperatingMicrowaveStateMachine;

    // entry actions and do activities
    switch(operatingMicrowaveStateMachine)
    {
      case readyToCook:
        // line 19 "MicrowaveOven2.ump"
        // turn off light
        turnOff();
        break;
      case doorOpen:
        // line 28 "MicrowaveOven2.ump"
        // turn on light
        turnLightOn(true);
        break;
      case cooking:
        // line 36 "MicrowaveOven2.ump"
        // turn on light
        turnLightOn(true);
        // energize power tube
        energizePowerTube(true);
        //release a button
        setIsButtonPressed(false);
        // start timer
        timer.setTimeMs(TimeIncrementMs);
        doActivityOperatingMicrowaveStateMachineCookingThread = new DoActivityThread(this,"doActivityOperatingMicrowaveStateMachineCooking");
        break;
      case cookingInterrupted:
        // line 56 "MicrowaveOven2.ump"
        turnOff();
        break;
      case cookingComplete:
        // line 61 "MicrowaveOven2.ump"
        turnOff();
        break;
      case cookingExtended:
        // line 67 "MicrowaveOven2.ump"
        // add 1 minute to timer
        timer.setTimeMs(TimeIncrementMs+timer.getTimeMs());
        //release a button
        setIsButtonPressed(false);
        break;
    }
  }

  private void doActivityOperatingMicrowaveStateMachineCooking()
  {
    try
    {
      timer.tick(timer.getTimeMs());
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    Microwave controller;
    String doActivityMethodName;
    
    public DoActivityThread(Microwave aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityOperatingMicrowaveStateMachineCooking".equals(doActivityMethodName))
      {
        controller.doActivityOperatingMicrowaveStateMachineCooking();
      }
    }
  }

  public void delete()
  {}

  protected class Message
  {
    MessageType type;
    
    //Message parameters
    Vector<Object> param;
    
    public Message(MessageType t, Vector<Object> p)
    {
      type = t; 
      param = p;
    }

    @Override
    public String toString()
    {
      return type + "," + param;
    }
  }
  
  protected class MessageQueue {
    Queue<Message> messages = new LinkedList<Message>();
    
    public synchronized void put(Message m)
    {
      messages.add(m); 
      notify();
    }

    public synchronized Message getNext()
    {
      try {
        while (messages.isEmpty()) 
        {
          wait();
        }
      } catch (InterruptedException e) { e.printStackTrace(); } 

      //The element to be removed
      Message m = messages.remove(); 
      return (m);
    }
  }

  //------------------------------
  //messages accepted 
  //------------------------------

  public void doorOpened ()
  {
    queue.put(new Message(MessageType.doorOpened_M, null));
  }

  public void buttonPressed ()
  {
    queue.put(new Message(MessageType.buttonPressed_M, null));
  }

  public void doorClosed ()
  {
    queue.put(new Message(MessageType.doorClosed_M, null));
  }

  public void timerTimesout ()
  {
    queue.put(new Message(MessageType.timerTimesout_M, null));
  }

  
  @Override
  public void run ()
  {
    boolean status=false;
    while (true) 
    {
      Message m = queue.getNext();
      
      switch (m.type)
      {
        case doorOpened_M:
          status = _doorOpened();
          break;
        case buttonPressed_M:
          status = _buttonPressed();
          break;
        case doorClosed_M:
          status = _doorClosed();
          break;
        case timerTimesout_M:
          status = _timerTimesout();
          break; 
        default:
      }
      if(!status)
      {
        // Error message is written or  exception is raised
      }
    }
  }

  /**
   * turn on light
   */
  // line 82 "MicrowaveOven2.ump"
   public void turnLightOn(boolean on){
    System.out.println("turns the light "+ (on ? "on" : "off"));
    System.out.println("light " + (on ? "on" : "off"));
    setLightOn(on);
  }


  /**
   * energize/deenergize power tube
   */
  // line 89 "MicrowaveOven2.ump"
   public void energizePowerTube(boolean on){
    System.out.println("energizes/deenergize the power tube");
    System.out.println("power tube " + (on ? "on" : "off"));
    setPowerTubeOn(on);
  }

  // line 95 "MicrowaveOven2.ump"
   public void turnOff(){
    // turn off light
    turnLightOn(false);
    //release button
    setIsButtonPressed(false);
    // de-energize power tube
    energizePowerTube(false);
    // clear timer
    timer.setTimeMs(0);
  }

  // line 106 "MicrowaveOven2.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
    Microwave microwave=new Microwave();
    //microwave.doorOpened();
    microwave.buttonPressed();
    //microwave.buttonPressed();
    microwave.timerTimesout();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "lightOn" + ":" + getLightOn()+ "," +
            "powerTubeOn" + ":" + getPowerTubeOn()+ "," +
            "isDoorOpened" + ":" + getIsDoorOpened()+ "," +
            "isButtonPressed" + ":" + getIsButtonPressed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "timer" + "=" + (getTimer() != null ? !getTimer().equals(this)  ? getTimer().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      translate(e);
      if(e.getCause()!=null)
      {
        translate(e.getCause());
      }
      e.printStackTrace();
    }
    public void translate(Throwable e)
    {
      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();
      StackTraceElement[] elements = e.getStackTrace();
      try
      {
        for(StackTraceElement element:elements)
        {
          String className = element.getClassName();
          String methodName = element.getMethodName();
          boolean methodFound = false;
          int index = className.lastIndexOf('.')+1;
          try {
            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+"_"+methodName,new Class[]{});
            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});
            for(int i=0;i<sourceInformation.size();++i)
            {
              int distanceFromStart = element.getLineNumber()-sourceInformation.getJavaLine(i)-(("main".equals(methodName))?2:0);
              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))
              {
                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));
                methodFound = true;
                break;
              }
            }
          }
          catch (Exception e2){}
          if(!methodFound)
          {
            result.add(element);
          }
        }
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
      e.setStackTrace(result.toArray(new StackTraceElement[0]));
    }
  //The following methods Map Java lines back to their original Umple file / line    
    public UmpleSourceData Microwave_energizePowerTube(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump").setUmpleLines(88).setJavaLines(475).setLengths(3);}
    public UmpleSourceData Microwave_turnLightOn(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump").setUmpleLines(81).setJavaLines(464).setLengths(3);}
    public UmpleSourceData Microwave_doorClosed(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump"," MicrowaveOven2.ump").setUmpleLines(31, 56).setJavaLines(226, 232).setLengths(1, 1);}
    public UmpleSourceData Microwave_buttonPressed(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump").setUmpleLines(23, 47, 62, 73).setJavaLines(187, 194, 200, 206).setLengths(1, 1, 1, 1);}
    public UmpleSourceData Microwave_doActivityOperatingMicrowaveStateMachineCooking(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump").setUmpleLines(49).setJavaLines(330).setLengths(1);}
    public UmpleSourceData Microwave_turnOff(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump").setUmpleLines(94).setJavaLines(482).setLengths(3);}
    public UmpleSourceData Microwave_setOperatingMicrowaveStateMachine(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump").setUmpleLines(18, 27, 35, 55, 60, 66).setJavaLines(286, 291, 296, 308, 312, 316).setLengths(2, 2, 8, 1, 1, 4);}
    public UmpleSourceData Microwave_main(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump").setUmpleLines(105).setJavaLines(494).setLengths(3);}
    public UmpleSourceData Microwave_doorOpened(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump"," MicrowaveOven2.ump").setUmpleLines(22, 46, 61, 72).setJavaLines(148, 155, 161, 167).setLengths(1, 1, 1, 1);}
    public UmpleSourceData Timer_tick(){ return new UmpleSourceData().setFileNames("MicrowaveOven2.ump").setUmpleLines(117).setJavaLines(46).setLengths(3);}

  }
  public static class UmpleSourceData
  {
    String[] umpleFileNames;
    Integer[] umpleLines;
    Integer[] umpleJavaLines;
    Integer[] umpleLengths;
    
    public UmpleSourceData(){
    }
    public String getFileName(int i){
      return umpleFileNames[i];
    }
    public Integer getUmpleLine(int i){
      return umpleLines[i];
    }
    public Integer getJavaLine(int i){
      return umpleJavaLines[i];
    }
    public Integer getLength(int i){
      return umpleLengths[i];
    }
    public UmpleSourceData setFileNames(String... filenames){
      umpleFileNames = filenames;
      return this;
    }
    public UmpleSourceData setUmpleLines(Integer... umplelines){
      umpleLines = umplelines;
      return this;
    }
    public UmpleSourceData setJavaLines(Integer... javalines){
      umpleJavaLines = javalines;
      return this;
    }
    public UmpleSourceData setLengths(Integer... lengths){
      umpleLengths = lengths;
      return this;
    }
    public int size(){
      return umpleFileNames.length;
    }
  } 
}