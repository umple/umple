/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;
import java.util.*;

// line 80 "../../../src/TestHarnessAssociations.ump"
public class MentorF
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextY = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int y;

  //MentorF Associations
  private List<StudentF> students;
  private ProgramF program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorF(StudentF... allStudents)
  {
    y = nextY++;
    students = new ArrayList<StudentF>();
    boolean didAddStudents = setStudents(allStudents);
    if (!didAddStudents)
    {
      throw new RuntimeException("Unable to create MentorF, must have at least 2 students");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getY()
  {
    return y;
  }

  public StudentF getStudent(int index)
  {
    StudentF aStudent = students.get(index);
    return aStudent;
  }

  public List<StudentF> getStudents()
  {
    List<StudentF> newStudents = Collections.unmodifiableList(students);
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

  public int indexOfStudent(StudentF aStudent)
  {
    int index = students.indexOf(aStudent);
    return index;
  }

  public ProgramF getProgram()
  {
    return program;
  }

  public static int minimumNumberOfStudents()
  {
    return 2;
  }

  public boolean addStudent(StudentF aStudent)
  {
    boolean wasAdded = false;
    if (students.contains(aStudent)) { return false; }
    MentorF existingMentor = aStudent.getMentor();
    if (existingMentor != null && existingMentor.numberOfStudents() <= minimumNumberOfStudents())
    {
      return wasAdded;
    }
    else if (existingMentor != null)
    {
      existingMentor.students.remove(aStudent);
    }
    students.add(aStudent);
    setMentor(aStudent,this);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudent(StudentF aStudent)
  {
    boolean wasRemoved = false;
    if (students.contains(aStudent) && numberOfStudents() > minimumNumberOfStudents())
    {
      students.remove(aStudent);
      setMentor(aStudent,null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setStudents(StudentF... newStudents)
  {
    boolean wasSet = false;
    if (newStudents.length < minimumNumberOfStudents())
    {
      return wasSet;
    }

    ArrayList<StudentF> checkNewStudents = new ArrayList<StudentF>();
    HashMap<MentorF,Integer> mentorToNewStudents = new HashMap<MentorF,Integer>();
    for (StudentF aStudent : newStudents)
    {
      if (checkNewStudents.contains(aStudent))
      {
        return wasSet;
      }
      else if (aStudent.getMentor() != null && !this.equals(aStudent.getMentor()))
      {
        MentorF existingMentor = aStudent.getMentor();
        if (!mentorToNewStudents.containsKey(existingMentor))
        {
          mentorToNewStudents.put(existingMentor, new Integer(existingMentor.numberOfStudents()));
        }
        Integer currentCount = mentorToNewStudents.get(existingMentor);
        int nextCount = currentCount - 1;
        if (nextCount < 2)
        {
          return wasSet;
        }
        mentorToNewStudents.put(existingMentor, new Integer(nextCount));
      }
      checkNewStudents.add(aStudent);
    }

    students.removeAll(checkNewStudents);

    for (StudentF orphan : students)
    {
      setMentor(orphan, null);
    }
    students.clear();
    for (StudentF aStudent : newStudents)
    {
      if (aStudent.getMentor() != null)
      {
        aStudent.getMentor().students.remove(aStudent);
      }
      setMentor(aStudent, this);
      students.add(aStudent);
    }
    wasSet = true;
    return wasSet;
  }

  private void setMentor(StudentF aStudent, MentorF aMentor)
  {
    try
    {
      java.lang.reflect.Field mentorField = aStudent.getClass().getDeclaredField("mentor");
      mentorField.setAccessible(true);
      mentorField.set(aStudent, aMentor);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aMentor to aStudent", e);
    }
  }

  public boolean addStudentAt(StudentF aStudent, int index)
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

  public boolean addOrMoveStudentAt(StudentF aStudent, int index)
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

  public boolean setProgram(ProgramF newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramF existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramF currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorF existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(StudentF aStudent : students)
    {
      setMentor(aStudent,null);
    }
    students.clear();
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}