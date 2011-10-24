/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorJ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorJ Attributes
  private String name;

  //MentorJ Associations
  private List<StudentJ> students;
  private ProgramJ program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorJ(String aName)
  {
    name = aName;
    students = new ArrayList<StudentJ>();
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

  public StudentJ getStudent(int index)
  {
    StudentJ aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentJ> getStudents()
  {
    List<StudentJ> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentJ aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramJ getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 0;
  }

  public StudentJ addStudent(int aNumber)
  {
    return new StudentJ(aNumber, this);
  }

  public boolean addStudent(StudentJ aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    MentorJ existingMentor = aStudent.getMentor();
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

  public boolean removeStudent(StudentJ aStudent)
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

  public boolean setProgram(ProgramJ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramJ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramJ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorJ existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(StudentJ aStudent : students)
    {
      aStudent.delete();
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}