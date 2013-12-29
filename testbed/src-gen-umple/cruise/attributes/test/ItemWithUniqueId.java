/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

package cruise.attributes.test;
import java.util.*;

// line 97 "../../../../src/TestHarnessAttributes.ump"
public class ItemWithUniqueId
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, ItemWithUniqueId> itemwithuniqueidsById = new HashMap<String, ItemWithUniqueId>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ItemWithUniqueId Attributes
  private String id;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ItemWithUniqueId(String aId)
  {
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    String anOldId = getId();
    if (hasWithId(aId)) {
      return wasSet;
    }
    id = aId;
    wasSet = true;
    if (anOldId != null) {
      itemwithuniqueidsById.remove(anOldId);
    }
    itemwithuniqueidsById.put(aId, this);
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public static ItemWithUniqueId getWithId(String aId)
  {
    return itemwithuniqueidsById.get(aId);
  }

  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }

  public void delete()
  {
    itemwithuniqueidsById.remove(getId());
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]"
     + outputString;
  }
}