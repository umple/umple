/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class MentorW
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorW Attributes
  private String name;

  //MentorW Associations
  private List<StudentW> students;
  private ProgramW program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorW(String aName)
  {
    name = aName;
    students = new ArrayList<StudentW>();
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

  public StudentW getStudent(int index)
  {
    StudentW aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentW> getStudents()
  {
    List<StudentW> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentW aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramW getProgram()
  {
    return program;
  }

  public boolean isNumberOfStudentsValid()
  {
    boolean isValid = numberOfStudents() >= minimumNumberOfStudents();
    return isValid;
  }

  public static int minimumNumberOfStudents()
  {
    return 3;
  }

  public boolean addStudent(StudentW aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
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

  public boolean removeStudent(StudentW aStudent)
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

  public boolean setStudents(StudentW... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentW> verifiedStudents = new ArrayList<StudentW>();
    for (StudentW aStudent : newStudents)
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

    ArrayList<StudentW> oldStudents = new ArrayList<StudentW>(students);
    students.clear();
    for (StudentW newStudent : verifiedStudents)
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

    for (StudentW oldStudent : oldStudents)
    {
      oldStudent.removeMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramW newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramW existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramW currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorW existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<StudentW> copyOfStudents = new ArrayList<StudentW>(students);
    students.clear();
    for(StudentW aStudent : copyOfStudents)
    {
      if (aStudent.numberOfMentors() <= StudentW.minimumNumberOfMentors())
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