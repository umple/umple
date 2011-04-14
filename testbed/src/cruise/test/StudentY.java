/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class StudentY
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentY Attributes
  private int number;

  //StudentY Associations
  private ProgramY program;
  private MentorY mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentY(int aNumber)
  {
    number = aNumber;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public ProgramY getProgram()
  {
    return program;
  }

  public MentorY getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramY newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramY existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramY currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentY existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorY aMentor)
  {
    boolean wasSet = false;
    if (aMentor != null && aMentor.numberOfStudents() >= MentorY.maximumNumberOfStudents())
    {
      return wasSet;
    }

    MentorY existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      existingMentor.removeStudent(this);
    }
    if (aMentor != null)
    {
      aMentor.addStudent(this);
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
      MentorY placeholderMentor = mentor;
      this.mentor = null;
      placeholderMentor.removeStudent(this);
    }
  }

}