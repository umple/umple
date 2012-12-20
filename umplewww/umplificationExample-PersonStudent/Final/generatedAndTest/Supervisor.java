/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2809 modeling language!*/


import java.util.*;

public class Supervisor extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Supervisor Associations
  private List<Student> students;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Supervisor(String aName)
  {
    super(aName);
    students = new ArrayList<Student>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Student getStudent(int index)
  {
    Student aStudent = students.get(index);
    return aStudent;
  }

  public List<Student> getStudents()
  {
    List<Student> newStudents = Collections.unmodifiableList(students);
    return newStudents;
  }

  public int numberOfStudents()
  {
    int number = students.size();
    return number;
  }

  public boolean hasStudents()
  {
    boolean has = students.size() > 0;
    return has;
  }

  public int indexOfStudent(Student aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public boolean addStudent(Student aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    Supervisor existingSupervisor = aStudent.getSupervisor();
    if (existingSupervisor == null)
    {
      aStudent.setSupervisor(this);
    }
    else if (!existingSupervisor.equals(this))
    {
      existingSupervisor.removeStudent(aStudent);
      addStudent(aStudent);
    }
    else
    {
      students.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(Student aStudent)
  {
    boolean wasRemoved = false;
    if (students.contains(aStudent))
    {
      students.remove(aStudent);
      aStudent.setSupervisor(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    for(Student aStudent : students)
    {
      aStudent.setSupervisor(null);
    }
    super.delete();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String toString() {
    return(
      (getName()==null ?
        " " : getName()) + " "   
         +
      numberOfStudents()+ " mentees"
    );
  }
}
