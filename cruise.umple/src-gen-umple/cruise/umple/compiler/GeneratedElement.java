/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * TODO: Code smell: This duplicates the structure of the class from UmpleClass
 * This is a problem for model-to-model transformations
 * Should be abolished
 * 
 * @umplesource Umple.ump 685
 * @umplesource Umple_Code.ump 1933
 */
// line 685 "../../../../src/Umple.ump"
// line 1933 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={1942},file={"Umple_Code.ump"},javaline={42},length={3})
   public void setLookup(String aKey, String aValue){
    lookups.put(aKey, aValue);
  }

  @umplesourcefile(line={1947},file={"Umple_Code.ump"},javaline={47},length={10})
   public String getLookup(String aKey){
    if (aKey == null)
    {
      return null;
    }
    else
    {
      return lookups.get(aKey);  
    }
  }

  @umplesourcefile(line={1959},file={"Umple_Code.ump"},javaline={59},length={20})
   public boolean addMultiLookup(String aKey, String aValue){
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

  @umplesourcefile(line={1981},file={"Umple_Code.ump"},javaline={81},length={12})
   public String[] getMultiLookup(String aKey){
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

  @umplesourcefile(line={1995},file={"Umple_Code.ump"},javaline={95},length={9})
   public String toString(){
    String answer = "<<";
    for (String aKey : lookups.keySet())
    {
      answer += "[" + aKey + ":" + lookups.get(aKey) + "]";
    }    
    answer += ">>";
    return answer;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={1936},file={"Umple_Code.ump"},javaline={108},length={4})
  @umplesourcefile(line={1937},file={"Umple_Code.ump"},javaline={109},length={3})
  private Map<String, String> lookups = new HashMap<String, String>() ;
//  @umplesourcefile(line={1937},file={"Umple_Code.ump"},javaline={111},length={2})
  @umplesourcefile(line={1938},file={"Umple_Code.ump"},javaline={112},length={1})
  private Map<String, List<String>> multiLookups = new HashMap<String,List<String>>() ;

  
}