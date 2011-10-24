/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorAA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAA Attributes
  private String name;

  //MentorAA Associations
  private List<StudentAA> students;
  private ProgramAA program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAA(String aName)
  {
    name = aName;
    students = new ArrayList<StudentAA>();
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

  public StudentAA getStudent(int index)
  {
    StudentAA aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentAA> getStudents()
  {
    List<StudentAA> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentAA aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramAA getProgram()
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

  public boolean addStudent(StudentAA aStudent)
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

  public boolean removeStudent(StudentAA aStudent)
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

  public boolean setStudents(StudentAA... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentAA> verifiedStudents = new ArrayList<StudentAA>();
    for (StudentAA aStudent : newStudents)
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

    ArrayList<StudentAA> oldStudents = new ArrayList<StudentAA>(students);
    students.clear();
    for (StudentAA newStudent : verifiedStudents)
    {
      students.add(newStudent);
      if (oldStudents.contains(newStudent))
      {
        oldStudents.remove(newStudent);
      }
      else
      {
        newStudent.addMentor(this);
      }
    }

    for (StudentAA oldStudent : oldStudents)
    {
      oldStudent.removeMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramAA newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAA existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAA currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAA existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<StudentAA> copyOfStudents = new ArrayList<StudentAA>(students);
    students.clear();
    for(StudentAA aStudent : copyOfStudents)
    {
      aStudent.removeMentor(this);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}