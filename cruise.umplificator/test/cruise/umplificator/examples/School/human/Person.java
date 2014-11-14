/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package human;

// line 15 "../../School.ump"
// line 28 "../../School.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private int idNumber;

  //Person Associations
  private School school;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdNumber;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, int aIdNumber)
  {
    cachedHashCode = -1;
    canSetIdNumber = true;
    name = aName;
    idNumber = aIdNumber;
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

  public boolean setIdNumber(int aIdNumber)
  {
    boolean wasSet = false;
    if (!canSetIdNumber) { return false; }
    idNumber = aIdNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public School getSchool()
  {
    return school;
  }

  public boolean hasSchool()
  {
    boolean has = school != null;
    return has;
  }

  public boolean setSchool(School aSchool)
  {
    boolean wasSet = false;
    School existingSchool = school;
    school = aSchool;
    if (existingSchool != null && !existingSchool.equals(aSchool))
    {
      existingSchool.removeStudent(this);
    }
    if (aSchool != null)
    {
      aSchool.addStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Person compareTo = (Person)obj;
  
    if (idNumber != compareTo.idNumber)
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
    cachedHashCode = cachedHashCode * 23 + idNumber;

    canSetIdNumber = false;
    return cachedHashCode;
  }

  public void delete()
  {
    if (school != null)
    {
      School placeholderSchool = school;
      this.school = null;
      placeholderSchool.removeStudent(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "school = "+(getSchool()!=null?Integer.toHexString(System.identityHashCode(getSchool())):"null")
     + outputString;
  }
}