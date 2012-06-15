/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.patterns.test;
import java.util.*;

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
    addLog("before addId:" + numberOfIds());
    wasAdded = ids.add(aId);
    addLog("after addId:" + numberOfIds());
    return wasAdded;
  }

  public boolean removeId(String aId)
  {
    boolean wasRemoved = false;
    addLog("before removeId:" + numberOfIds());
    wasRemoved = ids.remove(aId);
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
    addLog("before getId");
    String aId = ids.get(index);
    addLog("after getId");
    return aId;
  }

  public String[] getIds()
  {
    addLog("before getIds");
    String[] newIds = ids.toArray(new String[ids.size()]);
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
    addLog("before indexOfId");
    int index = ids.indexOf(aId);
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