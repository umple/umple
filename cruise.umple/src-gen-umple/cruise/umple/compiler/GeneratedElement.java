/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * TODO: Code smell: This duplicates the structure of the class from UmpleClass
 * This is a problem for model-to-model transformations
 * Should be abolished
 */
public class GeneratedElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GeneratedElement()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private Map<String, String> lookups = new HashMap<String, String>();
  private Map<String, List<String>> multiLookups = new HashMap<String,List<String>>();

  public void setLookup(String aKey, String aValue)
  {
    lookups.put(aKey, aValue);
  }

  public String getLookup(String aKey)
  {
    if (aKey == null)
    {
      return null;
    }
    else
    {
      return lookups.get(aKey);  
    }
  }

  public boolean addMultiLookup(String aKey, String aValue)
  {
    List<String> oldList = null;
    if (multiLookups.containsKey(aKey))
    {
      oldList = multiLookups.get(aKey);
    }
    else
    {
      oldList = new ArrayList<String>();
    }

    if (aValue == null || "".equals(aValue) || oldList.contains(aValue))
    {
      return false;
    }

    oldList.add(aValue);
    multiLookups.put(aKey, oldList);
    return true;
  }

  public String[] getMultiLookup(String aKey)
  {
    if (aKey == null || !multiLookups.containsKey(aKey))
    {
      return new String[0];
    }
    else
    {
      List<String> list = multiLookups.get(aKey);

      return list.toArray(new String[list.size()]);
    }
  }

  public String toString()
  {
    String answer = "<<";
    for (String aKey : lookups.keySet())
    {
      answer += "[" + aKey + ":" + lookups.get(aKey) + "]";
    }    
    answer += ">>";
    return answer;
  }
}