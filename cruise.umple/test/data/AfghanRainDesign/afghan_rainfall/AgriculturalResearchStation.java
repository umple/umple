/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

public class AgriculturalResearchStation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AgriculturalResearchStation Attributes
  private String name;

  //AgriculturalResearchStation State Machines
  enum Details { Herat, Kabul, Kunduz }
  private Details details;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AgriculturalResearchStation(String aName)
  {
    name = aName;
    details = Details.Herat;
    cachedHashCode = -1;
    canSetName = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    if (!canSetName)
    {
      return false;
    }
    name = aName;
    return true;
  }

  public String getName()
  {
    return name;
  }

  public Details getDetails()
  {
    return details;
  }

  public boolean setDetails(Details aDetails)
  {
    details = aDetails;
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    AgriculturalResearchStation compareTo = (AgriculturalResearchStation)obj;
  
    if (name == null && compareTo.name != null)
    {
      return false;
    }
    else if (name != null && !name.equals(compareTo.name))
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
    if (name != null)
    {
      cachedHashCode = cachedHashCode * 23 + name.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetName = false;
    return cachedHashCode;
  }

  public void delete()
  {}

}