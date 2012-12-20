/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

public class District
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //District Attributes
  private int id;
  private String name;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public District(int aId, String aName)
  {
    id = aId;
    name = aName;
    cachedHashCode = -1;
    canSetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    if (!canSetId)
    {
      return false;
    }
    id = aId;
    return true;
  }

  public boolean setName(String aName)
  {
    name = aName;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    District compareTo = (District)obj;
  
    if (id != compareTo.id)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + id;

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {}

}