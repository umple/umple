/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorZ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorZ Attributes
  private String name;

  //MentorZ Associations
  private List<StudentZ> students;
  private ProgramZ program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorZ(String aName)
  {
    name = aName;
    students = new ArrayList<StudentZ>();
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

  public String getName()
  {
    return name;
  }

  public StudentZ getStudent(int index)
  {
    StudentZ aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentZ> getStudents()
  {
    List<StudentZ> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentZ aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramZ getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 0;
  }

  public static int maximumNumberOfStudents()
  {
    return 3;
  }

  public StudentZ addStudent(int aNumber)
  {
    if (numberOfStudents() >= maximumNumberOfStudents())
    {
      return null;
    }
    else
    {
      return new StudentZ(aNumber, this);
    }
  }

  public boolean addStudent(StudentZ aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    if (numberOfStudents() >= maximumNumberOfStudents())
    {
      return wasAdded;
    }

    MentorZ existingMentor = aStudent.getMentor();
    boolean isNewMentor = existingMentor != null && !this.equals(existingMentor);
    if (isNewMentor)
    {
      aStudent.setMentor(this);
    }
    else
    {
      students.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(StudentZ aStudent)
  {
    boolean wasRemoved = false;
    //Unable to remove aStudent, as it must always have a mentor
    if (!this.equals(aStudent.getMentor()))
    {
      students.remove(aStudent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setProgram(ProgramZ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramZ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramZ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorZ existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(StudentZ aStudent : students)
    {
      aStudent.delete();
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}