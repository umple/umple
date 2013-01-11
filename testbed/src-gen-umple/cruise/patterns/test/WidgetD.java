/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.patterns.test;
import java.util.*;

// line 26 "../../../../src/TestHarnessPatterns.ump"
public class WidgetD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetD Attributes
  private String id;
  private List<String> logs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetD(String aId)
  {
    id = aId;
    logs = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    // line 32 "../../../../src/TestHarnessPatterns.ump"
    addLog("before setId:" + id);
    id = aId;
    wasSet = true;
    // line 33 "../../../../src/TestHarnessPatterns.ump"
    addLog("after setId:" + id);
    return wasSet;
  }

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

  public String getId()
  {
    // line 34 "../../../../src/TestHarnessPatterns.ump"
    addLog("before getId");
    String aId = id;
    // line 35 "../../../../src/TestHarnessPatterns.ump"
    addLog("after getId");
    return aId;
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

  public void delete()
  {}

}