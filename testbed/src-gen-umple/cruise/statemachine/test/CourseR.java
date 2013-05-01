/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 128 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseR
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseR Attributes
  private List<String> logs;

  //CourseR State Machines
  enum One { Off, On }
  private One one;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseR()
  {
    logs = new ArrayList<String>();
    setOne(One.Off);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addLog(String aLog)
  {
    boolean wasAdded = false;
    wasAdded = logs.add(aLog);
    return wasAdded;
  }

  public boolean removeLog(String aLog)
  {
    boolean wasRemoved = false;
    wasRemoved = logs.remove(aLog);
    return wasRemoved;
  }

  public String getLog(int index)
  {
    String aLog = logs.get(index);
    return aLog;
  }

  public String[] getLogs()
  {
    String[] newLogs = logs.toArray(new String[logs.size()]);
    return newLogs;
  }

  public int numberOfLogs()
  {
    int number = logs.size();
    return number;
  }

  public boolean hasLogs()
  {
    boolean has = logs.size() > 0;
    return has;
  }

  public int indexOfLog(String aLog)
  {
    int index = logs.indexOf(aLog);
    return index;
  }

  public String getOneFullName()
  {
    String answer = one.toString();
    return answer;
  }

  public One getOne()
  {
    return one;
  }

  private boolean __autotransition2__()
  {
    boolean wasEventProcessed = false;
    
    One aOne = one;
    switch (aOne)
    {
      case Off:
        exitOne();
        setOne(One.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitOne()
  {
    switch(one)
    {
      case Off:
        // line 135 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Exit Off");
        break;
      case On:
        // line 140 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Exit On");
        break;
    }
  }

  private void setOne(One aOne)
  {
    one = aOne;

    // entry actions and do activities
    switch(one)
    {
      case Off:
        // line 134 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Enter Off");
        __autotransition2__();
        break;
      case On:
        // line 139 "../../../../src/TestHarnessStateMachineJava.ump"
        addLog("Enter On");
        break;
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]"
     + outputString;
  }
}