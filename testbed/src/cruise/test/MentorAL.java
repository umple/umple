/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorAL
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAL Attributes
  private String name;

  //MentorAL Associations
  private List<StudentAL> students;
  private ProgramAL program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAL(String aName, StudentAL... allStudents)
  {
    name = aName;
    students = new ArrayList<StudentAL>();
    boolean didAddStudents = setStudents(allStudents);
    if (!didAddStudents)
    {
      throw new RuntimeException("Unable to create MentorAL, must have at least 3 students");
    }
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

  public StudentAL getStudent(int index)
  {
    StudentAL aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentAL> getStudents()
  {
    List<StudentAL> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentAL aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramAL getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 3;
  }

  public boolean addStudent(StudentAL aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    students.add(aStudent);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(StudentAL aStudent)
  {
    boolean wasRemoved = false;
    if (!students.contains(aStudent))
    {
      return wasRemoved;
    }

    if (numberOfStudents() <= minimumNumberOfStudents())
    {
      return wasRemoved;
    }

    students.remove(aStudent);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean setStudents(StudentAL... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentAL> verifiedStudents = new ArrayList<StudentAL>();
    for (StudentAL aStudent : newStudents)
    {
      if (verifiedStudents.contains(aStudent))
      {
        continue;
      }
      verifiedStudents.add(aStudent);
    }

    if (verifiedStudents.size() != newStudents.length || verifiedStudents.size() < minimumNumberOfStudents())
    {
      return wasSet;
    }

    students.clear();
    students.addAll(verifiedStudents);
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramAL newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAL existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAL currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAL existingMentor = newProgram.getMentor();

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