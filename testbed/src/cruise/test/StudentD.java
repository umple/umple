/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class StudentD
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

  //StudentD Associations
  private ProgramD program;
  private MentorD mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentD()
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

  public ProgramD getProgram()
  {
    return program;
  }

  public MentorD getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramD newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramD existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramD currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentD existingStudent = newProgram.getStudent();

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
      mentor.delete();
    }
  }

}