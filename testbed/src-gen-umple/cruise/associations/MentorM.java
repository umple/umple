/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class MentorM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorM Attributes
  private String name;

  //MentorM Associations
  private List<StudentM> students;
  private ProgramM program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorM(String aName)
  {
    name = aName;
    students = new ArrayList<StudentM>();
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

  public StudentM getStudent(int index)
  {
    StudentM aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentM> getStudents()
  {
    List<StudentM> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentM aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramM getProgram()
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
    return 2;
  }

  public StudentM addStudent(int aNumber)
  {
    return new StudentM(aNumber, this);
  }

  public boolean addStudent(StudentM aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    MentorM existingMentor = aStudent.getMentor();
    boolean isNewMentor = existingMentor != null && !this.equals(existingMentor);

    if (isNewMentor && existingMentor.numberOfStudents() <= minimumNumberOfStudents())
    {
      return wasAdded;
    }

    if (isNewMentor)
    {
      aStudent.setMentor(this);
    }
    else
    {
      students.add(aStudent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(StudentM aStudent)
  {
    boolean wasRemoved = false;
    //Unable to remove aStudent, as it must always have a mentor
    if (this.equals(aStudent.getMentor()))
    {
      return wasRemoved;
    }

    //mentor already at minimum (2)
    if (numberOfStudents() <= minimumNumberOfStudents())
    {
      return wasRemoved;
    }

    students.remove(aStudent);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addStudentAt(StudentM aStudent, int index)
  {  
    boolean wasAdded = false;
    if(addStudent(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudentAt(StudentM aStudent, int index)
  {
    boolean wasAdded = false;
    if(students.contains(aStudent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudents()) { index = numberOfStudents() - 1; }
      students.remove(aStudent);
      students.add(index, aStudent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudentAt(aStudent, index);
    }
    return wasAdded;
  }

  public boolean setProgram(ProgramM newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramM existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramM currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorM existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=students.size(); i > 0; i--)
    {
      StudentM aStudent = students.get(i - 1);
      aStudent.delete();
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}