/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;
import java.util.*;

// line 119 "../../../src/TestHarnessAssociations.ump"
public class MentorI
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean addStudentAt(StudentI aStudent, int index)
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

  public boolean addOrMoveStudentAt(StudentI aStudent, int index)
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

  public boolean setProgram(ProgramI aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setMentorI(null);
    }

    program = aNewProgram;
    MentorI existingMentorI = aNewProgram.getMentorI();

    if (!equals(existingMentorI))
    {
      aNewProgram.setMentorI(this);
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null")
     + outputString;
  }
}