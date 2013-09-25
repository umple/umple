/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.stats;
import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

/**
 * @umplesource UmpleStats_Code.ump 60
 */
// line 60 "../../../../src/UmpleStats_Code.ump"
public class MetricsCollector
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MetricsCollector Attributes
  private List<String> logs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={68},file={"UmpleStats_Code.ump"},javaline={33},length={1})
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

  @umplesourcefile(line={75},file={"UmpleStats_Code.ump"},javaline={89},length={6})
   private void init(){
    _currentProject = null;
    _allProjectIds = new ArrayList<String>();
    _allAssociationTypes = new ArrayList<String>();
    _projectToMetricsMap = new Hashtable<String, Hashtable<String, Integer>>();
  }

  @umplesourcefile(line={83},file={"UmpleStats_Code.ump"},javaline={97},length={27})
   public boolean analyze(String projectName, String inputFilename){
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

  @umplesourcefile(line={112},file={"UmpleStats_Code.ump"},javaline={126},length={3})
   public void save(String outputFilename){
    FileManager.writeFileToDisk(outputFilename, toString());
  }

  @umplesourcefile(line={117},file={"UmpleStats_Code.ump"},javaline={131},length={10})
   public int numberOf(String projectId, String lowerBound, String upperBound){
    Hashtable<String,Integer> lookup = _projectToMetricsMap.get(projectId);
    if (lookup == null)
    {
      return 0;
    }
    int forward = currentNumberOfAssociationType(lowerBound + " -- " + upperBound,lookup);
    int backward = currentNumberOfAssociationType(upperBound + " -- " + lowerBound,lookup);
    return forward + backward;
  }

  @umplesourcefile(line={129},file={"UmpleStats_Code.ump"},javaline={143},length={26})
   public String toString(){
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

  @umplesourcefile(line={157},file={"UmpleStats_Code.ump"},javaline={171},length={10})
   private int currentNumberOfAssociationType(String key, Hashtable<String,Integer> lookup){
    if (lookup.containsKey(key))
    {
      return lookup.get(key).intValue();
    }
    else
    {
      return 0;
    }
  }

  @umplesourcefile(line={169},file={"UmpleStats_Code.ump"},javaline={183},length={3})
   private void incrementAssociationType(String key){
    incrementAssociationType(key,_projectToMetricsMap.get(_currentProject));
  }

  @umplesourcefile(line={174},file={"UmpleStats_Code.ump"},javaline={188},length={8})
   private void incrementAssociationType(String key, Hashtable<String,Integer> lookup){
    if (!_allAssociationTypes.contains(key))
    {
      _allAssociationTypes.add(key);
    }
    Integer newInt = new Integer(currentNumberOfAssociationType(key,lookup) + 1);
    lookup.put(key, newInt);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={69},file={"UmpleStats_Code.ump"},javaline={201},length={11})
  private Hashtable<String, Hashtable<String, Integer>> _projectToMetricsMap ;

//  @umplesourcefile(line={70},file={"UmpleStats_Code.ump"},javaline={204},length={8})
  private String _currentProject ;

//  @umplesourcefile(line={71},file={"UmpleStats_Code.ump"},javaline={207},length={5})
  private ArrayList<String> _allProjectIds ;

//  @umplesourcefile(line={72},file={"UmpleStats_Code.ump"},javaline={210},length={2})
  private ArrayList<String> _allAssociationTypes ;

}