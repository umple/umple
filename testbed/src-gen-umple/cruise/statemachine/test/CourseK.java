/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.statemachine.test;
import java.util.*;

// line 86 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseK Attributes
  private List<String> logs;

  //CourseK State Machines
  enum Status { On, Final }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseK()
  {
    logs = new ArrayList<String>();
    setStatus(Status.On);
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

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean flip()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case On:
        setStatus(Status.Final);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case Final:
        delete();
        break;
    }
  }

  public void delete()
  {
    // line 96 "../../../../src/TestHarnessStateMachineJava.ump"
    addLog("deleted");
  }

}