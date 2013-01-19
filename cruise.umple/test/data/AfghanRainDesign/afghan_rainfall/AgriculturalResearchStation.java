/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;

// line 99 "../AfghanRainDesign.ump"
// line 175 "../AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetName = true;
    name = aName;
    setDetails(Details.Herat);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    if (!canSetName) { return false; }
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getDetailsFullName()
  {
    String answer = details.toString();
    return answer;
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