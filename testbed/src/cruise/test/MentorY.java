/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorY
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorY Attributes
  private String name;

  //MentorY Associations
  private List<StudentY> students;
  private ProgramY program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorY(String aName)
  {
    name = aName;
    students = new ArrayList<StudentY>();
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

  public StudentY getStudent(int index)
  {
    StudentY aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentY> getStudents()
  {
    List<StudentY> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentY aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramY getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 0;
  }

  public static int maximumNumberOfStudents()
  {
    return 4;
  }

  public boolean addStudent(StudentY aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    if (numberOfStudents() >= maximumNumberOfStudents())
    {
      return wasAdded;
    }

    MentorY existingMentor = aStudent.getMentor();
    if (existingMentor == null)
    {
      aStudent.setMentor(this);
    }
    else if (!this.equals(existingMentor))
    {
      existingMentor.removeStudent(aStudent);
      addStudent(aStudent);
    }
    else
    {
      students.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(StudentY aStudent)
  {
    boolean wasRemoved = false;
    if (students.contains(aStudent))
    {
      students.remove(aStudent);
      aStudent.setMentor(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setProgram(ProgramY newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramY existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramY currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorY existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(StudentY aStudent : students)
    {
      aStudent.setMentor(null);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}