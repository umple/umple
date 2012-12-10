/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 11 "../../../src/TestHarnessAssociations.ump"
public class MentorB
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

  //MentorB Associations
  private StudentB student;
  private ProgramB program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorB(StudentB aStudent)
  {
    y = nextY++;
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create mentor due to student");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getY()
  {
    return y;
  }

  public StudentB getStudent()
  {
    return student;
  }

  public ProgramB getProgram()
  {
    return program;
  }

  public boolean setStudent(StudentB newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      //Unable to setStudent to null, as mentor must always be associated to a student
      return wasSet;
    }
    
    MentorB existingMentor = newStudent.getMentor();
    if (existingMentor != null && !equals(existingMentor))
    {
      //Unable to setStudent, the current student already has a mentor, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    StudentB oldStudent = student;
    student = newStudent;
    student.setMentor(this);

    if (oldStudent != null)
    {
      oldStudent.setMentor(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramB newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramB existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramB currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorB existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    StudentB existingStudent = student;
    student = null;
    if (existingStudent != null)
    {
      existingStudent.setMentor(null);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}