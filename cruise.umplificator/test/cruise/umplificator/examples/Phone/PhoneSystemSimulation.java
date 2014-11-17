/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 7 "Phone.ump"
public class PhoneSystemSimulation
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static PhoneSystemSimulation theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneSystemSimulation Associations
  private List<PhoneLine> lines;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private PhoneSystemSimulation()
  {
    lines = new ArrayList<PhoneLine>();
    // line 11 "Phone.ump"
    addLine(new PhoneLine("line1","Bruce",this));
        addLine(new PhoneLine("line2","Ralph",this));
        addLine(new PhoneLine("line3","Victoria",this));
        addLine(new PhoneLine("line4","Vicki",this));
        addLine(new PhoneLine("line5","Agnes",this));
  }

  public static PhoneSystemSimulation getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new PhoneSystemSimulation();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public PhoneLine getLine(int index)
  {
    PhoneLine aLine = lines.get(index);
    return aLine;
  }

  /**
   * lazy PhoneLine[] lines;
   */
  public List<PhoneLine> getLines()
  {
    List<PhoneLine> newLines = Collections.unmodifiableList(lines);
    return newLines;
  }

  public int numberOfLines()
  {
    int number = lines.size();
    return number;
  }

  public boolean hasLines()
  {
    boolean has = lines.size() > 0;
    return has;
  }

  public int indexOfLine(PhoneLine aLine)
  {
    int index = lines.indexOf(aLine);
    return index;
  }

  public static int minimumNumberOfLines()
  {
    return 0;
  }

  public PhoneLine addLine(String aId, String aVoice)
  {
    return new PhoneLine(aId, aVoice, this);
  }

  public boolean addLine(PhoneLine aLine)
  {
    boolean wasAdded = false;
    if (lines.contains(aLine)) { return false; }
    PhoneSystemSimulation existingPhoneSystemSimulation = aLine.getPhoneSystemSimulation();
    boolean isNewPhoneSystemSimulation = existingPhoneSystemSimulation != null && !this.equals(existingPhoneSystemSimulation);
    if (isNewPhoneSystemSimulation)
    {
      aLine.setPhoneSystemSimulation(this);
    }
    else
    {
      lines.add(aLine);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLine(PhoneLine aLine)
  {
    boolean wasRemoved = false;
    //Unable to remove aLine, as it must always have a phoneSystemSimulation
    if (!this.equals(aLine.getPhoneSystemSimulation()))
    {
      lines.remove(aLine);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLineAt(PhoneLine aLine, int index)
  {  
    boolean wasAdded = false;
    if(addLine(aLine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLines()) { index = numberOfLines() - 1; }
      lines.remove(aLine);
      lines.add(index, aLine);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLineAt(PhoneLine aLine, int index)
  {
    boolean wasAdded = false;
    if(lines.contains(aLine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLines()) { index = numberOfLines() - 1; }
      lines.remove(aLine);
      lines.add(index, aLine);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLineAt(aLine, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=lines.size(); i > 0; i--)
    {
      PhoneLine aLine = lines.get(i - 1);
      aLine.delete();
    }
  }

  // line 22 "Phone.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new .AgentSystem.UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new .AgentSystem.UmpleExceptionHandler());
    s = getInstance();
    PhoneLine lineA;
    PhoneLine lineB;
    int choiceA, choiceB;
    
    while(true) {
    
      // Randomly choose who initiates
      choiceA = (int)Math.floor(Math.random()*5);
      choiceB = (choiceA + 1 + (int)Math.floor(Math.random()*4)) % 5;
      lineA = s.getLine(choiceA);
      lineB = s.getLine(choiceB);

    
      // Initate a call
      lineA.startDialing();
      lineA.pause(200);
      lineA.setOtherParty(lineB);
      lineA.completeNumber();
        lineA.p(); lineB.p(); // Will be done by tracing associations

      // The other party can choose whether to pick up or not.
      if(Math.random() > 0.5) {
        lineB.pickUp();
      
        // While talking either party can hang up
        if(Math.random() > 0.5) {
          lineA.hangUp();
          lineB.hangUp(); // assuming it doesn't forget
        }
        else {
          lineB.hangUp();
          lineA.hangUp(); // assuming it doesn't forget
        }
      }
      else {
        // Hang up while waiting and the other will too
        lineA.hangUp();
      }
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 19 Phone.ump
  static PhoneSystemSimulation s ;

  
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
    public UmpleSourceData PhoneSystemSimulation_PhoneSystemSimulation(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(10).setJavaLines(31).setLengths(6);}
    public UmpleSourceData PhoneSystemSimulation_main(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(21).setJavaLines(166).setLengths(3);}
    public UmpleSourceData PhoneLine_pause(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(138).setJavaLines(465).setLengths(3);}
    public UmpleSourceData PhoneLine_pickUp(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(89).setJavaLines(138).setLengths(1);}
    public UmpleSourceData PhoneLine_p(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(126).setJavaLines(451).setLengths(3);}
    public UmpleSourceData PhoneLine_say(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(130).setJavaLines(456).setLengths(3);}
    public UmpleSourceData PhoneLine_toString(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(122).setJavaLines(446).setLengths(3);}
    public UmpleSourceData PhoneLine_setState(){ return new UmpleSourceData().setFileNames("Phone.ump"," Phone.ump"," Phone.ump"," Phone.ump"," Phone.ump"," Phone.ump").setUmpleLines(78, 88, 94, 105, 110, 116).setJavaLines(339, 346, 350, 354, 358, 362).setLengths(4, 1, 1, 1, 1, 1);}
    public UmpleSourceData PhoneLine_hangUp(){ return new UmpleSourceData().setFileNames("Phone.ump"," Phone.ump"," Phone.ump"," Phone.ump"," Phone.ump").setUmpleLines(95, 100, 107, 112, 117).setJavaLines(204, 210, 216, 222, 228).setLengths(1, 1, 1, 1, 1);}
    public UmpleSourceData PhoneLine_autoPickup(){ return new UmpleSourceData().setFileNames("Phone.ump").setUmpleLines(91).setJavaLines(184).setLengths(1);}

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