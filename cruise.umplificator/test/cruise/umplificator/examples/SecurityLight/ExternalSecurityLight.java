/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.lang.Thread;

// line 9 "SecurityLight.ump"
public class ExternalSecurityLight implements Runnable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ExternalSecurityLight Attributes
  private boolean ambientLight;

  //ExternalSecurityLight State Machines
  enum ExternalSecurityLightStateMachine { day, night }
  enum ExternalSecurityLightStateMachineNight { Null, off, moving, timing }
  private ExternalSecurityLightStateMachine externalSecurityLightStateMachine;
  private ExternalSecurityLightStateMachineNight externalSecurityLightStateMachineNight;
  
  //enumeration type of messages accepted by ExternalSecurityLight
  enum MessageType { dark_M, light_M, movement_M, noMovement_M, timeout_M }
  
  MessageQueue queue;
  Thread removal;

  //ExternalSecurityLight Associations
  private Timer timer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ExternalSecurityLight(Timer aTimer)
  {
    ambientLight = false;
    if (aTimer == null || aTimer.getExternalSecurityLight() != null)
    {
      throw new RuntimeException("Unable to create ExternalSecurityLight due to aTimer");
    }
    timer = aTimer;
    setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.Null);
    setExternalSecurityLightStateMachine(ExternalSecurityLightStateMachine.day);
    queue = new MessageQueue();
    removal=new Thread(this);
    //start the thread of ExternalSecurityLight
    removal.start();
    // line 48 "SecurityLight.ump"
    setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.Null);
        setExternalSecurityLightStateMachine(ExternalSecurityLightStateMachine.day);
        removal=new Thread(this);
        //start the thread of ExternalSecurityLight
        removal.start();
  }

  public ExternalSecurityLight()
  {
    ambientLight = false;
    timer = new Timer(this);
    // line 48 "SecurityLight.ump"
    setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.Null);
        setExternalSecurityLightStateMachine(ExternalSecurityLightStateMachine.day);
        removal=new Thread(this);
        //start the thread of ExternalSecurityLight
        removal.start();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAmbientLight(boolean aAmbientLight)
  {
    boolean wasSet = false;
    ambientLight = aAmbientLight;
    wasSet = true;
    return wasSet;
  }

  /**
   * ambient light is false when it is low, and true when it is increased
   */
  public boolean getAmbientLight()
  {
    return ambientLight;
  }

  public String getExternalSecurityLightStateMachineFullName()
  {
    String answer = externalSecurityLightStateMachine.toString();
    if (externalSecurityLightStateMachineNight != ExternalSecurityLightStateMachineNight.Null) { answer += "." + externalSecurityLightStateMachineNight.toString(); }
    return answer;
  }

  public ExternalSecurityLightStateMachine getExternalSecurityLightStateMachine()
  {
    return externalSecurityLightStateMachine;
  }

  public ExternalSecurityLightStateMachineNight getExternalSecurityLightStateMachineNight()
  {
    return externalSecurityLightStateMachineNight;
  }

  public boolean _dark()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachine aExternalSecurityLightStateMachine = externalSecurityLightStateMachine;
    switch (aExternalSecurityLightStateMachine)
    {
      case day:
        // line 21 "SecurityLight.ump"
        setAmbientLight(false);
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _light()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachine aExternalSecurityLightStateMachine = externalSecurityLightStateMachine;
    switch (aExternalSecurityLightStateMachine)
    {
      case night:
        exitExternalSecurityLightStateMachine();
        // line 44 "SecurityLight.ump"
        lampOff();
        setExternalSecurityLightStateMachine(ExternalSecurityLightStateMachine.day);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterNight()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachineNight aExternalSecurityLightStateMachineNight = externalSecurityLightStateMachineNight;
    switch (aExternalSecurityLightStateMachineNight)
    {
      case Null:
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.off);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitNight()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachineNight aExternalSecurityLightStateMachineNight = externalSecurityLightStateMachineNight;
    switch (aExternalSecurityLightStateMachineNight)
    {
      case off:
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.Null);
        wasEventProcessed = true;
        break;
      case moving:
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.Null);
        wasEventProcessed = true;
        break;
      case timing:
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _movement()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachineNight aExternalSecurityLightStateMachineNight = externalSecurityLightStateMachineNight;
    switch (aExternalSecurityLightStateMachineNight)
    {
      case off:
        if (getAmbientLight().equals(false))
        {
        // line 26 "SecurityLight.ump"
          lampOn();
          setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.moving);
          wasEventProcessed = true;
          break;
        }
        break;
      case timing:
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _noMovement()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachineNight aExternalSecurityLightStateMachineNight = externalSecurityLightStateMachineNight;
    switch (aExternalSecurityLightStateMachineNight)
    {
      case moving:
        // line 29 "SecurityLight.ump"
        timer.startTimer(); setAmbientLight(true);
        setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.timing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean _timeout()
  {
    boolean wasEventProcessed = false;
    
    ExternalSecurityLightStateMachineNight aExternalSecurityLightStateMachineNight = externalSecurityLightStateMachineNight;
    switch (aExternalSecurityLightStateMachineNight)
    {
      case timing:
        if (getAmbientLight().equals(true))
        {
        // line 32 "SecurityLight.ump"
          timer.stopTimer();
          
          while (System.currentTimeMillis() < timer.getStopTime()) {
            try {
              Thread.sleep(10000); 
              System.out.println("Lamp is lighting for: "+((timer.getStopTime()-timer.getStartTime())/1000)+" seconds"); 
              lampOff();
            } catch (InterruptedException e) {}
          }
          setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.off);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitExternalSecurityLightStateMachine()
  {
    switch(externalSecurityLightStateMachine)
    {
      case night:
        exitNight();
        break;
    }
  }

  private void setExternalSecurityLightStateMachine(ExternalSecurityLightStateMachine aExternalSecurityLightStateMachine)
  {
    externalSecurityLightStateMachine = aExternalSecurityLightStateMachine;

    // entry actions and do activities
    switch(externalSecurityLightStateMachine)
    {
      case night:
        if (externalSecurityLightStateMachineNight == ExternalSecurityLightStateMachineNight.Null) { setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight.off); }
        break;
    }
  }

  private void setExternalSecurityLightStateMachineNight(ExternalSecurityLightStateMachineNight aExternalSecurityLightStateMachineNight)
  {
    externalSecurityLightStateMachineNight = aExternalSecurityLightStateMachineNight;
    if (externalSecurityLightStateMachine != ExternalSecurityLightStateMachine.night && aExternalSecurityLightStateMachineNight != ExternalSecurityLightStateMachineNight.Null) { setExternalSecurityLightStateMachine(ExternalSecurityLightStateMachine.night); }
  }

  public Timer getTimer()
  {
    return timer;
  }

  public void delete()
  {
    Timer existingTimer = timer;
    timer = null;
    if (existingTimer != null)
    {
      existingTimer.delete();
    }
  }

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

  public void dark ()
  {
    queue.put(new Message(MessageType.dark_M, null));
  }

  public void light ()
  {
    queue.put(new Message(MessageType.light_M, null));
  }

  public void movement ()
  {
    queue.put(new Message(MessageType.movement_M, null));
  }

  public void noMovement ()
  {
    queue.put(new Message(MessageType.noMovement_M, null));
  }

  public void timeout ()
  {
    queue.put(new Message(MessageType.timeout_M, null));
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
        case dark_M:
          status = _dark();
          break;
        case light_M:
          status = _light();
          break;
        case movement_M:
          status = _movement();
          break;
        case noMovement_M:
          status = _noMovement();
          break;
        case timeout_M:
          status = _timeout();
          break; 
        default:
      }
      if(!status)
      {
        // Error message is written or  exception is raised
      }
    }
  }
  // line 56 "SecurityLight.ump"
   public void lampOff(){
    System.out.println("Lamp OFF");
  }

  // line 60 "SecurityLight.ump"
   public void lampOn(){
    System.out.println("Lamp ON");
  }

  // line 64 "SecurityLight.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new .AgentSystem.UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new .AgentSystem.UmpleExceptionHandler());
    ExternalSecurityLight exLight=new ExternalSecurityLight();
    
    exLight.dark();
    exLight.movement();
    exLight.noMovement();
    exLight.timeout();
    exLight.light();
    
    //day --> off(night) --> moving --> timing --> off --> day
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ambientLight" + ":" + getAmbientLight()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "timer = "+(getTimer()!=null?Integer.toHexString(System.identityHashCode(getTimer())):"null")
     + outputString;
  }
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
    public UmpleSourceData ExternalSecurityLight_lampOn(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(59).setJavaLines(430).setLengths(3);}
    public UmpleSourceData ExternalSecurityLight_noMovement(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(28).setJavaLines(230).setLengths(1);}
    public UmpleSourceData ExternalSecurityLight_lampOff(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(55).setJavaLines(426).setLengths(2);}
    public UmpleSourceData ExternalSecurityLight_movement(){ return new UmpleSourceData().setFileNames("SecurityLight.ump"," SecurityLight.ump").setUmpleLines(25, 25).setJavaLines(203, 205).setLengths(1, 1);}
    public UmpleSourceData ExternalSecurityLight_dark(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(20).setJavaLines(117).setLengths(1);}
    public UmpleSourceData ExternalSecurityLight_ExternalSecurityLight(){ return new UmpleSourceData().setFileNames("SecurityLight.ump"," SecurityLight.ump").setUmpleLines(47, 47).setJavaLines(52, 64).setLengths(6, 6);}
    public UmpleSourceData ExternalSecurityLight_light(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(43).setJavaLines(138).setLengths(1);}
    public UmpleSourceData ExternalSecurityLight_timeout(){ return new UmpleSourceData().setFileNames("SecurityLight.ump"," SecurityLight.ump").setUmpleLines(31, 31).setJavaLines(251, 253).setLengths(1, 9);}
    public UmpleSourceData ExternalSecurityLight_main(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(63).setJavaLines(435).setLengths(3);}
    public UmpleSourceData Timer_stopTimer(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(89).setJavaLines(111).setLengths(3);}
    public UmpleSourceData Timer_startTimer(){ return new UmpleSourceData().setFileNames("SecurityLight.ump").setUmpleLines(83).setJavaLines(104).setLengths(3);}

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