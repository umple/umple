/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.stats;
import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

// line 60 "../../../../src/UmpleStats_Code.ump"
public class MetricsCollector
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MetricsCollector Attributes
  private List<String> logs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MetricsCollector()
  {
    // line 68 "../../../../src/UmpleStats_Code.ump"
    init();
    logs = new ArrayList<String>();
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

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 70 ../../../../src/UmpleStats_Code.ump
  private Hashtable<String, Hashtable<String, Integer>> _projectToMetricsMap;  
  private String _currentProject;
  private ArrayList<String> _allProjectIds;
  private ArrayList<String> _allAssociationTypes;
  
  private void init()
  {
    _currentProject = null;
    _allProjectIds = new ArrayList<String>();
    _allAssociationTypes = new ArrayList<String>();
    _projectToMetricsMap = new Hashtable<String, Hashtable<String, Integer>>();
  }
  
  public boolean analyze(String projectName, String inputFilename)
  {
    _currentProject = projectName;
    _allProjectIds.add(projectName);
    _projectToMetricsMap.put(projectName, new Hashtable<String,Integer>());

    try
    {
      UmpleFile umpleFile = new UmpleFile(inputFilename);
      UmpleModel model = new UmpleModel(umpleFile);
      model.setShouldGenerate(false);
      model.run();
      
      for (Association association : model.getAssociations())
      {
        String key = association.toGenericString();
        incrementAssociationType(key);
      }
      
      return true;
    }
    catch (Exception e)
    {
      addLog(e.getMessage() + ": " + inputFilename);
      _allProjectIds.remove(projectName);
      return false;
    }
  }
  
  public void save(String outputFilename)
  {
    FileManager.writeFileToDisk(outputFilename, toString()); 
  }
  
  public int numberOf(String projectId, String lowerBound, String upperBound)
  {
    Hashtable<String,Integer> lookup = _projectToMetricsMap.get(projectId);
    if (lookup == null)
    {
      return 0;
    }
    int forward = currentNumberOfAssociationType(lowerBound + " -- " + upperBound,lookup);
    int backward = currentNumberOfAssociationType(upperBound + " -- " + lowerBound,lookup);
    return forward + backward;
  }
  
  public String toString()
  {
    StringBuilder header = new StringBuilder();
    StringBuilder body = new StringBuilder();
    header.append("Project Id");
    for(int i=0; i<_allAssociationTypes.size(); i++)
    {
      header.append("\t#" + _allAssociationTypes.get(i));
    }
    header.append("\n");
    
    for (Iterator<String> p = _allProjectIds.iterator(); p.hasNext();)
    {
      String projectId = p.next();
      body.append(projectId);
      Hashtable<String, Integer> frequencyMap = _projectToMetricsMap.get(projectId);
      for(int i=0; i<_allAssociationTypes.size(); i++)
      {
        String key = _allAssociationTypes.get(i);
        int number = currentNumberOfAssociationType(key, frequencyMap);
        body.append("\t"+ number);
      }
      body.append("\n");
    }

    return header.toString() + body.toString();
  }
  
  private int currentNumberOfAssociationType(String key, Hashtable<String,Integer> lookup)
  {
    if (lookup.containsKey(key))
    {
      return lookup.get(key).intValue();
    }
    else
    {
      return 0;
    }
  }
  
  private void incrementAssociationType(String key)
  {
    incrementAssociationType(key,_projectToMetricsMap.get(_currentProject));
  }
  
  private void incrementAssociationType(String key, Hashtable<String,Integer> lookup)
  {
    if (!_allAssociationTypes.contains(key))
    {
      _allAssociationTypes.add(key);
    }
    Integer newInt = new Integer(currentNumberOfAssociationType(key,lookup) + 1);
    lookup.put(key, newInt);
  }
}