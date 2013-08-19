/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * TODO: Code smell: This duplicates the structure of the class from UmpleClass
 * This is a problem for model-to-model transformations
 * Should be abolished
 * @umplesource Umple.ump 585
 * @umplesource Umple_Code.ump 1674
 */
// line 585 "../../../../src/Umple.ump"
// line 1674 "../../../../src/Umple_Code.ump"
public class GeneratedElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  //  @umplesourcefile(line={1676},file={"Umple_Code.ump"},javaline={43},length={67})
  @umplesourcefile(line={1677},file={"Umple_Code.ump"},javaline={44},length={7})
  private Map<String, String> lookups = new HashMap<String, String>();
  @umplesourcefile(line={1678},file={"Umple_Code.ump"},javaline={46},length={6})
  private Map<String, List<String>> multiLookups = new HashMap<String,List<String>>();

  @umplesourcefile(line={1680},file={"Umple_Code.ump"},javaline={49},length={4})
  public void setLookup(String aKey, String aValue)
  {
    lookups.put(aKey, aValue);
  }

  @umplesourcefile(line={1685},file={"Umple_Code.ump"},javaline={55},length={11})
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

  @umplesourcefile(line={1697},file={"Umple_Code.ump"},javaline={68},length={21})
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

  @umplesourcefile(line={1719},file={"Umple_Code.ump"},javaline={91},length={13})
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

  @umplesourcefile(line={1733},file={"Umple_Code.ump"},javaline={106},length={10})
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