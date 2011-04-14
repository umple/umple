/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class StudentE
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextX = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int x;

  //StudentE Associations
  private ProgramE program;
  private MentorE mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentE()
  {
    x = nextX++;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getX()
  {
    return x;
  }

  public ProgramE getProgram()
  {
    return program;
  }

  public MentorE getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramE newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramE existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramE currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentE existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    if (mentor != null)
    {
      if (mentor.numberOfStudents() <= 2)
      {
        mentor.delete();
      }
      else
      {
        MentorE placeholderMentor = mentor;
        this.mentor = null;
        placeholderMentor.removeStudent(this);
      }
    }
  }

}