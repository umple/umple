/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorP
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorP Attributes
  private String name;

  //MentorP Associations
  private List<StudentP> students;
  private ProgramP program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorP(String aName)
  {
    name = aName;
    students = new ArrayList<StudentP>();
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

  public StudentP getStudent(int index)
  {
    StudentP aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentP> getStudents()
  {
    List<StudentP> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentP aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramP getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 0;
  }

  public boolean addStudent(StudentP aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    students.add(aStudent);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(StudentP aStudent)
  {
    boolean wasRemoved = false;
    if (students.contains(aStudent))
    {
      students.remove(aStudent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setProgram(ProgramP newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramP existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramP currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorP existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    students.clear();
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}