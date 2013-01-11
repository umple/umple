/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.patterns.test;
import java.util.*;

// line 38 "../../../../src/TestHarnessPatterns.ump"
public class WidgetE
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetE Attributes
  private List<String> ids;
  private List<String> logs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetE()
  {
    ids = new ArrayList<String>();
    logs = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addId(String aId)
  {
    boolean wasAdded = false;
    // line 44 "../../../../src/TestHarnessPatterns.ump"
    addLog("before addId:" + numberOfIds());
    wasAdded = ids.add(aId);
    // line 45 "../../../../src/TestHarnessPatterns.ump"
    addLog("after addId:" + numberOfIds());
    return wasAdded;
  }

  public boolean removeId(String aId)
  {
    boolean wasRemoved = false;
    // line 46 "../../../../src/TestHarnessPatterns.ump"
    addLog("before removeId:" + numberOfIds());
    wasRemoved = ids.remove(aId);
    // line 47 "../../../../src/TestHarnessPatterns.ump"
    addLog("after removeId:" + numberOfIds());
    return wasRemoved;
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

  public String getId(int index)
  {
    // line 50 "../../../../src/TestHarnessPatterns.ump"
    addLog("before getId");
    String aId = ids.get(index);
    // line 51 "../../../../src/TestHarnessPatterns.ump"
    addLog("after getId");
    return aId;
  }

  public String[] getIds()
  {
    // line 52 "../../../../src/TestHarnessPatterns.ump"
    addLog("before getIds");
    String[] newIds = ids.toArray(new String[ids.size()]);
    // line 53 "../../../../src/TestHarnessPatterns.ump"
    addLog("after getIds");
    return newIds;
  }

  public int numberOfIds()
  {
    int number = ids.size();
    return number;
  }

  public boolean hasIds()
  {
    boolean has = ids.size() > 0;
    return has;
  }

  public int indexOfId(String aId)
  {
    // line 48 "../../../../src/TestHarnessPatterns.ump"
    addLog("before indexOfId");
    int index = ids.indexOf(aId);
    // line 49 "../../../../src/TestHarnessPatterns.ump"
    addLog("after indexOfId");
    return index;
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