/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package human;
import java.util.*;

/**
 * Positioning
 */
// line 5 "../../School.ump"
// line 22 "../../School.ump"
public class School
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //School Attributes
  private String name;
  private String address;
  private String description;

  //School Associations
  private List<Person> student;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public School(String aName, String aAddress, String aDescription)
  {
    cachedHashCode = -1;
    canSetName = true;
    name = aName;
    address = aAddress;
    description = aDescription;
    student = new ArrayList<Person>();
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getDescription()
  {
    return description;
  }

  public Person getStudent(int index)
  {
    Person aStudent = student.get(index);
    return aStudent;
  }

  public List<Person> getStudent()
  {
    List<Person> newStudent = Collections.unmodifiableList(student);
    return newStudent;
  }

  public int numberOfStudent()
  {
    int number = student.size();
    return number;
  }

  public boolean hasStudent()
  {
    boolean has = student.size() > 0;
    return has;
  }

  public int indexOfStudent(Person aStudent)
  {
    int index = student.indexOf(aStudent);
    return index;
  }

  public static int minimumNumberOfStudent()
  {
    return 0;
  }

  public boolean addStudent(Person aStudent)
  {
    boolean wasAdded = false;
    if (student.contains(aStudent)) { return false; }
    School existingSchool = aStudent.getSchool();
    if (existingSchool == null)
    {
      aStudent.setSchool(this);
    }
    else if (!this.equals(existingSchool))
    {
      existingSchool.removeStudent(aStudent);
      addStudent(aStudent);
    }
    else
    {
      student.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(Person aStudent)
  {
    boolean wasRemoved = false;
    if (student.contains(aStudent))
    {
      student.remove(aStudent);
      aStudent.setSchool(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStudentAt(Person aStudent, int index)
  {  
    boolean wasAdded = false;
    if(addStudent(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudent()) { index = numberOfStudent() - 1; }
      student.remove(aStudent);
      student.add(index, aStudent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudentAt(Person aStudent, int index)
  {
    boolean wasAdded = false;
    if(student.contains(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudent()) { index = numberOfStudent() - 1; }
      student.remove(aStudent);
      student.add(index, aStudent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudentAt(aStudent, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    School compareTo = (School)obj;
  
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
  {
    while( !student.isEmpty() )
    {
      student.get(0).setSchool(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}