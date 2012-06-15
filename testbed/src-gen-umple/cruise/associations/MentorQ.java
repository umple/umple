/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class MentorQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorQ Attributes
  private String name;

  //MentorQ Associations
  private List<StudentQ> students;
  private ProgramQ program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorQ(String aName, StudentQ... allStudents)
  {
    name = aName;
    students = new ArrayList<StudentQ>();
    boolean didAddStudents = setStudents(allStudents);
    if (!didAddStudents)
    {
      throw new RuntimeException("Unable to create MentorQ, must have 2 students");
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

  public StudentQ getStudent(int index)
  {
    StudentQ aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentQ> getStudents()
  {
    List<StudentQ> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentQ aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramQ getProgram()
  {
    return program;
  }

  public boolean isNumberOfStudentsValid()
  {
    boolean isValid = numberOfStudents() >= minimumNumberOfStudents() && numberOfStudents() <= maximumNumberOfStudents();
    return isValid;
  }

  public static int requiredNumberOfStudents()
  {
    return 2;
  }

  public static int minimumNumberOfStudents()
  {
    return 2;
  }

  public static int maximumNumberOfStudents()
  {
    return 2;
  }

  public boolean addStudent(StudentQ aStudent)
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

  public boolean removeStudent(StudentQ aStudent)
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

  public boolean setStudents(StudentQ... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentQ> verifiedStudents = new ArrayList<StudentQ>();
    for (StudentQ aStudent : newStudents)
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

    ArrayList<StudentQ> oldStudents = new ArrayList<StudentQ>(students);
    students.clear();
    for (StudentQ newStudent : verifiedStudents)
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

    for (StudentQ oldStudent : oldStudents)
    {
      oldStudent.removeMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramQ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramQ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramQ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorQ existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<StudentQ> copyOfStudents = new ArrayList<StudentQ>(students);
    students.clear();
    for(StudentQ aStudent : copyOfStudents)
    {
      aStudent.removeMentor(this);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}