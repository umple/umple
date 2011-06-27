/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorX
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorX Attributes
  private String name;

  //MentorX Associations
  private List<StudentX> students;
  private ProgramX program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorX(String aName)
  {
    name = aName;
    students = new ArrayList<StudentX>();
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

  public StudentX getStudent(int index)
  {
    StudentX aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentX> getStudents()
  {
    List<StudentX> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentX aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramX getProgram()
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

  public boolean addStudent(StudentX aStudent)
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

  public boolean removeStudent(StudentX aStudent)
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

  public boolean setStudents(StudentX... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentX> verifiedStudents = new ArrayList<StudentX>();
    for (StudentX aStudent : newStudents)
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

    ArrayList<StudentX> oldStudents = new ArrayList<StudentX>(students);
    students.clear();
    for (StudentX newStudent : verifiedStudents)
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

    for (StudentX oldStudent : oldStudents)
    {
      oldStudent.removeMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramX newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramX existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramX currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorX existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<StudentX> copyOfStudents = new ArrayList<StudentX>(students);
    students.clear();
    for(StudentX aStudent : copyOfStudents)
    {
      if (aStudent.numberOfMentors() <= StudentX.minimumNumberOfMentors())
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