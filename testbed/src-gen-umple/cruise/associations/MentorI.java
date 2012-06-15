/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class MentorI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorI Attributes
  private String name;

  //MentorI Associations
  private List<StudentI> students;
  private ProgramI program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorI(String aName, StudentI... allStudents)
  {
    name = aName;
    students = new ArrayList<StudentI>();
    boolean didAddStudents = setStudents(allStudents);
    if (!didAddStudents)
    {
      throw new RuntimeException("Unable to create MentorI, must have 2 to 4 students");
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

  public StudentI getStudent(int index)
  {
    StudentI aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentI> getStudents()
  {
    List<StudentI> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentI aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramI getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 2;
  }

  public static int maximumNumberOfStudents()
  {
    return 4;
  }

  public boolean addStudent(StudentI aStudent)
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

  public boolean removeStudent(StudentI aStudent)
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

  public boolean setStudents(StudentI... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentI> verifiedStudents = new ArrayList<StudentI>();
    for (StudentI aStudent : newStudents)
    {
      if (verifiedStudents.contains(aStudent))
      {
        continue;
      }
      verifiedStudents.add(aStudent);
    }

    if (verifiedStudents.size() != newStudents.length || verifiedStudents.size() < minimumNumberOfStudents() || verifiedStudents.size() > maximumNumberOfStudents())
    {
      return wasSet;
    }

    students.clear();
    students.addAll(verifiedStudents);
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramI newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramI existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentorI() != null)
      {
        existingProgram.setMentorI(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramI currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentorI(null);
    }

    program = newProgram;
    MentorI existingMentorI = newProgram.getMentorI();

    if (!equals(existingMentorI))
    {
      newProgram.setMentorI(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    students.clear();
    if (program != null)
    {
      program.setMentorI(null);
    }
  }

}