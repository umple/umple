/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorAJ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAJ Attributes
  private String name;

  //MentorAJ Associations
  private List<StudentAJ> students;
  private ProgramAJ program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAJ(String aName, StudentAJ... allStudents)
  {
    name = aName;
    students = new ArrayList<StudentAJ>();
    boolean didAddStudents = setStudents(allStudents);
    if (!didAddStudents)
    {
      throw new RuntimeException("Unable to create MentorAJ, must have 3 students");
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

  public StudentAJ getStudent(int index)
  {
    StudentAJ aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentAJ> getStudents()
  {
    List<StudentAJ> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentAJ aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramAJ getProgram()
  {
    return program;
  }

  public static int requiredNumberOfStudents()
  {
    return 3;
  }

  public static int minimumNumberOfStudents()
  {
    return 3;
  }

  public static int maximumNumberOfStudents()
  {
    return 3;
  }

  public boolean setStudents(StudentAJ... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentAJ> verifiedStudents = new ArrayList<StudentAJ>();
    for (StudentAJ aStudent : newStudents)
    {
      if (verifiedStudents.contains(aStudent))
      {
        continue;
      }
      verifiedStudents.add(aStudent);
    }

    if (verifiedStudents.size() != newStudents.length || verifiedStudents.size() != requiredNumberOfStudents())
    {
      return wasSet;
    }

    students.clear();
    students.addAll(verifiedStudents);
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramAJ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAJ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAJ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAJ existingMentor = newProgram.getMentor();

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