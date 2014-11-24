/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Ref_Facility_Type
 */
// line 7 "AccessControl.ump"
// line 83 "AccessControl.ump"
public class FacilityType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FacilityType Attributes
  private String code;

  //FacilityType State Machines
  enum Description { Menu, Record, Screen }
  private Description description;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FacilityType(String aCode)
  {
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    setDescription(Description.Menu);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    if (!canSetCode) { return false; }
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public String getDescriptionFullName()
  {
    String answer = description.toString();
    return answer;
  }

  public Description getDescription()
  {
    return description;
  }

  public boolean setDescription(Description aDescription)
  {
    description = aDescription;
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    FacilityType compareTo = (FacilityType)obj;
  
    if (code == null && compareTo.code != null)
    {
      return false;
    }
    else if (code != null && !code.equals(compareTo.code))
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
    if (code != null)
    {
      cachedHashCode = cachedHashCode * 23 + code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCode = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "]"
     + outputString;
  }
}