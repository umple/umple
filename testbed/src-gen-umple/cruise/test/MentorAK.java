/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorAK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAK Attributes
  private String name;

  //MentorAK Associations
  private List<StudentAK> students;
  private ProgramAK program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAK(String aName)
  {
    name = aName;
    students = new ArrayList<StudentAK>();
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

  public StudentAK getStudent(int index)
  {
    StudentAK aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentAK> getStudents()
  {
    List<StudentAK> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentAK aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramAK getProgram()
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

  public boolean addStudent(StudentAK aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    if (numberOfStudents() < maximumNumberOfStudents())
    {
      students.add(aStudent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeStudent(StudentAK aStudent)
  {
    boolean wasRemoved = false;
    if (students.contains(aStudent))
    {
      students.remove(aStudent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setStudents(StudentAK... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentAK> verifiedStudents = new ArrayList<StudentAK>();
    for (StudentAK aStudent : newStudents)
    {
      if (verifiedStudents.contains(aStudent))
      {
        continue;
      }
      verifiedStudents.add(aStudent);
    }

    if (verifiedStudents.size() != newStudents.length || verifiedStudents.size() > maximumNumberOfStudents())
    {
      return wasSet;
    }

    students.clear();
    students.addAll(verifiedStudents);
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramAK newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAK existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAK currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAK existingMentor = newProgram.getMentor();

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