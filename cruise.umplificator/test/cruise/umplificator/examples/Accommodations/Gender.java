/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 96 "Accommodations.ump"
// line 143 "Accommodations.ump"
public class Gender
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Gender Attributes
  private String code;

  //Gender State Machines
  enum Gender_description { M, F, U }
  private Gender_description gender_description;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Gender(String aCode)
  {
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    setGender_description(Gender_description.M);
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

  public String getGender_descriptionFullName()
  {
    String answer = gender_description.toString();
    return answer;
  }

  public Gender_description getGender_description()
  {
    return gender_description;
  }

  public boolean setGender_description(Gender_description aGender_description)
  {
    gender_description = aGender_description;
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Gender compareTo = (Gender)obj;
  
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