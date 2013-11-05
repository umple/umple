/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * TODO: Code smell: This duplicates the structure of the class from UmpleClass
 * This is a problem for model-to-model transformations
 * Should be abolished
 * 
 * @umplesource Umple.ump 608
 * @umplesource Umple_Code.ump 1907
 */
// line 608 "../../../../src/Umple.ump"
// line 1907 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={1914},file={"Umple_Code.ump"},javaline={41},length={3})
   public void setLookup(String aKey, String aValue){
    lookups.put(aKey, aValue);
  }

  @umplesourcefile(line={1919},file={"Umple_Code.ump"},javaline={46},length={10})
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

  @umplesourcefile(line={1931},file={"Umple_Code.ump"},javaline={58},length={20})
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

  @umplesourcefile(line={1953},file={"Umple_Code.ump"},javaline={80},length={12})
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

  @umplesourcefile(line={1967},file={"Umple_Code.ump"},javaline={94},length={9})
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
  //  @umplesourcefile(line={1910},file={"Umple_Code.ump"},javaline={108},length={5})
  @umplesourcefile(line={1911},file={"Umple_Code.ump"},javaline={109},length={4})
  private Map<String, String> lookups = new HashMap<String, String>() ;

//  @umplesourcefile(line={1911},file={"Umple_Code.ump"},javaline={112},length={2})
  @umplesourcefile(line={1912},file={"Umple_Code.ump"},javaline={113},length={1})
  private Map<String, List<String>> multiLookups = new HashMap<String,List<String>>() ;

  
}