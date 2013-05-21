/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;
import java.util.*;

// line 216 "../../../src/TestHarnessAssociations.ump"
public class MentorO
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorO Attributes
  private String name;

  //MentorO Associations
  private List<StudentO> students;
  private ProgramO program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorO(String aName, StudentO... allStudents)
  {
    name = aName;
    students = new ArrayList<StudentO>();
    boolean didAddStudents = setStudents(allStudents);
    if (!didAddStudents)
    {
      throw new RuntimeException("Unable to create MentorO, must have 2 to 4 students");
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

  public StudentO getStudent(int index)
  {
    StudentO aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentO> getStudents()
  {
    List<StudentO> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentO aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramO getProgram()
  {
    return program;
  }

  public boolean isNumberOfStudentsValid()
  {
    boolean isValid = numberOfStudents() >= minimumNumberOfStudents() && numberOfStudents() <= maximumNumberOfStudents();
    return isValid;
  }

  public static int minimumNumberOfStudents()
  {
    return 2;
  }

  public static int maximumNumberOfStudents()
  {
    return 4;
  }

  public boolean addStudent(StudentO aStudent)
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

  public boolean removeStudent(StudentO aStudent)
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

  public boolean setStudents(StudentO... newStudents)
  {
    boolean wasSet = false;
    ArrayList<StudentO> verifiedStudents = new ArrayList<StudentO>();
    for (StudentO aStudent : newStudents)
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

    ArrayList<StudentO> oldStudents = new ArrayList<StudentO>(students);
    students.clear();
    for (StudentO aNewStudent : verifiedStudents)
    {
      students.add(aNewStudent);
      if (oldStudents.contains(aNewStudent))
      {
        oldStudents.remove(aNewStudent);
      }
      else
      {
        aNewStudent.addMentor(this);
      }
    }

    for (StudentO anOldStudent : oldStudents)
    {
      anOldStudent.removeMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addStudentAt(StudentO aStudent, int index)
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

  public boolean addOrMoveStudentAt(StudentO aStudent, int index)
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

  public boolean setProgram(ProgramO aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramO existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramO currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setMentor(null);
    }

    program = aNewProgram;
    MentorO existingMentor = aNewProgram.getMentor();

    if (!equals(existingMentor))
    {
      aNewProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<StudentO> copyOfStudents = new ArrayList<StudentO>(students);
    students.clear();
    for(StudentO aStudent : copyOfStudents)
    {
      aStudent.removeMentor(this);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + (getProgram() != null ? !getProgram().equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}