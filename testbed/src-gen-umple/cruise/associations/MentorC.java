/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class MentorC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorC Attributes
  private String name;

  //MentorC Associations
  private List<StudentC> students;
  private ProgramC program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorC(String aName)
  {
    name = aName;
    students = new ArrayList<StudentC>();
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

  public StudentC getStudent(int index)
  {
    StudentC aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentC> getStudents()
  {
    List<StudentC> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentC aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramC getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 0;
  }

  public boolean addStudent(StudentC aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    MentorC existingMentor = aStudent.getMentor();
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

  public boolean removeStudent(StudentC aStudent)
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

  public boolean setProgram(ProgramC newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramC existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramC currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorC existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(StudentC aStudent : students)
    {
      aStudent.setMentor(null);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}