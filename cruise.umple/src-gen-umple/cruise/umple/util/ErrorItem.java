/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import java.util.*;

/**
 * @umplesource Util_Code.ump 288
 */
// line 288 "../../../../src/Util_Code.ump"
public class ErrorItem
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ErrorItem Attributes
  private String id;
  private List<String> parts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorItem(String aId)
  {
    id = aId;
    parts = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean addPart(String aPart)
  {
    boolean wasAdded = false;
    wasAdded = parts.add(aPart);
    return wasAdded;
  }

  public boolean removePart(String aPart)
  {
    boolean wasRemoved = false;
    wasRemoved = parts.remove(aPart);
    return wasRemoved;
  }

  public String getId()
  {
    return id;
  }

  public String getPart(int index)
  {
    String aPart = parts.get(index);
    return aPart;
  }

  public String[] getParts()
  {
    String[] newParts = parts.toArray(new String[parts.size()]);
    return newParts;
  }

  public int numberOfParts()
  {
    int number = parts.size();
    return number;
  }

  public boolean hasParts()
  {
    boolean has = parts.size() > 0;
    return has;
  }

  public int indexOfPart(String aPart)
  {
    int index = parts.indexOf(aPart);
    return index;
  }

  public void delete()
  {}

  @umplesourcefile(line={296},file={"Util_Code.ump"},javaline={100},length={7})
   public  ErrorItem(String aId, String [] aParts){
    this(aId);
    for (String part : aParts)
    {
      addPart(part);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]"
     + outputString;
  }
}