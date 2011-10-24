/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorAB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAB Attributes
  private String name;

  //MentorAB Associations
  private List<StudentAB> students;
  private ProgramAB program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAB(String aName)
  {
    name = aName;
    students = new ArrayList<StudentAB>();
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

  public StudentAB getStudent(int index)
  {
    StudentAB aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentAB> getStudents()
  {
    List<StudentAB> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentAB aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramAB getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 0;
  }

  public static int maximumNumberOfStudents()
  {
    return 2;
  }

  public boolean addStudent(StudentAB aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    if (numberOfStudents() >= maximumNumberOfStudents())
    {
      return wasAdded;
    }

    students.add(aStudent);
    if (aStudent.indexOfMentor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStudent.addMentor(this);
      if (!wasAdded)
      {
        students.remove(aStudent);
      }
    }
    return wasAdded;
  }

  public boolean removeStudent(StudentAB aStudent)
  {
    boolean wasRemoved = false;
    if (!students.contains(aStudent))
    {
      return wasRemoved;
    }

    int oldIndex = students.indexOf(aStudent);
    students.remove(oldIndex);
    if (aStudent.indexOfMentor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStudent.removeMentor(this);
      if (!wasRemoved)
      {
        students.add(oldIndex,aStudent);
      }
    }
    return wasRemoved;
  }

  public boolean setProgram(ProgramAB newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAB existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAB currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAB existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<StudentAB> copyOfStudents = new ArrayList<StudentAB>(students);
    students.clear();
    for(StudentAB aStudent : copyOfStudents)
    {
      if (aStudent.numberOfMentors() <= StudentAB.minimumNumberOfMentors())
      {
        aStudent.delete();
      }
      else
      {
        aStudent.removeMentor(this);
      }
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}