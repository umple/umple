/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import java.util.*;

/**
 * @umplesource Json.ump 16
 * @umplesource Json_Code.ump 126
 */
// line 16 "../../../../src/Json.ump"
// line 126 "../../../../src/Json_Code.ump"
public class Json
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Json Attributes
  private String name;
  private String value;
  private List<Json> composites;
  private List<Json> arrays;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Json(String aName, String aValue)
  {
    name = aName;
    value = aValue;
    composites = new ArrayList<Json>();
    arrays = new ArrayList<Json>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  public boolean addComposite(Json aComposite)
  {
    boolean wasAdded = false;
    wasAdded = composites.add(aComposite);
    return wasAdded;
  }

  public boolean removeComposite(Json aComposite)
  {
    boolean wasRemoved = false;
    wasRemoved = composites.remove(aComposite);
    return wasRemoved;
  }

  public boolean addArray(Json aArray)
  {
    boolean wasAdded = false;
    wasAdded = arrays.add(aArray);
    return wasAdded;
  }

  public boolean removeArray(Json aArray)
  {
    boolean wasRemoved = false;
    wasRemoved = arrays.remove(aArray);
    return wasRemoved;
  }

  public String getName()
  {
    return name;
  }

  public String getValue()
  {
    return value;
  }

  public Json getComposite(int index)
  {
    Json aComposite = composites.get(index);
    return aComposite;
  }

  public Json[] getComposites()
  {
    Json[] newComposites = composites.toArray(new Json[composites.size()]);
    return newComposites;
  }

  public int numberOfComposites()
  {
    int number = composites.size();
    return number;
  }

  public boolean hasComposites()
  {
    boolean has = composites.size() > 0;
    return has;
  }

  public int indexOfComposite(Json aComposite)
  {
    int index = composites.indexOf(aComposite);
    return index;
  }

  public Json getArray(int index)
  {
    Json aArray = arrays.get(index);
    return aArray;
  }

  public Json[] getArrays()
  {
    Json[] newArrays = arrays.toArray(new Json[arrays.size()]);
    return newArrays;
  }

  public int numberOfArrays()
  {
    int number = arrays.size();
    return number;
  }

  public boolean hasArrays()
  {
    boolean has = arrays.size() > 0;
    return has;
  }

  public int indexOfArray(Json aArray)
  {
    int index = arrays.indexOf(aArray);
    return index;
  }

  public void delete()
  {}

  @umplesourcefile(line={132},file={"Json_Code.ump"},javaline={163},length={3})
   public boolean isComposite(){
    return value == null;
  }

  @umplesourcefile(line={137},file={"Json_Code.ump"},javaline={168},length={3})
   public void addComposite(String name, String value){
    addComposite(new Json(name,value));
  }

  @umplesourcefile(line={142},file={"Json_Code.ump"},javaline={173},length={3})
   public void addArrayEntity(String value){
    addComposite(new Json(null,value));
  }

  @umplesourcefile(line={147},file={"Json_Code.ump"},javaline={178},length={3})
   public int getIntValue(String name){
    return convertToInt(getValue(name));
  }

  @umplesourcefile(line={152},file={"Json_Code.ump"},javaline={183},length={10})
   public Json[] getArray(String name){
    for (Json anArray : arrays)
    {
      if (name.equals(anArray.getName()))
      {
        return anArray.getComposites();
      }
    }
    return null;
  }

  @umplesourcefile(line={164},file={"Json_Code.ump"},javaline={195},length={15})
   public Json getAttribute(String name){
    if (name == null)
    {
      return null;
    }
    
    for (Json attr : composites)
    {
      if (name.equals(attr.getName()))
      {
        return attr;
      }
    }
    return null;
  }

  @umplesourcefile(line={181},file={"Json_Code.ump"},javaline={212},length={4})
   public String getValue(String name){
    Json attr = getAttribute(name);
    return attr == null ? null : attr.getValue();
  }

  @umplesourcefile(line={187},file={"Json_Code.ump"},javaline={218},length={3})
   public int getIntValue(){
    return convertToInt(value);
  }

  @umplesourcefile(line={192},file={"Json_Code.ump"},javaline={223},length={15})
   private int convertToInt(String input){
    if (input == null)
    {
      return -1;
    }
    
    try
    {
      return Integer.parseInt(input);
    }
    catch (NumberFormatException e)
    {
      return -1;
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "value" + ":" + getValue()+ "]"
     + outputString;
  }
}